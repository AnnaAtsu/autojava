package tests;
import model.DataContact;
import org.junit.jupiter.api.Test;

public class ContractCreate extends TestBase{


    @Test
        public void ContractCreate() {
        app.allcontacts().openContactPage();
        app.allcontacts().createContactfull();
    }

    @Test
    public void ContractCreateWithName() {
        app.allcontacts().openContactPage();
        app.allcontacts().createContactshort(new DataContact().withFirstName("Maxim"));
    }

    @Test
    public void ContractCreateWithLastNameOnly() {
        app.allcontacts().openContactPage();
        var emptyContact = new DataContact();
        var emptyContactWithLastName = emptyContact.withLastname("Ivengo");
        app.allcontacts().createContactshort(emptyContactWithLastName);
    }


   }



