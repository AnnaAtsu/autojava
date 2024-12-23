package tests;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.DataContact;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ContractCreate extends TestBase {




    public static List<DataContact> ContactProdiver() throws IOException {
        var result = new ArrayList<DataContact>();
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<DataContact>>() {});
        result.addAll(value);
        return result;
    }


    //Старая версия до Лекции 5

 //   public static List<DataContact> ContactProdiver() {
   //     var result = new ArrayList<DataContact>(List.of(
     //           new DataContact(),
       //         new DataContact().withLastname("Vinokurov"),
         //       new DataContact("Uva", "", "Tatov", ""),
           //     new DataContact("", "Leskov", "Mesov", "")));
        //for (var i = 0; i < 3; i++) {
          //  result.add(new DataContact()
            //        .withFirstName(CommonFunctions.randomString(i * 2))
              //      .withMiddleName(CommonFunctions.randomString(i * 2))
                //    .withLastname(CommonFunctions.randomString(i * 2)));
       // }
        //return result;
    //}


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


//Лекция 5.1. Пути к файлам и директориям
    @Test
    public void ContractCreateWithNameWithFile() {
        app.allcontacts().openContactPage();
        var contact = new DataContact()
                .withFirstName("Margarita")
                .withLastname("Ivanova")
                .withPhoto("src/test/resources/images/avat.png");
        app.allcontacts().createContactshort(contact);

    }

    //Лекция 5 с рандомным файлом
    @Test
    public void ContractCreateWithNameWithRandomFile() {
        app.allcontacts().openContactPage();
        var contact = new DataContact()
                .withFirstName("Marcus")
                .withLastname("Smith")
                .withPhoto(randomFile("src/test/resources/images"));
        app.allcontacts().createContactshort(contact);

    }



    @ParameterizedTest
    @MethodSource("ContactProdiver")
    public void ContractMultipleCreate(DataContact dataContact) {
        int contactCount = app.allcontacts().getCount();
        app.allcontacts().createContactshort(dataContact);
        int newContactCount = app.allcontacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }

// Лекция 6
    @ParameterizedTest
    @MethodSource("ContactProdiver")
    public void ContractMultipleWithJDBC(DataContact dataContact) {
        int contactCount = app.allcontacts().getCount();
        app.allcontacts().createContactshort(dataContact);
        int newContactCount = app.allcontacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }

}


