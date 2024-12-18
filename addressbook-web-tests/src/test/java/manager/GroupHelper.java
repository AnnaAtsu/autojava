package manager;

import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void openGroupPage() {
        manager.driver.findElement(By.linkText("groups")).click();
        if(!manager.isSelectPresent(By.name("new"))) {
            manager.driver.findElement(By.linkText("groups")).click();
        }
    }

    public boolean isGroupPresent() {
        if(!manager.isSelectPresent(By.name("selected[]"))) {
            manager.driver.findElement(By.name("new")).click();
            manager.driver.findElement(By.name("group_name")).click();
            manager.driver.findElement(By.name("group_name")).sendKeys("anna1");
            manager.driver.findElement(By.name("group_header")).click();
            manager.driver.findElement(By.name("group_header")).sendKeys("max");
            manager.driver.findElement(By.name("group_footer")).click();
            manager.driver.findElement(By.name("group_footer")).sendKeys("moore");
            manager.driver.findElement(By.name("submit")).click();
            manager.driver.findElement(By.linkText("group page")).click();
        }
        return false;
    }

    public void canCreateGroup(GroupData groupData) {
        openGroupPage();
        manager.driver.findElement(By.name("new")).click();
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys(groupData.name());
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys(groupData.header());
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
        manager.driver.findElement(By.name("submit")).click();
        manager.driver.findElement(By.linkText("groups")).click();
    }

 //  public void deleteGroupPage(GroupData groupData) {
     //   openGroupPage();
     //   selectGroup(groupData);
      //  manager.driver.findElement(By.name("selected[]")).click();
      //  manager.driver.findElement(By.cssSelector(".group:nth-child(8) > input")).click();
      //  manager.driver.findElement(By.name("delete")).click();
      //  returnToGroupsPage();
  //  }

    public void deleteGroupPage(GroupData groupData) {
        openGroupPage();
      selectGroup(groupData);
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.cssSelector(".group:nth-child(8) > input")).click();
        manager.driver.findElement(By.name("delete")).click();
        returnToGroupsPage();
    }




    public int getCount() {
        openGroupPage();
         return  manager.driver.findElements(By.name("selected[]")).size();
    }



    public void modifyGroup(GroupData groupData, GroupData modifiedGroup) {
        openGroupPage();
        selectGroup(groupData);
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }

    private void returnToGroupsPage() {
        manager.driver.findElement(By.linkText("group page")).click();
    }

    private void initGroupModification() {
        manager.driver.findElement(By.xpath("//*[@id=\"content\"]/form/input[6]")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).clear();
        manager.driver.findElement(By.name("group_name")).sendKeys(groupData.name());
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys(groupData.header());
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    private void submitGroupModification() {
        manager.driver.findElement(By.name("update")).click();
    }

    private void selectGroup(GroupData groupData) {
        //manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.cssSelector(String.format("input[value='%s']", groupData.id()))).click();
    }
    public List<GroupData> getList() {
        var groups = new ArrayList<GroupData>();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        for (var span : spans) {
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

}
