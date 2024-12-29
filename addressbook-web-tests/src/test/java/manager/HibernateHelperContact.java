package manager;

import manager.hbm.ContactRecord;
import manager.hbm.GroupRecord;
import model.DataContact;
import model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelperContact extends ContactHelper{

    private SessionFactory sessionFactory;

    public HibernateHelperContact(ApplicationManager manager) {
        super(manager);

        sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                // PostgreSQL
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook")
                // Credentials
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                // Create a new SessionFactory
                .buildSessionFactory();
}

    static List<DataContact> convertList(List<ContactRecord> records) {
        List<DataContact> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }


    private static DataContact convert(ContactRecord record) {
        return new DataContact().withId("" + record.id)
                .withFirstName(record.firstname)
                .withMiddleName(record.middlename)
                .withLastname(record.lastname);

    }



  //  private static DataContact convert(ContactRecord record) {
    //    return new DataContact("" + record.id, record.firstname, record.lastname, record.address);
   // }
    private static ContactRecord convert(DataContact data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new ContactRecord(Integer.parseInt(id), data.firstname(), data.lastname(), data.middlename());
    }

    public List<DataContact> getContactList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }


    public long getContactCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", Long.class).getSingleResult();
        });
    }
    public void CreateGroup(DataContact dataContact) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(dataContact));
            session.getTransaction().commit();
        });
    }
}