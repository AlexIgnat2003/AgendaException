import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    private List<Contact> contacts = new LinkedList<>();
    private IContactsProvider provider;

    public Agenda(IContactsProvider provider) throws CantLoadContacts {
        this.provider = provider;
        refresh();
    }

    public void refresh() throws CantLoadContacts {
        contacts = provider.loadContacts();
        contacts.sort(Comparator.comparing(contact -> contact.getName()));
    }

    public void add(Contact contact) throws CantLoadContacts {
        provider.add(contact);
        refresh();
    }

    public void remove(Contact contact) throws CantLoadContacts {
        provider.remove(contact);
        refresh();
    }

    public void update(Contact contact) throws CantLoadContacts {
        provider.update(contact);
        refresh();
    }

    public Contact searchContact(String search){
        return contacts.get(Integer.parseInt(search));
    }

    public void removeAll() throws CantLoadContacts {
        provider.removeAll();
        refresh();
    }

    public Contact retrieve(int index) {
        return contacts.get(index);
    }

    public List<Contact> filter(String filter) {
        return contacts.stream().filter(c -> c.getName().contains(filter) || c.getAddress().contains(filter)
                || c.getEmail().contains(filter) || c.getPhoneNumber().contains(filter)).collect(Collectors.toList());
    }

    public int generateid() throws CantLoadContacts {
        int newid = 0;
        newid = provider.generateid();
        refresh();
        return newid;
    }


    @Override
    public String toString() {
        String agendaStr = "";
        for (Contact contact : contacts)
            agendaStr += contacts.indexOf(contact) + "\n" + contact + "\n\n";
        return agendaStr + "\n";
    }
}
