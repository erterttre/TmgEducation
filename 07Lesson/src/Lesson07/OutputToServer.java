package Lesson07;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class OutputToServer extends Thread {
    private DataOutputStream output;
    private Scanner scan;

    public OutputToServer() {
        try {
            output = new DataOutputStream(Client.cs.getOutputStream());
            scan = new Scanner(System.in);
            start();
        } catch (IOException ex) {
        }
    }

    public void run() {
        while (true) {
            String data = scan.nextLine();
            if (data != null) {
                sendText(data);
            }
        }
    }

    private void sendText(String text) {
        try {
            output.writeUTF(text);
        } catch (IOException ex) {
        }
    }
}
