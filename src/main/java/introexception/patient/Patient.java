package introexception.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String ssn, int year) {
        if(name.isEmpty() || name==null){
            throw new IllegalArgumentException("Name is empty!");
        }
        if (year <= 1900) {
            throw new IllegalArgumentException("Year of birth is not valid! " + yearOfBirth);
        }
        if (!new SsnValidator().isValidSsn(ssn))
            throw new IllegalArgumentException("Social Security Number is not valid! " + ssn);

        this.name = name;
        this.socialSecurityNumber = ssn;
        this.yearOfBirth = year;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
