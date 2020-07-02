package model.fahrzueg;

public class Fahrzeug {

    //properties--------------------------------------------------------------------------------------------------------
    private String fahzeugTyp;
    private String fahrzeugMarke;
    private int sitzplatze;
    private int garagenNummer;
    private int baujahr;

    //constructor parametrized------------------------------------------------------------------------------------------
    public Fahrzeug(String fahzeugTyp, String fahrzeugMarke, int sitzplatze, int garagenNummer, int baujahr) {
        this.fahzeugTyp = fahzeugTyp;
        this.fahrzeugMarke = fahrzeugMarke;
        this.sitzplatze = sitzplatze;
        this.garagenNummer = garagenNummer;
        this.baujahr = baujahr;
    }

    //getters for properties--------------------------------------------------------------------------------------------
    public String getFahzeugTyp() {
        return fahzeugTyp;
    }

    public String getFahrzeugMarke() {
        return fahrzeugMarke;
    }

    public int getSitzplatze() {
        return sitzplatze;
    }

    public int getGaragenNummer() {
        return garagenNummer;
    }

    public int getBaujahr() {
        return baujahr;
    }

    //to String---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "\n\n\n------------------FAHRZEUG-------------------------------" +
                "\nTyp:                 " + fahzeugTyp +
                "\nMarke:               " + fahrzeugMarke +
                "\nSitzplatze Zahl:     " + sitzplatze +
                "\nGaragen Nummer:      " + garagenNummer +
                "\nBaujahr:             " + baujahr;
    }
}
