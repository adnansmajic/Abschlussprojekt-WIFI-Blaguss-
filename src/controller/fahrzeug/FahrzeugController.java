package controller.fahrzeug;

import model.fahrzueg.Fahrzeug;
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

public class FahrzeugController implements ActionListener {

    //properties--------------------------------------------------------------------------------------------------------
    JComboBox<String> jComboBoxTyp;
    JComboBox<String> jComboBoxMarke;
    JComboBox<String> jComboBoxSitzplatze;
    JComboBox<String> jComboBoxBaujahr;
    JTextField jTextFieldGaragenNummer;

    //constructor-------------------------------------------------------------------------------------------------------
    public FahrzeugController(JComboBox<String> jComboBoxTyp, JComboBox<String> jComboBoxTMarke, JComboBox<String> jComboBoxSitzplatze, JComboBox<String> jComboBoxBaujahr, JTextField jTextFieldGaragenNummer) {
        this.jComboBoxTyp = jComboBoxTyp;
        this.jComboBoxMarke = jComboBoxTMarke;
        this.jComboBoxSitzplatze = jComboBoxSitzplatze;
        this.jComboBoxBaujahr = jComboBoxBaujahr;
        this.jTextFieldGaragenNummer = jTextFieldGaragenNummer;
    }//end of constructor

    //method fileWriter with fields validation--------------------------------------------------------------------------
    public void fileWriter (){
        if (jTextFieldGaragenNummer.getText().isEmpty()){
            new InfoWarnung();
        }else {
            int sitzplatze = Integer.parseInt(Objects.requireNonNull(jComboBoxSitzplatze.getSelectedItem()).toString());
            int baujahr = Integer.parseInt(Objects.requireNonNull(jComboBoxBaujahr.getSelectedItem()).toString());
            int garagenNummer = Integer.parseInt(jTextFieldGaragenNummer.getText());

            Fahrzeug fahrzeug = new Fahrzeug(Objects.requireNonNull(jComboBoxTyp.getSelectedItem()).toString(), Objects.requireNonNull(jComboBoxMarke.getSelectedItem()).toString(),sitzplatze,garagenNummer,baujahr);
            File fileFahrzeuge = new File("FAHRZEUGE\\BUS." + fahrzeug.getFahrzeugMarke() + "_" + fahrzeug.getGaragenNummer() + ".txt");

            try (FileWriter fileWriterFahrzeug = new FileWriter(fileFahrzeuge)) {
                fileWriterFahrzeug.write(fahrzeug.getFahzeugTyp() + " " + fahrzeug.getFahrzeugMarke() + " " + fahrzeug.getSitzplatze() + " " + fahrzeug.getBaujahr() + " " + fahrzeug.getGaragenNummer());
                jTextFieldGaragenNummer.setText("");
            } catch (IOException exs) {
                exs.printStackTrace();
            }
            new InfoGespeichert();
        }
    }

    //action listener --------------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        FahrzeugController.this.fileWriter();
    }

    //getter for KeyListener--------------------------------------------------------------------------------------------
    public KeyListener getKeyListener (){
        return new AdapterKeyListener();
    }

    //inner class Adapter KeyListener-----------------------------------------------------------------------------------
    private class AdapterKeyListener implements KeyListener{

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                FahrzeugController.this.fileWriter();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}//end of class
