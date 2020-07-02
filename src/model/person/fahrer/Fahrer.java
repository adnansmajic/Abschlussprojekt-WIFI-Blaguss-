package model.person.fahrer;

import model.person.Person;

public class Fahrer extends Person {

    //properties--------------------------------------------------------------------------------------------------------
    private String fuhrerschein;

    //constructor parametrized------------------------------------------------------------------------------------------
    public Fahrer(String vorName, String nachName, String telefonNummer, String fuhrerschein) {
        super(vorName, nachName, telefonNummer);
        this.fuhrerschein = fuhrerschein;
    }//end of constructor

    //getter for properties---------------------------------------------------------------------------------------------
    public String getVorname() {
        return vorName;
    }

    public String getNachname() {
        return nachName;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public String getFuhrerschein() {
        return fuhrerschein;
    }

    //to String---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\n\n---------------------FAHRER------------------------------" +
                super.toString() +
                "\nFuhrerscheinklassen: " + this.fuhrerschein;
    }
}//end of class



