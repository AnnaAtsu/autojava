package ru.stqa.mantis.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;

import java.time.Duration;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static ru.stqa.mantis.manager.ApplicationManager.driver;

public class UserRegistrationTests extends TestBase{

    DeveloperMailUser user;

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

    public static Stream<String> randomUser() {
       return Stream.of(CommonFunctions.randomString(6));
    }




    @ParameterizedTest
    @MethodSource("randomUser")
    void canRegisterUserforAPI(String username) {


        var email = String.format("%s@localhost", username);
        var password = "password";
                app.jamesApi().addUser(email, password);

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


@Test
void canRegisterUserDeveloperMail() {
    var password = "password";
    user = app.developerMail().addUser();
    var email = String.format("%s@developermail.com", user.name());
   app.session().loginNewSignup(user.name(), email);
  // app.mail().receive(email, password, Duration.ofSeconds(60));
   var message = app.developerMail().receive(user, Duration.ofSeconds(10));
   var pattern = Pattern.compile("http://\\S*");
   var matcher = pattern.matcher(message);
 Assertions.assertTrue(matcher.find());
 var url = message.substring(matcher.start(), matcher.end());
 app.driver().get(url);

 app.session().confirmRegistration(user.name(), password);

  Assertions.assertTrue(app.session().isLoggedIn());
}

@AfterEach
    void deleteMailUser() {
    app.developerMail().deleteUser(user);
}


}
