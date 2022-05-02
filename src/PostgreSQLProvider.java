import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class PostgreSQLProvider implements IContactsProvider{

    Connection con = null;

    public PostgreSQLProvider(){
        try {
        String url = "jdbc:postgresql://89.36.214.106:5432/geo_1cfsy_2486w";
        String usuari = "geo_1cfsy_2486w";
        String password = "geo_1cfsy_2486w";
        con = DriverManager.getConnection(url, usuari, password);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No s'ha pogut connectar");
        }
    }
    @Override
    public List<Contact> loadContacts() {
        return null;
    }

    @Override
    public void add(Contact contact) {
//insert into agenda
    }

    @Override
    public void remove(Contact contact) {
//delete
    }

    @Override
    public void update(Contact contact) {
//update
    }

    @Override
    public void removeAll() {

    }

    @Override
    public int generateid() {
        return 0;
    }
}
