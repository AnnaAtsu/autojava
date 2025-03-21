package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReestrNomerov extends TestBase{


    @Test
    void generateSDIZnumber() {
        app.session().login("Molchanov", "пароль111");
        app.session().goToReestrNomerov();
        app.session().goToReesrrNomerovSDIZ();
        int lineCount = app.session().getCount();
        app.session().generateNumber();
        int newlineCount = app.session().getCount();
        Assertions.assertTrue(app.session().checkTablePart());
        Assertions.assertEquals(lineCount, newlineCount);
    }


    @Test
    void generateLotNumber() {
        app.session().login("Molchanov", "пароль111");
        app.session().goToReestrNomerov();
        app.session().goToReestrNomerovLots();
        app.session().generatelotNumber();
        Assertions.assertTrue(app.session().checkTablePart());
    }


    @Test
    void generateLotPPZNumber() {
        app.session().login("Molchanov", "пароль111");
        app.session().goToReestrNomerov();
        app.session().goToReestrNomerovLotsPPZ();
        Assertions.assertTrue(app.session().checkTablePart());
    }
}
