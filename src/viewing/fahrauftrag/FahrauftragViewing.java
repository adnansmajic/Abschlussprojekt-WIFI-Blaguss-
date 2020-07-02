package viewing.fahrauftrag;

import controller.fahrauftrag.kontrolle.Kontrolle;
import controller.fahrauftrag.save.Save;
import controller.fahrauftrag.warnung.Warnung;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

public class FahrauftragViewing extends JFrame {

    //constructor-------------------------------------------------------------------------------------------------------
    public FahrauftragViewing()  {
        //Date and Time-------------------------------------------------------------------------------------------------
        Date date = new Date();
        LocalTime localTime = LocalTime.now();

        //Format Date and JFormattedTextField AbfahrtZeit----------
        Format formatAbfahrt = new SimpleDateFormat("dd/MM/yyyy");
        MaskFormatter maskFormatterAbfahrt = null;
        try {
            maskFormatterAbfahrt = new MaskFormatter("## /## /####  -  ##:##");
            maskFormatterAbfahrt.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateStringAbfahrt = formatAbfahrt.format(date);

        //Format Date and JFormattedTextField AnkunftZeit----------
        Format formatAnkunft = new SimpleDateFormat("dd/MM/yyyy");
        MaskFormatter maskFormatterAnkunft = null;
        try {
            maskFormatterAnkunft = new MaskFormatter("## /## /####  -  ##:##");
            maskFormatterAnkunft.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateStringAnkunft = formatAnkunft.format(date);

        //Jcombobox Baujahr---------------------------------------------------------------------------------------------
        List jahren = new List();
        int aktuelleJahr = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 2000;i < aktuelleJahr + 1; i++ ){
            jahren.add(String.valueOf(i));
        }

        //Jcombo fahrer, sachbearbeiter ,fahrzeug-----------------------------------------------------------------------
        //List-----------------------------------------------------------
        java.util.List<String> listFahrer = new ArrayList<>();
        java.util.List<String> listSachbearbeiter = new ArrayList<>();
        java.util.List<String> listFahrzeug = new ArrayList<>();

        //add to List----------------------------------------------------
        listFahrer.add("bitte fahrer auswaehlen:");
        listSachbearbeiter.add("bitte sachbearbeiter auswaehlen:");
        listFahrzeug.add("bitte fahrzeug auswaehlen:");

        //File with absoluth Path----------------------------------------
        File filePathFahrzeuge = new File("FAHRZEUGE");
        File filePathFahrer = new File("FAHRER");
        File filePathSachbearbeiter = new File("SACHBEARBEITER");

        //File Arrays---------------------------------------------------
        File[] filesFahrzeug = filePathFahrzeuge.listFiles();
        File[] filesFahrer = filePathFahrer.listFiles();
        File[] filesSachbearbeiter = filePathSachbearbeiter.listFiles();

        //list files and split-------------------------------------------
        assert filesFahrzeug != null;
        for (File fileEinzeln : filesFahrzeug) {
            String fileEinzelnString = fileEinzeln.getName();
                    String[] nameFahrzeug = fileEinzelnString.split("[.]+");
                    listFahrzeug.add(nameFahrzeug[1]);
        }
        assert filesFahrer != null;
        for (File fileEinzeln : filesFahrer) {
            String fileEinzelnString = fileEinzeln.getName();
                    String[] nameFahrer = fileEinzelnString.split("[.]+");
                    listFahrer.add(nameFahrer[1]);
        }
        assert filesSachbearbeiter != null;
        for (File fileEinzeln : filesSachbearbeiter) {
            String fileEinzelnString = fileEinzeln.getName();
                    String[] nameSachbearbeiter = fileEinzelnString.split("[.]+");
                    listSachbearbeiter.add(nameSachbearbeiter[1]);
        }

        //String Arrays for JComboBox-----------------------------------------------------------------------------------
        final String[] fahrzeugTyp = {"Linienbus","Reisebus"};
        final String[] sachbearbeitungFach = {"Linienverkehr","Reiseverkehr"};
        final String[] fuhrerschein = {"D","D,E"};
        final String[] fahrzeugMarke = {"Setra","Mercedes","Neoplan","MAN","Volvo","Scania","Solaris","Temsa","Van Hool","VDL","Irizar","Irisbus"};
        final String[] fahrzeugSitzplatze = {"37","44","50","54","58","62","82"};
        final String[] fahrer = listFahrer.toArray(new String[0]);
        final String[] sachbearbeiter = listSachbearbeiter.toArray(new String[0]);
        final String[] fahrzeug = listFahrzeug.toArray(new String[0]);
        final String[] garagenNummer = jahren.getItems();
        final String[] laender = {"Oesterreich","Deutschland","Schweiz","Italien","Kroatien","Ungarn","Slowakei","Polen","Tschechien","Niederlande","Belgien","Frenkreich","Spanien","Portugal","Serbien","Bosnien","Albanien","Mazedonien","Grichenland","Bulgarien","Rumanien","Moladawien","Ukraine","Weissrussland","Litauen","Daenenmark","Norwegen","Schweden","UK","Ireland"};

        //JLabels------JTextField------JButtons-------JComboBox-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //JLabel FAHRER,SACHBEARBEITER----------------------------------------------------------------------------------
        JLabel jLabelFahrtauftrag = new JLabel("   FAHRAUFTRAG VON:");       JLabel jLabelFahrtauftragNummer = new JLabel();                                      JLabel jLabelfakeFahrtauftrag1 = new JLabel();                                   JLabel jLabelfakeFahrtauftrag2 = new JLabel();
        JLabel jLabelFahrer = new JLabel("    FAHRER:");                     JComboBox<String>jComboBoxFahrer = new JComboBox<>(fahrer);                          JLabel jLabelSachbearbeiter = new JLabel("    SACHBEARBEITER:");            JComboBox<String>jComboBoxSachbearbeiter = new JComboBox<>(sachbearbeiter);
        JLabel jLabelFahrerName = new JLabel("    Name:");                   JTextField jTextFieldFahreName =new JTextField();                                    JLabel jLabelSachbearbeiterName = new JLabel("    Name:");                  JTextField jTextFieldSachbearbeiterName = new JTextField();
        JLabel jLabelFahrerNachname = new JLabel("    Nachname:");           JTextField jTextFieldFahrehNachname = new JTextField();                              JLabel jLabelSachbearbeiterNachname = new JLabel("    Nachname:");          JTextField jTextFieldSachbearbeiterNachname = new JTextField();
        JLabel jLabelFahrerTel = new JLabel("    Telefon / Handy Nummer:");  JTextField jTextFieldFahreTelefon =new JTextField();                                 JLabel jLabelSachbearbeiterTel = new JLabel("    Telefon / Handy Nummer:"); JTextField jTextFieldSachbearbeiterTel = new JTextField();
        JLabel jLabelFuhrerschein = new JLabel("    Fuhrerscheinklassen:");  JComboBox <String>jComboBoxFuhrerscheinklassen = new JComboBox<>(fuhrerschein);      JLabel jLabelBearbeitungsFach = new JLabel("    Bearbeitungsfach:");        JComboBox<String> jComboBoxBearbeitungFach = new JComboBox<>(sachbearbeitungFach);
        JLabel jLabelFakeNordUnten1 = new JLabel();                               JLabel jLabelFakeNordUnten2 = new JLabel();
        JLabel jLabelFakeNordUnten3 = new JLabel();                               JLabel jLabelFakeNordUnten4 = new JLabel();

        //JLabel-Set Font Art,Size---------------------------
        jLabelFahrtauftrag.setFont(new Font("Verdana",Font.BOLD,12));
        jLabelFahrtauftragNummer.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        //Jlabels-Set Text Colors
        jLabelFahrtauftrag.setForeground(Color.white);                           jLabelFahrtauftragNummer.setForeground(Color.white);                                 jLabelSachbearbeiter.setForeground(Color.white);
        jLabelFahrer.setForeground(Color.white);                                                                                                                      jLabelSachbearbeiterName.setForeground(Color.white);
        jLabelFahrerName.setForeground(Color.white);                                                                                                                  jLabelSachbearbeiterNachname.setForeground(Color.white);
        jLabelFahrerNachname.setForeground(Color.white);                                                                                                              jLabelSachbearbeiterTel.setForeground(Color.white);
        jLabelFahrerTel.setForeground(Color.white);                                                                                                                   jLabelBearbeitungsFach.setForeground(Color.white);
        jLabelFuhrerschein.setForeground(Color.white);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //JLabel KUNDE--------------------------------------------------------------------------------------------------
       JLabel jLabelKundeGruppe = new JLabel("    KUNDE:");            JLabel jLabelFakeKundeGruppe = new JLabel();                                        JLabel jLabelAdresse = new JLabel("    ABHOLADRESSE:");    JLabel jLabelFakeAdresse = new JLabel();                             JLabel jLabelAdresseZ = new JLabel("    ZIELADRESSE:");     JLabel jLabelFakeAdresseZ = new JLabel();
       JLabel jlabelKundeGruppeName = new JLabel("    Name:");         JTextField jTextFieldKundeGruppe = new JTextField() ;                               JLabel jLabelLand = new JLabel("    Land:");               JComboBox<String> jComboBoxLand = new JComboBox<>(laender);          JLabel jLabelLandZ = new JLabel("    Land:");               JComboBox<String> jComboBoxLandZ = new JComboBox<>(laender);
       JLabel jLabelAbfahrtZeit = new JLabel("    Abfahrt Zeit:");     JFormattedTextField jFormattedTextFieldAbfahrZeit = new JFormattedTextField();      JLabel jLabelPlz = new JLabel("    Plz:");                 JTextField jTextField1Plz = new JTextField();                        JLabel jLabelPlzZ = new JLabel("    Plz:");                 JTextField jTextField1PlzZ = new JTextField();
       JLabel jLabelAnkunftZeit = new JLabel("    Ankunft Zeit:");     JFormattedTextField jFormattedTextField1AnkunftZeit = new JFormattedTextField();    JLabel jLabelStadt = new JLabel("    Stadt:");             JTextField jTextField1Stadt = new JTextField();                      JLabel jLabelStadtZ = new JLabel("    Stadt:");             JTextField jTextField1StadtZ = new JTextField();
       JLabel jLabelPersonenzahl = new JLabel("    Personenzahl:");    JTextField jTextField1Personenzahl = new JTextField("0");                           JLabel jLabelStrasse = new JLabel("    Strasse:");         JTextField jTextField1Strasse = new JTextField();                    JLabel jLabelStrasseZ = new JLabel("    Strasse:");         JTextField jTextField1StrasseZ = new JTextField();
       JLabel jLabelKilometer = new JLabel("    Kilometer:");          JTextField jTextField1Kilometer = new JTextField();                                 JLabel jLabelStressenNummer = new JLabel("    Nummer:");   JTextField jTextField1StrassenNummer = new JTextField();             JLabel jLabelStrassenNummerZ = new JLabel("    Nummer:");   JTextField jTextField1StrassenNummerZ = new JTextField(6);
       JLabel jLabelfakeCenter1 = new JLabel();                             JLabel jLabelfakeCenter2 = new JLabel();                                            JLabel jLabelfakeCenter3 = new JLabel();                         JLabel jLabelfakeCenter4 = new JLabel();                             JLabel jLabelfakeCenter5 = new JLabel();                         JLabel jLabelfakeCenter6 = new JLabel();

       //JformatedTextFields -Set format-----------------------------------
        jFormattedTextField1AnkunftZeit.setFormatterFactory(new DefaultFormatterFactory(maskFormatterAbfahrt));
        jFormattedTextField1AnkunftZeit.setText(dateStringAbfahrt + localTime);
        jFormattedTextFieldAbfahrZeit.setFormatterFactory(new DefaultFormatterFactory(maskFormatterAnkunft));
        jFormattedTextFieldAbfahrZeit.setText(dateStringAnkunft + localTime);

        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //JLabel FAHRZEUG,WARNUNGEN-------------------------------------------------------------------------------------
        JLabel jLabelFahzeug = new JLabel("    FAHRZEUG:");                 JComboBox<String> jComboBoxFahrzeug = new JComboBox<>(fahrzeug);                  JLabel jLabelWarnung = new JLabel("                              WARNUNG:");
        JLabel jLabelFahrzeugTyp = new JLabel("    Typ:");                  JComboBox<String> jcomboboxFahrzeugTyp = new JComboBox<>(fahrzeugTyp);            JLabel jLabelWarnungFalscheTyp = new JLabel();
        JLabel jLabelFahrzeugMarke = new JLabel("    Marke:");              JComboBox<String> jComboBoxFahrzeugMarke = new JComboBox<>(fahrzeugMarke);        JLabel jLabel2Fahrer = new JLabel();
        JLabel jLabelFahrzeugGrosse = new JLabel("    Sitzplatze Zahl:");   JComboBox<String> jComboBoxFahrzeugGrosse =new JComboBox<>(fahrzeugSitzplatze);   JLabel jLabelWarnungFalscheGrosse = new JLabel();
        JLabel jLabelBaujahr = new JLabel("    Baujahr:");                  JComboBox<String> jcomboboxBaujahr = new JComboBox<>(garagenNummer);              JLabel jLabelWarnungLenkUndRuhezeiten = new JLabel();
        JLabel jLabelGaragenNummer = new JLabel("    Garagen Nummer:");     JTextField jTextFieldGaragenNummer = new JTextField(7);                  JLabel jLabelWarnungEinsatzZeit = new JLabel();
        JButton jButtonKontrolle = new JButton("Kontrolle");                JButton jButtonSave = new JButton("Speichern");                              JButton jButtonLoschenWarnungen = new JButton("Warnung Löschen");

        //JPanels-------------------------------------------------------------------------------------------------------
        //JPanel North Image-----------------------------------------
        NorthPanelImage jPanelNorth = new NorthPanelImage();
        jPanelNorth.setLayout(new GridLayout(7,4));

        jPanelNorth.add(jLabelFahrtauftrag);    jPanelNorth.add(jLabelFahrtauftragNummer);      jPanelNorth.add(jLabelfakeFahrtauftrag1);       jPanelNorth.add(jLabelfakeFahrtauftrag2);
        jPanelNorth.add(jLabelFahrer);          jPanelNorth.add(jComboBoxFahrer);               jPanelNorth.add(jLabelSachbearbeiter);          jPanelNorth.add(jComboBoxSachbearbeiter);
        jPanelNorth.add(jLabelFahrerName);      jPanelNorth.add(jTextFieldFahreName);           jPanelNorth.add(jLabelSachbearbeiterName);      jPanelNorth.add(jTextFieldSachbearbeiterName);
        jPanelNorth.add(jLabelFahrerNachname);  jPanelNorth.add(jTextFieldFahrehNachname);      jPanelNorth.add(jLabelSachbearbeiterNachname);  jPanelNorth.add(jTextFieldSachbearbeiterNachname);
        jPanelNorth.add(jLabelFahrerTel);       jPanelNorth.add(jTextFieldFahreTelefon);        jPanelNorth.add(jLabelSachbearbeiterTel);       jPanelNorth.add(jTextFieldSachbearbeiterTel);
        jPanelNorth.add(jLabelFuhrerschein);    jPanelNorth.add(jComboBoxFuhrerscheinklassen);  jPanelNorth.add(jLabelBearbeitungsFach);        jPanelNorth.add(jComboBoxBearbeitungFach);
        jPanelNorth.add(jLabelFakeNordUnten1);  jPanelNorth.add(jLabelFakeNordUnten2);          jPanelNorth.add(jLabelFakeNordUnten3);          jPanelNorth.add(jLabelFakeNordUnten4);

        //JPanel Center----------------------------------------------
        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(7,6));

        jPanelCenter.add(jLabelKundeGruppe);      jPanelCenter.add(jLabelFakeKundeGruppe);            jPanelCenter.add(jLabelAdresse);         jPanelCenter.add(jLabelFakeAdresse);          jPanelCenter.add(jLabelAdresseZ);         jPanelCenter.add(jLabelFakeAdresseZ);
        jPanelCenter.add(jlabelKundeGruppeName);  jPanelCenter.add(jTextFieldKundeGruppe);            jPanelCenter.add(jLabelLand);            jPanelCenter.add(jComboBoxLand);             jPanelCenter.add(jLabelLandZ);            jPanelCenter.add(jComboBoxLandZ);
        jPanelCenter.add(jLabelAbfahrtZeit);      jPanelCenter.add(jFormattedTextFieldAbfahrZeit);    jPanelCenter.add(jLabelPlz);             jPanelCenter.add(jTextField1Plz);             jPanelCenter.add(jLabelPlzZ);             jPanelCenter.add(jTextField1PlzZ);
        jPanelCenter.add(jLabelAnkunftZeit);      jPanelCenter.add(jFormattedTextField1AnkunftZeit);  jPanelCenter.add(jLabelStadt);           jPanelCenter.add(jTextField1Stadt);           jPanelCenter.add(jLabelStadtZ);           jPanelCenter.add(jTextField1StadtZ);
        jPanelCenter.add(jLabelPersonenzahl);     jPanelCenter.add(jTextField1Personenzahl);          jPanelCenter.add(jLabelStrasse);         jPanelCenter.add(jTextField1Strasse);         jPanelCenter.add(jLabelStrasseZ);         jPanelCenter.add(jTextField1StrasseZ);
        jPanelCenter.add(jLabelKilometer);        jPanelCenter.add(jTextField1Kilometer);             jPanelCenter.add(jLabelStressenNummer);  jPanelCenter.add(jTextField1StrassenNummer);  jPanelCenter.add(jLabelStrassenNummerZ);  jPanelCenter.add(jTextField1StrassenNummerZ);
        jPanelCenter.add(jLabelfakeCenter1);      jPanelCenter.add(jLabelfakeCenter2);                jPanelCenter.add(jLabelfakeCenter3);     jPanelCenter.add(jLabelfakeCenter4);          jPanelCenter.add(jLabelfakeCenter5);      jPanelCenter.add(jLabelfakeCenter6);

        //JPanelSouth------------------------------------------------
        JPanel jpanelSouth = new JPanel();
        jpanelSouth.setLayout(new GridLayout(7, 3));

        jpanelSouth.add(jLabelFahzeug);          jpanelSouth.add(jComboBoxFahrzeug);         jpanelSouth.add(jLabelWarnung);
        jpanelSouth.add(jLabelFahrzeugTyp);      jpanelSouth.add(jcomboboxFahrzeugTyp);      jpanelSouth.add(jLabelWarnungFalscheTyp);
        jpanelSouth.add(jLabelFahrzeugMarke);    jpanelSouth.add(jComboBoxFahrzeugMarke);    jpanelSouth.add(jLabel2Fahrer);
        jpanelSouth.add(jLabelFahrzeugGrosse);   jpanelSouth.add(jComboBoxFahrzeugGrosse);   jpanelSouth.add(jLabelWarnungFalscheGrosse);
        jpanelSouth.add(jLabelBaujahr);          jpanelSouth.add(jcomboboxBaujahr);          jpanelSouth.add(jLabelWarnungLenkUndRuhezeiten);
        jpanelSouth.add(jLabelGaragenNummer);    jpanelSouth.add(jTextFieldGaragenNummer);   jpanelSouth.add(jLabelWarnungEinsatzZeit);
        jpanelSouth.add(jButtonKontrolle);       jpanelSouth.add(jButtonSave);               jpanelSouth.add(jButtonLoschenWarnungen);

        //jtextFields validation on Numbers-----------------------------------------------------------------------------
        jTextFieldFahreTelefon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textFieldNumbersValidation(e,jTextFieldFahreTelefon);
            }
        });

        jTextFieldSachbearbeiterTel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textFieldNumbersValidation(e,jTextFieldSachbearbeiterTel);
            }
        });

        jTextField1Personenzahl.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textFieldNumbersValidation(e,jTextField1Personenzahl);
            }
        });

        jTextField1Kilometer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textFieldNumbersValidation(e,jTextField1Kilometer);
            }
        });

        jTextField1Plz.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textFieldNumbersValidation(e,jTextField1Plz);
            }
        });

        jTextField1PlzZ.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textFieldNumbersValidation(e,jTextField1PlzZ);
            }
        });

        jTextFieldGaragenNummer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                textFieldNumbersValidation(e,jTextFieldGaragenNummer);
            }
        });

        //JButtons Actions----------------------------------------------------------------------------------------------
        //JButton Kontrolle with Controller class-Kontrolle----
        jButtonKontrolle.addActionListener(new Kontrolle(jTextField1Personenzahl,jComboBoxFahrzeugGrosse,jTextField1Kilometer,jcomboboxFahrzeugTyp,jComboBoxBearbeitungFach,jLabelWarnungFalscheGrosse,jLabelWarnungFalscheTyp,jLabel2Fahrer,jLabelFahrerName,
                jTextFieldFahreName,jLabelSachbearbeiterName,jTextFieldSachbearbeiterName,jLabelFahrerNachname,jTextFieldFahrehNachname,jLabelSachbearbeiterNachname,jTextFieldSachbearbeiterNachname,jLabelFahrerTel,jTextFieldFahreTelefon,
                jLabelSachbearbeiterTel,jTextFieldSachbearbeiterTel,jlabelKundeGruppeName,jTextFieldKundeGruppe, jLabelPersonenzahl,jLabelPlz,jTextField1Plz,jLabelPlzZ,jTextField1PlzZ,jLabelKilometer,
                jLabelStadt,jTextField1Stadt,jLabelStadtZ,jTextField1StadtZ,jLabelStrasse,jTextField1Strasse,jLabelStrasseZ,jTextField1StrasseZ,jLabelStressenNummer,jTextField1StrassenNummer,jLabelStrassenNummerZ,jTextField1StrassenNummerZ,
                jFormattedTextFieldAbfahrZeit,jFormattedTextField1AnkunftZeit,jLabelWarnungLenkUndRuhezeiten,jLabelWarnungEinsatzZeit));

        //JButton Save with Controller class-Save--------------
        jButtonSave.addActionListener(new Save(jTextFieldFahreName,jTextFieldFahrehNachname,jTextFieldFahreTelefon,jComboBoxFuhrerscheinklassen,jTextFieldSachbearbeiterName,jTextFieldSachbearbeiterNachname,jTextFieldSachbearbeiterTel,
                jComboBoxBearbeitungFach,jTextFieldKundeGruppe,jFormattedTextFieldAbfahrZeit,jFormattedTextField1AnkunftZeit,jTextField1Personenzahl,jTextField1Kilometer,jComboBoxLand,jTextField1Plz,jTextField1Stadt,jTextField1Strasse,
                jTextField1StrassenNummer,jComboBoxLandZ,jTextField1PlzZ,jTextField1StadtZ,jTextField1StrasseZ,jTextField1StrassenNummerZ,jcomboboxFahrzeugTyp,jComboBoxFahrzeugMarke,jComboBoxFahrzeugGrosse,jTextFieldGaragenNummer,jcomboboxBaujahr));

       //JBUtton Warnungen with Controller class Warnungen--------------------------------------------------------------
        jButtonLoschenWarnungen.addActionListener(new Warnung(jLabelWarnungFalscheTyp,jLabel2Fahrer,jLabelWarnungFalscheGrosse,jLabelWarnungLenkUndRuhezeiten,jLabelWarnungEinsatzZeit));

        //jcomboBox Fahrzeug(filter fahrzeuge) STREAMS------------------------------------------------------------------
       jComboBoxFahrzeug.addPopupMenuListener(new PopupMenuListener() {
           @Override
           public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
               try{
               int personenzahl = Integer.parseInt(jTextField1Personenzahl.getText());

               if (personenzahl < 39){
               //    java.util.List<String> listFiltered = listFahrzeug.stream().filter(s -> s.contains("37")).collect(Collectors.toList());
//                   java.util.List<String> listFiltered = listFahrzeug.stream().filter(new Predicate<String>() {
//                       @Override
//                       public boolean test(String s) {
//                           return s.contains("37");
//                       }
//                   }).collect(Collectors.toList());

                  java.util.List<String> listFiltered = listFahrzeug.stream().filter(new MethodReference()::test).collect(Collectors.toList());

                   jComboBoxFahrzeug.setModel(new DefaultComboBoxModel<>(listFiltered.toArray(new String[0])));
               }else if (personenzahl < 45){
                   java.util.List<String> listFiltered = listFahrzeug.stream().filter(s -> s.contains("44")).collect(Collectors.toList());
                   jComboBoxFahrzeug.setModel(new DefaultComboBoxModel<>(listFiltered.toArray(new String[0])));
               }else if (personenzahl < 51){
                   java.util.List<String> listFiltered = listFahrzeug.stream().filter(s -> s.contains("50")).collect(Collectors.toList());
                   jComboBoxFahrzeug.setModel(new DefaultComboBoxModel<>(listFiltered.toArray(new String[0])));
               }else if (personenzahl < 55){
                   java.util.List<String> listFiltered = listFahrzeug.stream().filter(s -> s.contains("54")).collect(Collectors.toList());
                   jComboBoxFahrzeug.setModel(new DefaultComboBoxModel<>(listFiltered.toArray(new String[0])));
               }else if (personenzahl < 59){
                   java.util.List<String> listFiltered = listFahrzeug.stream().filter(s -> s.contains("58")).collect(Collectors.toList());
                   jComboBoxFahrzeug.setModel(new DefaultComboBoxModel<>(listFiltered.toArray(new String[0])));
               }else if (personenzahl < 63){
                   java.util.List<String> listFiltered = listFahrzeug.stream().filter(s -> s.contains("62")).collect(Collectors.toList());
                   jComboBoxFahrzeug.setModel(new DefaultComboBoxModel<>(listFiltered.toArray(new String[0])));
               }else if (personenzahl < 83){
                   java.util.List<String> listFiltered = listFahrzeug.stream().filter(s -> s.contains("82")).collect(Collectors.toList());
                   jComboBoxFahrzeug.setModel(new DefaultComboBoxModel<>(listFiltered.toArray(new String[0])));
               }else {
                   jComboBoxFahrzeug.setModel(new DefaultComboBoxModel<>(listFahrzeug.toArray(new String[0])));
               }
           }catch (Exception exs){
                   exs.printStackTrace();
                   System.out.println("LOG:Personenzahl TextField leer");
               }
           }

           //non implemented methods Interface---------------------
           @Override
           public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
           @Override
           public void popupMenuCanceled(PopupMenuEvent e) {}
       });

       //jcombobox Item listener FAHRER------------------------------------------------------------------------
        jComboBoxFahrer.addItemListener(e -> {
            if (Objects.equals(jComboBoxFahrer.getSelectedItem(), "bitte fahrer auswaehlen:")) {
                jTextFieldFahreName.setText("");
                jTextFieldFahrehNachname.setText("");
                jTextFieldFahreTelefon.setText("");
            } else {
                String fahrerNachname = "FAHRER\\F." + jComboBoxFahrer.getSelectedItem() + ".txt";

                        try (FileReader fileReader = new FileReader(fahrerNachname)) {
                            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                                String fahrerInhalt = bufferedReader.readLine();
                                String[] inhaltGeteilt = fahrerInhalt.split("[ ]+");

                                jTextFieldFahreName.setText(inhaltGeteilt[0]);
                                jTextFieldFahrehNachname.setText(inhaltGeteilt[1]);
                                jTextFieldFahreTelefon.setText(inhaltGeteilt[2]);
                                jComboBoxFuhrerscheinklassen.setSelectedItem(inhaltGeteilt[3]);
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });

        //jcombobox Item listener Sachbearbeiter--------------------------------------------------------------------------------
        jComboBoxSachbearbeiter.addItemListener(e -> {
            if (Objects.equals(jComboBoxSachbearbeiter.getSelectedItem(), "bitte sachbearbeiter auswaehlen:")){
                jTextFieldSachbearbeiterName.setText("");
                jTextFieldSachbearbeiterNachname.setText("");
                jTextFieldSachbearbeiterTel.setText("");
            }else {
                String sachbearbiterNachname = "SACHBEARBEITER\\S." + jComboBoxSachbearbeiter.getSelectedItem() + ".txt";

                try (FileReader fileReader = new FileReader(sachbearbiterNachname)) {
                    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                        String sachbearbeiterInhalt = bufferedReader.readLine();
                        String[] inhaltGeteilt = sachbearbeiterInhalt.split("[ ]+");

                        jTextFieldSachbearbeiterName.setText(inhaltGeteilt[0]);
                        jTextFieldSachbearbeiterNachname.setText(inhaltGeteilt[1]);
                        jTextFieldSachbearbeiterTel.setText(inhaltGeteilt[2]);
                        //to upper case--------------------------------------------------
                        String helper = inhaltGeteilt[3].substring(0,1).toUpperCase();
                        jComboBoxBearbeitungFach.setSelectedItem(helper + inhaltGeteilt[3].substring(1));
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        //jcombobox Item listener Fahrzeug-----------------------------------------------------------------------------------
        jComboBoxFahrzeug.addItemListener(e -> {
            if (Objects.equals(jComboBoxFahrzeug.getSelectedItem(), "bitte fahrzeug auswaehlen:")){
                jTextFieldGaragenNummer.setText("");
            }else {
                String fahrzeugName = "FAHRZEUGE\\BUS." + Objects.requireNonNull(jComboBoxFahrzeug.getSelectedItem()).toString() + ".txt";

                try (FileReader fileReader = new FileReader(fahrzeugName)) {
                    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                        String sachbearbeiterInhalt = bufferedReader.readLine();
                        String[] inhaltGeteilt = sachbearbeiterInhalt.split("[ ]+");

                        jcomboboxFahrzeugTyp.setSelectedItem(inhaltGeteilt[0]);
                        jComboBoxFahrzeugMarke.setSelectedItem(inhaltGeteilt[1]);
                        jComboBoxFahrzeugGrosse.setSelectedItem(inhaltGeteilt[2]);
                        jcomboboxBaujahr.setSelectedItem(inhaltGeteilt[3]);
                        jTextFieldGaragenNummer.setText(inhaltGeteilt[4]);
                        //to upper case--------------------------------------------------
                        String helper = inhaltGeteilt[3].substring(0,1).toUpperCase();
                        jComboBoxBearbeitungFach.setSelectedItem(helper + inhaltGeteilt[3].substring(1));
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        //jcombobox Item listener Sitzplatze,Baujahr--------------------------------------------------------------------
        jComboBoxFahrzeugGrosse.addItemListener(e -> jTextFieldGaragenNummer.setText(jComboBoxFahrzeugGrosse.getSelectedItem() + "" + jcomboboxBaujahr.getSelectedItem()));
        jcomboboxBaujahr.addItemListener(e -> jTextFieldGaragenNummer.setText(jComboBoxFahrzeugGrosse.getSelectedItem() + "" + jcomboboxBaujahr.getSelectedItem()));

        //Rahmen--------------------------------------------------------------------------------------------------------
        this.setLayout(new GridLayout(3,1));
        this.add(jPanelNorth);
        this.add(jPanelCenter);
        this.add(jpanelSouth);
        this.setTitle("Fahrtauftrag");
        this.setSize(900,800);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        //window listener-----------------------------------
        this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               dispose();
           }
       });
        //----------Visible---------------------------------
        this.setVisible(true);
    }//end constructor

    //Method for validation on input(only numbers)----------------------------------------------------------------------
    private void textFieldNumbersValidation (KeyEvent e,JTextField jTextField){
        if ((e.getKeyChar()>='0' && e.getKeyChar()<= '9') || e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            jTextField.setEditable(true);
        }else{
            jTextField.setEditable(false);
        }
    }

    // Private inner classes for Images---------------------------------------------------------------------------------
    private  class NorthPanelImage extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("rahmenBackground.jpg");
            imageIcon.paintIcon(this,g,0,0);
        }
    }//end inner class NorthPanelImage

    private class MethodReference {
        public boolean test(String s) {
            return s.contains("37");
        }
    }
}//end class Rahmen
