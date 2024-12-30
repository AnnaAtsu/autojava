package tests;

import model.DataContact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhones() {
        if (app.hbmcontact().getContactCount() == 0) {
            app.hbmcontact().createContactshort(new DataContact());
        }
        var contacts = app.hbmcontact().getContactList();
        var contact = contacts.get(0);
        var phones = app.allcontacts().getPhones(contact);
        var expected = Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);

    }

    @Test
    void testEmails() {
        if (app.hbmcontact().getContactCount() == 0) {
            app.hbmcontact().createContactshort(new DataContact());
        }
        var contacts = app.hbmcontact().getContactList();
        var contact = contacts.get(0);
        var emails = app.allcontacts().getEmails(contact);
        var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, emails);

    }

    @Test
    void testAddresses() {
        if (app.hbmcontact().getContactCount() == 0) {
            app.hbmcontact().createContactshort(new DataContact());
        }
        var contacts = app.hbmcontact().getContactList();
        var contact = contacts.get(0);
        var addresses = app.allcontacts().getAddresses(contact);
        var expected = Stream.of(contact.address(), contact.address2())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, addresses);

    }


}
