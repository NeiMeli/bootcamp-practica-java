package clase2.tt.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordsTest {
    @Test
    void testSimplePasswordIsValid() {
        Password simplePassword = new SimplePassword();
        assertFalse(simplePassword.isValid("1234"));
        assertFalse(simplePassword.isValid("password1234"));
        assertTrue(simplePassword.isValid("password"));
    }

    @Test
    void testSimplePasswordSetValue() {
        Password simplePassword = new SimplePassword();
        assertThrows(Password.PasswordException.class, () -> simplePassword.setValue("password1234"));
        assertNotEquals( "password1234", simplePassword.getValue());
        simplePassword.setValue("password");
        assertEquals("password", simplePassword.getValue());
    }

    @Test
    void testMediumPasswordIsValid() {
        Password mediumPassword = new MediumPassword();
        assertFalse(mediumPassword.isValid("password"));
        assertFalse(mediumPassword.isValid("1234"));
        assertTrue(mediumPassword.isValid("password1234"));
    }

    @Test
    void testMediumPasswordSetValue() {
        Password mediumPassword = new MediumPassword();
        assertThrows(Password.PasswordException.class, () -> mediumPassword.setValue("password"));
        assertNotEquals( "password", mediumPassword.getValue());
        mediumPassword.setValue("password1234");
        assertEquals("password1234", mediumPassword.getValue());
    }

    @Test
    void testStrongPasswordIsValid() {
        Password strongPassword = new StrongPassword();
        assertFalse(strongPassword.isValid("password"));
        assertFalse(strongPassword.isValid("1234"));
        assertFalse(strongPassword.isValid("password1234"));
        assertFalse(strongPassword.isValid("password1234#"));
        assertFalse(strongPassword.isValid("Password1234@"));
        assertFalse(strongPassword.isValid("PAss12@"));
        assertTrue(strongPassword.isValid("PasswoRd1234@"));
    }

    @Test
    void testStrongPasswordSetValue() {
        Password strongPassword = new StrongPassword();
        assertThrows(Password.PasswordException.class, () -> strongPassword.setValue("password"));
        assertNotEquals( "password", strongPassword.getValue());
        strongPassword.setValue("278HJt#mk");
        assertEquals("278HJt#mk", strongPassword.getValue());
    }
}