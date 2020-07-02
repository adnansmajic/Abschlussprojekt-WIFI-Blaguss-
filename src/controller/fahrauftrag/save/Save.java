package controller.fahrauftrag.save;

import model.auftrag.Auftrag;
import model.fahrzueg.Fahrzeug;
import model.kunde.Kunde;
import model.kunde.adresse.Adresse;
import model.person.fahrer.Fahrer;
import model.person.sachbearbeiter.Sachbearbeiter;
import viewing.infoGespeichert.InfoGespeichert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Save implements ActionListener {

    //properties--------------------------------------------------------------------------------------------------------
    //fahrer,sachbearbeiter--------------------------------
    private JTextField jTextFieldFahreName;                        private JTextField jTextFieldSachbearbeiterName;
    private JTextField jTextFieldFahrehNachname;                   private JTextField jTextFieldSaxhbearbeiterNachname;
    private JTextField jTextFieldFahreTelefon;                     private JTextField jTextFieldSachbearbeiterTel;
    private JComboBox <String>jComboBoxFuhrerscheinklassen;        private JComboBox<String> jComboBoxBearbeitungFach;
   //kunde-------------------------------------------------
    private JTextField jTextFieldKundeGruppe;                      private JComboBox<String> jComboBoxLand;                private JComboBox<String> jComboBoxLandZ;
    private JFormattedTextField jFormattedTextFieldAbfahrZeit;     private JTextField jTextField1Plz;                      private JTextField jTextField1PlzZ;
    private JFormattedTextField jFormattedTextField1AnkunftZeit;   private JTextField jTextField1Stadt;                    private JTextField jTextField1StadtZ;
    private JTextField jTextField1Personenzahl;                    private JTextField jTextField1Strasse;                  private JTextField jTextField1StrasseZ;
    private JTextField jTextField1Kilometer;                       private JTextField jTextField1StrassenNummer;           private JTextField jTextField1StrassenNummerZ;
    //fahrzeug---------------------------------------------
    private JComboBox<String> jcomboboxFahrzeugTyp;
    private JComboBox<String> jComboBoxFahrzeugMarke;
    private JComboBox<String> jComboBoxFahrzeugGrosse;
    private JTextField jTextFieldGaragenNummer;
    private JComboBox<String> jcomboboxBaujahr;

    //constructor-------------------------------------------------------------------------------------------------------
    public Save(JTextField jTextFieldFahreName, JTextField jTextFieldFahrehNachname, JTextField jTextFieldFahreTelefon, JComboBox<String> jComboBoxFuhrerscheinklassen, JTextField jTextFieldSachbearbeiterName, JTextField jTextFieldSaxhbearbeiterNachname,
                JTextField jTextFieldSachbearbeiterTel, JComboBox<String> jComboBoxBearbeitungFach, JTextField jTextFieldKundeGruppe, JFormattedTextField jFormattedTextFieldAbfahrZeit, JFormattedTextField jFormattedTextField1AnkunftZeit,
                JTextField jTextField1Personenzahl, JTextField jTextField1Kilometer, JComboBox<String> jComboBoxLand, JTextField jTextField1Plz, JTextField jTextField1Stadt, JTextField jTextField1Strasse, JTextField jTextField1StrassenNummer,
                JComboBox<String> jComboBoxLandZ, JTextField jTextField1PlzZ, JTextField jTextField1StadtZ, JTextField jTextField1StrasseZ, JTextField jTextField1StrassenNummerZ, JComboBox<String> jcomboboxFahrzeugTyp, JComboBox<String> jComboBoxFahrzeugMarke,
                JComboBox<String> jComboBoxFahrzeugGrosse, JTextField jTextFieldGaragenNummer, JComboBox<String> jcomboboxBaujahr) {
        this.jTextFieldFahreName = jTextFieldFahreName;
        this.jTextFieldFahrehNachname = jTextFieldFahrehNachname;
        this.jTextFieldFahreTelefon = jTextFieldFahreTelefon;
        this.jComboBoxFuhrerscheinklassen = jComboBoxFuhrerscheinklassen;
        this.jTextFieldSachbearbeiterName = jTextFieldSachbearbeiterName;
        this.jTextFieldSaxhbearbeiterNachname = jTextFieldSaxhbearbeiterNachname;
        this.jTextFieldSachbearbeiterTel = jTextFieldSachbearbeiterTel;
        this.jComboBoxBearbeitungFach = jComboBoxBearbeitungFach;
        this.jTextFieldKundeGruppe = jTextFieldKundeGruppe;
        this.jFormattedTextFieldAbfahrZeit = jFormattedTextFieldAbfahrZeit;
        this.jFormattedTextField1AnkunftZeit = jFormattedTextField1AnkunftZeit;
        this.jTextField1Personenzahl = jTextField1Personenzahl;
        this.jTextField1Kilometer = jTextField1Kilometer;
        this.jComboBoxLand = jComboBoxLand;
        this.jTextField1Plz = jTextField1Plz;
        this.jTextField1Stadt = jTextField1Stadt;
        this.jTextField1Strasse = jTextField1Strasse;
        this.jTextField1StrassenNummer = jTextField1StrassenNummer;
        this.jComboBoxLandZ = jComboBoxLandZ;
        this.jTextField1PlzZ = jTextField1PlzZ;
        this.jTextField1StadtZ = jTextField1StadtZ;
        this.jTextField1StrasseZ = jTextField1StrasseZ;
        this.jTextField1StrassenNummerZ = jTextField1StrassenNummerZ;
        this.jcomboboxFahrzeugTyp = jcomboboxFahrzeugTyp;
        this.jComboBoxFahrzeugMarke = jComboBoxFahrzeugMarke;
        this.jComboBoxFahrzeugGrosse = jComboBoxFahrzeugGrosse;
        this.jTextFieldGaragenNummer = jTextFieldGaragenNummer;
        this.jcomboboxBaujahr = jcomboboxBaujahr;
    }

    //File Writer method------------------------------------------------------------------------------------------------
    private void fileWriter() {
        //datum and time,format date and time---------------
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String strDate = dateFormat.format(date);

        //make Objects----------------------------------------
        Fahrer fahrer = new Fahrer(jTextFieldFahreName.getText(),jTextFieldFahrehNachname.getText(),jTextFieldFahreTelefon.getText(), Objects.requireNonNull(jComboBoxFuhrerscheinklassen.getSelectedItem()).toString());

        Sachbearbeiter sachbearbeiter = new Sachbearbeiter(jTextFieldSachbearbeiterName.getText(),jTextFieldSaxhbearbeiterNachname.getText(),jTextFieldSachbearbeiterTel.getText(), Objects.requireNonNull(jComboBoxBearbeitungFach.getSelectedItem()).toString());

        Adresse abholAdresse = new Adresse(jTextField1StrassenNummer.getText(),jTextField1Strasse.getText(),jTextField1Stadt.getText(),Long.parseLong(jTextField1Plz.getText()), Objects.requireNonNull(jComboBoxLand.getSelectedItem()).toString());
        Adresse ankunftAdresse = new Adresse(jTextField1StrassenNummerZ.getText(),jTextField1StrasseZ.getText(),jTextField1StadtZ.getText(),Long.parseLong(jTextField1PlzZ.getText()), Objects.requireNonNull(jComboBoxLandZ.getSelectedItem()).toString());

        Kunde kunde = new Kunde(jTextFieldKundeGruppe.getText(),jFormattedTextFieldAbfahrZeit.getText(),jFormattedTextField1AnkunftZeit.getText(),abholAdresse,ankunftAdresse,Integer.parseInt(jTextField1Personenzahl.getText()),Integer.parseInt(jTextField1Kilometer.getText()));

        Fahrzeug fahrzeug = new Fahrzeug(Objects.requireNonNull(jcomboboxFahrzeugTyp.getSelectedItem()).toString(), Objects.requireNonNull(jComboBoxFahrzeugMarke.getSelectedItem()).toString(),Integer.parseInt(Objects.requireNonNull(jComboBoxFahrzeugGrosse.getSelectedItem()).toString()),Integer.parseInt(jTextFieldGaragenNummer.getText()),Integer.parseInt(Objects.requireNonNull(jcomboboxBaujahr.getSelectedItem()).toString()));

        Auftrag auftrag = new Auftrag(fahrer,sachbearbeiter,kunde,fahrzeug);

        //writer into the file----------------------------
        File fileFahraufrtaege = new File("FAHRAUFTRAEGE\\A." + strDate + ".txt");

        try (FileWriter fw = new FileWriter(fileFahraufrtaege)){
            fw.write("\n\n\n< < < < <  W E L C O M E   T O    B L A G U S S  > > > > > " +
                    "\n\nErstellt um: \n" + timeFormat.format(date) + auftrag.toString() +
                    "\n---------------------------------------------------------\n\n\n\n\n" +
                    "  W I R      W U N S C H E N     G U T E      F A H R T ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //action listener Save JButton--------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
      Save.this.fileWriter();
        new InfoGespeichert();
    }//end of action listener
}//end of Save class
