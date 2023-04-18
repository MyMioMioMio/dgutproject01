package cn.chapter11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//class Example01 extends JFrame {
//    void createAndShowGUI() {
//        JFrame frame = new JFrame("Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Test01");
//        frame.setBounds(320, 320, 320, 300);
////      frame.setSize(320, 300);
////      frame.setLocation(320, 320);
//        // frame.setBackground(Color.blue);
//        frame.getContentPane().setBackground(Color.blue);
//        frame.setVisible(true);
//        JDialog f = new JDialog(frame);
//        f.setBounds(380, 380, 100, 100);
//        f.setVisible(true);
//    }
//}
class Example02 {
    void createAndShowGUI() {
        JButton btn1 = new JButton("模态对话框");
        JButton btn2 = new JButton("非模态对话框");
        JFrame  frame = new JFrame("DialogDemo");
        frame.setBounds(300, 200, 320, 200);
        frame.setLayout(new FlowLayout());
        frame.add(btn1);
        frame.add(btn2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        final JLabel label = new JLabel();
        final JDialog dialog = new JDialog(frame, "dialog");
        dialog.setBounds(350, 250, 220, 150);
        dialog.setLayout(new FlowLayout());
        final JButton btn3 = new JButton("确定");
        dialog.add(btn3);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dialog.setModal(true);
               if (dialog.getComponents().length == 1) {
                   dialog.add(label);
               }
               label.setText("模态对话框，单击确定关闭");
               dialog.setVisible(true);
           }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setModal(false);
                if (dialog.getComponents().length == 1) {
                    dialog.add(label);
                }
                label.setText("非模态对话框，单击确定关闭");
                dialog.setVisible(true);
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
    }
}
public class GUItest01 {
    public static void main(String[] args) {
        new Example02().createAndShowGUI();
    }
}
