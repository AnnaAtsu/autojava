package ru.stqa.mantis.common;

import java.time.Duration;
import java.util.Random;
import java.util.regex.Pattern;



public class CommonFunctions {
    public static String randomString(int n) {
            var rnd = new Random();
            var result = "";
            for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(10));
        }
        return result;
    }



   // public static String extractURL() {
    //    var messages = app.mail().receive("user1@localhost", "password", Duration.ofSeconds(60));
     //   var text = messages.get(0).content();
     //   var pattern = Pattern.compile("http://\\S*");
     //   var matcher = pattern.matcher(text);
     //   if (matcher.find()) {
      //      var url = text.substring(matcher.start(), matcher.end());


       // }


}
