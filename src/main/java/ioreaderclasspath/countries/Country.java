package ioreaderclasspath.countries;

public class Country {
    private int borderCountries;
    private String name;

    public Country(String name, int borderCountries) {
        this.name = name;
        this.borderCountries = borderCountries;
    }

    public String getName() {
        return name;
    }

    public int getBorderCountries() {
        return borderCountries;
    }
}
