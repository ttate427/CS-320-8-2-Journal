import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService service;
    private Contact contact1;
    private Contact contact2;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact1 = new Contact("001", "John", "Doe", "1234567890", "123 Main St");
        contact2 = new Contact("002", "Jane", "Smith", "0987654321", "456 Elm St");
    }

    // Test adding a contact
    @Test
    void testAddContact() {
        service.addContact(contact1);
        assertEquals(contact1, service.getContact("001"));
    }

    // Test adding a contact with duplicate ID
    @Test
    void testAddDuplicateContact() {
        service.addContact(contact1);
        Contact duplicate = new Contact("001", "Mike", "Brown", "1112223333", "789 Oak St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    // Test deleting a contact
    @Test
    void testDeleteContact() {
        service.addContact(contact1);
        service.deleteContact("001");
        assertNull(service.getContact("001"));
    }

    // Test deleting a contact that doesn't exist
    @Test
    void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    // Test updating firstName
    @Test
    void testUpdateFirstName() {
        service.addContact(contact1);
        service.updateFirstName("001", "Mike");
        assertEquals("Mike", service.getContact("001").getFirstName());
    }

    // Test updating lastName
    @Test
    void testUpdateLastName() {
        service.addContact(contact1);
        service.updateLastName("001", "Brown");
        assertEquals("Brown", service.getContact("001").getLastName());
    }

    // Test updating phone
    @Test
    void testUpdatePhone() {
        service.addContact(contact1);
        service.updatePhone("001", "1112223333");
        assertEquals("1112223333", service.getContact("001").getPhone());
    }

    // Test updating address
    @Test
    void testUpdateAddress() {
        service.addContact(contact1);
        service.updateAddress("001", "789 Oak St");
        assertEquals("789 Oak St", service.getContact("001").getAddress());
    }

    // Test updating a non-existent contact
    @Test
    void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Mike"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("999", "Brown"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("999", "1112223333"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("999", "789 Oak St"));
    }
}
