package tests;

import common.CommonFunctions;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    void CanModifyGroup() {
        if (app.groupshelper().getCount() == 0) {
            app.groupshelper().canCreateGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldGroups = app.groupshelper.getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName("modified name");
        //app.groupshelper().modifyGroup(new GroupData().withName("modified name"));
        app.groupshelper().modifyGroup(oldGroups.get(index), testData);
        var newGroups = app.groupshelper().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }


    // Провайдер один для jdbc
    public static List<GroupData> singleRandomGroup() {
        return List.of(new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(10))
                .withFooter(CommonFunctions.randomString(10)));
    }


    // Что было
    // @ParameterizedTest
    //  @MethodSource("singleRandomGroup")
    // void CanModifyGroupWithLDBC() {
    //  if(app.groupshelper().getCount() == 0) {
    //       app.groupshelper().canCreateGroup(new GroupData("", "group name", "group header", "group footer"));
    //   }
    //   var oldGroups = app.jdbc().getGroupList();
    //   var rnd = new Random();
    //  var index = rnd.nextInt(oldGroups.size());
    //  var testData = new GroupData().withName("modified name number1");
    //app.groupshelper().modifyGroup(new GroupData().withName("modified name"));
    //  app.groupshelper().modifyGroup(oldGroups.get(index), testData);
    //  var newGroups = app.jdbc().getGroupList();
    //  var expectedList = new ArrayList<>(oldGroups);
    //  expectedList.set(index, testData.withId(oldGroups.get(index).id()));
    //  Comparator<GroupData> compareById = (o1, o2) -> {
    //       return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
    //   };
    //    newGroups.sort(compareById);
    //    expectedList.sort(compareById);
    //   Assertions.assertEquals(newGroups, expectedList);
    //  }


    // Эксперименты
    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    void CanModifyGroupWithLDBC1(GroupData groupData) {
        if (app.groupshelper().getCount() == 0) {
            app.groupshelper().canCreateGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldGroups = app.jdbc().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName("modified name number1");
        //app.groupshelper().modifyGroup(new GroupData().withName("modified name"));
        app.groupshelper().modifyGroup(oldGroups.get(index), testData);
        var newGroups = app.jdbc().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }


}