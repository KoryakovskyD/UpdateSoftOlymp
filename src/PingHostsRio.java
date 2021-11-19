import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EnumSet;


public class PingHostsRio extends javax.swing.JFrame {

    private static final String dirPngGreen="png/green.png";
    private static final String dirPngRed="png/red.png";
    private static boolean reachable = false;
    private static String ipList ="";


    public PingHostsRio() {
        super("РИО");
        this.setSize(new Dimension(220,600));
        this.setLocation(280,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Cambria",Font.PLAIN, 15);

        final Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));


        JButton button1 = new JButton("Закрыть");
        JButton button2 = new JButton("Обновить");

        // Запуск окна "Пожалуйста, подождите"
        Wait wait = new Wait();
        wait.setVisible(true);

        // Создадим список с приборами РИО
        for (IpListRio ipListRio : IpListRio.values()) {
            ipList += ipListRio.getComment() + ":" + ipListRio.getIp() + " ";
        }

        for (String str:ipList.split(" ")) {
            String ip = "";
            String prib = "";
            int count = 0;
            for (String str2 : str.split(":")) {
                if (count != 0) {
                    ip = str2;
                    break;
                }
                count++;
                prib = str2;
            }

            JLabel host = new JLabel(prib);
            host.setPreferredSize(new Dimension(150, 40));
            host.setFont(font);
            JLabel red = new JLabel(new ImageIcon(dirPngRed));
            red.setVisible(true);
            JLabel green = new JLabel(new ImageIcon(dirPngGreen));
            green.setVisible(true);
            PingFunc(ip);
            container.add(host);
            if (reachable == true) {
                container.add(green);
            } else {
                container.add(red);
            }
        }

        container.add(button1);
        container.add(button2);

        wait.setVisible(false);



        button1.addActionListener(e -> {
            setVisible(false);
        });


        button2.addActionListener(e -> {
            setVisible(false);
            PingHostsRio pingRio = new PingHostsRio();
            pingRio.setVisible(true);
        });
    }



    public static void PingFunc( String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            try {
                reachable = address.isReachable(1500);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}



