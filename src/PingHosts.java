import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;



public class PingHosts extends javax.swing.JFrame {

    private static final String dirPngGreen="png/green.png";
    private static final String dirPngRed="png/red.png";
    private static String ipList= "";
    private static boolean reachable = false;

    public PingHosts() {
        super("Пинг");
        this.setSize(new Dimension(220,400));
        this.setLocation(1270,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Cambria",Font.PLAIN, 15);

        final Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));

        JButton button1 = new JButton("Закрыть");
        JButton button2 = new JButton("Обновить");
        JButton button3 = new JButton("10.3.6.*");
        JButton button4 = new JButton("РИО");


        // Запуск окна "Пожалуйста, подождите"
        Wait wait = new Wait();


        // Создадим список с приборами Intel
        for (IpListIntel ipListIntel : IpListIntel.values()) {
            if (ipListIntel.getIp().contains("55") || ipListIntel.getIp().contains("99")) continue;
            ipList += ipListIntel.getIp() + " ";
        }


        for (String ip:ipList.split(" ")) {
            JLabel host =  new JLabel(ip);
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

        wait.setVisible(false);


        container.add(button3);
        container.add(button4);
        container.add(button1);
        container.add(button2);


        button1.addActionListener(e -> {
            setVisible(false);
        });


        button2.addActionListener(e -> {
            setVisible(false);
            PingHosts ping = new PingHosts();
            ping.setVisible(true);
        });

        button3.addActionListener(e -> {
            PingHostsSecond pingSec = new PingHostsSecond();
            pingSec.setVisible(true);
        });

        button4.addActionListener(e -> {
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



