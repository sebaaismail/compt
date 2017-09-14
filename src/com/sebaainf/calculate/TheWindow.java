package com.sebaainf.calculate;

import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmButtonStackBuilder;
import com.sebaainf.ismUtils.IsmPrintStream;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
    JLabel label1, label2;
    FileReader input;
    JButton buttonOuvrir = new JButton("Ouvrir fichier");

    public TheWindow(){

        buttonOuvrir.setActionCommand("myButton");
        //buttonOuvrir.addActionListener(this);

        this.setTitle("App CD Paye validator#  ................. apc_boufatis©2017 / par SEBAA.I");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());
        this.pack();
        this.setSize(new Dimension(5 * (int) screenSize.getWidth() / 10, 5 * (int) screenSize.getHeight() / 10));
        this.setLocationRelativeTo(null); //to center the frame in the middle of screen

        //this.setSize((int) (IsmAbstractJFrame.screenSize.getWidth()/2), (int) (IsmAbstractJFrame.screenSize.getHeight()/2));
        //this.setSize(500, 500);
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
        label1 = new JLabel("................");
        label2 = new JLabel("");
        return FormBuilder.create()
                .columns("fill:pref:grow,fill:pref:grow, fill:pref:grow,fill:pref:grow")
                .rows("fill:pref:grow,fill:pref:grow")
                .add(label1).xy(1, 1)
                .add(label2).xy(3, 1)
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
/*
        buttonCalculer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {


                    String message = String.valueOf(MyApp.parseFile(input));
                    label1.setText("  La somme est égal à : ");

                    label1.setText(String.format("<html>%s<font color='red'>%s</font></html>",
                            label1.getText(), message));

                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });*/
        //*
        buttonCalculer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                MyApp.TheResult result = null;
                try {
                    result = MyApp.parseFile(input);
                    String message = String.valueOf(result.lasomme);

                    label1.setForeground(Color.blue);
                    label1.setFont(new Font("Serif", Font.PLAIN, 18));
                if (result.isCorrect){
                    label1.setText("  Fichier correct !! La somme = ");

                    label1.setText(String.format("<html>%s<font color='green'>%s</font></html>",
                            label1.getText(), message));
                    label2.setIcon(new ImageIcon(ImageIO.read(new File("files/true.jpg"))));
                    System.out.println("result is Correct ");
                } else {
                    label1.setForeground(Color.RED);
                    label1.setText("  Erreur !! la somme doit être = ");

                    label1.setText(String.format("<html>%s<font color='black'>%s</font></html>",
                            label1.getText(), message));
                    label2.setIcon(new ImageIcon(ImageIO.read(new File("files/false.jpg"))));
                    System.out.println("result is Correct ");
                }
                System.out.println("buttonCalculer clicked ");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
//*/



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

        label1.setText("Fichier selectionné : 22222222 ");
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
