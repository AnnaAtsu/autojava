package tests;

import org.junit.jupiter.api.Test;

public class ReestrNomerov extends TestBase{


    @Test
    void generateSDIZnumber() {
        app.session().login("Molchanov", "пароль111");
        app.session().goToReestrNomerov();
        app.session().goToReesrrNomerovSDIZ();
        app.session().generateNumber();

    }
}
