import lists.IpListIntel;

import javax.swing.*;
import java.awt.*;

public class Build extends javax.swing.JFrame {

    public Build() {
        super("Пересборка ФПО");
        this.setBounds(450,450,500,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));


        JLabel labelPrib = new JLabel(" Прибор для пересборки");
        labelPrib.setFont(new Font("Calibri", Font.PLAIN, 18));
        JTextArea jTextAreaBrib = new JTextArea(IpListIntel.DEVICE5.getIp());
        jTextAreaBrib.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel line1 = new JLabel("--------------------------");
        line1.setFont(new Font("Calibri", Font.PLAIN, 20));
        JLabel labelFPO_09 = new JLabel(" Прибор 4.09");
        labelFPO_09.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel labelASK = new JLabel(" ASK");
        labelASK.setFont(new Font("SCalibri", Font.PLAIN, 18));
        JCheckBox checkBoxASK = new JCheckBox("",false);
        JLabel labelOGS_VP = new JLabel(" OGS_VP");
        labelOGS_VP.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxOGS_VP = new JCheckBox("",false);
        JLabel labelSGR = new JLabel(" SGR");
        labelSGR.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxSGR = new JCheckBox("",false);
        JLabel labelSORD = new JLabel(" SORD");
        labelSORD.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxSORD = new JCheckBox("",false);
        JLabel labelSPPR = new JLabel(" SPPR");
        labelSPPR.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxSPPR = new JCheckBox("",false);
        JLabel labelASK_SP = new JLabel(" ASK SP");
        labelASK_SP.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxASK_SP = new JCheckBox("",false);
        JLabel line2 = new JLabel("--------------------------");
        line2.setFont(new Font("Calibri", Font.PLAIN, 20));
        JLabel labelFPO_06 = new JLabel(" Прибор 6.06");
        labelFPO_06.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel labelASK_06 = new JLabel(" ASK");
        labelASK_06.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxASK_06 = new JCheckBox("",false);
        JLabel labelASK_06_SP = new JLabel(" ASK SP");
        labelASK_06_SP.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxASK_06_SP = new JCheckBox("",false);
        JLabel labelLDB_CLI = new JLabel(" LDB_CLI");
        labelLDB_CLI.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxLDB_CLI = new JCheckBox("",false);
        JLabel labelLDB_CLI_SP = new JLabel(" LDB_CLI SP");
        labelLDB_CLI_SP.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxLDB_CLI_SP = new JCheckBox("",false);
        JLabel labelMSP = new JLabel(" MSP");
        labelMSP.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxMSP = new JCheckBox("",false);
        JLabel labelSVS = new JLabel(" SVS");
        labelSVS.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxSVS = new JCheckBox("",false);
        JLabel labelSVS_SP = new JLabel(" SVS SP");
        labelSVS_SP.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxSVS_SP = new JCheckBox("",false);
        JLabel labelAll = new JLabel(" Пересобрать всё ФПО");
        labelAll.setFont(new Font("Calibri", Font.PLAIN, 18));
        JCheckBox checkBoxAll = new JCheckBox("",false);

        JButton button1 = new JButton("Далее");
        JButton button2 = new JButton("Назад");

        container.add(labelPrib);
        container.add(jTextAreaBrib);
        container.add(line1);
        container.add(labelFPO_09);
        container.add(labelASK);
        container.add(checkBoxASK);
        container.add(labelASK_SP);
        container.add(checkBoxASK_SP);
        container.add(labelOGS_VP);
        container.add(checkBoxOGS_VP);
        container.add(labelSGR);
        container.add(checkBoxSGR);
        container.add(labelSORD);
        container.add(checkBoxSORD);
        container.add(labelSPPR);
        container.add(checkBoxSPPR);
        container.add(line2);
        container.add(labelFPO_06);
        container.add(labelASK_06);
        container.add(checkBoxASK_06);
        container.add(labelASK_06_SP);
        container.add(checkBoxASK_06_SP);
        container.add(labelLDB_CLI);
        container.add(checkBoxLDB_CLI);
        container.add(labelLDB_CLI_SP);
        container.add(checkBoxLDB_CLI_SP);
        container.add(labelMSP);
        container.add(checkBoxMSP);
        container.add(labelSVS);
        container.add(checkBoxSVS);
        container.add(labelSVS_SP);
        container.add(checkBoxSVS_SP);
        container.add(labelAll);
        container.add(checkBoxAll);
        container.add(button2);
        container.add(button1);


        button1.addActionListener(e -> {

            String IpPrib=jTextAreaBrib.getText();
            String command = "build ";

                               //                         ПО работяг                       //
            // Пересборка ASK
            if (checkBoxASK.isSelected())
                command = command + "ASK_09 ";

            // Пересборка ASK_SP
            if (checkBoxASK_SP.isSelected())
                command = command + "ASK09_SP ";

            // Пересборка OGS_VP
            if (checkBoxOGS_VP.isSelected())
                command = command + "OGS_VP ";

            // Пересборка SGR
            if (checkBoxSGR.isSelected())
                command = command + "SGR ";

            // Пересборка SORD
            if (checkBoxSORD.isSelected())
                command = command + "SORD ";

            // Пересборка SPPR
            if (checkBoxSPPR.isSelected())
                command = command + "SPPR ";

            // Пересборка ASK_06
            if (checkBoxASK_06.isSelected())
                command = command + "ASK_06 ";

            // Пересборка ASK_06_SP
            if (checkBoxASK_06_SP.isSelected())
                command = command + "ASK06_SP ";

            // Пересборка LDB_CLI
            if (checkBoxLDB_CLI.isSelected())
                command = command + "LDB_CLI06 ";

            // Пересборка LDB_CLI_SP
            if (checkBoxLDB_CLI_SP.isSelected())
                command = command + "LDB_CLISP ";

            // Пересборка MSP
            if (checkBoxMSP.isSelected())
                command = command + "MSP ";

            // Пересборка SVS
            if (checkBoxSVS.isSelected())
                command = command + "SVS06 ";

            // Пересборка SVS_SP
            if (checkBoxSVS_SP.isSelected())
                command = command + "SVS_SP ";

            // Полное обновление
            if (checkBoxAll.isSelected())
                command = "build ASK_09 ASK09_SP OGS_VP SGR SORD SPPR ASK_06 ASK06_SP LDB_CLI06 LDB_CLISP MSP SVS06 SVS_SP";

            // Запуск окна "Пожалуйста, подождите"
            Wait wait = new Wait();
            wait.setVisible(true);

            BashCommand.pushCommand("sshpass -p wizard ssh root@" + IpPrib + " \"sudo mount " + IpListIntel.SERVER.getIp() +
                    ":/home/PROJECTS /mnt/net; /mnt/net/OLYMP-G/FLASH/INTEL/COMMON/SPO/UpdateSoftOlymp/" + command + "; sudo umount -l /mnt/net\"");

            JOptionPane.showMessageDialog(null, "Пересборка успешно завершена!");
            // Выход из программы
            System.exit(0);
        });

        // Кнопка назад
        button2.addActionListener(e -> {
            setVisible(false);
            JFrame frame = new JFrame();
            frame.setVisible(true);
        });
    }
}