package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="addressbook")
public class ContactRecord {


    public int id;


    public String firstname;


    public String lastname;


    public String middlename;


    public ContactRecord() {}

    public ContactRecord(int id, String firstname, String middlename, String lastname) {

        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;

    }
}