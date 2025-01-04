package ru.stqa.mantis.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase {


    @Test
    void canlogin() {
        app.session().login("administrator", "root");
        Assertions.assertTrue(app.session().isLoggedIn());
    }
}
