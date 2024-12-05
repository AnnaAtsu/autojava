package manager;

import model.GroupData;
import org.openqa.selenium.By;

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

    public void isGroupPresent(ApplicationManager applicationManager) {
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

    public void deleteGroupPage() {
        openGroupPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.cssSelector(".group:nth-child(8) > input")).click();
        manager.driver.findElement(By.name("delete")).click();
        manager.driver.findElement(By.linkText("group page")).click();
    }
}
