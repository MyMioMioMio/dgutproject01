package cn.chapter11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventTest {
    public static void main(String[] args) {
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
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JButton button = new JButton("mouse");
        JDialog dialog = new JDialog(frame, "Dialog");
        JDialog dialog2 = new JDialog(frame, "Dialog2");
        JButton button111 = new JButton("keyEvent");
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(null);
        dialog2.setSize(200, 100);
        dialog2.setLocationRelativeTo(null);
        frame.add(button);
        frame.add(button111);
//        button.addMouseListener(new MouseAdapter() {
//            @Override
//                    public void mouseClicked(MouseEvent e) {
//                        System.out.println("Mouse Clicked");
//                    }
//
//                    @Override
//                    public void mousePressed(MouseEvent e) {
//                        System.out.println("Mouse Pressed");
//                    }
//
//                    @Override
//                    public void mouseReleased(MouseEvent e) {
//                        System.out.println("Mouse Released");
//                    }
//
//                    @Override
//                    public void mouseEntered(MouseEvent e) {
//                        System.out.println("Mouse Entered");
//                    }
//
//                    @Override
//                    public void mouseExited(MouseEvent e) {
//                        System.out.println("Mouse Exited");
//                    }
//        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setModal(true);
                dialog.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Mouse Clicked");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        System.out.println("Mouse Pressed");
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        System.out.println("Mouse Released");
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        System.out.println("Mouse Entered");
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        System.out.println("Mouse Exited");
                    }
                });
                System.out.println("单击");
                dialog.setVisible(true);
            }
        });
        button111.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog2.setModal(false);
                dialog.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        System.out.println(e.getKeyChar() + " " +e.getKeyCode());
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                dialog2.setVisible(true);
            }
        });
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("open");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("closing");
                JButton button02 = new JButton("button2");
                dialog.setLayout(new FlowLayout());
                dialog.add(button02);
                dialog.setModal(true);
                button02.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                        frame.dispose();
                    }
                });
                dialog.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("窗体图标化");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("窗体取消图标化");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("窗体激活");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("窗体停用");
            }
        });

        frame.setVisible(true);
    }
}
