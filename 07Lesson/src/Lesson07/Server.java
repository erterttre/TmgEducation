package Lesson07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server  extends Thread{

    public static ArrayList<Connection> connections = new ArrayList<>();
    public  int port = 4444;
    private static ServerSocket ss;

    public Server() {
        try {
            ss = new ServerSocket(port);
            System.out.println("Server started!");
            while (true) {
                Socket socket = ss.accept();
                connections.add(new Connection(socket));
                System.out.println("We have new client");
            }
        } catch (IOException ex) {
        }
    }
}
