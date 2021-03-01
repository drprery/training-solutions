package covid;

public class Citizen {

    private final String fullName;
    private final String zipCode;
    private final int age;
    private final String email;
    private final String ssn;

    public Citizen(String fullName, String zipCode, int age, String email, String ssn) {
        CitizenDao dao = new CitizenDao();
        Validator validator = new Validator();

        if(validator.isValidFullName(fullName)) {
            this.fullName = fullName.trim();
        } else throw new IllegalArgumentException("Name must not be empty!");

        if (!validator.isValidZipCode(zipCode) || dao.getSettlementsByZip(zipCode).isEmpty()) {
            throw new IllegalArgumentException("ZIP Code error: must be 4 characters or the city not found in the database!");
        }
        this.zipCode = zipCode.trim();

        if (!validator.isValidAge(age)) {
            throw new IllegalArgumentException("Age must be between 10 and 150!");
        }
        this.age = age;

        if (!validator.isValidEmail(email)) {
            throw new IllegalArgumentException("Not valid email address!");
        }
        this.email = email.trim();

        if (!validator.isValidSsn(ssn.trim())) {
            throw new IllegalArgumentException("SSN number is non valid!");
        }
        this.ssn = ssn.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSsn() {
        return ssn;
    }
}
