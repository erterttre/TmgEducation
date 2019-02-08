package Lesson07;

public class NewServer {
    public static void main(String[] args) {
        System.out.println("server");
        Server server = new Server();
        //server.port = 4444;
        server.start();
    }
}
