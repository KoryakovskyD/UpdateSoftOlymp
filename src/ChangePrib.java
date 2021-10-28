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


        JLabel labelPr70 = new JLabel(DeviceIp.DEVICE1.getComment() + "  " + DeviceIp.DEVICE1.getIp());
        labelPr70.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr70 = new JCheckBox("", false);
        JLabel labelPr71 = new JLabel(DeviceIp.DEVICE2.getComment() + "  " + DeviceIp.DEVICE2.getIp());
        labelPr71.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr71 = new JCheckBox("", false);
        JLabel labelPr72 = new JLabel(DeviceIp.DEVICE3.getComment() + "  " + DeviceIp.DEVICE3.getIp());
        labelPr72.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr72 = new JCheckBox("", false);
        JLabel labelPr73 = new JLabel(DeviceIp.DEVICE4.getComment() + "  " + DeviceIp.DEVICE4.getIp());
        labelPr73.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr73 = new JCheckBox("", false);
        JLabel labelPr74 = new JLabel(DeviceIp.DEVICE5.getComment() + "  " + DeviceIp.DEVICE5.getIp());
        labelPr74.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr74 = new JCheckBox("", false);
        JLabel labelPr75 = new JLabel(DeviceIp.DEVICE6.getComment() + "  " + DeviceIp.DEVICE6.getIp());
        labelPr75.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr75 = new JCheckBox("", false);
        JLabel labelPr76 = new JLabel(DeviceIp.DEVICE7.getComment() + "  " + DeviceIp.DEVICE7.getIp());
        labelPr76.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxPr76 = new JCheckBox("", false);
        JLabel labelPr77 = new JLabel(DeviceIp.DEVICE8.getComment() + "  " + DeviceIp.DEVICE8.getIp());
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
                ip_list=ip_list + DeviceIp.DEVICE1.getIp() + " ";
            }

            if (checkBoxPr71.isSelected()) {
                ip_list=ip_list + DeviceIp.DEVICE2.getIp() + " ";
            }

            if (checkBoxPr72.isSelected()) {
                ip_list=ip_list + DeviceIp.DEVICE3.getIp() + " ";
            }

            if (checkBoxPr73.isSelected()) {
                ip_list=ip_list + DeviceIp.DEVICE4.getIp() + " ";
            }

            if (checkBoxPr74.isSelected()) {
                ip_list=ip_list + DeviceIp.DEVICE5.getIp() + " ";
            }

            if (checkBoxPr75.isSelected()) {
                ip_list=ip_list + DeviceIp.DEVICE6.getIp() + " ";
            }

            if (checkBoxPr76.isSelected()) {
                ip_list=ip_list + DeviceIp.DEVICE7.getIp() + " ";
            }

            if (checkBoxPr77.isSelected()) {
                ip_list=ip_list + DeviceIp.DEVICE8.getIp() + " ";
            }

            if (checkBoxAll.isSelected()) {
                ip_list=ip_list + DeviceIp.DEVICE1.getIp() + " " + DeviceIp.DEVICE2.getIp() + " " + DeviceIp.DEVICE3.getIp() + " " +
                        DeviceIp.DEVICE4.getIp() + " " + DeviceIp.DEVICE5.getIp() + " " + DeviceIp.DEVICE6.getIp() + " " +
                        DeviceIp.DEVICE7.getIp() + " " + DeviceIp.DEVICE8.getIp();
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
