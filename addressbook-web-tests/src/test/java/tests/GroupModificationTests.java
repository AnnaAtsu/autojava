package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase{

    @Test
    void CanModifyGroup() {
        if(!app.groupshelper().isGroupPresent()) {
            app.groupshelper().canCreateGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        app.groupshelper().modifyGroup(new GroupData().withName("modified name"));

    }
}