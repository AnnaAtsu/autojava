package tests;

import manager.ApplicationManager;
import model.DataContact;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.NoSuchElementException;

public class TestBase {

    public static WebDriver driver;
   protected static ApplicationManager app;

    protected static void createContactshort(DataContact dataContact) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(dataContact.firstname());
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys(dataContact.middlename());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(dataContact.lastname());
        driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    protected static void removeContact() {
        driver.findElement(By.id("1")).click();
        driver.findElement(By.xpath("xpath=//input[@value='Delete']")).click();
        driver.switchTo().alert().accept();
    }

    //@AfterEach
    //public void tearDown() {
     //   driver.findElement(By.linkText("Logout")).click();
      //  driver.quit();

    //}

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "edge"));
    }

    @BeforeEach
    public void set() {
        if (driver == null) {
            driver = new EdgeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/index.php");
            driver.manage().window().setSize(new Dimension(1904, 1119));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }


    public boolean isContactPresent(By locator) {
       try {
           driver.findElement(locator);
           return true;
       }
        catch (NoSuchElementException exception) {
           return false;
       }
    }

    protected void createContactfull() {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("Alina24");
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys("Alex");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("Brown");
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).sendKeys("nick");
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).sendKeys("tutle");
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).sendKeys("Rert");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("trtrtretert");
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys("233456");
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys("565676767");
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("work")).sendKeys("ddd");
        driver.findElement(By.name("fax")).click();
        driver.findElement(By.name("fax")).sendKeys("123456");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("dfdf1@mail.ru");
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).sendKeys("dfdf2@dfdf.ru");
        driver.findElement(By.name("email3")).click();
        driver.findElement(By.name("email3")).sendKeys("ghghg3@dfgdf.tu");
        driver.findElement(By.name("homepage")).click();
        driver.findElement(By.name("homepage")).sendKeys("testpage.ru");
        driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).sendKeys("1988");
        driver.findElement(By.name("aday")).click();
        {
            WebElement dropdown = driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '7']")).click();
        }
        driver.findElement(By.name("amonth")).click();
        {
            WebElement dropdown = driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = 'January']")).click();
        }
        driver.findElement(By.name("ayear")).click();
        driver.findElement(By.name("ayear")).sendKeys("2010");
        driver.findElement(By.cssSelector("input:nth-child(75)")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    public static void openContactPage() {
        driver.findElement(By.xpath("//a[contains(@href, 'edit.php')]")).click();
    }
}
