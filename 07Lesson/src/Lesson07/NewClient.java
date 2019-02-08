package Lesson07;

public class NewClient {
    public static void main(String[] args) {
        System.out.println("client");
        Client client = new Client();
        //client.address = "127.0.0.1";
        //client.port = 4444;
        client.start();
    }
}
