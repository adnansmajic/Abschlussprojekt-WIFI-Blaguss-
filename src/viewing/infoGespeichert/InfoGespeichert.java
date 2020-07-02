package viewing.infoGespeichert;

import javax.swing.*;
import java.awt.*;

public class InfoGespeichert extends JFrame {

    //constructor-------------------------------------------------------------------------------------------------------
    public InfoGespeichert() {
        //Jlabel----------------------------------
        JLabel jLabelInfo = new JLabel("            Gespeichert");
        jLabelInfo.setForeground(Color.RED );

        //Thread-----------------------------------
        Thread thread = new Thread(new MyTimer());
        thread.start();

        //Rahmen--------------------------------
        this.setTitle("Info");
        this.setSize(250,80);
        this.add(jLabelInfo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }//end of constructor

    //innerclass MyTimer for Thread(1 sek)------------------------------------------------------------------------------
    private class MyTimer implements Runnable  {
        @Override
        public void run() {
            int counterTimer = 1;
            while (counterTimer == 1) {
                try {
                    Thread.sleep(1000);
                    counterTimer--;
                    if (counterTimer < 1){
                        InfoGespeichert.this.dispose();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }//end of MyTimer
}//end of class
