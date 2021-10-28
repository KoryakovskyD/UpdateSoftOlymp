import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class PingHostsSecond extends javax.swing.JFrame {

    private static final String dirPngGreen="png/green.png";
    private static final String dirPngRed="png/red.png";
    private static boolean reachable;
    private static final String ipList="10.3.6.70 10.3.6.71 10.3.6.72 10.3.6.73 10.3.6.74 10.3.6.75 10.3.6.76 10.3.6.77 10.3.6.99";

    public PingHostsSecond() {
        super("10.3.6.0");
        this.setSize(new Dimension(220,400));
        this.setLocation(1470,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Cambria",Font.PLAIN, 15);

        final Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));

        JButton button1 = new JButton("Закрыть");
        JButton button2 = new JButton("Обновить");


        // Запуск окна "Пожалуйста, подождите"
        Wait wait = new Wait();
        wait.setVisible(true);

        reachable = false;
        for (String ip : ipList.split(" ")) {
            JLabel host = new JLabel(ip);
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
            PingHostsSecond pingSec = new PingHostsSecond();
            pingSec.setVisible(true);
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



