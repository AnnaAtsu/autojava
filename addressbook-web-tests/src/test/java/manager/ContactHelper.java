package manager;
import model.DataContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactHelper {
    private final ApplicationManager manager;


    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }


    public void openContactPage() {
        manager.driver.findElement(By.xpath("//a[contains(@href, 'edit.php')]")).click();
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
        return  manager.driver.findElements(By.name("selected[]")).size();
    }

    public void modificationContact(DataContact dataContact, DataContact modifiedfirstname1) {
        selectContact(dataContact);
        initContactModification();
        fillContactForm(modifiedfirstname1);
        submitContactModification();
        returnToMainPage();
    }

    private void returnToMainPage() {
        manager.driver.findElement(By.linkText("home page")).click();
    }

    private void fillContactForm(DataContact modifiedfirstname) {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(modifiedfirstname.firstname());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(modifiedfirstname.middlename());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(modifiedfirstname.lastname());
    }

    private void submitContactModification() {
        manager.driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/input[1]")).click();
    }

    private void initContactModification() {
        manager.driver.findElement(By.xpath("//a[contains(@href, 'edit.php')]")).click();

    }

   public void selectContact(DataContact dataContact) {
       manager.driver.findElement(By.xpath(String.format("//a[contains(@href, 'edit.php='%s')]", dataContact.firstname()))).click();
    }




    public List<DataContact> getList() {
      var contacts = new ArrayList<DataContact>();
     //var trList = charge.driver.findElements(By.cssSelector("tr td:nth-child(8)"));
        var trList = manager.driver.findElements(By.name("entry"));
      for (var trPart : trList) {
          var td = trPart.findElement(By.cssSelector("tr td:nth-child(8)"));
          var name = td.getText();
          var checkbox = trPart.findElement(By.xpath("//a[contains(@href, 'edit.php')]"));
          var id = checkbox.getAttribute("value");
           contacts.add(new DataContact().withFirstName(name));
       }
      return contacts;
   }




   protected  void  attach(By locator, String file) {
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














    public void GoToHomePage() {
        manager.driver.findElement(By.linkText("home")).click();
    }

    public void addElementToGroup() {
        manager.driver.findElement(By.id("3")).click();
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







}
