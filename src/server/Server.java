package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void run() throws IOException {
        System.out.println("Запускаем сервер...");
        ServerSocket servers = new ServerSocket(4444);


        System.out.println("Ждем подключение клиента...");
        Socket serversocket= servers.accept();
        System.out.println("Клиент подключился!");


        BufferedReader in = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));
        PrintStream out = new PrintStream(serversocket.getOutputStream());

        String message;

        message="kek";
        out.println(message);
        System.out.println("Сервер отправил:     " + message);

    }
}

