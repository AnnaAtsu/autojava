import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DeleteGroupTest extends TestBase{


    @Test
    public void deleteGroup() {
        driver.findElement(By.linkText("groups")).click();
        openGroupPage();
        isGroupPresent();
        deleteGroupPage();
        driver.findElement(By.linkText("Logout")).click();
    }


}
