package cn.chapter11;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BorderLayout");
        frame.setLayout(new BorderLayout(5, 5));
        frame.setSize(300, 300);
        frame.setFont(new Font("Consolas", Font.PLAIN, 14));//设置组件字体，如果为容器，则上面组件都被设置
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(BorderLayout.NORTH, new JButton("North"));
        frame.add(BorderLayout.EAST, new JButton("East"));
        frame.add(BorderLayout.WEST, new JButton("West"));
        frame.add(BorderLayout.SOUTH, new JButton("south"));
        frame.add(BorderLayout.CENTER, new JButton("center"));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
