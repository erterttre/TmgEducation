package Lesson07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;

 class Connection extends Thread {

     DataInputStream input;
     DataOutputStream output;
    private Socket socket;
    private String name = "";
    private String magikNumber = "123";
    static String magikNumberFromUser = "";

    public Connection(Socket socket) {
        try {
            this.socket = socket;
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF("Enter Magic:");
            start();
        } catch (IOException ex) {
        }
    }

    public void run() {
        try {
            magikNumberFromUser = input.readUTF();
            if (magikNumber.equals(magikNumberFromUser)) {
                output.writeUTF("Enter your nick:");
                name = input.readUTF();
                while (true) {
                    String data = input.readUTF();
                    receiveText(data);
                }
            }else output.writeUTF("exit");
            }catch(IOException ex){
        }
    }

    private void receiveText(String text) {
        System.out.println(name + " send text: " + text);
        sendText(text);
    }

    private void sendText(String text) {
        try {
            Iterator<Connection> iter = Lesson07.Server.connections.iterator();
            while (iter.hasNext()) {
                iter.next().output.writeUTF(name + ": " + text);
            }
        } catch (IOException ex) {
        }
    }
}
