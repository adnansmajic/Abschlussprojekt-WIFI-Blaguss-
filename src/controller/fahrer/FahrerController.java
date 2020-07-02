package controller.fahrer;

import model.person.fahrer.Fahrer;
import viewing.infoGespeichert.InfoGespeichert;
import viewing.infoWarnung.InfoWarnung;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class FahrerController implements ActionListener {

    //properties--------------------------------------------------------------------------------------------------------
    private JTextField jTextFieldName;
    private JTextField jTextFieldNachname;
    private JTextField jTextFieldTel;
    private JComboBox<String> jComboBoxFuhrerschein;

    //constructor-------------------------------------------------------------------------------------------------------
    public FahrerController(JTextField jTextFieldName, JTextField jTextFieldNachname, JTextField jTextFieldTel, JComboBox<String> jComboBoxFuhrerschein) {
        this.jTextFieldName = jTextFieldName;
        this.jTextFieldNachname = jTextFieldNachname;
        this.jTextFieldTel = jTextFieldTel;
        this.jComboBoxFuhrerschein = jComboBoxFuhrerschein;
    }//end of constructor

    //method file writer with fields validation-------------------------------------------------------------------------
    private void fileWriterFahrer() {
        if (jTextFieldName.getText().isEmpty()||jTextFieldNachname.getText().isEmpty()||jTextFieldTel.getText().isEmpty()){
            new InfoWarnung();
        } else {
            Fahrer fahrer = new Fahrer(jTextFieldName.getText(), jTextFieldNachname.getText(),jTextFieldTel.getText(),Objects.requireNonNull(jComboBoxFuhrerschein.getSelectedItem()).toString());
            File fileFahrer = new File("FAHRER\\F." + fahrer.getNachname() + ".txt");

            try (FileWriter fileWriterFahrer = new FileWriter(fileFahrer)) {
                fileWriterFahrer.write(fahrer.getVorname() + " " + fahrer.getNachname() + " " + fahrer.getTelefonNummer() + " " + fahrer.getFuhrerschein());
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
        this.fileWriterFahrer();
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
                FahrerController.this.fileWriterFahrer();
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
