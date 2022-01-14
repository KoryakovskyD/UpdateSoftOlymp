package actions;

import actions.BashCommand;

import javax.swing.*;
import java.awt.*;


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
            setVisible(false);
            BashCommand.pushCommand("a=`cat ../../rconf/rconf_OLYMP-G.dan | awk '{print $8}' | awk -F'.' '{print $1}' | sed 1,2d | head -n1`;" +
                    " sed -i \"s/$a/" + jTextAreaBort.getText() + "/g\"  ../../rconf/rconf_OLYMP-G.dan");
            // Выход из программы
            System.exit(0);
        });


        button2.addActionListener(e -> {
            setVisible(false);
            JFrame frame = new JFrame();
            frame.setVisible(true);
        });
    }

}


