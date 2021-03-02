package covid;

import java.time.LocalDate;


public class ExtendedCitizen extends Citizen{
    private int numOfVacc;
    private LocalDate lastVacc;

    public ExtendedCitizen(String fullName, String zipCode, int age, String email, String ssn, int numOfVacc, LocalDate lastVacc) {
        super(fullName, zipCode, age, email, ssn);
        this.numOfVacc = numOfVacc;
        this.lastVacc = lastVacc;
    }

    public int getNumOfVacc() {
        return numOfVacc;
    }

    public LocalDate getLastVacc() {
        return lastVacc;
    }

    public String getFullName(){
        return super.getFullName();
    }

    public String getZipCode(){
        return super.getZipCode();
    }

    public int getAge(){
        return super.getAge();
    }

    public String getEmail(){
        return super.getEmail();
    }

    public String getSsn(){
        return super.getSsn();
    }
}
