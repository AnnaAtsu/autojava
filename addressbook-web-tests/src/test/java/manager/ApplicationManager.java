package manager;

import model.DataContact;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.Properties;

public class ApplicationManager {
    public static WebDriver driver;
    private LoginHelper session;
    public GroupHelper groupshelper;
    public ContactHelper allcontacts;
    private Properties properties;
    //Добавлено в лекции 6.1
    private JdbcHelper jdbc;
    private JDBCHelperContact jdbccontact;
    private  HibernateHelper hbm;
    private HibernateHelperContact hbmcontact;


    public void init(String browser, Properties properties) {
        this.properties = properties;
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
            session().login(properties.getProperty("web.username"), properties.getProperty("web.password"));
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }



    public HibernateHelper hbm() {
        if (hbm == null) {
            hbm = new HibernateHelper(this);
        }
        return hbm;
    }


    public HibernateHelperContact hbmcontact() {
        if (hbmcontact == null) {
            hbmcontact = new HibernateHelperContact(this);
        }
        return hbmcontact;
    }

    public JdbcHelper jdbc() {
        if (jdbc == null) {
            jdbc = new JdbcHelper(this);
        }
        return jdbc;
    }


    public JDBCHelperContact jdbccontact() {
        if (jdbccontact == null) {
            jdbccontact = new JDBCHelperContact(this);
        }
        return jdbccontact;
    }


    public GroupHelper groupshelper() {
        if (groupshelper == null) {
            groupshelper = new GroupHelper(this);
        }
        return groupshelper;
    }

    public ContactHelper allcontacts() {
        if (allcontacts == null) {
            allcontacts = new ContactHelper(this);
        }
        return allcontacts;
    }

    protected boolean isSelectPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean isContactPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
