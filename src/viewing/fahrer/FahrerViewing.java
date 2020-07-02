package viewing.fahrer;

import controller.fahrer.FahrerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FahrerViewing extends JFrame {

    //constructor-------------------------------------------------------------------------------------------------------
    public FahrerViewing (){
        //properties----------------------------------------------------------------------------------------------------
        String[] fuhrerscheinKlassen = {"D","D,E"};

        JLabel jLabelName = new JLabel("    Vorname: ");                      JTextField  jTextFieldName = new JTextField();
        JLabel jLabelNachnme = new JLabel("    Nachname: ");                  JTextField jTextFieldNachname = new JTextField();
        JLabel jLabelTel = new JLabel("    Telefon: ");                       JTextField jTextFieldTel = new JTextField();
        JLabel jLabelFuhrerschein = new JLabel("    Fuhrerschein: ");         JComboBox<String> jComboBoxFuhrerschein = new JComboBox<>(fuhrerscheinKlassen);
        JButton jButtonAddfahrer = new JButton("Speichern");                  JButton jButtonFahrerExit = new JButton("Exit");

        //jpanel--------------------------------------------------------------------------------------------------------
        JPanel jPanel = new JPanel(new GridLayout(5,2));

        jPanel.add(jLabelName);               jPanel.add(jTextFieldName);
        jPanel.add(jLabelNachnme);            jPanel.add(jTextFieldNachname);
        jPanel.add(jLabelTel);                jPanel.add(jTextFieldTel);
        jPanel.add(jLabelFuhrerschein);       jPanel.add(jComboBoxFuhrerschein);
        jPanel.add(jButtonAddfahrer);         jPanel.add(jButtonFahrerExit);

        //jtextFieldTel validation on input(only numbers)---------------------------------------------------------------
        jTextFieldTel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyChar()>='0' && e.getKeyChar()<= '9') || e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
                    jTextFieldTel.setEditable(true);
                }else{
                    jTextFieldTel.setEditable(false);
                }
            }
        });

        //button actions------------------------------------------------------------------------------------------------
        jButtonAddfahrer.addActionListener( new FahrerController(jTextFieldName,jTextFieldNachname,jTextFieldTel,jComboBoxFuhrerschein));
        jButtonAddfahrer.addKeyListener(new FahrerController(jTextFieldName,jTextFieldNachname,jTextFieldTel,jComboBoxFuhrerschein).keyListener());
        jButtonFahrerExit.addActionListener(e -> dispose());

        //rahmen--------------------------------------------------------------------------------------------------------
        this.setTitle("Fahrer hinzufugen");
        this.add(jPanel);
        this.setSize(400,250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        //visible------------------------------------------
        this.setVisible(true);
    }//end of constructor
}//ebd of class
