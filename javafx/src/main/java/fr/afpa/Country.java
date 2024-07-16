package fr.afpa;

public class Country {

    //Attributs
    private String name;
    private String isoCode;

    //Constructeur
    public Country(String name, String isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    //Méthodes
    @Override
    public String toString() {
        return "Country [name=" + name + ", isoCode=" + isoCode + "]";
    }  
}
