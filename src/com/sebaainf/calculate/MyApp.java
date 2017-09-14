package com.sebaainf.calculate;

//import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;

import com.jgoodies.looks.plastic.*;
import com.sebaainf.ismThemes.BlackTheme;
import com.sebaainf.ismThemes.MyTheme;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmPrintStream;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Created by admin on 24/01/2015.
 */
public class MyApp {

    public static int default_id_c = 3114; //todo maybe get from general variable or file config
    public static MyTheme theme = new BlackTheme();
    public static Color tableBackColor = Color.white;
    public static Color alternateRowColor = Color.lightGray;
    public static Date defaultDate;


    //public static Color tableBackgColor = Color.decode("#D7EAF5");

    //public static MyTheme theme = new GreyTheme(); // put in config
    public static void setUIFont(javax.swing.plaf.FontUIResource f) {

        java.util.Enumeration keys = UIManager.getDefaults().keys();

        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }

    static void filereader(Scanner aScanner) {
        int sum = 0;

        while (aScanner.hasNextInt()) {
            sum += aScanner.nextInt();
        }

        System.out.println(sum);
    }
    static int extractNum(String str) {
        int number = 0;
            //str = "Ram-sita-laxman";
            String seperator = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
            String[] splitstrings = str.split(seperator);
            for (int i = 0; i < splitstrings.length; i++) {
                IsmPrintStream.logging(splitstrings[i]);
            }
            //split the last 10 characters from last
            str = splitstrings[1].substring(splitstrings[1].length() - 10);
            //int number = Integer.parseInt(splitstrings[splitstrings.length-1]);
            number = Integer.parseInt(str);

        return number;
    }
    static int extractFisrtNum(String str) {
        int number = 0;
        //str = "Ram-sita-laxman";
        String seperator = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
        String[] splitstrings = str.split(seperator);
        seperator = "000";
        String[] splitstrings2 = splitstrings[1].split(seperator);

        str = splitstrings2[splitstrings2.length-2];
        //split the last 10 characters from last
        //str = splitstrings2[1].substring(splitstrings[1].length() - 10);
        //int number = Integer.parseInt(splitstrings[splitstrings.length-1]);
        number = Integer.parseInt(str);

        return number;
    }

    static TheResult parseFile(FileReader input) throws IOException {
        BufferedReader bufRead = new BufferedReader(input);
        String myLine = null;
        int i = 0 , firstLineNum = 0, realSomme = 0;

        TheResult result = new TheResult(0, false);

        while ( (myLine = bufRead.readLine()) != null)
        {

            if (i==0) {

                firstLineNum = extractFisrtNum(myLine);
                i++;

            } else {
                if(myLine.length() > 0) {
                    //System.out.println("*****");
                    realSomme += extractNum(myLine);
                    i++;
                    System.out.println("i = " + i + " # " + extractNum(myLine));
                }
            }
        }
        result.firstnum = firstLineNum;
        result.lasomme = realSomme;
        result.validate();

        return result;
    }

    protected static class TheResult{
        int firstnum, lasomme = 0;
        boolean isCorrect = false;
        protected TheResult(int somme, boolean val){
            this.lasomme = somme;
            this.isCorrect = val;
        }
        protected void validate(){
            if (this.firstnum == this.lasomme) {
                this.isCorrect = true;
            } else {
                this.isCorrect = false;
            }
        }
    }

    public static void main(String[] args) {

        /**
         * set jgoodies Look And Feel
         */

        try {
            defaultDate =new SimpleDateFormat("yyyy/MM/dd").parse("1900/01/01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        IsmPrintStream.prepareLogFile();
        IsmPrintStream.logging("Application calcul CD paye - Boufatis/ Sebaa.Ism©2017");
        int num = extractNum("*00000000000169961144000003523770YAYAOUI FATIMA             1");
        IsmPrintStream.logging("ok = " + num);

        try {
            IsmPrintStream.logging("La somme  = " + parseFile(new FileReader("myFile.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        TheWindow view = new TheWindow();
        view.setVisible(true);

        //extractor("Ram-sita-laxman");

        EventQueue.invokeLater(new Runnable() {
            public void run() {


                try {
                    UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                    UIManager.put("TextField.inactiveBackground", new ColorUIResource(Color.blue));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setUIFont(new javax.swing.plaf.FontUIResource("Times New Roman", Font.PLAIN, 18));

        //*****************************************************



        Toolkit toolkit = Toolkit.getDefaultToolkit();
        IsmAbstractJFrame.screenSize = toolkit.getScreenSize();

        //TODO
        //JFrame frame = new SearchCit_window();
        /*
         JFrame frame = new SearchAttestEditor();
         frame.setVisible(true);
        //*/
        
        
        
        //AttestEditorModel attestModel = new AttestEditorModel(getObj());
        /*
        TODO
          AttestEditorModel attestModel = new AttestEditorModel(new Attest());
        Editor_window view = new Editor_window(attestModel);
        view.setVisible(true);

         */
      }

}
