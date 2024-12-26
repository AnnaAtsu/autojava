package tests;

import common.CommonFunctions;
import model.DataContact;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContractDelete extends TestBase {

    @Test
    public void DeleteContract() {
        if (!app.isContactPresent(By.name("selected[]"))) {
            app.allcontacts().openContactPage();
            app.allcontacts().createContactshort(new DataContact().withFirstName("Maxim"));
        }

        var oldContacts = app.allcontacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.allcontacts().removeContact(oldContacts.get(index));
        var newContacts = app.allcontacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts.size(), expectedList.size() - 1);
        // app.allcontacts().removeContact();
    }


    @Test
    public void DeleteContractWithComparasion() {
        if (!app.isContactPresent(By.name("selected[]"))) {
            app.allcontacts().openContactPage();
            app.allcontacts().createContactshort(new DataContact().withFirstName("Maxim"));
        }

        var oldContacts = app.allcontacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.allcontacts().removeContactWithComparasion(oldContacts.get(index));
        var newContacts = app.allcontacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts.size(), expectedList.size() - 1);
        // app.allcontacts().removeContact();
    }


    // Провайдер один для jdbc
    public static List<DataContact> singleRandomGroup() {
        return List.of(new DataContact()
                .withFirstName(CommonFunctions.randomString(10))
                .withMiddleName(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10)));
    }


    // Тест для jdbc Лекция 6


    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    public void DeleteContractWithComparasionWithJDBC(DataContact dataContact) {
        if (!app.isContactPresent(By.name("selected[]"))) {
            app.allcontacts().openContactPage();
            app.allcontacts().createContactshort(new DataContact().withFirstName("Maxim"));
        }

        var oldContacts = app.jdbccontact().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.allcontacts().removeContactWithComparasion(oldContacts.get(index));
        var newContacts = app.jdbccontact().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts.size() - 1, expectedList.size());
        // app.allcontacts().removeContact();
    }


}

