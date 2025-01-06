package ru.stqa.mantis.test;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

public class JamesTests extends TestBase{

    @Test
    void canCreateUser() {
        app.jamescli().addUser(String.format("%s@localhost", CommonFunctions.randomString(5)), "password");
    }
}
