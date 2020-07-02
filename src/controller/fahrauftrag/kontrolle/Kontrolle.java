package controller.fahrauftrag.kontrolle;

import controller.fahrauftrag.warnung.Warnung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Kontrolle implements ActionListener {

    //properties--------------------------------------------------------------------------------------------------------
    private int stunde ;
    private int minuten ;
    private JComboBox<String> jComboBoxFahrzeugGrosse;
    private JComboBox<String> jcomboboxFahrzeugTyp;
    private JComboBox<String>jComboBoxBearbeitungFach;
    //properties for warnungen-----------------------------
    private JLabel jLabelWarnungFalscheGrosse;
    private JLabel jLabelWarnungFalscheTyp;
    private JLabel jLabel2Fahrer;
    //properties for validation----------------------------
    //fahrer,sachbearbeiter--------------------------------
    private JLabel jLabelFahrerName;                                     private JTextField jTextFieldFahreName;               private JLabel jLabelSachbearbeiterName;              private JTextField jTextFieldSachbearbeiterName;
    private JLabel jLabelFahrerNachname;                                 private JTextField jTextFieldFahrehNachname;          private JLabel jLabelSachbearbeiterNachname;          private JTextField jTextFieldSachbearbeiterNachname;
    private JLabel jLabelFahrerTel;                                      private JTextField jTextFieldFahreTelefon;            private JLabel jLabelSachbearbeiterTel;               private JTextField jTextFieldSachbearbeiterTel;
    //kunde------------------------------------------------
    private JLabel jlabelKundeGruppeName;                                private JTextField jTextFieldKundeGruppe;
    private JLabel jLabelPersonenzahl;                                   private JTextField jTextField1Personenzahl;           private JLabel jLabelPlz;                              private JTextField jTextField1Plz;                   private JLabel jLabelPlzZ;                private JTextField jTextField1PlzZ;
    private JLabel jLabelKilometer;                                      private JTextField jTextField1Kilometer;              private JLabel jLabelStadt;                            private JTextField jTextField1Stadt;                 private JLabel jLabelStadtZ;              private JTextField jTextField1StadtZ;
    private JFormattedTextField jFormattedTextFieldAbfahrZeit;           private JLabel jLabelStrasse;                         private JTextField jTextField1Strasse;                 private JLabel jLabelStrasseZ;                       private JTextField jTextField1StrasseZ;
    private JFormattedTextField jFormattedTextField1AnkunftZeit;                                                               private JLabel jLabelStressenNummer;                   private JTextField jTextField1StrassenNummer;        private JLabel jLabelStrassenNummerZ;     private JTextField jTextField1StrassenNummerZ;
    private JLabel jLabelWarnungLenkUndRuhezeiten;
    private JLabel jLabelWarnungEinsatzZeit;

    //constructor-------------------------------------------------------------------------------------------------------
    public Kontrolle(JTextField jTextField1Personenzahl, JComboBox<String> jComboBoxFahrzeugGrosse, JTextField jTextField1Kilometer, JComboBox<String> jcomboboxFahrzeugTyp, JComboBox<String> jComboBoxBearbeitungFach, JLabel jLabelWarnungFalscheGrosse,
                     JLabel jLabelWarnungFalscheTyp, JLabel jLabel2Fahrer, JLabel jLabelFahrerName, JTextField jTextFieldFahreName, JLabel jLabelSachbearbeiterName, JTextField jTextFieldSachbearbeiterName, JLabel jLabelFahrerNachname,
                     JTextField jTextFieldFahrehNachname, JLabel jLabelSachbearbeiterNachname, JTextField jTextFieldSachbearbeiterNachname, JLabel jLabelFahrerTel, JTextField jTextFieldFahreTelefon, JLabel jLabelSachbearbeiterTel,
                     JTextField jTextFieldSachbearbeiterTel, JLabel jlabelKundeGruppeName, JTextField jTextFieldKundeGruppe, JLabel jLabelPersonenzahl,
                     JLabel jLabelPlz, JTextField jTextField1Plz, JLabel jLabelPlzZ, JTextField jTextField1PlzZ, JLabel jLabelKilometer, JLabel jLabelStadt, JTextField jTextField1Stadt, JLabel jLabelStadtZ, JTextField jTextField1StadtZ,
                     JLabel jLabelStrasse, JTextField jTextField1Strasse, JLabel jLabelStrasseZ, JTextField jTextField1StrasseZ, JLabel jLabelStressenNummer, JTextField jTextField1StrassenNummer, JLabel jLabelStrassenNummerZ,
                     JTextField jTextField1StrassenNummerZ, JFormattedTextField jFormattedTextFieldAbfahrZeit, JFormattedTextField jFormattedTextField1AnkunftZeit, JLabel jLabelWarnungLenkUndRuhezeiten, JLabel jLabelWarnungEinsatzZeit) {
        this.jTextField1Personenzahl = jTextField1Personenzahl;
        this.jComboBoxFahrzeugGrosse = jComboBoxFahrzeugGrosse;
        this.jTextField1Kilometer = jTextField1Kilometer;
        this.jcomboboxFahrzeugTyp = jcomboboxFahrzeugTyp;
        this.jComboBoxBearbeitungFach = jComboBoxBearbeitungFach;
        this.jLabelWarnungFalscheGrosse = jLabelWarnungFalscheGrosse;
        this.jLabelWarnungFalscheTyp = jLabelWarnungFalscheTyp;
        this.jLabel2Fahrer = jLabel2Fahrer;
        this.jLabelFahrerName = jLabelFahrerName;
        this.jTextFieldFahreName = jTextFieldFahreName;
        this.jLabelSachbearbeiterName = jLabelSachbearbeiterName;
        this.jTextFieldSachbearbeiterName = jTextFieldSachbearbeiterName;
        this.jLabelFahrerNachname = jLabelFahrerNachname;
        this.jTextFieldFahrehNachname = jTextFieldFahrehNachname;
        this.jLabelSachbearbeiterNachname = jLabelSachbearbeiterNachname;
        this.jTextFieldSachbearbeiterNachname = jTextFieldSachbearbeiterNachname;
        this.jLabelFahrerTel = jLabelFahrerTel;
        this.jTextFieldFahreTelefon = jTextFieldFahreTelefon;
        this.jLabelSachbearbeiterTel = jLabelSachbearbeiterTel;
        this.jTextFieldSachbearbeiterTel = jTextFieldSachbearbeiterTel;
        this.jlabelKundeGruppeName = jlabelKundeGruppeName;
        this.jTextFieldKundeGruppe = jTextFieldKundeGruppe;
        this.jLabelPersonenzahl = jLabelPersonenzahl;
        this.jLabelPlz = jLabelPlz;
        this.jTextField1Plz = jTextField1Plz;
        this.jLabelPlzZ = jLabelPlzZ;
        this.jTextField1PlzZ = jTextField1PlzZ;
        this.jLabelKilometer = jLabelKilometer;
        this.jLabelStadt = jLabelStadt;
        this.jTextField1Stadt = jTextField1Stadt;
        this.jLabelStadtZ = jLabelStadtZ;
        this.jTextField1StadtZ = jTextField1StadtZ;
        this.jLabelStrasse = jLabelStrasse;
        this.jTextField1Strasse = jTextField1Strasse;
        this.jLabelStrasseZ = jLabelStrasseZ;
        this.jTextField1StrasseZ = jTextField1StrasseZ;
        this.jLabelStressenNummer = jLabelStressenNummer;
        this.jTextField1StrassenNummer = jTextField1StrassenNummer;
        this.jLabelStrassenNummerZ = jLabelStrassenNummerZ;
        this.jTextField1StrassenNummerZ = jTextField1StrassenNummerZ;
        this.jFormattedTextFieldAbfahrZeit = jFormattedTextFieldAbfahrZeit;
        this.jFormattedTextField1AnkunftZeit = jFormattedTextField1AnkunftZeit;
        this.jLabelWarnungLenkUndRuhezeiten = jLabelWarnungLenkUndRuhezeiten;
        this.jLabelWarnungEinsatzZeit = jLabelWarnungEinsatzZeit;
    }

    //TextFields validation Method--------------------------------------------------------------------------------------
    private void textFieldValidation (JTextField jTextField,JLabel jLabel,Color color) {
        String eingabe = " Eingabe";
            if (jTextField.getText().equals("") && !jLabel.getText().contains(eingabe)) {
                jLabel.setText(jLabel.getText() + eingabe);
                jLabel.setForeground(Color.red);
            }if (!jTextField.getText().equals("") && jLabel.getText().contains(eingabe)){
                jLabel.setText(jLabel.getText().substring(0,jLabel.getText().length() - 8));
                jLabel.setForeground(color);
            }
    }

    //method warnungLabelForThread--------------------------------------------------------------------------------------
    private void warnungForThread(JLabel jLabel){
        try {
            while (!(jLabel.getText().isEmpty())){
                jLabel.setForeground(Color.white);
                Thread.sleep(1000);
                jLabel.setForeground(Color.red);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Action Performed Method-------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        //warnungen loschen------------------------------------
        Warnung warnungLoschen = new Warnung();

        warnungLoschen.warnungenLoschen(jLabelWarnungEinsatzZeit);
        warnungLoschen.warnungenLoschen(jLabelWarnungFalscheGrosse);
        warnungLoschen.warnungenLoschen(jLabelWarnungFalscheTyp);
        warnungLoschen.warnungenLoschen(jLabelWarnungLenkUndRuhezeiten);
        warnungLoschen.warnungenLoschen(jLabel2Fahrer);

        //JTextField insert validation--------------------------
        //fahre,sachbearbeiter----------------------------------
        textFieldValidation(jTextFieldFahreName, jLabelFahrerName, Color.white);            textFieldValidation(jTextFieldSachbearbeiterName, jLabelSachbearbeiterName, Color.white);
        textFieldValidation(jTextFieldFahrehNachname, jLabelFahrerNachname, Color.white);   textFieldValidation(jTextFieldSachbearbeiterNachname, jLabelSachbearbeiterNachname, Color.white);
        textFieldValidation(jTextFieldFahreTelefon, jLabelFahrerTel, Color.white);          textFieldValidation(jTextFieldSachbearbeiterTel, jLabelSachbearbeiterTel, Color.white);
        //Kunde--------------------------------------------------
        textFieldValidation(jTextFieldKundeGruppe, jlabelKundeGruppeName, Color.black);
        textFieldValidation(jTextField1Personenzahl, jLabelPersonenzahl, Color.black);      textFieldValidation(jTextField1Plz, jLabelPlz, Color.black);                           textFieldValidation(jTextField1PlzZ, jLabelPlzZ, Color.black);
        textFieldValidation(jTextField1Kilometer, jLabelKilometer, Color.black);            textFieldValidation(jTextField1Stadt, jLabelStadt, Color.black);                       textFieldValidation(jTextField1StadtZ, jLabelStadtZ, Color.black);
                                                                                            textFieldValidation(jTextField1Strasse, jLabelStrasse, Color.black);                   textFieldValidation(jTextField1StrasseZ, jLabelStrasseZ, Color.black);
                                                                                            textFieldValidation(jTextField1StrassenNummer, jLabelStressenNummer, Color.black);     textFieldValidation(jTextField1StrassenNummerZ, jLabelStrassenNummerZ, Color.black);

        // Accuracy of logic------------------------------------
        try {
            double personenZahl = Double.parseDouble(jTextField1Personenzahl.getText());
            int fahrzeugGrosse = Integer.parseInt(Objects.requireNonNull(jComboBoxFahrzeugGrosse.getSelectedItem()).toString());
            double kilometer = Double.parseDouble(jTextField1Kilometer.getText());

            if (personenZahl > fahrzeugGrosse) {
                jLabelWarnungFalscheGrosse.setText("      Eingeteillte Fahrzeug ist zu klein!");
                jLabelWarnungFalscheGrosse.setForeground(Color.WHITE);
                jLabelWarnungFalscheGrosse.setOpaque(true);
                jLabelWarnungFalscheGrosse.setBackground(Color.RED);
            }
            if (kilometer > 100 && Objects.equals(jcomboboxFahrzeugTyp.getSelectedItem(), "Linienbus")) {
                jLabelWarnungFalscheTyp.setText("      Teile Reisebuss ein!");
                jLabelWarnungFalscheTyp.setForeground(Color.WHITE);
                jLabelWarnungFalscheTyp.setOpaque(true);
                jLabelWarnungFalscheTyp.setBackground(Color.RED);
            }
            if ((Objects.equals(jComboBoxBearbeitungFach.getSelectedItem(), "Linienverkehr") != Objects.equals(jcomboboxFahrzeugTyp.getSelectedItem(), "Linienbus")) && (jComboBoxBearbeitungFach.getSelectedItem().equals("Reiseverkehr")) != jcomboboxFahrzeugTyp.getSelectedItem().equals("Reisebus")) {
                jLabel2Fahrer.setText("      Falsche Sachbearbeiter!");
                jLabel2Fahrer.setForeground(Color.WHITE);
                jLabel2Fahrer.setOpaque(true);
                jLabel2Fahrer.setBackground(Color.RED);
            }
        } catch (Exception e1) {
            System.out.println("LOG: " + e1.getMessage());
        }

        //lenk und ruhe zeiten berechnung + einsatzzeit-----------------------------------------------------------------
        //datum parsen---------------------------------
        int datumAbfahrt = Integer.parseInt(jFormattedTextFieldAbfahrZeit.getText().substring(0, 2));
        int datumAnkunft = Integer.parseInt(jFormattedTextField1AnkunftZeit.getText().substring(0, 2));

        //zeit parsen----------------------------------
        int abfahrtStunde = Integer.parseInt(jFormattedTextFieldAbfahrZeit.getText().substring(17, 19));
        int ankunftStunde = Integer.parseInt(jFormattedTextField1AnkunftZeit.getText().substring(17, 19));
        int abfahrtMinuten = Integer.parseInt(jFormattedTextFieldAbfahrZeit.getText().substring(20, 22));
        int ankunftMinuten = Integer.parseInt(jFormattedTextField1AnkunftZeit.getText().substring(20, 22));

        //minuten--------------------------------------
        if (abfahrtMinuten > ankunftMinuten) {
            stunde -= 1;
        } else {
            minuten = ankunftMinuten - abfahrtMinuten;
        }

        //warnungen------------------------------------
        if (datumAbfahrt == datumAnkunft) {
            if (ankunftStunde == 0) {
                ankunftStunde = 24;
            }
            stunde = ankunftStunde - abfahrtStunde;
        }

        if (datumAnkunft - datumAbfahrt == 1) {
            if (abfahrtStunde > ankunftStunde) {
                ankunftStunde = ankunftStunde + 24;
                stunde = ankunftStunde - abfahrtStunde;
            } else {
                stunde = ankunftStunde - abfahrtStunde + 24;
            }
        }

        if (datumAnkunft < datumAbfahrt){
            if ((datumAnkunft == 1) && (datumAbfahrt == 30 || datumAbfahrt == 31)){
                if (abfahrtStunde > ankunftStunde) {
                    ankunftStunde = ankunftStunde + 24;
                    stunde = ankunftStunde - abfahrtStunde;
                } else {
                    stunde = ankunftStunde - abfahrtStunde + 24;
                }
            }else{
                stunde = 16;
            }
        }
        if ((datumAnkunft - datumAbfahrt) > 1) {
                stunde = 16;
            }
        if ((stunde >= 9 && minuten > 30) || (stunde > 9)) {
                jLabelWarnungLenkUndRuhezeiten.setOpaque(true);
                jLabelWarnungLenkUndRuhezeiten.setBackground(Color.red);
                jLabelWarnungLenkUndRuhezeiten.setForeground(Color.white);
                jLabelWarnungLenkUndRuhezeiten.setText("      Lenk und Ruhezeiten überschreitung!");
            }
        if (stunde > 15) {
                jLabelWarnungEinsatzZeit.setOpaque(true);
                jLabelWarnungEinsatzZeit.setBackground(Color.red);
                jLabelWarnungEinsatzZeit.setForeground(Color.white);
                jLabelWarnungEinsatzZeit.setText("      Einsatzzeit überschreitung!");
            }

        //threads-------------------------------------------------------------------------------------------------------
        //thread lenk und ruhezeiten,einsatzzeit----------
        class MyThreadEinsatz implements Runnable{
            @Override
            public void run() {
              warnungForThread(jLabelWarnungEinsatzZeit);
            }
        }
        Thread threadEinsatz = new Thread(new MyThreadEinsatz());
        threadEinsatz.start();

        //thread lenk und ruhezeiten-----------------
        class MyThreadLenkundRuhezeiten implements Runnable{
            @Override
            public void run() {
                warnungForThread(jLabelWarnungLenkUndRuhezeiten);
            }
        }
        Thread threadLenkundRuhezeiten = new Thread(new MyThreadLenkundRuhezeiten());
        threadLenkundRuhezeiten.start();

        //thread Fahrzeug Grosse----------------------
        class MyThreadfahrzeugGrosse implements Runnable{
            @Override
            public void run() {
               warnungForThread(jLabelWarnungFalscheGrosse);
            }
        }
        Thread threadfahrzeugGrosse = new Thread(new MyThreadfahrzeugGrosse());
        threadfahrzeugGrosse.start();

        //thread falche Fahrzeug Typ-------------------
        //thread Fahrzeug Grosse-----------------------
        class MyThreadFalscheFahrzeugTyp implements Runnable{
            @Override
            public void run() {
               warnungForThread(jLabelWarnungFalscheTyp);
            }
        }
        Thread threadFalscheFahrzeugTyp = new Thread(new MyThreadFalscheFahrzeugTyp());
        threadFalscheFahrzeugTyp.start();

        //thread falsche Sachbearbeiter--------------------
        class MyThreadFalscheSachbearbeiter implements Runnable{
            @Override
            public void run() {
               warnungForThread(jLabel2Fahrer);
            }
        }
        Thread threadFalscheSachbearbeiter = new Thread(new MyThreadFalscheSachbearbeiter());
        threadFalscheSachbearbeiter.start();
    }
}//end class Controller
