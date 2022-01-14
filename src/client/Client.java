package client;

import ping.PingHostsIntel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client implements AutoCloseable {
    private static Socket clientsocket;

    public static void run() throws IOException {

        System.out.println("Запуск клиента...");
        System.out.println("Подключаемся к серверу...");



        while (true) {
            clientsocket = new Socket("192.168.51.53", 4444);
            if (clientsocket == null)
                continue;


        System.out.println(clientsocket);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
        PrintStream out = new PrintStream(clientsocket.getOutputStream());

        String message;

            message = in.readLine();
            System.out.println("Клиент принял команду: " + message);
            if (message.equals("kek")) {
                new Thread(() -> {
                    PingHostsIntel pingHosts = new PingHostsIntel("10.4.6.*");
                    pingHosts.setVisible(true);
                }).start();
            }
            clientsocket = null;
        }
    }

    @Override
    public void close() throws Exception {
        if (clientsocket != null && !clientsocket.isClosed()) {
            clientsocket.close();
        }
    }
}