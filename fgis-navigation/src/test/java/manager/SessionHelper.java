package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static manager.ApplicationManager.driver;

public class SessionHelper extends HelperBase{

    public SessionHelper(ApplicationManager manager) {
        super(manager);
    }
    public void login(String user, String password) {

        click(By.id("input-57"));
        type(By.id("input-57"),user);
        click(By.id("input-67"));
        type(By.id("input-67"), password);
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
        isElementPresent(By.tagName("tr"));
        return true;
    }

    public void  goToReestrOtborov() {
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
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       // WebElement generateDataButton = driver.findElement(By.xpath("//span[@class='btn__content' and text='Сгенерировать']"));
        //WebElement generateDataButton = driver.findElement(By.xpath("//div[2]/div[2]/div/button[2]/span/span[2]"));
        WebElement generateDataButton = driver.findElement(By.xpath("//*[@class='btn__content' and text='Сгенерировать']"));
        generateDataButton.click();

    }
}
