package viewing.sachbearbeiter;

import controller.sachbearbeiter.SachbearbeiterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SachbearbeiterViewing extends JFrame {

    //constructor-------------------------------------------------------------------------------------------------------
    public SachbearbeiterViewing(){
        //properties----------------------------------------------------------------------------------------------------
        String[] fuhrerscheinKlassen = {"Linienverkehr","Reiseverkehr"};

        JLabel jLabelName = new JLabel("    Name: ");                           JTextField  jTextFieldName = new JTextField();
        JLabel jLabelNachnme = new JLabel("    Nachname: ");                    JTextField jTextFieldNachname = new JTextField();
        JLabel jLabelTel = new JLabel("    Telefon: ");                         JTextField jTextFieldTel = new JTextField();
        JLabel jLabelBearbeitungsfach = new JLabel("    Bearbeitungsfach: ");   JComboBox<String> jComboBoxBearbeitungsfach = new JComboBox<>(fuhrerscheinKlassen);
        JButton jButtonAddSachbearbeiter = new JButton("Speichern");            JButton jbuttonSachbearbeiterExit = new JButton("Exit");

        //jpanel--------------------------------------------------------------------------------------------------------
        JPanel jPanel = new JPanel(new GridLayout(5,2));

        jPanel.add(jLabelName);                   jPanel.add(jTextFieldName);
        jPanel.add(jLabelNachnme);                jPanel.add(jTextFieldNachname);
        jPanel.add(jLabelTel);                    jPanel.add(jTextFieldTel);
        jPanel.add(jLabelBearbeitungsfach);       jPanel.add(jComboBoxBearbeitungsfach);
        jPanel.add(jButtonAddSachbearbeiter);     jPanel.add(jbuttonSachbearbeiterExit);

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
        jButtonAddSachbearbeiter.addActionListener(new SachbearbeiterController(jTextFieldName,jTextFieldNachname,jTextFieldTel,jComboBoxBearbeitungsfach));
        jButtonAddSachbearbeiter.addKeyListener(new SachbearbeiterController(jTextFieldName,jTextFieldNachname,jTextFieldTel,jComboBoxBearbeitungsfach).keyListener());
        jbuttonSachbearbeiterExit.addActionListener(e -> dispose());

        //rahmen--------------------------------------------------------------------------------------------------------
        this.setTitle("Sachbearbeiter hinzufugen");
        this.add(jPanel);
        this.setSize(400,250);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //visible------------------------------------------
        this.setVisible(true);
    }//end of constructor
}//enf of class
