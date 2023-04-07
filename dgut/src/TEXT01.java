import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;
import java.util.*;
import java.io.*;
class MyThread implements Runnable {
    double mile;
    double speed;
    public MyThread(double mile, double speed) {
        this.speed = speed;
        this.mile = mile;
    }
    public void run() {
        Thread th = Thread.currentThread();
        String th_name = th.getName();
        double curmile = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        while (curmile <= mile) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            curmile += speed;
            System.out.println(th_name + " " + df.format(curmile));
            if (th_name.equals("r") && df.format(curmile).equals(df.format(600.00))) {

            }
        }
        System.out.println(th_name + "到达终点!");
    }
}
public class TEXT01 {
    public static void main(String[] args) throws IOException {
        MyThread wrun = new MyThread(1000, 1);
        MyThread rrun = new MyThread(1000, 1.2);
        new Thread(wrun, "w").start();
        new Thread(rrun, "r").start();
    }
}
