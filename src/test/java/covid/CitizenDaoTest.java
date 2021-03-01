package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizenDaoTest {
    private  CitizenDao citizenDao = new CitizenDao();
    private  Validator validator = new Validator();

    @BeforeEach
    void setUp() {
        MariaDbDataSource dataSource = new MariaDbDataSource();

        Flyway flyway = Flyway.configure().dataSource(citizenDao.getDataSource()).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void getSettlementsByZip() {
        assertEquals(List.of("Gyöngyös"), citizenDao.getSettlementsByZip("3200"));
    }

    @Test
    void validSsn() {
        assertTrue(validator.isValidSsn("123456788"));
        assertFalse(validator.isValidSsn("123456787"));
    }

    @Test
    void uploadCitizensFromFile() {
        assertEquals("Successfully uploaded 1000 citizens to the DB!",
                citizenDao.uploadCitizensFromFile("persons.csv"));
    }

    @Test
    void uploadCitizenToDb() {
        Citizen citizen = new Citizen("Kovács János", "3200", 30, "hunited@gmail.com", "123458603");
        assertEquals(1, citizenDao.uploadCitizenToDb(citizen));
    }

}
