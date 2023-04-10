import java.io.*;
import java.net.*;//test
import java.util.Scanner;
//UDP transport

class Receive implements Runnable {
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(10000);
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                socket.receive(packet);
                String ip = packet.getAddress().getHostAddress() + ":" + packet.getPort() + ":";
                System.out.println(ip);
                System.out.println(new String(packet.getData(), 0, packet.getLength()));
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*class SendThread implements Runnable {
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner scan = new Scanner(System.in);
            while (true) {
                String str = scan.nextLine();
                if (str.equals("quite")) {
                    break;
                }
                DatagramPacket packet = new DatagramPacket(str.getBytes(), str.length());
                socket.send(packet);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/
public class EasyChat {
    public static void main(String[] args) throws IOException {
        Receive run = new Receive();
        Thread re = new Thread(run);
        re.start();
        try {
            InetAddress me = InetAddress.getLocalHost();
            DatagramSocket socket = new DatagramSocket();
            Scanner scan = new Scanner(System.in);
            while (true) {
                String str = scan.next();
                if (str.equals("quite")) {
                    re.interrupt();
                    break;
                }
                DatagramPacket packet = new DatagramPacket(str.getBytes(), str.getBytes().length, me, 10000);
                socket.send(packet);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
