package manager;

import model.DataContact;
import model.GroupData;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCHelperContact extends ContactHelper {

    public JDBCHelperContact(ApplicationManager manager) {
        super(manager);
    }

    // Лекция 6 - получение доступа к бд

    public List<DataContact> getContactList() {
        var contacts = new ArrayList<DataContact>();
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
             var statement = conn.createStatement();
             var result = statement.executeQuery("SELECT id, firstname, middlename, lastname FROM addressbook")) {
            while (result.next()) {
                contacts.add(new DataContact()
                        .withId(result.getString("id"))
                        .withFirstName(result.getString("firstname"))
                        .withMiddleName(result.getString("middlename"))
                        .withLastname(result.getString("lastname")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;


    }
}
