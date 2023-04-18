package cn.chapter11;

import javax.swing.*;
import java.awt.*;

class GBLFrame extends JFrame {
    public GBLFrame(String name) {
        this.setTitle(name);//this.可以省略
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);
//        constraints.gridx = GridBagConstraints.RELATIVE;
//        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        this.addButton("btn1", layout, constraints);
        this.addButton("btn2", layout, constraints);
        this.addButton("btn3", layout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        this.addButton("btn4", layout, constraints);
        constraints.weightx = 0;
        constraints.weighty = 0;
        this.addButton("btn5", layout, constraints);
        constraints.gridwidth = 1;
        this.addButton("btn6", layout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        this.addButton("btn7", layout, constraints);
//        constraints.gridwidth = 1;//change
//        constraints.gridheight = 2;
//        constraints.weightx = 1;
//        constraints.weighty = 1;
//        this.addButton("btn8", layout, constraints);
        constraints.weightx = 0.2;
        constraints.weighty = 0.2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        this.addButton("btn9", layout, constraints);
        constraints.gridx = 4;
        this.addButton("btn10", layout, constraints);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void addButton(String buttonName, GridBagLayout layout, GridBagConstraints constraints) {
        JButton button = new JButton(buttonName);
        layout.setConstraints(button, constraints);
        this.add(button);
    }
}
public class GridBagLayoutTest {
    //最灵活的布局管理器
    public static void main(String[] args) {
        new GBLFrame("Test");
    }
}
