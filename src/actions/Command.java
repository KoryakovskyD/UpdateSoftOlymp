package actions;

import actions.BashCommand;
import actions.ChangePrib;

import javax.swing.*;
import java.awt.*;

public class Command extends javax.swing.JFrame{
    public Command() {
        super("Выполнение удаленной команды");
        this.setBounds(450, 450, 700, 130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0, 2));

        JLabel labelPrib = new JLabel(" Введите команду: ");
        labelPrib.setFont(new Font("Calibri", Font.PLAIN, 18));
        JTextArea jTextAreaPrib = new JTextArea("");
        jTextAreaPrib.setFont(new Font("Calibri", Font.PLAIN, 22));
        JScrollPane jScrollPane = new JScrollPane(jTextAreaPrib);
        JLabel labelCat = new JLabel(" Вывести файл на экран: ");
        labelCat.setFont(new Font("Calibri", Font.PLAIN, 18));
        JTextArea jTextAreaCat = new JTextArea("");
        jTextAreaCat.setFont(new Font("Calibri", Font.PLAIN, 22));
        JScrollPane jScrollPaneCat = new JScrollPane(jTextAreaCat);
        JButton button1 = new JButton("Далее");
        JButton button2 = new JButton("Назад");

        container.add(labelPrib);
        container.add(jScrollPane);
        container.add(labelCat);
        container.add(jScrollPaneCat);
        container.add(button2);
        container.add(button1);

        button1.addActionListener(e -> {
            // Список ip-адресов выбранных прибор
            String ip_list = ChangePrib.getIp_list();

            // Пробежка по каждой машине
            if (! jTextAreaPrib.getText().equals("")) {
                for (String ip : ip_list.split(" ")) {
                    BashCommand.pushCommand("sshpass -p wizard ssh root@" + ip + " \"" + jTextAreaPrib.getText() + "\"");
                }
            }

            if (! jTextAreaCat.getText().equals("")) {
                for (String ip : ip_list.split(" ")) {

                    String name = "";
                    for (String curName : jTextAreaCat.getText().split("/")) {
                        name = curName;
                    }

                    BashCommand.pushCommand("sshpass -p wizard ssh root@" + ip + " \"cp " + jTextAreaCat.getText() + " /home/mfp\"");
                    BashCommand.pushCommand("sudo mount " + ip + ":/home/mfp /mnt/cdrom; sudo cp /mnt/cdrom/" +
                            name + " /tmp; sudo rm /mnt/cdrom/" + name + "; sudo umount -l /mnt/cdrom");
                    BashCommand.pushCommand("pluma /tmp/" + name + "; sudo rm /tmp/" + name);
                }
            }

            System.exit(0);
        });

        // Кнопка назад
        button2.addActionListener(e -> {
            ChangePrib.setIp_list("");
            setVisible(false);
            JFrame frame = new JFrame();
            frame.setVisible(true);
        });
    }
}
