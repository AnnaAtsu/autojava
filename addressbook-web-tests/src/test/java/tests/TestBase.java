package tests;
import manager.ApplicationManager;
import model.DataContact;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class TestBase {
    protected static ApplicationManager app;

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

   // @BeforeEach
    //public void set() {
     //   if (driver == null) {
      //      driver = new EdgeDriver();
      //      Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
       //     driver.get("http://localhost/addressbook/index.php");
       //     driver.manage().window().setSize(new Dimension(1904, 1119));
        //    driver.findElement(By.name("user")).sendKeys("admin");
         //   driver.findElement(By.name("pass")).sendKeys("secret");
         //   driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
       // }
   // }


}
