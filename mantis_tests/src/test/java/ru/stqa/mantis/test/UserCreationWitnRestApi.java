package ru.stqa.mantis.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.regex.Pattern;


public class UserCreationWitnRestApi extends TestBase {

    @Test
    void createUserApi() {
        var password = "password";
        var username = CommonFunctions.randomString(5);
        var email = String.format("%s@google.ru", username);
        app.rest().createUser(new UserData()
                .withName(username)
                .withEmail(email));
       app.session().loginNewSignup(username, email);
       app.mail().receive(email, password, Duration.ofSeconds(60));
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        Assertions.assertTrue(matcher.find());
        var url = text.substring(matcher.start(), matcher.end());
         app.driver().get(url);
        app.session().confirmRegistration(username,password);
       Assertions.assertTrue(app.session().isLoggedIn());
    }
}
