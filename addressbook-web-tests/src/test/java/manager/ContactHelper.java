package manager;
import model.DataContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactHelper {
    private final ApplicationManager charge;


    public ContactHelper(ApplicationManager charge) {
        this.charge = charge;
    }


    public void openContactPage() {
        charge.driver.findElement(By.xpath("//a[contains(@href, 'edit.php')]")).click();
    }

    public void createContactshort(DataContact dataContact) {
        charge.driver.findElement(By.name("firstname")).click();
        charge.driver.findElement(By.name("firstname")).sendKeys(dataContact.firstname());
        charge.driver.findElement(By.name("middlename")).click();
        charge.driver.findElement(By.name("middlename")).sendKeys(dataContact.middlename());
        charge.driver.findElement(By.name("lastname")).click();
        charge.driver.findElement(By.name("lastname")).sendKeys(dataContact.lastname());
        charge.driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        charge.driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact(DataContact dataContact) {
        charge.driver.findElement(By.name("selected[]")).click();
        charge.driver.findElement(By.xpath("//input[@value='Delete']")).click();
       charge.driver.switchTo().alert().accept();
    }

    public void createContactfull() {
        charge.driver.findElement(By.name("firstname")).click();
        charge.driver.findElement(By.name("firstname")).sendKeys("Alina24");
        charge.driver.findElement(By.name("middlename")).click();
        charge.driver.findElement(By.name("middlename")).sendKeys("Alex");
        charge.driver.findElement(By.name("lastname")).click();
        charge.driver.findElement(By.name("lastname")).sendKeys("Brown");
        charge.driver.findElement(By.name("nickname")).click();
        charge.driver.findElement(By.name("nickname")).sendKeys("nick");
        charge.driver.findElement(By.name("title")).click();
        charge.driver.findElement(By.name("title")).sendKeys("tutle");
        charge.driver.findElement(By.name("company")).click();
        charge.driver.findElement(By.name("company")).sendKeys("Rert");
        charge.driver.findElement(By.name("address")).click();
        charge.driver.findElement(By.name("address")).sendKeys("trtrtretert");
        charge.driver.findElement(By.name("home")).click();
        charge.driver.findElement(By.name("home")).sendKeys("233456");
        charge.driver.findElement(By.name("mobile")).click();
        charge.driver.findElement(By.name("mobile")).sendKeys("565676767");
        charge.driver.findElement(By.name("work")).click();
        charge.driver.findElement(By.name("work")).sendKeys("ddd");
        charge.driver.findElement(By.name("fax")).click();
        charge.driver.findElement(By.name("fax")).sendKeys("123456");
        charge.driver.findElement(By.name("email")).click();
        charge.driver.findElement(By.name("email")).sendKeys("dfdf1@mail.ru");
        charge.driver.findElement(By.name("email2")).click();
        charge.driver.findElement(By.name("email2")).sendKeys("dfdf2@dfdf.ru");
        charge.driver.findElement(By.name("email3")).click();
        charge.driver.findElement(By.name("email3")).sendKeys("ghghg3@dfgdf.tu");
        charge.driver.findElement(By.name("homepage")).click();
        charge.driver.findElement(By.name("homepage")).sendKeys("testpage.ru");
        charge.driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = ApplicationManager.driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        charge.driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = ApplicationManager.driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        charge.driver.findElement(By.name("byear")).click();
        charge.driver.findElement(By.name("byear")).sendKeys("1988");
        charge.driver.findElement(By.name("aday")).click();
        {
            WebElement dropdown = ApplicationManager.driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '7']")).click();
        }
        charge.driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = ApplicationManager.driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        charge.driver.findElement(By.name("ayear")).click();
        charge.driver.findElement(By.name("ayear")).sendKeys("2010");
        charge.driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        charge.driver.findElement(By.linkText("home page")).click();
    }

    public int getCount() {
        openContactPage();
        return  charge.driver.findElements(By.name("selected[]")).size();
    }

    public void modificationContact(DataContact  modifiedfirstname) {
        //selectContact();
        initContactModification();
        fillContactForm(modifiedfirstname);
        submitContactModification();
        returnToMainPage();
    }

    private void returnToMainPage() {
        charge.driver.findElement(By.linkText("home page")).click();
    }

    private void fillContactForm(DataContact modifiedfirstname) {
        charge.driver.findElement(By.name("firstname")).click();
        charge.driver.findElement(By.name("firstname")).sendKeys(modifiedfirstname.firstname());
        charge.driver.findElement(By.name("middlename")).click();
        charge.driver.findElement(By.name("middlename")).sendKeys(modifiedfirstname.middlename());
        charge.driver.findElement(By.name("lastname")).click();
        charge.driver.findElement(By.name("lastname")).sendKeys(modifiedfirstname.lastname());
    }

    private void submitContactModification() {
        charge.driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/input[1]")).click();
    }

    private void initContactModification() {
        charge.driver.findElement(By.xpath("//a[contains(@href, 'edit.php')]")).click();

    }

//public void selectContact() {
    //   charge.driver.findElements(By.name("selected[]")).click();
   // }




    public List<DataContact> getList() {
      var contacts = new ArrayList<DataContact>();
      var trList = charge.driver.findElements(By.cssSelector(".center"));
      for (var trPart : trList) {
          var name = trPart.getText();
          var chekbox = trPart.findElement(By.name("selected[]"));
          var id = chekbox.getAttribute("value");
           contacts.add(new DataContact().withFirstName(name));
       }
      return contacts;
   }
}
