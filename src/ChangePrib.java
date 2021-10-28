import javax.swing.*;
import java.awt.*;

public class ChangePrib extends javax.swing.JFrame {

    private static String ip_list = "";

    public static String getIp_list() {
        return ip_list;
    }

    public static void setIp_list(String ip_list) {
        ChangePrib.ip_list = ip_list;
    }

    public ChangePrib(int num) {
        super("Выбор приборов");
        this.setBounds(500,500,480,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));


        JLabel labelPr70 = new JLabel("4.09(1) Верх  10.4.6.70");
        labelPr70.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr70 = new JCheckBox("", false);
        JLabel labelPr71 = new JLabel("4.09(1) Низ   10.4.6.71");
        labelPr71.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr71 = new JCheckBox("", false);
        JLabel labelPr72 = new JLabel("4.09(2) Верх  10.4.6.72");
        labelPr72.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr72 = new JCheckBox("", false);
        JLabel labelPr73 = new JLabel("4.09(2) Низ   10.4.6.73");
        labelPr73.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr73 = new JCheckBox("", false);
        JLabel labelPr74 = new JLabel("4.09(3) Верх  10.4.6.74");
        labelPr74.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr74 = new JCheckBox("", false);
        JLabel labelPr75 = new JLabel("4.09(3) Низ   10.4.6.75");
        labelPr75.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr75 = new JCheckBox("", false);
        JLabel labelPr76 = new JLabel("4.09(4) Верх  10.4.6.76");
        labelPr76.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr76 = new JCheckBox("", false);
        JLabel labelPr77 = new JLabel("4.09(4) Низ   10.4.6.77");
        labelPr77.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr77 = new JCheckBox("", false);
        JLabel labelAll = new JLabel("Все приборы");
        labelAll.setFont(new Font("Calibri", Font.PLAIN, 22));
        JCheckBox checkBoxAll = new JCheckBox("", false);
        JButton button1 = new JButton("Далее");
        JButton button2 = new JButton("Назад");


        container.add(labelPr70);
        container.add(checkBoxPr70);
        container.add(labelPr71);
        container.add(checkBoxPr71);
        container.add(labelPr72);
        container.add(checkBoxPr72);
        container.add(labelPr73);
        container.add(checkBoxPr73);
        container.add(labelPr74);
        container.add(checkBoxPr74);
        container.add(labelPr75);
        container.add(checkBoxPr75);
        container.add(labelPr76);
        container.add(checkBoxPr76);
        container.add(labelPr77);
        container.add(checkBoxPr77);
        container.add(labelAll);
        container.add(checkBoxAll);
        container.add(button2);
        container.add(button1);



        button1.addActionListener(e -> {

            if (checkBoxPr70.isSelected()) {
                ip_list=ip_list + "10.4.6.70 ";
            }

            if (checkBoxPr71.isSelected()) {
                ip_list=ip_list + "10.4.6.71 ";
            }

            if (checkBoxPr72.isSelected()) {
                ip_list=ip_list + "10.4.6.72 ";
            }

            if (checkBoxPr73.isSelected()) {
                ip_list=ip_list + "10.4.6.73 ";
            }

            if (checkBoxPr74.isSelected()) {
                ip_list=ip_list + "10.4.6.74 ";
            }

            if (checkBoxPr75.isSelected()) {
                ip_list=ip_list + "10.4.6.75 ";
            }

            if (checkBoxPr76.isSelected()) {
                ip_list=ip_list + "10.4.6.76 ";
            }

            if (checkBoxPr77.isSelected()) {
                ip_list=ip_list + "10.4.6.77 ";
            }

            if (checkBoxAll.isSelected()) {
                ip_list=ip_list + "10.4.6.70 10.4.6.71 10.4.6.72 10.4.6.73 10.4.6.74 10.4.6.75 10.4.6.76 10.4.6.77";
            }


            // Открытие консолей
            if (num == 1) {
                if (ip_list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Выберите хотя бы один прибор!");
                    setVisible(false);
                    ChangePrib prib = new ChangePrib(1);
                    prib.setVisible(true);
                    return;
                }

                setVisible(false);
                OpenConsole openConsole = new OpenConsole();
                openConsole.open();
            }


            // Обновление прибора 4.09
            if (num == 2) {
                if (ip_list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Выберите хотя бы один прибор!");
                    setVisible(false);
                    ChangePrib prib = new ChangePrib(2);
                    prib.setVisible(true);
                    return;
                }

                setVisible(false);
                Prib09_update prib = new Prib09_update();
                prib.setVisible(true);
            }


            // Перевод на ШТАТ или СП
            if (num == 3) {
                if (ip_list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Выберите хотя бы один прибор!");
                    setVisible(false);
                    ChangePrib prib = new ChangePrib(3);
                    prib.setVisible(true);
                    return;
                }

                setVisible(false);
                SPorSHTAT prib = new SPorSHTAT();
                prib.setVisible(true);
            }

            // Выполнение команды
            if (num == 4) {
                if (ip_list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Выберите хотя бы один прибор!");
                    setVisible(false);
                    ChangePrib prib = new ChangePrib(4);
                    prib.setVisible(true);
                    return;
                }

                setVisible(false);
                Command command = new Command();
                command.setVisible(true);
            }

        });

        button2.addActionListener(e -> {
            setVisible(false);
            JFrame frame = new JFrame();
            frame.setVisible(true);
        });

    }

}
