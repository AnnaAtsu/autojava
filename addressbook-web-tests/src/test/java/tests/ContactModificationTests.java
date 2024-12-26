package tests;

import common.CommonFunctions;
import model.DataContact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void ModifyContact() {
        // app.allcontacts().openContactPage();
        if (!app.isContactPresent(By.name("selected[]"))) {
            app.allcontacts().openContactPage();
            app.allcontacts().createContactshort(new DataContact().withFirstName("Maxim14"));
        }
        //  if(!app.allcontacts().selectContact()){
        //     app.allcontacts().createContactshort(new DataContact("firstname", "middlename", "lastname"));
        //}

        //  app.allcontacts().modificationContact(new DataContact().withFirstName("modifiedfirstname"));
    }

    @Test
    void ModifyContactWithComparasion() {
        app.allcontacts().openContactPage();
        if (app.allcontacts().getCount() == 0) {
            //app.allcontacts().createContactshort(new DataContact("Nickolas", "",));
            app.allcontacts().createContactshort(new DataContact().withFirstName("Marianna").withLastname("Smirnova22"));
        }
        var oldContacts = app.allcontacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new DataContact().withFirstName("new name").withLastname("new lastname");
        app.allcontacts().modificationContact(oldContacts.get(index), testData);
        var newContacts = app.allcontacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<DataContact> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };

        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

        //  if(!app.allcontacts().selectContact()){
        //     app.allcontacts().createContactshort(new DataContact("firstname", "middlename", "lastname"));
        //}

        // app.allcontacts().modificationContact(new DataContact().withFirstName("modifiedfirstname"));
    }


    // Провайдер один для jdbc
    public static List<DataContact> singleRandomGroup() {
        return List.of(new DataContact()
                .withFirstName(CommonFunctions.randomString(10))
                .withMiddleName(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10)));
    }

    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    void ModifyContactWithComparasionWithJDBC() {
        app.allcontacts().openContactPage();
        if (app.allcontacts().getCount() == 0) {
            //app.allcontacts().createContactshort(new DataContact("Nickolas", "",));
            app.allcontacts().createContactshort(new DataContact().withFirstName("Marianna").withLastname("Smirnova22"));
        }
        var oldContacts = app.jdbccontact().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var n = rnd.nextInt(1000);
        var testData = new DataContact().withFirstName(String.format("new name %s", n)).withLastname(String.format("new lastname %s", n));
        app.allcontacts().modificationContact(oldContacts.get(index), testData);
        var newContacts = app.jdbccontact().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<DataContact> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };

        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }


}