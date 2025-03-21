package manager;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static manager.ApplicationManager.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;


public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(String user, String password) {

        click(By.id("input-58"));
        type(By.id("input-58"), user);
        click(By.id("input-68"));
        type(By.id("input-68"), password);
        click(By.xpath("//span[contains(.,'Войти')]"));
    }


    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("div.user-panel"));
    }


    public void goToMestoForm() {
        WebElement MestoGMButton = driver.findElement(By.xpath("//*[contains(text(), \" Реестр мест формирования партии зерна \")]"));
        MestoGMButton.click();

    }

    public void goToReessrtGM() {
        WebElement reestrButton = driver.findElement(By.xpath("//*[contains(text(), \"Госмониторинг\")]"));
        reestrButton.click();

    }

    public boolean checkTablePart() {
        isElementPresent(By.cssSelector("span.text-start"));
        return true;
    }

    public void goToReestrOtborov() {
        WebElement OtborovButton = driver.findElement(By.xpath("//*[contains(text(), \" Реестр отборов проб \")]"));
        OtborovButton.click();
    }

    public void gotoReestrSvedenii() {
        WebElement SvedeniiButton = driver.findElement(By.xpath("//*[contains(text(), \" Реестр поданных сведений товаропроизводителями \")]"));
        SvedeniiButton.click();
    }

    public void goToReesstrIssledovanii() {
        WebElement IssledovaniiButton = driver.findElement(By.xpath("//*[contains(text(), \" Реестр проведенных исследований \")]"));
        IssledovaniiButton.click();
    }


    public boolean checkButtonVnestiDannye() {
        isElementPresent(By.xpath("//*[contains(text(), \" Внести данные \")]"));
        return true;
    }

    public void goToReestrNomerov() {
        WebElement reestrNomerovButton = driver.findElement(By.xpath("//*[contains(text(), \"Реестр номеров\")]"));
        reestrNomerovButton.click();
    }

    public void goToReesrrNomerovSDIZ() {
        WebElement reestrNomerovSDIZButton = driver.findElement(By.xpath("//*[contains(text(), \" Реестр выданных номеров СДИЗ \")]"));
        reestrNomerovSDIZButton.click();
    }

    public void generateNumber() {
        WebElement putOnDataButton = driver.findElement(By.xpath("//*[contains(text(), \"Внести данные\")]"));
        putOnDataButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //  {
        // WebElement element = driver.findElement(By.tagName("body"));
       // Actions builder = new Actions(driver);
        // builder.moveToElement(element, 0, 0).perform();
       //  }

        driver.switchTo().activeElement();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //явное ожидание
        //  WebElement button = (new WebDriverWait(driver, Duration.ofSeconds(8))
        //       .until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//*[@class='btn__content' and text='Сгенерировать']")))));
        //неявное ожидание
        //  button.click();
     //Второй способ
// Получаем идентификаторы всех окон
    //    Set<String> windowHandles = driver.getWindowHandles();
    //    String mainWindowHandle = driver.getWindowHandle();  // Основное окно

        // Переключаемся на всплывающее окно
    //    for (String handle : windowHandles) {
     //       if (!handle.equals(mainWindowHandle)) {
      //          driver.switchTo().window(handle);
               // break;
      //      }
      //  }

        // Находим кнопку "Сгенерировать" и нажимаем её
        //WebElement generateButton = driver.findElement(By.xpath("//button[text()='Сгенерировать']"));
        WebElement generateButton = driver.findElement(By.xpath("//*[contains(text(), \"Сгенерировать\")]"));
        generateButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }




    public int getCount() {
        return driver.findElements(By.cssSelector("span.text-start")).size();
    }

    public void goToReestrNomerovLots() {
        WebElement reestrNomerovLOTButton = driver.findElement(By.xpath("//*[contains(text(), \" Реестр выданных номеров партий зерна \")]"));
        reestrNomerovLOTButton.click();

    }

    public void generatelotNumber() {
        WebElement putOnDataButton = driver.findElement(By.xpath("//*[contains(text(), \"Внести данные\")]"));
        putOnDataButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement chculture = driver.findElement(By.cssSelector("div.v-input--hide-details"));

        //chculture.deSelectByContainsVisibleText("Арахис (орех земляной) лущеный ( ОКПД 2: 01.11.83 )");
        chculture.click();
        chculture.sendKeys("01.11.83.000", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        WebElement generateDataButton = driver.findElement(By.xpath("//*[contains(text(), \"Сгенерировать\")]"));
        generateDataButton.click();
    }

    public void goToReestrNomerovLotsPPZ() {
        WebElement reestrNomerovLOTPPZButton = driver.findElement(By.xpath("//*[contains(text(), \" Реестр выданных номеров партий продуктов переработки зерна \")]"));
        reestrNomerovLOTPPZButton.click();
    }

    public void generatePPZnumber() {
        WebElement putOnDataButton = driver.findElement(By.xpath("//*[contains(text(), \"Внести данные\")]"));
        putOnDataButton.click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();

        }
        Select chculturePPZ = new Select(driver.findElement(By.id("input-1353")));
        ///
    }
}
