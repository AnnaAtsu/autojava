package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;

public class ApplicationManager {
    public static WebDriver driver;
    private  LoginHelper session;
    private GroupHelper groupshelper;

    public void init(String browser) {
        if (driver == null) {
            if("edge".equals(browser)){
                driver = new EdgeDriver();
            }
            else if ("firefox".equals(browser)){
                driver= new FirefoxDriver();
            }
            else {
                throw new IllegalArgumentException(String.format("unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1904, 1119));
            session().login("admin","secret");
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }


    public GroupHelper groupshelper() {
        if (groupshelper == null) {
            groupshelper = new GroupHelper(this);
        }
        return groupshelper;
    }


    protected boolean isSelectPresent(By locator) {
        try {
            driver.findElement(locator);
           return true;
       }
        catch (NoSuchElementException exception) {
        return false;
        }
    }

}
