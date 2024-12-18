package tests;
import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class GroupCreationTest extends TestBase {

    //public static List<String> groupNameProvider() {
    //    var result = new ArrayList<String>();
    //  for (int i = 0; i < 3; i++) {
    //       result.add(randomString(i * 2));
    //   }
    //   return  result;
    // }

    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData(),
                new GroupData().withName("Marina"),
                new GroupData("", "group name1", "", ""),
                new GroupData("", "Inav", "", "")));
        for (var name : List.of("", "group name")) {
            for (var header : List.of("", "group header")) {
                for (var footer : List.of("", "group footer")) {
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 2))
                    .withHeader(CommonFunctions.randomString(i * 2))
                    .withFooter(CommonFunctions.randomString(i * 2)));
        }
        return  result;
    }


    @Test
    public void CreateGroup() {
        int groupCount = app.groupshelper().getCount();
        app.groupshelper().canCreateGroup(new GroupData("", "name", "header", "footer"));
        int newgroupCount = app.groupshelper().getCount();
        Assertions.assertEquals(groupCount + 1, newgroupCount);

    }

    @Test
    public void CreateGroupOnlyName() {
        //ApplicationManager.driver.findElement(By.linkText("groups")).click();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("DARIANA");
        //var groupData = new GroupData(name, this.header, this.footer);
        app.groupshelper().canCreateGroup(groupWithName);

    }

    @Test
    public void CreateManyGroups() {
        int n = 3;
        int groupCount = app.groupshelper().getCount();
        for (int i = 0; i < n; i++) {
            app.groupshelper().canCreateGroup(new GroupData("", CommonFunctions.randomString(i * 2), "header", "footer"));
        }
        int newgroupCount = app.groupshelper().getCount();
        Assertions.assertEquals(groupCount + n, newgroupCount);
    }


    @ParameterizedTest
    @ValueSource(strings = {"name1", "name2"})
    public void CreateGroup(String name) {
        int groupCount = app.groupshelper().getCount();
        app.groupshelper().canCreateGroup(new GroupData("", name, "header", "footer"));
        int newgroupCount = app.groupshelper().getCount();
        Assertions.assertEquals(groupCount + 1, newgroupCount);

    }


    //@ParameterizedTest
    //@MethodSource("groupNameProvider")
    //public void CreateManyGroups(String name) {
    // int groupCount = app.groupshelper().getCount();
    //app.groupshelper().canCreateGroup(new GroupData(name, "header", "footer"));
    //int newgroupCount = app.groupshelper().getCount();
    //Assertions.assertEquals(groupCount + 1, newgroupCount);
    //}
    @ParameterizedTest
    @MethodSource("groupProvider")
    public void CreateManyGroups(GroupData groupData) {
        int groupCount = app.groupshelper().getCount();
        app.groupshelper().canCreateGroup(groupData);
        int newgroupCount = app.groupshelper().getCount();
        Assertions.assertEquals(groupCount + 1, newgroupCount);
    }




}