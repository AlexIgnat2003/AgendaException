public class CantLoadContacts extends Exception{
    public CantLoadContacts() {
        super("No se han podido cargar los contactos");
    }
}
