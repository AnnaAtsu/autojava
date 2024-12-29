package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {

    //public static List<String> groupNameProvider() {
    //    var result = new ArrayList<String>();
    //  for (int i = 0; i < 3; i++) {
    //       result.add(randomString(i * 2));
    //   }
    //   return  result;
    // }


    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();

        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("groups.json"), new TypeReference<List<GroupData>>() {
        });
        result.addAll(value);
        return result;
    }


    //Старая версия до Лекции 5

    //public static List<GroupData> groupProvider() {
    //  var result = new ArrayList<GroupData>(List.of(
    //        new GroupData(),
    //      new GroupData().withName("Marina"),
    //    new GroupData("", "group name1", "", ""),
    //  new GroupData("", "Inav", "", "")));
    //for (var name : List.of("", "group name")) {
    //  for (var header : List.of("", "group header")) {
    //    for (var footer : List.of("", "group footer")) {
    //      result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
    //}
    // }
    //}
    //for (int i = 0; i < 3; i++) {
    //  result.add(new GroupData()
    //        .withName(CommonFunctions.randomString(i * 2))
    //      .withHeader(CommonFunctions.randomString(i * 2))
    //    .withFooter(CommonFunctions.randomString(i * 2)));
    //}
    //return  result;
    //     }


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

    // Провайдер один для jdbc
    public static List<GroupData> singleRandomGroup() {
        return List.of(new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(10))
                .withFooter(CommonFunctions.randomString(10)));
    }


    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    public void CreateGroupWithJDBC(GroupData groupData) {
        var oldGroups = app.jdbc().getGroupList();
        app.groupshelper().canCreateGroup(groupData);
        var newGroups = app.jdbc().getGroupList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var maxId = newGroups.get(newGroups.size() - 1).id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(groupData.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);

    }
    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    public void CreateGroupWithHibernate(GroupData groupData) {
        var oldGroups = app.hbm().getGroupList();
        app.groupshelper().canCreateGroup(groupData);
        var newGroups = app.hbm().getGroupList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var maxId = newGroups.get(newGroups.size() - 1).id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(groupData.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);

    }

}