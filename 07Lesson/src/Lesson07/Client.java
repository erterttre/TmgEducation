package Lesson07;

import java.io.IOException;
import java.net.Socket;

public class Client extends Thread{
    public   int port = 4444;
    public String address="127.0.0.1";
    public static Socket cs;

    public Client() {
        try {
            cs = new Socket(address, port);
            new InputFromServer();
            new OutputToServer();
        } catch (IOException ex) {
        }
    }
}
