package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class CitizenDao {
    private MariaDbDataSource dataSource = new MariaDbDataSource();
    private Validator validator = new Validator();

    public CitizenDao() {
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("root");
            dataSource.setPassword("root74");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database!", se);
        }

    }

    public List<String> getSettlementsByZip(String zipCode) {
        Dbase dbase = new Dbase(dataSource);

        return dbase.queryStringColumn("SELECT `settlement` FROM `postcodes` WHERE `zip` = ? ORDER BY `settlement`", zipCode);
    }

    public String uploadCitizensFromFile(String fileName) {
        int sum = 0;

        try (InputStream is = CitizenDao.class.getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String cols = br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] row = line.split(";");
                Citizen citizen = new Citizen(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4]);
                uploadCitizenToDb(citizen);
                sum++;
            }
            return "Successfully uploaded " + sum + " citizens to the DB!";
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
        }
    }

    public long uploadCitizenToDb(Citizen citizen) {
            try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO `citizens`(`citizen_name`, `zip`, `age`, `email`, `taj`) VALUES (?, ?, ?, ?, ?);",
                        Statement.RETURN_GENERATED_KEYS
                )) {
                ps.setString(1, citizen.getFullName());
                ps.setString(2, citizen.getZipCode());
                ps.setInt(3, citizen.getAge());
                ps.setString(4, citizen.getEmail());
                ps.setString(5, citizen.getSsn());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getLong(1);

            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not insert to DB!", sqle);
            }
    }

    public boolean isSsnRegistered(String ssn){
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT `citizen_id` FROM `citizens` WHERE `taj` = ?;"))
        {
            ps.setString(1, ssn);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error in connection of the DB!", sqle);
        }
    }

    public int selectNumberOfVaccinationBySsn(String ssn) {
        if (validator.isValidSsn(ssn)) {
            Citizen citizen = selectCitizenBySsn(ssn);
            if (citizen != null) {
                return citizen.getNumOfVacc();
            }
            System.out.println("\n4. Vaccination:\nCitizen not registered");
        }
        return -1;
    }

    public Citizen selectCitizenBySsn(String ssn) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select * from citizens where ssn = ?")) {
            stmt.setString(1, ssn);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("citizen_id");
                    String name = rs.getString("citizen_name");
                    String zipCode = rs.getString("zip");
                    int age = rs.getInt("age");
                    String email = rs.getString("email");
                    int vaccNumber = rs.getInt("number_of_vaccination");
                    LocalDate dateTime = rs.getObject("last_vaccination", LocalDate.class);
                    return new Citizen(id, name, zipCode, age, email, ssn, vaccNumber, dateTime);
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
        return null;
    }

    public String selectAndPrintLineCityByZipCode(String zipCode) {
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select city from postcodes where zipcode = ?")) {
            stmt.setString(1, zipCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String cityName = rs.getString("city");
                    System.out.println(cityName);
                    return cityName;
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }

        return null;
    }

    public void vaccination(String ssn) {
        int numberOfVaccination = selectNumberOfVaccinationBySsn(ssn);
        Scanner scanner = new Scanner(System.in);

        if (numberOfVaccination == 0) {
            System.out.println("\n4. Vaccination:\nEnter the date of vaccination! (Suitable format: yyyy-MM-dd hh:mm)");
            String dateTimeString = scanner.nextLine();
            System.out.println("\n4. Vaccination:\nEnter the type of vaccine! (PFIZER, MODERNA, ASTRAZENECA, SINOPHARM, SZPUTNYIK_V)");
            String vaccTypeString = scanner.nextLine();

            saveVaccination(ssn, dateTimeString, vaccTypeString);
            updateCitizenWithVaccination(ssn, dateTimeString, numberOfVaccination);
            System.out.println("\nSuccessful recording.");

        } else if (numberOfVaccination == 1) {
            Citizen citizen = selectCitizenBySsn(ssn);
            LocalDate dateTime = citizen.getLastVacc();
            Vaccination vaccination = selectVaccinationBySsn(ssn);

            System.out.println(String.format("%n4. Vaccination:%n Date of previous vaccination: %s,%n type of previous vaccination: %s.%n Enter the date of actual vaccination! (Suitable format: yyyy-MM-dd hh:mm)",
                    dateTime.toString(), vaccination.getVaccinationType().toString()));
            String actualDateTimeString = scanner.nextLine();
            saveVaccination(ssn, actualDateTimeString, vaccination.getVaccinationType().toString());
            updateCitizenWithVaccination(ssn, actualDateTimeString, numberOfVaccination);
            System.out.println("\nSuccessful recording.");

        } else if (numberOfVaccination == 2) {
            System.out.println("\n4. Vaccination:\nThe citizen is vaccinated twice!");
        }
    }

    public void saveVaccinationFailure(String ssn, Status status, String reasonOfFailure) {
        Scanner scanner = new Scanner(System.in);
        Citizen citizen = selectCitizenBySsn(ssn);
        int citizenId = 0;

        if (citizen != null) citizenId = citizen.getId();
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
                "insert into vaccinations(citizen_id, vaccination_date, status, note) VALUES (?,?,?,?)")){
            stmt.setInt(1, citizenId);
            stmt.setString(2, LocalDate.now().toString());
            stmt.setString(3, status.toString());
            stmt.setString(4, reasonOfFailure);
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert vaccination", se);
        }
        System.out.println("\nSuccessful recording.");
    }

    public Vaccination selectVaccinationBySsn(String ssn) {
        Citizen citizen = selectCitizenBySsn(ssn);
        int citizenId = 0;
        if (citizen != null) citizenId = citizen.getId();
        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement("select * from vaccinations where citizen_id = ?")) {
            stmt.setInt(1, citizenId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    LocalDate dateTime = rs.getObject("vaccination_date", LocalDate.class);
                    Status status = Status.valueOf(rs.getString("status"));
                    VaccinationType vaccType = VaccinationType.valueOf(rs.getString("vaccination_type"));
                    return new Vaccination(citizenId, dateTime, status, vaccType);
                }
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed", se);
        }
        return null;
    }

    public void saveVaccination(String ssn, String dateTimeString, String vaccinationTypeString) {
        Citizen citizen = selectCitizenBySsn(ssn);
        int citizenId = 0;
        if (citizen != null) citizenId = citizen.getId();

        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
                "insert into vaccinations(citizen_id, vaccination_date, status, vaccination_type) VALUES (?,?,?,?)")){
            stmt.setInt(1, citizenId);
            stmt.setString(2, dateTimeString);
            stmt.setString(3, setStatusBySsn(ssn));
            stmt.setString(4, vaccinationTypeString);
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert citizen", se);
        }
    }

    private String setStatusBySsn(String ssn) {
        int vaccNum = selectNumberOfVaccinationBySsn(ssn);
        if(vaccNum == 0) {
            return "FIRST";
        }
        if (vaccNum == 1) {
            return "SECOND";
        }
        return null;

    }

    private void updateCitizenWithVaccination(String ssn, String dateTimeString, int numberOfVaccination) {
        Citizen citizen = selectCitizenBySsn(ssn);
        int citizenId = 0;
        if (citizen != null) citizenId = citizen.getId();

        try (PreparedStatement stmt = dataSource.getConnection().prepareStatement(
                "UPDATE citizens SET number_of_vaccination = ?, last_vaccination = ? WHERE citizen_id = ?")){
            stmt.setInt(1,  numberOfVaccination + 1);
            stmt.setString(2, dateTimeString);
            stmt.setInt(3, citizenId);
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert citizen", se);
        }
    }

    private LocalDate parseDateTime(String dateTimeString) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDate.parse(dateTimeString, dtf);
    }

    public MariaDbDataSource getDataSource() {
        return dataSource;
    }
}
