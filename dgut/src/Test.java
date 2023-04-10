import java.io.*;
import java.net.*;
import java.util.Scanner;
class TCPServer {
    private static final int PORT = 10006;
    public void listen() throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket client = serverSocket.accept();
        System.out.println("Linking...");
        OutputStream os = client.getOutputStream();
        os.write(new String("hello").getBytes());
        System.out.println("complete!");
        os.close();
        client.close();
    }
}
class TCPClient {
    private static final int PORT = 10006;
    public void connect() throws Exception {
        Socket client = new Socket(InetAddress.getLocalHost(), PORT);
        byte[] bytes = new byte[1024];
        InputStream is = client.getInputStream();
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        is.close();
        client.close();
    }
}
class clientThread implements Runnable {
    @Override
    public void run() {
        TCPClient client = new TCPClient();
        try {
            client.connect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        clientThread run = new clientThread();
        Thread client = new Thread(run);
        client.start();
        TCPServer server = new TCPServer();
        server.listen();

    }
}
