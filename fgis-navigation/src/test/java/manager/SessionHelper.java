package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        WebElement generateDataButton = driver.findElements(By.tagName("button")).get(92);
        generateDataButton.click();

    }
}
