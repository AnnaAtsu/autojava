package tests;
import model.DataContact;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContractDelete extends TestBase{

    @Test
    public void DeleteContract() {
     if(!isContactPresent(By.name("selected[]"))) {
         openContactPage();
         createContactshort(new DataContact().withFirstName("Maxim"));
     }
        removeContact();
    }

}

