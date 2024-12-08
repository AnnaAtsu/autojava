package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DeleteGroupTest extends TestBase {


    @Test
    public void deleteGroup() {
        //ApplicationManager.driver.findElement(By.linkText("groups")).click();
        //app.groupshelper().openGroupPage();
        app.groupshelper().isGroupPresent(app);
        int groupCount = app.groupshelper().getCount();
        app.groupshelper().deleteGroupPage();
        int newgroupCount = app.groupshelper().getCount();
        Assertions.assertEquals(groupCount - 2, newgroupCount);
        ApplicationManager.driver.findElement(By.linkText("Logout")).click();
    }


}
