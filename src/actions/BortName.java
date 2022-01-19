package actions;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class BortName extends javax.swing.JFrame {
    public BortName() {
        super("Замена номера борта");
        this.setSize(new Dimension(450,100));
        this.setLocation(400,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));

        JLabel labelBort = new JLabel("Номер борта");
        labelBort.setFont(new Font("Serif", Font.PLAIN, 18));
        JTextArea jTextAreaBort = new JTextArea("6163");
        jTextAreaBort.setFont(new Font("Calibri", Font.PLAIN, 18));

        JButton button1 = new JButton("OK");
        JButton button2 = new JButton("Назад");

        container.add(labelBort);
        container.add(jTextAreaBort);
        container.add(button2);
        container.add(button1);

        button1.addActionListener(e -> {
            buttonPressed(jTextAreaBort);
        });

        button2.addActionListener(e -> {
            setVisible(false);
            JFrame frame = new JFrame();
            frame.setVisible(true);
        });
    }


    private void buttonPressed(JTextArea jTextArea) {
        setVisible(false);
        AppProperties ap = new AppProperties();
        String rconfDan = ap.getProp().getProperty("rconfDan");

        File rconf = new File(rconfDan);
        try {
            String line;
            BufferedReader fin = new BufferedReader(new FileReader(rconf));
            while ((line = fin.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //BashCommand.pushCommand("a=`cat ../../rconf/rconf_OLYMP-G.dan | awk '{print $8}' | awk -F'.' '{print $1}' | sed 1,2d | head -n1`;" +
        //        " sed -i \"s/$a/" + jTextArea.getText() + "/g\"  ../../rconf/rconf_OLYMP-G.dan");
        // Выход из программы
        System.exit(0);
    }

}


