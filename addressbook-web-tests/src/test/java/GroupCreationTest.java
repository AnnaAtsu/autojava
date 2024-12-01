import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTest extends TestBase{


    @Test
    public void CreateGroup() {
        driver.findElement(By.linkText("groups")).click();
        canCreateGroup("name", "header", "footer");

    }

}
