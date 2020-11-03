package introdate;

import java.time.LocalDateTime;
import java.time.LocalDate;

public class Employee {

    private String name;
    private LocalDate dateOfBirth;
    private LocalDateTime beginEmployment;

    public Employee(int year, int month, int day, String name) {
        this.dateOfBirth=LocalDate.of(year,month,day);
        this.beginEmployment=LocalDateTime.now();
        this.name=name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getBeginEmployment() {
        return beginEmployment;
    }
}
