package tests;
import model.DataContact;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;


public class ContractCreate extends TestBase{



    public static List<DataContact> ContactProdiver() {
        var result = new ArrayList<DataContact>(List.of(
                new DataContact(),
                new DataContact().withLastname("Vinokurov"),
                new DataContact("Uva", "", "Tatov"),
                new DataContact("", "Leskov", "Mesov")));
        for(var i =0; i < 3; i++) {
            result.add(new DataContact()
                    .withFirstName(randomString(i * 2))
                    .withMiddleName(randomString(i * 2))
                    .withLastname(randomString(i * 2)));
        }
        return result;
    }


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

    @ParameterizedTest
    @MethodSource("ContactProdiver")
    public void ContractMultipleCreate(DataContact dataContact) {
        int contactCount = app.allcontacts().getCount();
        app.allcontacts().createContactshort(dataContact);
        int newContactCount = app.allcontacts().getCount();
    }
   }



