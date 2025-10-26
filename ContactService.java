import java.util.HashMap;

public class ContactService {
    // Store contacts using contactId as the key
    private HashMap<String, Contact> contacts = new HashMap<>();

    // Add a contact (must have unique contactId)
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    // Update first name
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setFirstName(firstName);
        } else {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
    }

    // Update last name
    public void updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setLastName(lastName);
        } else {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
    }

    // Update phone number
    public void updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setPhone(phone);
        } else {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
    }

    // Update address
    public void updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            contact.setAddress(address);
        } else {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
    }

    // Optional: Get contact (useful for testing)
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
