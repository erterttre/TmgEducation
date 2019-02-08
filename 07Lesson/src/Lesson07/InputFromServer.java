package Lesson07;

import java.io.DataInputStream;
import java.io.IOException;

public class InputFromServer extends Thread {
    private DataInputStream input;

    public InputFromServer() {
        try {
            input = new DataInputStream(Client.cs.getInputStream());
            start();
        } catch (IOException ex) {
        }
    }

    public void run() {
        try {
            while (true) {
                String data = input.readUTF();
                if (data != null) {
                    receiveText(data);
                }
            }
        } catch (IOException ex) {
        }
    }

    private void receiveText(String text){
        if (text.equals("exit")){
            System.out.println("Wrong password!");
            System.exit(0);
        }else System.out.println(text);
    }
}
