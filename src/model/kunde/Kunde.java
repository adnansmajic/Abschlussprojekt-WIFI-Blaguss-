package model.kunde;

import model.kunde.adresse.Adresse;

public class Kunde {

    //properties--------------------------------------------------------------------------------------------------------
    private String kundenGruppeName;
    private String abfahrtZeit;
    private String ankunftZeit;
    private Adresse abholAdresse;
    private Adresse zielAdresse;
    private int personenZahl;
    private int kilometer;

    //constructor parametrized------------------------------------------------------------------------------------------
    public Kunde(String kundenGruppeName, String abfahrtZeit, String ankunftZeit, Adresse abholAdresse, Adresse zielAdresse, int personenZahl, int kilometer) {
        this.kundenGruppeName = kundenGruppeName;
        this.abfahrtZeit = abfahrtZeit;
        this.ankunftZeit = ankunftZeit;
        this.abholAdresse = abholAdresse;
        this.zielAdresse = zielAdresse;
        this.personenZahl = personenZahl;
        this.kilometer = kilometer;
    }

    //to String---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return  "\n\n\n---------------------KUNDE-------------------------------" +
                "\nName:                " + this.kundenGruppeName +
                "\nAbfahrt Zeit:        " + this.abfahrtZeit +
                "\nAnkunft Zeit:        " + this.ankunftZeit +
                "\nPersonenzahl:        " + this.personenZahl +
                "\nKilometer:           " + this.kilometer +
                "\n\n-----Abholadresse-----" +
                "\n>> " + this.abholAdresse.toString() +
                "\n-----Zieladresse------" +
                "\n<< " + this.zielAdresse.toString() ;
    }
}

