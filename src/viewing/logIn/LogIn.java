package viewing.logIn;

import viewing.menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogIn extends JFrame {

    //properties--------------------------------------------------------------------------------------------------------
    private JTextField jTextFieldEingabe = new JTextField();
    private JButton jButtonLogIn = new JButton("LOG IN");
    private int counterAnmeldeversuche;
    private int counterAnmeldeAnzeiger = 4;

    //constructor ------------------------------------------------------------------------------------------------------
    public LogIn() {
        //activate Thread-------------------------------------------------
        Thread threadTimer = new Thread(new MyTimer());
        threadTimer.start();

        //properties------------------------------------------------------
        JButton jButtonExit = new JButton("EXIT");

        //set background and ToolTip on textfield "jTextFieldEingabe"-----
        jTextFieldEingabe.setBackground(new Color(250, 250, 250));
        jTextFieldEingabe.setToolTipText("bitte geben sie ihr passwort ein");

        //JPanel Elements,add to panel-------------------------------------
        JPanel jPanelElements = new JPanel(new GridLayout(1, 3));

        jPanelElements.add(jTextFieldEingabe);
        jPanelElements.add(jButtonLogIn);
        jPanelElements.add(jButtonExit);

        //JPanel LogIN-Set Image---------------------------------------------
        LogImage jpanelLogIn = new LogImage();
        jpanelLogIn.setLayout(new GridLayout(3, 1));

        //KeyListener ENTER--------------------------------------------------
//        jTextFieldEingabe.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    LogIn.this.setTitle(--counterAnmeldeAnzeiger + " anmeldeversuche (max 30 sekunden)");
//                    if (counterAnmeldeversuche++ > 2) {
//                        jButtonLogIn.setEnabled(false);
//                        LogIn.this.setTitle("Log In fehlgeschlagen");
//                        jTextFieldEingabe.setEnabled(false);
//                    }
//                    if (jTextFieldEingabe.getText().toLowerCase().equals("blaguss")) {
//                        new Menu();
//                        LogIn.this.dispose();
//                    }
//                }
//            }
//        });

        //Inner anonyme----------------------------------------------------
//        jTextFieldEingabe.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                        LogIn.this.setTitle(--counterAnmeldeAnzeiger + " anmeldeversuche (max 30 sekunden)");
//                        if (counterAnmeldeversuche++ > 2) {
//                            jButtonLogIn.setEnabled(false);
//                            LogIn.this.setTitle("Log In fehlgeschlagen");
//                            jTextFieldEingabe.setEnabled(false);
//                        }
//                        if (jTextFieldEingabe.getText().toLowerCase().equals("blaguss")) {
//                            new Menu();
//                            LogIn.this.dispose();
//                        }
//                    }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });

        //ADAPTER mit Lambda-----------------------------------------------------
        jTextFieldEingabe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    LogIn.this.setTitle(--counterAnmeldeAnzeiger + " anmeldeversuche (max 30 sekunden)");
                    if (counterAnmeldeversuche++ > 2) {
                        jButtonLogIn.setEnabled(false);
                        LogIn.this.setTitle("Log In fehlgeschlagen");
                        jTextFieldEingabe.setEnabled(false);
                    }
                    if (jTextFieldEingabe.getText().toLowerCase().equals("blaguss")) {
                        new Menu();
                        LogIn.this.dispose();
                    }
                }
            }
        });

        //Button Actions----------------------------------------------------
        //Exit Button-Action Listener---------------------------------------
        jButtonExit.addActionListener(e -> System.exit(0));
        jButtonLogIn.addActionListener(new ActionListenerMethodReference()::actionPerformed);

        //Rahmen-------------------------------------------------------------
        this.setLayout(new BorderLayout());
        this.add(jPanelElements, BorderLayout.NORTH);
        this.add(jpanelLogIn, BorderLayout.CENTER);
        this.setTitle(counterAnmeldeAnzeiger +" anmeldeversuche (max 30 sekunden)");
        this.setSize(800, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //----------Visible-------------------------------------------------
        this.setVisible(true);
    }//end of constructor

    //inner class LogImage for Picture on LogIn frame-------------------------------------------------------------------
    private class LogImage extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("flotte.jpg");
            imageIcon.paintIcon(this, g, 0, 0);
        }
    }//end of LogImage

    //inner class Method Reference--------------------------------------------------------------------------------------
    public class ActionListenerMethodReference {
        public void actionPerformed(ActionEvent e) {
            LogIn.this.setTitle(--counterAnmeldeAnzeiger + " anmeldeversuche (max 30 sekunden)");
            if (counterAnmeldeversuche++ > 2) {
                jButtonLogIn.setEnabled(false);
                LogIn.this.setTitle("Log In fehlgeschlagen");
            }
            if (jTextFieldEingabe.getText().toLowerCase().equals("blaguss")) {
                LogIn.this.dispose();
                new Menu();
            }
        }
    }

    //innerclass MyTimer for Thread-------------------------------------------------------------------------------------
    private class MyTimer implements Runnable  {
        @Override
        public void run() {
            int counterTimer = 30;
            while (counterTimer < 31 && counterTimer > 0) {
                try {
                    Thread.sleep(1000);
                    counterTimer--;
                    if (counterTimer < 1) {
                        LogIn.this.setTitle("Log In fehlgeschlagen");
                        jButtonLogIn.setEnabled(false);
                        jTextFieldEingabe.setEnabled(false);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }//end of MyTimer inner class
}//end of LogIn class
