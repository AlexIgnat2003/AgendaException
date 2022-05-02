import java.util.List;

public interface IContactsProvider {
    List<Contact> loadContacts() throws CantLoadContacts;
    void add(Contact contact) throws CantLoadContacts;
    void remove(Contact contact) throws CantLoadContacts;
    void update(Contact contact) throws CantLoadContacts;
    void removeAll() throws CantLoadContacts;
    int generateid() throws CantLoadContacts;
}
