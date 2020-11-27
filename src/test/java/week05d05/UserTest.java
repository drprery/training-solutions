package week05d05;

import org.junit.jupiter.api.Test;
import week05d02.ChangeLetter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {
    @Test
    public void invalidEmailShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("Kovács","János","kjanos@freemailhu"));
        assertEquals("Nem szabályos az email cím!", ex.getMessage());
    }

    @Test
    public void testGetFullName(){

        User user=new User("Kovács","János","kjanos@freemail.hu");

        assertEquals("Kovács János",user.getFullName());
    }

    @Test
    public void testOneOfTheNamesIsNull(){

        Exception ex = assertThrows(NullPointerException.class, () -> new User("Kovács",null,"kjanos@freemailhu"));
        assertEquals("Valamelyik név hiányzik!", ex.getMessage());
    }
}

