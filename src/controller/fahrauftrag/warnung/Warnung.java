package controller.fahrauftrag.warnung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warnung implements ActionListener {

    //properties -------------------------------------------------------------------------------------------------------
    private JLabel jLabelWarnungFalscheTyp;
    private JLabel jLabel2Fahrer;
    private JLabel jLabelWarnungFalscheGrosse;
    private JLabel jLabelWarnungLenkUndRuhezeiten;
    private JLabel jLabelWarnung1;

    //constructor default-----------------------------------------------------------------------------------------------
    public Warnung(){
    }//end of default constructor

    //constructor parametrized------------------------------------------------------------------------------------------
    public Warnung(JLabel jLabelWarnungFalscheTyp, JLabel jLabel2Fahrer, JLabel jLabelWarnungFalscheGrosse, JLabel jLabelWarnungLenkUndRuhezeiten, JLabel jLabelWarnung1) {
        this.jLabelWarnungFalscheTyp = jLabelWarnungFalscheTyp;
        this.jLabel2Fahrer = jLabel2Fahrer;
        this.jLabelWarnungFalscheGrosse = jLabelWarnungFalscheGrosse;
        this.jLabelWarnungLenkUndRuhezeiten = jLabelWarnungLenkUndRuhezeiten;
        this.jLabelWarnung1 = jLabelWarnung1;
    }//end of parametriziered constructor

    //warnungen delete method-------------------------------------------------------------------------------------------
    public void warnungenLoschen(JLabel jLabel){
        jLabel.setText("");
        jLabel.setOpaque(false);
    }

    //action listener warnungen-----------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        warnungenLoschen(jLabel2Fahrer);
        warnungenLoschen(jLabelWarnung1);
        warnungenLoschen(jLabelWarnungFalscheTyp);
        warnungenLoschen(jLabelWarnungFalscheGrosse);
        warnungenLoschen(jLabelWarnungLenkUndRuhezeiten);
    }
}//end of class
