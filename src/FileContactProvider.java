import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileContactProvider implements IContactsProvider{


    @Override
    public List<Contact> loadContacts() throws CantLoadContacts{

        List<Contact> contacts= new LinkedList<>();

        try {
            FileReader entrada = new FileReader("/home/INFORMATICA/alu10720690/IdeaProjects/Estructura_agenda/resources/contacts.txt");

            BufferedReader br= new BufferedReader(entrada);

            String linea= br.readLine();

            while(linea!=null){
                String[] partes= linea.split(";");
                Contact contact=new Contact(Integer.parseInt(partes[0]), partes[1], partes[2], partes[3], partes[4]);
                contacts.add(contact);
                linea = br.readLine();

            }
            entrada.close();

        } catch (IOException e) {
            throw new CantLoadContacts();
        }
        return contacts;
    }

    private void save(List<Contact> contactos) {

        try (BufferedWriter br= new BufferedWriter(new FileWriter("/home/INFORMATICA/alu10720690/IdeaProjects/Estructura_agenda/resources/contacts.txt"))){

            for (Contact persona: contactos) {
                String text= persona.getId()+";"+ persona.getName()+";"+ persona.getPhoneNumber()+";"+ persona.getAddress()+";"+ persona.getEmail();
                br.write(text);
                br.newLine();
            }
        } catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
    }

    @Override
    public void add(Contact contact) throws CantLoadContacts {
        List<Contact> contacts = loadContacts();
        contacts.add(contact);
        save(contacts);
    }

    @Override
    public void remove(Contact contact) throws CantLoadContacts {
        List<Contact> contacts = loadContacts();
        contacts.remove(contact);
        save(contacts);
    }

    @Override
    public void update(Contact contact) throws CantLoadContacts {
        List<Contact> contacts = loadContacts();
        contacts.remove(contact);
        contacts.add(contact);
        save(contacts);
    }

    @Override
    public void removeAll() throws CantLoadContacts {
        List<Contact> contacts = loadContacts();
        contacts.clear();
        save(contacts);
    }

    @Override
    public int generateid() throws CantLoadContacts {
        List<Contact> contacts = loadContacts();
        int contador= 0;

        for (Contact contact: contacts) {
            contador++;
        }
        return contador;
    }
}
