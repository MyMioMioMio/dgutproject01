import java.io.IOException;
import java.net.*;//test
public class Inetest {
    public static void main(String[] args) throws IOException {
        InetAddress local = InetAddress.getLocalHost();
        InetAddress remote = InetAddress.getByName("www.dgut.edu.cn");
        System.out.println(local.getHostAddress());
        System.out.println(remote.getHostAddress());
        System.out.println(remote.isReachable(3000));
        System.out.println(remote.getHostName());
    }
}
