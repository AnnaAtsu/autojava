package manager;

import manager.hbm.GroupRecord;
import model.DataContact;
import model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends GroupHelper {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);
        sessionFactory = new Configuration()
                //.addAnnotatedClass(Book.class)
                .addAnnotatedClass(GroupRecord.class)
                // PostgreSQL
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook")
                // Credentials
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                // Create a new SessionFactory
                .buildSessionFactory();
    }

    static List<GroupData> convertList(List<GroupRecord> records) {
        List<GroupData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }


    public List<GroupData> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

  //  public long getGroupCount() {
  //      return sessionFactory.fromSession(session -> {
  //          return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
  //      });
 //   }

    public void CreateGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });
    }

   // public List<DataContact> getContactsInGroup(GroupData group) {
    //     return sessionFactory.fromSession(session -> {
    //        return session.createQuery();
    //    })
   // }
}