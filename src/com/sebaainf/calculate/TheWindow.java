package com.sebaainf.calculate;

import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmButtonStackBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Locale;

/**
 * Created by INFO on 3/09/2017.
 */
public class TheWindow extends IsmAbstractJFrame implements ActionListener {

    JFileChooser fileChooser = new JFileChooser();
    int result;
    JLabel label;
    FileReader input;
    JButton buttonOuvrir = new JButton("Ouvrir fichier");

    public TheWindow(){

        buttonOuvrir.setActionCommand("myButton");
        //buttonOuvrir.addActionListener(this);

        this.setTitle("Verifier fichier de Paye # CD ........................ apc_boufatis©2017");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());
        this.pack();
        this.setSize(new Dimension(6 * (int) screenSize.getWidth() / 10, 7 * (int) screenSize.getHeight() / 10));
        this.setLocationRelativeTo(null); //to center the frame in the middle of screen

        //this.setSize((int) (IsmAbstractJFrame.screenSize.getWidth()/2), (int) (IsmAbstractJFrame.screenSize.getHeight()/2));
        this.setSize(500, 500);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")+"/Desktop"));
    }
    public JComponent createPanel() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();


        LayoutManager layout = new BorderLayout();

        JComponent panel = new JPanel(layout);

        panel.add(buildButtonBarPanel(), BorderLayout.WEST);
        panel.add(buildResultPanel() , BorderLayout.CENTER);
        //panel.add(buildEpouxDecesInfoPanel(), BorderLayout.EAST);
        //panel.add(buildMariageInfoPanel(), BorderLayout.SOUTH);

        return panel;

    }

    private Component buildResultPanel() {
        label = new JLabel("................");
        return FormBuilder.create()
                .columns("fill:pref:grow,fill:pref:grow")
                .rows("fill:pref:grow,fill:pref:grow")
                .add(label).xy(1, 1)
                .build();
    }

    private JComponent buildButtonBarPanel() {

        LayoutManager layout = new FormLayout("center:pref", "center:pref");
        JComponent panel = new JPanel(layout);

        final JButton buttonCalculer = new JButton("Calculer");
        buttonCalculer.setEnabled(false);
        JButton buttonQuitter = new JButton("Quitter");

        IsmButtonStackBuilder builder = new IsmButtonStackBuilder((JPanel) panel, screenSize);

        builder.setBackground(MyApp.theme.buttonBarColor); //todo color


        //builder.getPanel().setLayout(layout);
        //todo for testing
        buttonOuvrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Fichier selectionné : " + selectedFile.getAbsolutePath());
                    buttonCalculer.setEnabled(true);
                    try {
                        input = new FileReader(selectedFile);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
                /*
                result = fileChooser.showOpenDialog(createPanel().getParent());
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Fichier selectionné : " + selectedFile.getAbsolutePath());
                }
                createPanel().requestFocus();
                label.setText("Fichier selectionné : 22222222 ");
                //*/
            }
        });

        buttonCalculer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String message = String.valueOf(MyApp.parseFile(input));
                    label.setText("  La somme est égal à : ");

                    label.setText(String.format("<html>%s<font color='red'>%s</font></html>",
                            label.getText(), message));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("buttonCalculer clicked ");

            }
        });


        builder.addUnrelatedGap();
        builder.addButton(buttonOuvrir);
        builder.addUnrelatedGap();

        builder.addButton(buttonCalculer);

        builder.addUnrelatedGap();
        builder.addButton(buttonQuitter);

        builder.addUnrelatedGap();
        builder.addUnrelatedGap();

        // setting sizes of buttons

        return builder.getPanel();
    }

    @Override
    protected JComponent buildContent() {
        JPanel mainPanel = new JPanel();

        mainPanel.add(fileChooser);

        return mainPanel;
    }
    public void actionPerformed(ActionEvent e)
    {

        label.setText("Fichier selectionné : 22222222 ");
    }
    public JComponent showDialog(EventObject e) {

        return buildContent();

    }

    @Override
    protected void initComponents() {

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));


    }

    @Override
    public ArrayList<JComponent> getListComponents() {
        return null;
    }
}
