package tests;

import model.DataContact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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


}

