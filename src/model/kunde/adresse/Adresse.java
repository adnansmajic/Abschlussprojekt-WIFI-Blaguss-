package model.kunde.adresse;

public class Adresse {

    //properties--------------------------------------------------------------------------------------------------------
    private String nummer;
    private String strasse;
    private String stadt;
    private long plz;
    private String land;

    //constructor parametrized------------------------------------------------------------------------------------------
    public Adresse(String nummer, String strasse, String stadt, long plz, String land) {
        this.nummer = nummer;
        this.strasse = strasse;
        this.stadt = stadt;
        this.plz = plz;
        this.land = land;
    }

    // to String-------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return this.strasse + " " + this.nummer +"\n"+ this.plz + " " + this.stadt +"\n"+ this.land;
    }
}
