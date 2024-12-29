package manager;

import model.DataContact;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper {
    private final ApplicationManager manager;


    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }


    public void openContactPage() {
        manager.driver.findElement(By.xpath("//a[contains(@href, 'edit.php')]")).click();
    }

    public void openContactPageForNewContact() {
        manager.driver.get("http://localhost/addressbook/edit.php");

    }

    public void createContactshort(DataContact dataContact) {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(dataContact.firstname());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(dataContact.middlename());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(dataContact.lastname());
        manager.driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact(DataContact dataContact) {
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.xpath("//input[@value='Delete']")).click();
        manager.driver.switchTo().alert().accept();
    }

    public void removeContactWithComparasion(DataContact dataContact) {
        selectContactToDelete(dataContact);
        //manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.xpath("//input[@value='Delete']")).click();
        //manager.driver.switchTo().alert().accept();
    }

    public void selectContactToDelete(DataContact dataContact) {
        manager.driver.findElement(By.cssSelector(String.format("input[value='%s']", dataContact.id()))).click();
        // manager.driver.findElement(By.cssSelector(String.format("tr td:nth-child(8)", dataContact.withFirstName("Marianna")))).click();
        // manager.driver.findElement(By.cssSelector(String.format("tr td:nth-child(8)", dataContact.id()))).click();
    }

    public void createContactfull() {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys("Alina24");
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys("Alex");
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys("Brown");
        manager.driver.findElement(By.name("nickname")).click();
        manager.driver.findElement(By.name("nickname")).sendKeys("nick");
        manager.driver.findElement(By.name("title")).click();
        manager.driver.findElement(By.name("title")).sendKeys("tutle");
        manager.driver.findElement(By.name("company")).click();
        manager.driver.findElement(By.name("company")).sendKeys("Rert");
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys("trtrtretert");
        manager.driver.findElement(By.name("home")).click();
        manager.driver.findElement(By.name("home")).sendKeys("233456");
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys("565676767");
        manager.driver.findElement(By.name("work")).click();
        manager.driver.findElement(By.name("work")).sendKeys("ddd");
        manager.driver.findElement(By.name("fax")).click();
        manager.driver.findElement(By.name("fax")).sendKeys("123456");
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys("dfdf1@mail.ru");
        manager.driver.findElement(By.name("email2")).click();
        manager.driver.findElement(By.name("email2")).sendKeys("dfdf2@dfdf.ru");
        manager.driver.findElement(By.name("email3")).click();
        manager.driver.findElement(By.name("email3")).sendKeys("ghghg3@dfgdf.tu");
        manager.driver.findElement(By.name("homepage")).click();
        manager.driver.findElement(By.name("homepage")).sendKeys("testpage.ru");
        manager.driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = ApplicationManager.driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        manager.driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = ApplicationManager.driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        manager.driver.findElement(By.name("byear")).click();
        manager.driver.findElement(By.name("byear")).sendKeys("1988");
        manager.driver.findElement(By.name("aday")).click();
        {
            WebElement dropdown = ApplicationManager.driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '7']")).click();
        }
        manager.driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = ApplicationManager.driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        manager.driver.findElement(By.name("ayear")).click();
        manager.driver.findElement(By.name("ayear")).sendKeys("2010");
        manager.driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public int getCount() {
        openContactPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void modificationContact(DataContact oldContact, DataContact newContact) {
        selectContact(oldContact);
        // initContactModification();
        fillContactForm(newContact);
        submitContactModification();
        returnToMainPage();
    }

    private void returnToMainPage() {
        manager.driver.findElement(By.linkText("home page")).click();
    }

    private void fillContactForm(DataContact newContact) {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).clear();
        manager.driver.findElement(By.name("firstname")).sendKeys(newContact.firstname());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).clear();
        manager.driver.findElement(By.name("middlename")).sendKeys(newContact.middlename());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).clear();
        manager.driver.findElement(By.name("lastname")).sendKeys(newContact.lastname());
    }

    private void submitContactModification() {
        manager.driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/input[1]")).click();
    }

    private void initContactModification() {
        manager.driver.findElement(By.xpath("//a[contains(@href, 'edit.php')]")).click();

    }

    public void selectContact(DataContact dataContact) {
        manager.driver.findElement(By.xpath(String.format("//a[contains(@href, 'edit.php?id=%s')]", dataContact.id()))).click();
        // manager.driver.findElement(By.cssSelector(String.format("tr td:nth-child(8)", dataContact.withFirstName("Marianna")))).click();
        // manager.driver.findElement(By.cssSelector(String.format("tr td:nth-child(8)", dataContact.id()))).click();
    }


    public List<DataContact> getList() {
        var contacts = new ArrayList<DataContact>();
        //var trList = charge.driver.findElements(By.cssSelector("tr td:nth-child(8)"));
        var trList = manager.driver.findElements(By.name("entry"));
        for (var trPart : trList) {
            var td = trPart.findElement(By.cssSelector("tr td:nth-child(3)"));
            //получить имя
            var name = td.getText();
            var td2 = trPart.findElement(By.cssSelector("tr td:nth-child(2)"));
            var lastname = td2.getText();
            //получить идентификатор строки
            //var checkbox = trPart.findElement(By.xpath("//a[contains(@href, 'edit.php')]"));
            //var checkbox = trPart.findElement(By.xpath("//a[contains(@href, 'edit.php')]"));
            var checkbox = trPart.findElement(By.cssSelector("input[type=checkbox]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new DataContact().withId(id).withFirstName(name).withLastname(lastname));
        }
        return contacts;
    }


    //Лекция 5.1. Пути к файлам и директориям
    protected void attach(By locator, String file) {
        manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }

    //Лекция 5.1. Пути к файлам и директориям
    private void fillContactFormwithFile(DataContact contact) {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        attach(By.name("photo"), contact.photo());
    }


    //Задание №15: Реализовать тесты для добавления контакта в группу и удаления контакта из группы
    public void GoToHomePage() {
        manager.driver.findElement(By.linkText("home")).click();
    }

    public void addElementToGroup() {
        manager.driver.findElement(By.id("1")).click();
        manager.driver.findElement(By.name("to_group")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("to_group"));
            dropdown.findElement(By.xpath("//option[. = 'SASHA']")).click();
        }
        manager.driver.findElement(By.name("add")).click();
    }

    public void openAddressbookPage() {
        manager.driver.get("http://localhost/addressbook/");
    }


    public void RemoveContactFromGroup() {
        manager.driver.findElement(By.name("remove")).click();
    }

    public void PickGroupForMethod() {
        manager.driver.findElement(By.name("group")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("group"));
            dropdown.findElement(By.xpath("//option[. = 'SASHA']")).click();
        }
        manager.driver.findElement(By.id("175")).click();
    }

  public void create(DataContact contact, GroupData group) {
      openContactPageForNewContact();
       createContactshort(contact);
       getSelectGroup(group);
        submitContactModification();
        returnToMainPage();
  }

    private static void getSelectGroup(GroupData groupData) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(groupData.id());
    }


}
