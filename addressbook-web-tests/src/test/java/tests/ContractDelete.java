package tests;
import model.DataContact;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContractDelete extends TestBase{

    @Test
    public void DeleteContract() {
     if(!app.isContactPresent(By.name("selected[]"))) {
         app.allcontacts().openContactPage();
         app.allcontacts().createContactshort(new DataContact().withFirstName("Maxim"));
     }
        app.allcontacts().removeContact();
    }

}

