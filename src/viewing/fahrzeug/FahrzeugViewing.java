package viewing.fahrzeug;

import controller.fahrzeug.FahrzeugController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;

public class FahrzeugViewing extends JFrame {

    //constructor-------------------------------------------------------------------------------------------------------
     public FahrzeugViewing() {
         //years for combobox from 2000 to actual year----------
        List jahren = new List();
        int aktuelleJahr = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 2000; i < aktuelleJahr + 1; i++) {
            jahren.add(String.valueOf(i));
        }

     //properties-------------------------------------------------------------------------------------------------------
     //String Arrays for JComboBoxes---------------------------
     final String[] fahrzeugtyp = {"Linienbus", "Reisebus"};
     final String[] fahrzeugMarke = {"Setra", "Mercedes", "Neoplan", "MAN", "Volvo", "Scania", "Solaris", "Temsa", "Van Hool", "VDL", "Irizar", "Irisbus"};
     final String[] fahrzeugSitzplatze = {"37", "44", "50", "54", "58", "62", "82"};
     final String[] baujahr = jahren.getItems();

    //JLabels,JButtons---------------------------------------
     JLabel jLabelTyp = new JLabel("    Typ: ");                               JComboBox<String> jComboBoxTyp = new JComboBox<>(fahrzeugtyp);
     JLabel jLabelMarke = new JLabel("    Marke: ");                           JComboBox<String> jComboBoxTMarke = new JComboBox<>(fahrzeugMarke);
     JLabel jLabelSitzplatzeZahl = new JLabel("    Sitzplatze Zahl: ");        JComboBox<String> jComboBoxSitzplatze = new JComboBox<>(fahrzeugSitzplatze);
     JLabel jLabelBaujahr = new JLabel("    Baujahr: ");                       JComboBox<String> jComboBoxBaujahr = new JComboBox<>(baujahr);
     JLabel jLabelGaragenNummer = new JLabel("    Garagen Nummer:");           JTextField jTextFieldGaragenNummer = new JTextField();
     JButton jButtonAddFahrzeug = new JButton("Speichern");                    JButton jButtonFahrzeugExit = new JButton("Exit");

      //jpanel----------------------------------------------------------------------------------------------------------
      JPanel jPanel = new JPanel(new GridLayout(6, 2));

      jPanel.add(jLabelTyp);               jPanel.add(jComboBoxTyp);
      jPanel.add(jLabelMarke);             jPanel.add(jComboBoxTMarke);
      jPanel.add(jLabelSitzplatzeZahl);    jPanel.add(jComboBoxSitzplatze);
      jPanel.add(jLabelBaujahr);           jPanel.add(jComboBoxBaujahr);
      jPanel.add(jLabelGaragenNummer);     jPanel.add(jTextFieldGaragenNummer);
      jPanel.add(jButtonAddFahrzeug);      jPanel.add(jButtonFahrzeugExit);

      //jtextFieldTel validation on input(only numbers)---------------------------------------------------------------
      jTextFieldGaragenNummer.addKeyListener(new KeyAdapter() {
       @Override
       public void keyPressed(KeyEvent e) {
        if ((e.getKeyChar()>='0' && e.getKeyChar()<= '9') || e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
         jTextFieldGaragenNummer.setEditable(true);
        }else{
         jTextFieldGaragenNummer.setEditable(false);
        }
       }
      });

      //action listener Buttons-----------------------------------------------------------------------------------------
      jButtonAddFahrzeug.addActionListener(new FahrzeugController(jComboBoxTyp,jComboBoxTMarke,jComboBoxSitzplatze,jComboBoxBaujahr,jTextFieldGaragenNummer));
      jButtonAddFahrzeug.addKeyListener(new FahrzeugController(jComboBoxTyp,jComboBoxTMarke,jComboBoxSitzplatze,jComboBoxBaujahr,jTextFieldGaragenNummer).getKeyListener());
      jButtonFahrzeugExit.addActionListener(e -> dispose());

      //jcombobox Item Listener-----------------------------------------------------------------------------------------
      jComboBoxBaujahr.addItemListener(e -> jTextFieldGaragenNummer.setText(jComboBoxSitzplatze.getSelectedItem() + "" + jComboBoxBaujahr.getSelectedItem()));
      jComboBoxSitzplatze.addItemListener(e -> jTextFieldGaragenNummer.setText(jComboBoxSitzplatze.getSelectedItem() + "" + jComboBoxBaujahr.getSelectedItem()));

      //rahmen----------------------------------------------------------------------------------------------------------
      this.setTitle("Fahrzeug hinzufugen");
      this.add(jPanel);
      this.setSize(400, 250);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.setResizable(false);
      //visible------------------------------------------
      this.setVisible(true);
    }//end of constructor
}//end of class
