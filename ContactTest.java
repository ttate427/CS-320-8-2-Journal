import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    // Test creating a valid contact
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test invalid contactId (null)
    @Test
    void testNullContactId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test invalid contactId (too long)
    @Test
    void testLongContactId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test invalid firstName (null)
    @Test
    void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", null, "Doe", "1234567890", "123 Main St"));
    }

    // Test invalid firstName (too long)
    @Test
    void testLongFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "JohnJacobJingle", "Doe", "1234567890", "123 Main St"));
    }

    // Test invalid lastName (null)
    @Test
    void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", null, "1234567890", "123 Main St"));
    }

    // Test invalid lastName (too long)
    @Test
    void testLongLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
    }

    // Test invalid phone (null)
    @Test
    void testNullPhone() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", null, "123 Main St"));
    }

    // Test invalid phone (not 10 digits)
    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "12345", "123 Main St"));
    }

    // Test invalid address (null)
    @Test
    void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "1234567890", null));
    }

    // Test invalid address (too long)
    @Test
    void testLongAddress() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("123", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }

    // Test setters with valid values
    @Test
    void testSetters() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }

    // Test setters with invalid values
    @Test
    void testSettersInvalid() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("ThisIsWayTooLong"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}
