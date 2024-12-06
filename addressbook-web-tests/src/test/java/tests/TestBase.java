package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

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

}
