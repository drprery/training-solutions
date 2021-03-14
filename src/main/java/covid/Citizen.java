package covid;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="citizens")
public class Citizen {

    @Id
    @Column(name = "citizen_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="citizen_name")
    private String fullName;

    @Column(name="zip")
    private String zipCode;

    @Column(name="age")
    private int age;

    @Column(name="email")
    private String email;

    @Column(name="taj")
    private String ssn;

    @Column(name="number_of_vaccination")
    private int numOfVacc = 0;

    @Column(name="last_vaccination")
    private LocalDate lastVacc = null;


    public Citizen() {}

    public Citizen(String name, String zip, int age, String email, String taj){
        Validator validator = new Validator();
        CitizenDao dao = new CitizenDao();

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

    public Citizen(int id, String name, String zip, int age, String email, String taj, int numOfVacc, LocalDate lastVacc){
        Validator validator = new Validator();
        CitizenDao dao = new CitizenDao();

        this.id = id;

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

        this.lastVacc = lastVacc;
        this.numOfVacc = numOfVacc;

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

    public int getId() {
        return id;
    }

    public int getNumOfVacc() {
        return numOfVacc;
    }

    public LocalDate getLastVacc() {
        return lastVacc;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setNumOfVacc(int numOfVacc) {
        this.numOfVacc = numOfVacc;
    }

    public void setLastVacc(LocalDate lastVacc) {
        this.lastVacc = lastVacc;
    }
}
