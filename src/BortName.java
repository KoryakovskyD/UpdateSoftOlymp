import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class BortName extends javax.swing.JFrame {

    public BortName() {
        super("10.3.6.0");
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
            String command="a=`cat ../../rconf/rconf_OLYMP-G.dan | awk '{print $8}' | awk -F'.' '{print $1}' | sed 1,2d | head -n1`; sed -i \"s/$a/" + jTextAreaBort.getText() + "/g\"  ../../rconf/rconf_OLYMP-G.dan";
            try {
                Process threadBash = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", command});
                threadBash.waitFor();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
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


