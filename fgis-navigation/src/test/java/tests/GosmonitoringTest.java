package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GosmonitoringTest extends TestBase{

    @Test
    void checkReestrMest() {
        app.session().login("Blinova", "пароль111");
        app.session().goToReessrtGM();
        app.session().goToMestoForm();
        Assertions.assertTrue(app.session().checkTablePart());
    }


    @Test
    void checkReestrOtborov() {
        app.session().login("Blinova", "пароль111");
        app.session().goToReessrtGM();
        app.session().goToReestrOtborov();
        Assertions.assertTrue(app.session().checkTablePart());
        Assertions.assertTrue(app.session().checkButtonVnestiDannye());

    }

    @Test
    void checkReestrSvedenii() {
        app.session().login("Blinova", "пароль111");
        app.session().goToReessrtGM();
        app.session().gotoReestrSvedenii();
        Assertions.assertTrue(app.session().checkTablePart());
    }

    @Test
    void checkReestrIssledovanii() {
        app.session().login("Blinova", "пароль111");
        app.session().goToReessrtGM();
        app.session().goToReesstrIssledovanii();
        Assertions.assertTrue(app.session().checkButtonVnestiDannye());
    }

}
