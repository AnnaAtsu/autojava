package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {

    public static WebDriver driver;
    private String browser;
    private Properties properties;
    private SessionHelper sessionHelper;


    public void init(String browser, Properties properties) {
        this.properties = properties;
        this.browser = browser;

    }


    public WebDriver driver() {
        if (driver == null) {
            if ("edge".equals(browser)) {
                driver = new EdgeDriver();
            } else if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException(String.format("unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            //driver.get("http://localhost/addressbook/");
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1904, 1119));
            //session().login("admin","secret");

        }
        return driver;
    }

    public  SessionHelper session() {
        if(sessionHelper == null) {
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }
}
