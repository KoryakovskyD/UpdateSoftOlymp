import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Prib09_update extends javax.swing.JFrame {

    public Prib09_update() {
        super("Прибор 4.09");
        this.setBounds(450,450,410,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout( 0,2));

        JLabel labelSysFiles = new JLabel(" Системные файлы");
        labelSysFiles.setFont(new Font("Serif", Font.PLAIN, 18));
        labelSysFiles.setToolTipText("Настройки МСВС");
        JCheckBox checkBoxSysFiles = new JCheckBox("", false);
        JLabel labelASK = new JLabel(" ASK");
        labelASK.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxASK = new JCheckBox("",false);
        JLabel labelOGS_VP = new JLabel(" OGS_VP");
        labelOGS_VP.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxOGS_VP = new JCheckBox("",false);
        JLabel labelSGR = new JLabel(" SGR");
        labelSGR.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxSGR = new JCheckBox("",false);
        JLabel labelSORD = new JLabel(" SORD");
        labelSORD.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxSORD = new JCheckBox("",false);
        JLabel labelSORD_TECH = new JLabel(" SORD_TECH");
        labelSORD_TECH.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxSORD_TECH = new JCheckBox("",false);
        JLabel labelSPPR_FMO = new JLabel(" SPPR_FMO");
        labelSPPR_FMO.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxSPPR_FMO = new JCheckBox("",false);
        JLabel labelTSYNC = new JLabel(" TSYNC");
        labelTSYNC.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxTSYNC = new JCheckBox("",false);
        JLabel labelStartPO = new JLabel(" start_po_mfp");
        labelStartPO.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxStartPO = new JCheckBox("",false);
        JLabel labelSYS_SPO = new JLabel(" Системное ПО");
        labelSYS_SPO.setFont(new Font("Serif", Font.PLAIN, 18));
        labelSYS_SPO.setToolTipText("rconf, poweroff, ndisp, remount_snd, poweroff, mountNfds");
        JCheckBox checkBoxSYS_SPO = new JCheckBox("",false);
        JLabel labelSP = new JLabel(" SP");
        labelSP.setFont(new Font("Serif", Font.PLAIN, 18));
        JCheckBox checkBoxSP = new JCheckBox("",false);
        JLabel labelAgatTests = new JLabel(" AgatTests");
        labelAgatTests.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxAgatTests = new JCheckBox("",false);
        JLabel labelDrWeb = new JLabel(" DrWeb");
        labelDrWeb.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxDrWeb = new JCheckBox("",false);
        JLabel labelRamec = new JLabel(" Ramec");
        labelRamec.setFont(new Font("Calibri", Font.PLAIN, 20));
        JCheckBox checkBoxRamec = new JCheckBox("",false);
        JLabel labelGIS = new JLabel(" GIS");
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
        container.add(labelOGS_VP);
        container.add(checkBoxOGS_VP);
        container.add(labelSGR);
        container.add(checkBoxSGR);
        container.add(labelSORD);
        container.add(checkBoxSORD);
        container.add(labelSORD_TECH);
        container.add(checkBoxSORD_TECH);
        container.add(labelSPPR_FMO);
        container.add(checkBoxSPPR_FMO);
        container.add(labelSP);
        container.add(checkBoxSP);
        container.add(line1);
        container.add(line2);
        container.add(labelTSYNC);
        container.add(checkBoxTSYNC);
        container.add(labelStartPO);
        container.add(checkBoxStartPO);
        container.add(labelSysFiles);
        container.add(checkBoxSysFiles);
        container.add(labelSYS_SPO);
        container.add(checkBoxSYS_SPO);
        container.add(lineAnotherPO);
        container.add(labelAnotherPO);
        container.add(labelAgatTests);
        container.add(checkBoxAgatTests);
        container.add(labelRamec);
        container.add(checkBoxRamec);
        container.add(labelDrWeb);
        container.add(checkBoxDrWeb);
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

            String command = "update 09 ";

            //                      ПО работяг                    //
            // Копирование ASK
            if (checkBoxASK.isSelected()) {
                command = command + "ASK ";
            }

            // Копирование OGS_VP
            if (checkBoxOGS_VP.isSelected()) {
                command = command + "OGS_VP ";
            }

            // Копирование SGR
            if (checkBoxSGR.isSelected()) {
                command = command + "SGR ";
            }
            // Копирование SORD
            if (checkBoxSORD.isSelected()) {
                command = command + "SORD ";
            }

            // Копирование SORD_TECH
            if (checkBoxSORD_TECH.isSelected()) {
                command = command + "SORD_TECH ";
            }

            // Копирование SPPR_FMO
            if (checkBoxSPPR_FMO.isSelected()) {
                command = command + "SPPR_FMO ";
            }

            // Копирование SP
            if (checkBoxSP.isSelected()) {
                command = command + "SP_MODE ";
            }


            //                    Системное ПО                   //
            // Копирование TSYNC
            if (checkBoxTSYNC.isSelected()) {
                command = command + "TSYNC ";
            }

            // Копирование SysFiles
            if (checkBoxSysFiles.isSelected()) {
                command = command + "SysFiles ";
            }

            // Копирование файла start_po_mfp
            if (checkBoxStartPO.isSelected()) {
                command = command + "start_po_mfp ";
            }

            // Копирование системнго ПО
            if (checkBoxSYS_SPO.isSelected()) {
                command = command + "SYS_SPO ";
            }


            String installOtherPO = "install_another_po 09 ";
            //                    Заимствованное ПО              //
            // Копирование тестов Агата
            if (checkBoxAgatTests.isSelected()) {
                installOtherPO = installOtherPO + "AgatTests ";
            }

            // Копирование агента Рамека
            if (checkBoxRamec.isSelected()) {
                installOtherPO = installOtherPO + "Ramec ";
            }

            // Копирование агента Рамека
            if (checkBoxDrWeb.isSelected()) {
                installOtherPO = installOtherPO + "DrWeb ";
            }

            // Копирование карт GIS
            if (checkBoxGIS.isSelected()) {
                installOtherPO = installOtherPO + "GIS ";
            }

            // Прошивка
            if (checkBoxAll.isSelected()) {
                command = "update 09 All ASK OGS_VP SGR SORD SORD_TECH SPPR_FMO SP_MODE TSYNC SysFiles start_po_mfp SYS_SPO";
            }


            // Список ip-адресов выбранных прибор
            String ip_list = ChangePrib.getIp_list();

            // Запуск окна "Пожалуйста, подождите"
            Wait wait = new Wait();
            wait.setVisible(true);


            // Пробежка по каждой машине
            for (String ip:ip_list.split(" ")) {

                String command3 = "sshpass -p wizard ssh root@" + ip + " \"mkdir -p /mnt/net; sudo mount 10.4.6.55:/home/PROJECTS /mnt/net; /mnt/net/OLYMP-G/FLASH/INTEL/COMMON/SPO/UpdateSoftOlymp/" + command + "; sudo umount -l /mnt/net\"";
                // Запуск скрипта update_soft
                try {
                    Process threadBash = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", command3});
                    threadBash.waitFor();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }

                String comandInstallOtherPO = "sshpass -p wizard ssh root@" + ip + " \"sudo mount 10.4.6.55:/home/PROJECTS /mnt/net; /mnt/net/OLYMP-G/FLASH/INTEL/COMMON/SPO/UpdateSoftOlymp/" + installOtherPO + "; sudo umount -l /mnt/net\"";
                // Запуск скрипта update_soft
                try {
                    Process threadBash = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", comandInstallOtherPO});
                    threadBash.waitFor();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }

                String comandCCS = "sshpass -p wizard ssh root@" + ip + " \"sudo mount 10.4.6.55:/home/PROJECTS /mnt/net; cd /mnt/net/OLYMP-G/FLASH/INTEL/COMMON/SPO/ccs; ./ccs; sudo umount -l /mnt/net\"";
                // Запуск скрипта ccs
                if (checkBoxCCS.isSelected()) {
                   try {
                       Process threadBash = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", comandCCS});
                       threadBash.waitFor();
                   } catch (IOException e1) {
                      e1.printStackTrace();
                   } catch (InterruptedException e2) {
                      e2.printStackTrace();
                   }
                }


            }


            JOptionPane.showMessageDialog(null, "Обновление успешно завершено!");

            wait.setVisible(false);
            setVisible(false);
            // Выход из программы
            System.exit(0);
        });


        // Кнопка назад
        button2.addActionListener(e -> {
            ChangePrib.setIp_list("");
            setVisible(false);
            ChangePrib frame = new ChangePrib(2);
            frame.setVisible(true);
        });

    }

}