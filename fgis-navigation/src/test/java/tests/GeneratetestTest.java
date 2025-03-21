
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static manager.ApplicationManager.driver;

public class GeneratetestTest {
  private WebDriver driver;



  @BeforeEach
  public void setUp() {
    driver = new EdgeDriver();

  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @org.junit.jupiter.api.Test

  public void generatetest() {
    driver.get("https://test-zerno.mcx.gov.ru/login");
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    driver.findElement(By.id("input-57")).sendKeys("Molchanov");
    driver.findElement(By.id("input-67")).sendKeys("пароль111");
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    driver.findElement(By.cssSelector(".btn--primary .btn__content")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".btn--primary .btn__content"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".v-expansion-panel:nth-child(1) .sidebar-menu__title")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".v-expansion-panel:nth-child(1) .sidebar-menu__title"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector("div:nth-child(1) > .sidebar-menu__link > .sidebar-menu__label")).click();
    driver.findElement(By.cssSelector(".btn--medium .btn__content")).click();
    driver.findElement(By.cssSelector(".btn--medium:nth-child(2) .btn__content")).click();
  }
}
