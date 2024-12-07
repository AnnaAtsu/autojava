package tests;
import model.DataContact;
import org.junit.jupiter.api.Test;

public class ContractCreate extends TestBase{


    @Test
        public void ContractCreate() {
        openContactPage();
        createContactfull();
    }

    @Test
    public void ContractCreateWithName() {
        openContactPage();
        createContactshort(new DataContact().withFirstName("Maxim"));
    }

    @Test
    public void ContractCreateWithLastNameOnly() {
        openContactPage();
        var emptyContact = new DataContact();
        var emptyContactWithLastName = emptyContact.withLastname("Ivengo");
        createContactshort(emptyContactWithLastName);
    }


   }



