package tests;
import model.DataContact;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase{

    @Test
    void ModifyContact() {
        app.allcontacts().openContactPage();
        if(!app.isContactPresent(By.name("selected[]"))) {
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
        if(app.allcontacts().getCount() == 0) {
            app.allcontacts().createContactshort(new DataContact().withFirstName("Alexander"));
        }
            var oldContacts = app.allcontacts().getList();
            var rnd = new Random();
            var index = rnd.nextInt(oldContacts.size());
        var testData = new DataContact().withFirstName("modified name Nastya");
            app.allcontacts().modificationContact(oldContacts.get(index), testData);
          var newContacts = app.allcontacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withFirstName(oldContacts.get(index).firstname()));
        Comparator<DataContact> compareByName = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.firstname()), Integer.parseInt(o2.firstname()));
        };
        newContacts.sort(compareByName);
        expectedList.sort(compareByName);
        Assertions.assertEquals(newContacts, expectedList);

        //  if(!app.allcontacts().selectContact()){
        //     app.allcontacts().createContactshort(new DataContact("firstname", "middlename", "lastname"));
        //}

       // app.allcontacts().modificationContact(new DataContact().withFirstName("modifiedfirstname"));
    }






}