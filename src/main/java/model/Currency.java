package model;

public class Currency {

    //Attributes
    private String abbreviation;
    private String name;
    private double rateToUSD;


    //Constructor
    public Currency(String abbreviation, String name, double rateToUSD) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    //Methods
    public String getAbbreviation() {
        return abbreviation;
    }

    //Getters and Setters
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }

    public void setRateToUSD(double rateToUSD) {
        this.rateToUSD = rateToUSD;
    }
}
