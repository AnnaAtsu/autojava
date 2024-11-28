import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.NoSuchElementException;

public class DeleteGroupTest {
    private static WebDriver driver;


    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new EdgeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1904, 1119));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }


    @Test
    public void deleteGroup() {
        driver.findElement(By.linkText("groups")).click();
        if(!isSelectPresent(By.name("selected[]"))) {
            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.cssSelector(".group:nth-child(8) > input")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();
        driver.findElement(By.linkText("Logout")).click();
    }


       //*[@id="content"]//input
    private boolean isSelectPresent(By locator) {
        try {
            driver.findElement(locator);
           return true;
       }
        catch (NoSuchElementException exception) {
        return false;
        }
    }
}
