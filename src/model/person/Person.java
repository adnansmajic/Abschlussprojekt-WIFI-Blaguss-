package model.person;

public abstract class Person {

    //properties--------------------------------------------------------------------------------------------------------
    protected String vorName;
    protected String nachName;
    protected String telefonNummer;

    //constructor parametrized------------------------------------------------------------------------------------------
    public Person(String vorName, String nachName, String telefonNummer) {
        this.vorName = vorName;
        this.nachName = nachName;
        this.telefonNummer = telefonNummer;
    }

    //to String---------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return  "\nName:                " + this.vorName +
                "\nNachname:            " + this.nachName +
                "\nTelefon:             " + this.telefonNummer;
    }
}
