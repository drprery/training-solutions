package covid;

import java.time.LocalDate;

public class Vaccination {
    private int citizenId;
    private LocalDate dateTime;
    private Status status;
    private String note;
    private VaccinationType vaccinationType;

    public Vaccination(int citizenId, LocalDate dateTime, Status status, String note, VaccinationType vaccinationType) {
        this.citizenId = citizenId;
        this.dateTime = dateTime;
        this.status = status;
        this.note = note;
        this.vaccinationType = vaccinationType;
    }

    public Vaccination(int citizenId, LocalDate dateTime, Status status, VaccinationType vaccinationType) {
        this.citizenId = citizenId;
        this.dateTime = dateTime;
        this.status = status;
        this.vaccinationType = vaccinationType;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public VaccinationType getVaccinationType() {
        return vaccinationType;
    }

    @Override
    public String toString() {
        return ", citizenId=" + citizenId +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", vaccinationType=" + vaccinationType;
    }
}
