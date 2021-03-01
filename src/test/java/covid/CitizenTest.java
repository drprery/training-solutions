package covid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {

    @Test
    void createCitizen() {
        Citizen citizen = new Citizen("Kovács János", "3200", 30, "kovacsjanos91@freemail.com", "123458603");
        assertEquals("Kovács János", citizen.getFullName());
        assertEquals("3200", citizen.getZipCode());
        assertEquals(30, citizen.getAge());
        assertEquals("kovacsjanos91@freemail.com", citizen.getEmail());
        assertEquals("123458603", citizen.getSsn());
    }

    @Test
    void createCitizenFailName() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "", "3200", 30, "kovacsjanos91@freemail.com", "123458603")
        );
    }

    @Test
    void createCitizenFailZip() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Kovács János", "9999", 30, "kovacsjanos91@freemail.com", "123458603")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Kovács János", null, 30, "kovacsjanos91@freemail.com", "123458603")
        );
    }

    @Test
    void createCitizenFailAge() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Kovács János", "3200", 9, "kovacsjanos91@freemail.com", "123458603")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Kovács János", "3200", 151, "kovacsjanos91@freemail.com", "123458603")
        );
    }

    @Test
    void createCitizenFailEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Kovács János", "3200", 30, "kj@freemailcom", "123458603")
        );
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Kovács János", "3200", 30, "kovacsjanos91freemail.com", "123458603")
        );
    }

    @Test
    void createCitizenFailSsn() {
        assertThrows(IllegalArgumentException.class, () -> new Citizen(
                "Kovács János", "3200", 40, "kovacsjanos91@freemail.com", "123458602")
        );
    }
}
