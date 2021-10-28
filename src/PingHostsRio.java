import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class PingHostsRio extends javax.swing.JFrame {

    private static final String dirPngGreen="png/green.png";
    private static final String dirPngRed="png/red.png";
    private static boolean reachable;
    private static final String ipList="16E01-00:10.4.6.1 16E01-01:10.4.6.3 16E01-02:10.4.6.5 16E01-03:10.4.6.7 16E01-04:10.4.6.9 " +
            "16E01-05:10.4.6.11 13KL01-00:10.4.6.13 13KL01-01:10.4.6.14 16E03-00:10.4.6.15 16E03-01:10.4.6.17 16E04-00:10.4.6.19 " +
            "16E04-01:10.4.6.21 16E05-00:10.4.6.23 16D06-00:10.4.6.25 16E07-00:10.4.6.37 16E08-00:10.4.6.33 16E08-01:10.4.6.35";

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


        reachable = false;

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



