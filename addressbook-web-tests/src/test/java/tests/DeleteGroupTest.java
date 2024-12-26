package tests;

import common.CommonFunctions;
import manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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
        //int newgroupCount = app.groupshelper().getCount();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        // Assertions.assertEquals(newGroups.size(), expectedList.size() - 1);
        Assertions.assertEquals(newGroups, expectedList);
        // изменила то, что выше, с Assertions.assertEquals(newGroups, expectedList);
        ApplicationManager.driver.findElement(By.linkText("Logout")).click();
    }


    // Провайдер один для jdbc
    public static List<GroupData> singleRandomGroup() {
        return List.of(new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(10))
                .withFooter(CommonFunctions.randomString(10)));
    }


    // Тест для jdbc Лекция 6
    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    public void deleteGroupwithJDBC(GroupData groupData) {
        app.groupshelper().openGroupPage();
        app.groupshelper().isGroupPresent();
        var oldGroups = app.jdbc().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groupshelper().deleteGroupPage(oldGroups.get(index));
        var newGroups = app.jdbc().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Assertions.assertEquals(newGroups, expectedList);
        // изменила то, что выше, с Assertions.assertEquals(newGroups, expectedList);
        ApplicationManager.driver.findElement(By.linkText("Logout")).click();
    }


}
