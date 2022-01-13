package ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class AbstractPingHosts extends javax.swing.JFrame {
    private static boolean reachable = false;

    public AbstractPingHosts(String setMode) {
    }


    public static void PingFunc(String ip) {
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



