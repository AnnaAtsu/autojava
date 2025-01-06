package ru.stqa.mantis.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.regex.Pattern;

import static ru.stqa.mantis.manager.ApplicationManager.driver;

public class UserRegistrationTests extends TestBase{

    @Test
    void canRegisterUser(String username) {
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
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
        }
        //пройти по ссылке и завершить регистрацию (браузер)
        app.session().copyAndOpenLink(password);
        //пользователь может залогиниться (httpsessionhelper)
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
