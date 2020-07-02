package controller.sachbearbeiter;

import model.person.sachbearbeiter.Sachbearbeiter;
import viewing.infoGespeichert.InfoGespeichert;
import viewing.infoWarnung.InfoWarnung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class SachbearbeiterController implements ActionListener {

    //properties--------------------------------------------------------------------------------------------------------
    private JTextField  jTextFieldName;
    private JTextField jTextFieldNachname;
    private JTextField jTextFieldTel;
    private JComboBox<String> jComboBoxBearbeitungsfach;

    //constructor-------------------------------------------------------------------------------------------------------
    public SachbearbeiterController(JTextField jTextFieldName, JTextField jTextFieldNachname, JTextField jTextFieldTel, JComboBox<String> jComboBoxBearbeitungsfach) {
        this.jTextFieldName = jTextFieldName;
        this.jTextFieldNachname = jTextFieldNachname;
        this.jTextFieldTel = jTextFieldTel;
        this.jComboBoxBearbeitungsfach = jComboBoxBearbeitungsfach;
    }//end of constructor

    //method file writer with fields validation-------------------------------------------------------------------------
    private void fileWriterSachbearbeiter(){
        if (jTextFieldName.getText().isEmpty()||jTextFieldNachname.getText().isEmpty()||jTextFieldTel.getText().isEmpty()){
            new InfoWarnung();
        }else {
            Sachbearbeiter sachbearbeiter = new Sachbearbeiter(jTextFieldName.getText(),jTextFieldNachname.getText(),jTextFieldTel.getText(), Objects.requireNonNull(jComboBoxBearbeitungsfach.getSelectedItem()).toString());
            File fileSachbearbeiter = new File("SACHBEARBEITER\\S." + sachbearbeiter.getNachname() + ".txt");

            try(FileWriter fileWriterSachbearbeiter = new FileWriter(fileSachbearbeiter)) {
                fileWriterSachbearbeiter.write(sachbearbeiter.getVorname() +" " + sachbearbeiter.getNachname() +" "+ sachbearbeiter.getTelefonNummer() +" " + sachbearbeiter.getBearbeitnugsFach());
                jTextFieldName.setText("");
                jTextFieldNachname.setText("");
                jTextFieldTel.setText("");
            } catch (IOException exs) {
                exs.printStackTrace();
            }
            new InfoGespeichert();
        }
    }

    //action listener use method filewriter-----------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        this.fileWriterSachbearbeiter();
    }

    //method keylistener from adapter class-----------------------------------------------------------------------------
    public KeyListener keyListener() {
        return new KeyListenerAdapter();
    }

    //Adapter class Key Listener use method filewriter------------------------------------------------------------------
    class KeyListenerAdapter implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                SachbearbeiterController.this.fileWriterSachbearbeiter();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }//end inner class
}//end of class
