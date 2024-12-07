package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void CreateGroup() {
        app.groupshelper().canCreateGroup(new GroupData("name", "header", "footer"));

    }

    @Test
    public void CreateGroupOnlyName() {
        //ApplicationManager.driver.findElement(By.linkText("groups")).click();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("DARIA");
        //var groupData = new GroupData(name, this.header, this.footer);
        app.groupshelper().canCreateGroup(groupWithName);

    }
}
