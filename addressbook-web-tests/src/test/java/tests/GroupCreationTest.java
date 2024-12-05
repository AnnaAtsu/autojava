package tests;

import manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTest extends TestBase {


    @Test
    public void CreateGroup() {
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        TestBase.app.canCreateGroup(new GroupData("name", "header", "footer"));

    }

    @Test
    public void CreateGroupOnlyName() {
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("DARIA");
        TestBase.app.canCreateGroup(groupWithName);

    }
}
