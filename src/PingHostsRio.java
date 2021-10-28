import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class PingHostsRio extends javax.swing.JFrame {

    private static final String dirPngGreen="png/green.png";
    private static final String dirPngRed="png/red.png";
    private static boolean reachable;
    private static final String ipList= DeviceIp.RIO1.getComment() + ":" + DeviceIp.RIO1.getIp() + " " +
            DeviceIp.RIO2.getComment() + ":" + DeviceIp.RIO2.getIp() + " " +
            DeviceIp.RIO3.getComment() + ":" + DeviceIp.RIO3.getIp() + " " +
            DeviceIp.RIO4.getComment() + ":" + DeviceIp.RIO4.getIp() + " " +
            DeviceIp.RIO5.getComment() + ":" + DeviceIp.RIO5.getIp() + " " +
            DeviceIp.RIO6.getComment() + ":" + DeviceIp.RIO6.getIp() + " " +
            DeviceIp.RIO7.getComment() + ":" + DeviceIp.RIO7.getIp() + " " +
            DeviceIp.RIO8.getComment() + ":" + DeviceIp.RIO8.getIp() + " " +
            DeviceIp.RIO9.getComment() + ":" + DeviceIp.RIO9.getIp() + " " +
            DeviceIp.RIO10.getComment() + ":" + DeviceIp.RIO10.getIp() + " " +
            DeviceIp.RIO11.getComment() + ":" + DeviceIp.RIO11.getIp() + " " +
            DeviceIp.RIO12.getComment() + ":" + DeviceIp.RIO12.getIp() + " " +
            DeviceIp.RIO13.getComment() + ":" + DeviceIp.RIO13.getIp() + " " +
            DeviceIp.RIO14.getComment() + ":" + DeviceIp.RIO14.getIp() + " " +
            DeviceIp.RIO15.getComment() + ":" + DeviceIp.RIO15.getIp() + " " +
            DeviceIp.RIO16.getComment() + ":" + DeviceIp.RIO16.getIp() + " " +
            DeviceIp.RIO17.getComment() + ":" + DeviceIp.RIO17.getIp();


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



