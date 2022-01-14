import client.Client;
import frame.JFrame;
import server.Server;

import java.io.IOException;

public class UpdateSoftOlymp {
    public static void main (String args[]) throws IOException {
        if (args[0].equals("client")) {
            Client client = new Client();
            client.run();
        } else {
            new JFrame();
            Server server = new Server();
            server.run();
        }
    }
}
