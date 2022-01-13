package ping;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import lists.*;


public class PingHostsRio extends AbstractPingHosts {
    private static final String dirPngGreen="png/green.png";
    private static final String dirPngRed="png/red.png";
    private static boolean reachable = false;
    private static String ipList ="";
    private ArrayList<JLabel> listLabel = new ArrayList<>();
    private ArrayList<String> listIp = new ArrayList<>();


    public PingHostsRio() {
        super("РИО");
        this.setSize(new Dimension(220,600));
        this.setLocation(280,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Cambria",Font.PLAIN, 15);

        JPanel container = new JPanel(new GridLayout(0,2));


        JButton button1 = new JButton("Закрыть");
        JButton button2 = new JButton("Зациклить");

        // Создадим список с приборами РИО
        ipList = "";
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
                    listIp.add(ip);
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
            listLabel.add(host);
            container.add(host);
            if (reachable == true) {
                container.add(green);
                listLabel.add(green);
            } else {
                container.add(red);
                listLabel.add(red);
            }
        }

        container.add(button1);
        container.add(button2);
        add(container,BorderLayout.CENTER);

        button1.addActionListener(e -> {
            setVisible(false);
        });

        button2.addActionListener(e -> {
            button2.setEnabled(false);
            new Thread(() -> {
                while (true) {
                    reachable = false;
                    String curIP="";
                    int i = 0;
                    for (JLabel lbl : listLabel) {
                        if (lbl.getText() != null) {
                            curIP = listIp.get(i);
                            i++;
                        } else {
                            PingFunc(curIP);
                            if (reachable == true) {
                                lbl.setIcon(new ImageIcon(dirPngGreen));
                            } else {
                                lbl.setIcon(new ImageIcon(dirPngRed));
                            }
                        }
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        });
    }
}



