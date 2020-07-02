package model.auftrag;

import model.fahrzueg.Fahrzeug;
import model.person.fahrer.Fahrer;
import model.kunde.Kunde;
import model.person.sachbearbeiter.Sachbearbeiter;

public class Auftrag {

    //properties--------------------------------------------------------------------------------------------------------
    private Fahrer fahrer;
    private Sachbearbeiter sachbearbeiter;
    private Kunde kunde;
    private Fahrzeug fahrzeug;

    //constructor-------------------------------------------------------------------------------------------------------
    public Auftrag(Fahrer fahrer, Sachbearbeiter sachbearbeiter, Kunde kunde, Fahrzeug fahrzeug) {
        this.fahrer = fahrer;
        this.sachbearbeiter = sachbearbeiter;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
    }

    //to String---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return fahrer.toString() + sachbearbeiter.toString() + kunde.toString() + fahrzeug.toString();
    }
}
