package cn.chapter11;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest {
    public static void main(String[] args) throws Exception {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame jFrame = new JFrame("Test");
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jFrame.setSize(320, 320);
        //jFrame.setResizable(false);//设置窗口不可改变大小
        jFrame.setLocationRelativeTo(null);//居屏幕正中间
        for (int i = 1; i < 11; i++) {
            JButton button = new JButton("button" + i);
            jFrame.add(button);
        }
        //jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
