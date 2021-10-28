import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SPorSHTAT extends javax.swing.JFrame{


    public SPorSHTAT() {
        super("SP или SHTAT");
        this.setBounds(500, 500, 480, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0, 2));


        JButton button1 = new JButton("SP");
        JButton button2 = new JButton("SHTAT");

        container.add(button1);
        container.add(button2);


        button1.addActionListener(e -> {
            setVisible(false);
            SPorSHTAT prib = new SPorSHTAT();
            prib.start(1);
        });


        button2.addActionListener(e -> {
            setVisible(false);
            SPorSHTAT prib = new SPorSHTAT();
            prib.start(2);
        });
    }



    public static void start(int num){
        // Список ip-адресов выбранных прибор
        String ip_list = ChangePrib.getIp_list();
        String command;


        if (num == 1) {
            command="touch /home/mfp/SP_MODE";
        } else {
            command="rm /home/mfp/SP_MODE";
        }


        // Пробежка по каждой машине
        for (String ip:ip_list.split(" ")) {

            String command3 = "sshpass -p wizard ssh root@" + ip + " \"" + command + "\"";
            // Запуск скрипта update_soft
            try {
                Process threadBash = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", command3});
                threadBash.waitFor();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        System.exit(0);
    }
}
