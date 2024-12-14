package tests;
import model.DataContact;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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

        app.allcontacts().modificationContact(new DataContact().withFirstName("modifiedfirstname"));
    }
}