package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DeleteGroupTest extends TestBase {


    @Test
    public void deleteGroup() {
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        TestBase.app.openGroupPage();
        TestBase.app.isGroupPresent();
        TestBase.app.deleteGroupPage();
        ApplicationManager.driver.findElement(By.linkText("Logout")).click();
    }


}
