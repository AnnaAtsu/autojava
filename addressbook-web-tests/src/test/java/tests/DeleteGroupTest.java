package tests;

import manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeleteGroupTest extends TestBase {


   // @Test
  //  public void deleteGroup() {
        //ApplicationManager.driver.findElement(By.linkText("groups")).click();
        //app.groupshelper().openGroupPage();
     //   app.groupshelper().isGroupPresent(app);
     //   int groupCount = app.groupshelper().getCount();
     //   app.groupshelper().deleteGroupPage();
      //  int newgroupCount = app.groupshelper().getCount();
      //  Assertions.assertEquals(groupCount - 2, newgroupCount);
      //  ApplicationManager.driver.findElement(By.linkText("Logout")).click();
   // }

    @Test
    public void deleteGroup() {
        //ApplicationManager.driver.findElement(By.linkText("groups")).click();
        app.groupshelper().openGroupPage();
        app.groupshelper().isGroupPresent();
        //int groupCount = app.groupshelper().getCount();
        var oldGroups = app.groupshelper().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groupshelper().deleteGroupPage(oldGroups.get(index));
        var newGroups = app.groupshelper().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        //int newgroupCount = app.groupshelper().getCount();
        Assertions.assertEquals(newGroups, expectedList);
        ApplicationManager.driver.findElement(By.linkText("Logout")).click();
    }


}
