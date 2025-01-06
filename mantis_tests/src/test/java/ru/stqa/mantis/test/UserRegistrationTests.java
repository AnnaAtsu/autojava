package ru.stqa.mantis.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

import static ru.stqa.mantis.manager.ApplicationManager.driver;

public class UserRegistrationTests extends TestBase{

    @Test
    void canRegisterUser() {

      // String username = CommonFunctions.randomString(5);
        String username = "user13";
        var email = String.format("%s@localhost", username);
        var password = "password";
        //создать адрес на почтовом сервере (jameshelper)
        app.jamescli().addUser(email, password);
        //заполнить форму создания и отправить (браузер)
        app.session().loginNewSignup(username, email);
        //получить почту (mailhelper)
        app.mail().receive(email, password, Duration.ofSeconds(60));
        //извлечь ссыллку
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        Assertions.assertTrue(matcher.find());
        var url = text.substring(matcher.start(), matcher.end());
        app.driver().get(url);
        //пройти по ссылке и завершить регистрацию (браузер)
        app.session().confirmRegistration(username,password);
        //пользователь может залогиниться
        Assertions.assertTrue(app.session().isLoggedIn());
    }
}
