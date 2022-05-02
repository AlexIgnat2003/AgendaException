import java.util.LinkedList;
import java.util.List;

public class HardcodedContactsProvider implements IContactsProvider {

    List<Contact> contacts = new LinkedList<>();

    public HardcodedContactsProvider() {
        contacts.add(new Contact(0, "Pepe", "123456789", "C/Bonita", "pepe@gmail.com"));
        contacts.add(new Contact(1, "Maria", "123456789", "C/Bonita", "pepe@gmail.com"));
        contacts.add(new Contact(2,"Jose", "123456789", "C/Bonita", "pepe@gmail.com"));
        contacts.add(new Contact(3, "Cosmin", "123456789", "C/Bonita", "pepe@gmail.com"));
    }

    @Override
    public List<Contact> loadContacts() {
        return contacts;
    }

    @Override
    public void add(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void remove(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public int generateid() {
        return 0;
    }
}
