package week15d05.listversion;

import java.util.Objects;

public class House implements Comparable<House>{
    private String name;
    private Integer numberOfBattles;

    public House(String name, int numberOfBattles) {
        this.name = name;
        this.numberOfBattles = numberOfBattles;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBattles() {
        return numberOfBattles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfBattles(int numberOfBattles) {
        this.numberOfBattles = numberOfBattles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(name, house.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(House o) {
        return numberOfBattles.compareTo(o.getNumberOfBattles());
    }
}
