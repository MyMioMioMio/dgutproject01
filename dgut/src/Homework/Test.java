package Homework;
abstract class Printer {
    protected String[] buffer;
    abstract protected void load(String[] contents) throws Exception;
    abstract protected void print();
}
interface Wireless {
    abstract public void wirelessConnect();
}
class LaserPrinter extends Printer {
    @Override
    protected void print() {
        if (buffer != null) {
            for(String line : buffer) {
                System.out.print(line + ",");
            }
            buffer = null;
        }
    }

    @Override
    protected void load(String[] contents) {
        print();
        buffer = contents;
    }
}
class WirelessPrinter extends Printer implements Wireless {
    private boolean status = false;
    @Override
    protected void load(String[] contents) throws Exception {
        print();
        if (status == false) {
            throw new Exception("无线打印机未联网!");
        } else {
            buffer = contents;
        }
    }

    @Override
    protected void print() {
        if (buffer != null) {
            for(String line : buffer) {
                System.out.print(line + ",");
            }
            buffer = null;
        }
    }

    @Override
    public void wirelessConnect() {
        status = true;
    }
}
public class Test {
    public static void main(String[] args) {
        String[] testLine01 = {"123456", "256789", "asdsdads"};
        String[] testLine02 = {"sadsad", "aaaa", "erwqqq"};
        LaserPrinter laserPrinter = new LaserPrinter();
        WirelessPrinter wirelessPrinter = new WirelessPrinter();
        laserPrinter.load(testLine01);
        laserPrinter.print();
        System.out.println("");
        laserPrinter.load(testLine02);
        laserPrinter.print();
        System.out.println("");
        try {
            wirelessPrinter.load(testLine01);
            wirelessPrinter.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            wirelessPrinter.wirelessConnect();
        }
        System.out.println("");
        try {
            wirelessPrinter.load(testLine01);
            wirelessPrinter.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            wirelessPrinter.wirelessConnect();
        }
        System.out.println("");
        try {
            wirelessPrinter.load(testLine02);
            wirelessPrinter.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            wirelessPrinter.wirelessConnect();
        }
    }
}
