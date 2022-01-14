package ping;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import actions.AppProperties;
import lists.*;

public class PingHostsIntel extends AbstractPingHosts {

    private static final String dirPngGreen="png/green.png";
    private static final String dirPngRed="png/red.png";
    private static String ipList= "";
    private static boolean reachable = false;
    private ArrayList<JLabel> listLabel = new ArrayList<>();
    private String setMode;
    private JProgressBar progressBar;


    public PingHostsIntel(String setMode) {
        super("Пинг");
        this.setMode = setMode;
        this.setSize(new Dimension(220,400));
        this.setLocation(1270,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AppProperties ap = new AppProperties();

        Font font = new Font("Cambria",Font.PLAIN, 15);
        JPanel container = new JPanel(new GridLayout(0,2));
        JButton button1 = new JButton("Закрыть");
        JButton button2 = new JButton("Зациклить");
        JButton button3 = new JButton(ap.getProp().getProperty("secondNetwork"));
        JButton button4 = new JButton("РИО");
        progressBar = new JProgressBar(0, 100);
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        progressBar.setString("Please, wait...");



        // Создадим список с приборами Intel
        ipList = "";
        for (IpListIntel ipListIntel : IpListIntel.values()) {
            if (ipListIntel.getIp().contains("55") || ipListIntel.getIp().contains("99")) continue;

            if (setMode.equals(ap.getProp().getProperty("network")))
                ipList += ipListIntel.getIp() + " ";
            else
                ipList += ipListIntel.getSecondIp() + " ";
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

        if (setMode.equals(ap.getProp().getProperty("network"))) {
            container.add(button3);
            container.add(button4);
        }
        container.add(button1);
        container.add(button2);
        add(container,BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);
        progressBar.setVisible(false);


        button1.addActionListener(e -> {
            setVisible(false);
        });


        button2.addActionListener(e -> {
            button2.setEnabled(false);
            new Thread(() -> {
                while (true) {
                    reachable = false;
                    String saveIP="";
                    for (JLabel lbl : listLabel) {
                        if (lbl.getText() != null) {
                            saveIP = lbl.getText();
                        } else {
                            PingFunc(saveIP);
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

        button3.addActionListener(e -> {
            new Thread(() -> {
                progressBar.setVisible(true);
                PingHostsIntel pingHosts = new PingHostsIntel(ap.getProp().getProperty("secondNetwork"));
                pingHosts.setVisible(true);
                progressBar.setVisible(false);
            }).start();
        });

        button4.addActionListener(e -> {
            new Thread(() -> {
                progressBar.setVisible(true);
                PingHostsRio pingRio = new PingHostsRio();
                pingRio.setVisible(true);
                progressBar.setVisible(false);
            }).start();
        });
    }
}



