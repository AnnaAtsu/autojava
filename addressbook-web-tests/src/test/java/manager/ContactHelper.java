package manager;
import model.DataContact;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public void removeContact() {
        charge.driver.findElement(By.id("1")).click();
        charge.driver.findElement(By.xpath("xpath=//input[@value='Delete']")).click();
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
}
