package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static manager.ApplicationManager.driver;

public class LoginTest  extends TestBase{


    @Test
    void canLogin() {
        app.session().login("Blinova", "пароль111");
        Assertions.assertTrue(app.session().isLoggedIn());
    }




}
