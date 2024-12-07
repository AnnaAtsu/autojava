package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Dimension;
import java.util.NoSuchElementException;

import static manager.ApplicationManager.driver;

public class ContractDelete {
    public static WebDriver driver;

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

    @Test
    public void DeleteContract() {
     if(!isContactPresent(By.id("1"))) {
         driver.findElement(By.xpath("//a[contains(@href, 'edit.php')]")).click();
         driver.findElement(By.name("firstname")).click();
         driver.findElement(By.name("firstname")).sendKeys("Alesya");
         driver.findElement(By.name("middlename")).click();
         driver.findElement(By.name("middlename")).sendKeys("Nick");
         driver.findElement(By.name("lastname")).click();
         driver.findElement(By.name("lastname")).sendKeys("Smith");
         driver.findElement(By.cssSelector("input:nth-child(75)")).click();
         driver.findElement(By.linkText("home page")).click();
        }
        driver.findElement(By.id("1")).click();
        driver.findElement(By.xpath("xpath=//input[@value='Delete']")).click();
        driver.switchTo().alert().accept();
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
}

