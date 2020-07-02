package model.person.sachbearbeiter;

import model.person.Person;

public class Sachbearbeiter extends Person {

    //properties--------------------------------------------------------------------------------------------------------
    private String bearbeitnugsFach;

    //constructor parametrized------------------------------------------------------------------------------------------
    public Sachbearbeiter(String vorName, String nachName, String telefonNummer, String bearbeitnugsFach) {
        super(vorName, nachName, telefonNummer);
        this.bearbeitnugsFach = bearbeitnugsFach;
    }

    //getters for properties--------------------------------------------------------------------------------------------
    public String getVorname() {
        return vorName;
    }

    public String getNachname() {
        return nachName;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public String getBearbeitnugsFach() {
        return bearbeitnugsFach;
    }

    //to String---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\n\n\n-----------------SACHBEARBEITER-------------------------" +
                super.toString() +
                "\nBearbeitungsfach:    " + this.bearbeitnugsFach;
    }
}//end of class
