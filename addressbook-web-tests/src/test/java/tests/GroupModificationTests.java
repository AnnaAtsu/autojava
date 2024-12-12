package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase{

    @Test
    void CanModifyGroup() {
        if(!app.groupshelper().isGroupPresent()) {
            app.groupshelper().canCreateGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldGroups = app.groupshelper.getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        GroupData testData = new GroupData().withName("modified name");
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
}