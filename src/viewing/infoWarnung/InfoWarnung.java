package viewing.infoWarnung;

import javax.swing.*;
import java.awt.*;

public class InfoWarnung extends JFrame {

    //constructor-------------------------------------------------------------------------------------------------------
    public InfoWarnung() {
        //Jlabel----------------------------------
        JLabel jLabelInfo = new JLabel("               Eingabe felder leer!");
        jLabelInfo.setForeground(Color.RED );

        //Thread-----------------------------------
        Thread thread = new Thread(new InfoWarnung.MyTimer());
        thread.start();

        //Rahmen--------------------------------
        this.setTitle("Info");
        this.setSize(250,80);
        this.add(jLabelInfo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }//end of constructror

    //innerclass MyTimer for Thread(2 sek)------------------------------------------------------------------------------
    private class MyTimer implements Runnable  {
        @Override
        public void run() {
            int counterTimer = 1;
            while (counterTimer == 1) {
                try {
                    Thread.sleep(2000);
                    counterTimer--;
                    if (counterTimer < 1){
                        InfoWarnung.this.dispose();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }//end of MyTimer
}//end of class
