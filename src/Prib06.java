import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Prib06 extends javax.swing.JFrame {

    public Prib06() {
        super(DeviceIp.DEVICE9.getComment());
        this.setBounds(450,450,410,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));

        JLabel labelSysFiles = new JLabel(" Системные файлы");
        labelSysFiles.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxSysFiles = new JCheckBox("Настройки МСВС", false);
        JLabel labelASK = new JLabel(" ASK");
        labelASK.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxASK = new JCheckBox("",false);
        JLabel labelLDB_CLI = new JLabel(" LDB_CLI");
        labelLDB_CLI.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxLDB_CLI = new JCheckBox("",false);
        JLabel labelMSP = new JLabel(" MSP");
        labelMSP.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxMSP = new JCheckBox("",false);
        JLabel labelSVS = new JLabel(" SVS");
        labelSVS.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxSVS = new JCheckBox("",false);
        JLabel labelTSYNC = new JLabel(" TSYNC");
        labelTSYNC.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxTSYNC = new JCheckBox("",false);
        JLabel labelMSE = new JLabel(" Межсетевой экран");
        labelMSE.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxMSE = new JCheckBox("",false);
        JLabel labelStartPO = new JLabel(" start_po_mfp");
        labelStartPO.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxStartPO = new JCheckBox("",false);
        JLabel labelRconf = new JLabel(" rconf");
        labelRconf.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxRconf = new JCheckBox("",false);
        JLabel labelSP = new JLabel(" SP");
        labelSP.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxSP = new JCheckBox("",false);
        JLabel labelTU = new JLabel(" TU");
        labelTU.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxTU = new JCheckBox("",false);
        JLabel labelDWeb = new JLabel(" DrWeb");
        labelDWeb.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxDWeb = new JCheckBox("",false);
        JLabel labelRamec = new JLabel(" Ramec");
        labelRamec.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxRamec = new JCheckBox("",false);
        JLabel labelLinter = new JLabel(" Linter");
        labelLinter.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxlinter = new JCheckBox("",false);
        JLabel labelGIS = new JLabel(" GIS 'Апдейтер'");
        labelGIS.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxGIS = new JCheckBox("",false);
        JLabel labelAll = new JLabel(" Прошивка");
        labelAll.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxAll = new JCheckBox("",false);
        JLabel labelCCS = new JLabel(" CCS");
        labelCCS.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxCCS = new JCheckBox("",false);
        JLabel line1 = new JLabel("--------------------------");
        line1.setFont(new Font("Calibri", Font.PLAIN, 20));
        JLabel line2 = new JLabel("СПО");
        line2.setFont(new Font("Calibri", Font.PLAIN, 20));
        JLabel labelFPO = new JLabel("ФПО");
        labelFPO.setFont(new Font("Calibri", Font.PLAIN, 20));
        JLabel lineFPO = new JLabel("--------------------------");
        lineFPO.setFont(new Font("Calibri", Font.PLAIN, 20));
        JLabel labelAnotherPO = new JLabel("Заимствованное ПО");
        labelAnotherPO.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel lineAnotherPO = new JLabel("--------------------------");
        lineAnotherPO.setFont(new Font("Calibri", Font.PLAIN, 20));
        JLabel labelEnd = new JLabel("Прошивка и CCS");
        labelEnd.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel lineEnd = new JLabel("--------------------------");
        lineEnd.setFont(new Font("Calibri", Font.PLAIN, 20));


        JButton button1 = new JButton("Далее");
        JButton button2 = new JButton("Назад");

        container.add(lineFPO);
        container.add(labelFPO);
        container.add(labelASK);
        container.add(checkBoxASK);
        container.add(labelLDB_CLI);
        container.add(checkBoxLDB_CLI);
        container.add(labelMSP);
        container.add(checkBoxMSP);
        container.add(labelSVS);
        container.add(checkBoxSVS);
        container.add(labelSP);
        container.add(checkBoxSP);
        container.add(labelTU);
        container.add(checkBoxTU);
        container.add(line1);
        container.add(line2);
        container.add(labelTSYNC);
        container.add(checkBoxTSYNC);
        container.add(labelMSE);
        container.add(checkBoxMSE);
        container.add(labelStartPO);
        container.add(checkBoxStartPO);
        container.add(labelSysFiles);
        container.add(checkBoxSysFiles);
        container.add(labelRconf);
        container.add(checkBoxRconf);
        container.add(lineAnotherPO);
        container.add(labelAnotherPO);
        container.add(labelDWeb);
        container.add(checkBoxDWeb);
        container.add(labelRamec);
        container.add(checkBoxRamec);
        container.add(labelLinter);
        container.add(checkBoxlinter);
        container.add(labelGIS);
        container.add(checkBoxGIS);
        container.add(lineEnd);
        container.add(labelEnd);
        container.add(labelAll);
        container.add(checkBoxAll);
        container.add(labelCCS);
        container.add(checkBoxCCS);
        container.add(button2);
        container.add(button1);



        button1.addActionListener(e -> {

            String command = "update 06 ";

            //                         ПО работяг                       //
            // Копирование ASK
            if (checkBoxASK.isSelected()) {
                command = command + "ASK ";
            }

            // Копирование LDB_CLI
            if (checkBoxLDB_CLI.isSelected()) {
                command = command + "LDB_CLI ";
            }
            // Копирование MSP
            if (checkBoxMSP.isSelected()) {
                command = command + "MSP ";
            }

            // Копирование SVS
            if (checkBoxSVS.isSelected()) {
                command = command + "SVS ";
            }

            // Копирование SP
            if (checkBoxSP.isSelected()) {
                command = command + "SP ";
            }

            // Копирование TU
            if (checkBoxTU.isSelected()) {
                command = command + "TU ";
            }


            //                       Системное СПО                     //
            // Копирование TSYNC
            if (checkBoxTSYNC.isSelected()) {
                command = command + "TSYNC ";
            }

            // Копирование MSE
            if (checkBoxMSE.isSelected()) {
                command = command + "MSE ";
            }

            // Копирование SysFiles
            if (checkBoxSysFiles.isSelected()) {
                command = command + "SysFiles ";
            }

            // Копирование файла start_po_mfp
            if (checkBoxStartPO.isSelected()) {
                command = command + "start_po_mfp ";
            }

            // Копирование rconf
            if (checkBoxRconf.isSelected()) {
                command = command + "rconf ";
            }

            String installOtherPO = "install_another_po 06 ";
            //                      Заимствованное ПО                  //
            // Копирование DrWeb
            if (checkBoxDWeb.isSelected()) {
                //installOtherPO = "DrWebInstall";
                installOtherPO = installOtherPO + "DrWeb ";
            }

            // Копирование агента Ramec
            if (checkBoxRamec.isSelected()) {
                installOtherPO = installOtherPO + "Ramec ";
            }

            // Копирование базы данных Linter
            if (checkBoxlinter.isSelected()) {
                installOtherPO = installOtherPO + "Linter ";
            }

            // Копирование апдейтера GIS
            if (checkBoxGIS.isSelected()) {
                installOtherPO = installOtherPO + "GIS ";
            }



            // Прошивка
            if (checkBoxAll.isSelected()) {
                command = "update 06 All ASK LDB_CLI MSP SVS SP TU TSYNC MSE SysFiles start_po_mfp rconf";
            }


            // Запуск окна "Пожалуйста, подождите"
            Wait wait = new Wait();
            wait.setVisible(true);

            BashCommand.pushCommand("sshpass -p wizard ssh root@" + DeviceIp.DEVICE9.getIp() + " \"mkdir -p /mnt/net; mount " +
                    DeviceIp.SERVER.getSecondIp() + ":/home/PROJECTS /mnt/net; /mnt/net/OLYMP-G/FLASH/INTEL/COMMON/SPO/UpdateSoftOlymp/" +
                    command + "; sudo umount -l /mnt/net\"");

            BashCommand.pushCommand("sshpass -p wizard ssh root@" + DeviceIp.DEVICE9.getIp() + " \"mkdir -p /mnt/net; mount " +
                    DeviceIp.SERVER.getSecondIp() + ":/home/PROJECTS /mnt/net; /mnt/net/OLYMP-G/FLASH/INTEL/COMMON/SPO/UpdateSoftOlymp/" +
                    installOtherPO + "; sudo umount -l /mnt/net\"");

            BashCommand.pushCommand("sshpass -p wizard ssh root@" + DeviceIp.DEVICE9.getIp() + " \"mkdir -p /mnt/net; mount " + DeviceIp.SERVER.getSecondIp() +
                    ":/home/PROJECTS /mnt/net; cd /mnt/net/OLYMP-G/FLASH/INTEL/COMMON/SPO/ccs; ./ccs; cd /mnt/net/OLYMP-G/FLASH.TU/INTEL/06/6.06/SPO/ccs;" +
                    " ./ccs; sudo umount -l /mnt/net\"");


            JOptionPane.showMessageDialog(null, "Обновление успешно завершено!");
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
