import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Command extends javax.swing.JFrame{
    public Command() {
        super("Выполнение удаленной команды");
        this.setBounds(450, 450, 700, 130);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0, 2));

        JLabel labelPrib = new JLabel(" Введите команду: ");
        labelPrib.setFont(new Font("Calibri", Font.PLAIN, 18));
        JTextArea jTextAreaBrib = new JTextArea("");
        jTextAreaBrib.setFont(new Font("Calibri", Font.PLAIN, 22));
        JScrollPane jScrollPane = new JScrollPane(jTextAreaBrib);
        JButton button1 = new JButton("Далее");
        JButton button2 = new JButton("Назад");



        container.add(labelPrib);
        container.add(jScrollPane);
        container.add(button2);
        container.add(button1);


        // Кнопка назад
        button1.addActionListener(e -> {
            // Список ip-адресов выбранных прибор
            String ip_list = ChangePrib.getIp_list();

            // Пробежка по каждой машине
            for (String ip:ip_list.split(" ")) {
                BashCommand.pushCommand("sshpass -p wizard ssh root@" + ip + " \"" + jTextAreaBrib.getText() + "\"");
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
