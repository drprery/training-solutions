package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countryList = new ArrayList<>();

    public void readFromFile(String file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                CountryStatistics.class.getResourceAsStream("/" + file)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(" ");
                Country country = new Country(lineParts[0], Integer.parseInt(lineParts[1]));
                countryList.add(country);
            }

        } catch (IOException ioe) {
            throw new IllegalStateException();
        }
    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        Country maxNeighbours = countryList.get(0);
        for (Country country : countryList) {

            if (country.getBorderCountries() > maxNeighbours.getBorderCountries()) {
                maxNeighbours = country;
            }
        }
        return maxNeighbours;
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }
}
