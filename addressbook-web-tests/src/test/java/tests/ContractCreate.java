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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class ContractCreate extends TestBase {


    public static List<DataContact> ContactProdiver() throws IOException {
        var result = new ArrayList<DataContact>();
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<DataContact>>() {
        });
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


    // Провайдер один для jdbc
    public static List<DataContact> singleRandomContact() {
        return List.of(new DataContact()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10)));
    }




    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void ContractCreateWithComparasion(DataContact dataContact) {
        //  app.allcontacts().openContactPage();
        var oldContacts = app.allcontacts().getList();
        app.allcontacts().openContactPageForNewContact();
        app.allcontacts().createContactshort(dataContact);
        var newContacts = app.allcontacts().getList();
        Comparator<DataContact> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };

        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(dataContact.withId(newContacts.get(newContacts.size() - 1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }


    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void ContractCreateWithJDBC(DataContact dataContact) {
        //  app.allcontacts().openContactPage();
        var oldContacts = app.jdbccontact().getContactList();
        app.allcontacts().openContactPageForNewContact();
        app.allcontacts().createContactshort(dataContact);
        var newContacts = app.jdbccontact().getContactList();
        Comparator<DataContact> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };

        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(dataContact.withId(newContacts.get(newContacts.size() - 1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }

    //Задание №15: Реализовать тесты для добавления контакта в группу и удаления контакта из группы
// создает контакт, который в группу включен
    @Test
    public void canCreateContactInGroup() {
        var contact = new DataContact()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().CreateGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.allcontacts().create(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());

    }

    //Задание №15: Реализовать тесты для добавления контакта в группу и удаления контакта из группы
    @Test
    public void addContactToGroup() {
        var contact = new DataContact()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().CreateGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.allcontacts().addElementToGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size(), newRelated.size());
    }

//Задание №15: Реализовать тесты для добавления контакта в группу и удаления контакта из группы

    @Test
    public void removeContactFromGroup() {
        var contact = new DataContact()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().CreateGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }
        var group = app.hbm().getGroupList().get(0);
       var oldRelated = app.hbm().getContactsInGroup(group);
        app.allcontacts().PickGroupForMethod(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size(), newRelated.size());

    }

}


