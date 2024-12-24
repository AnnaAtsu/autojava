package tests;

import model.DataContact;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import common.CommonFunctions;
import model.DataContact;

public class AddContactToGroupTest extends TestBase {
  private WebDriver driver;


  @Test
  public void addContactToGroup() {
    openAddressbookPage();
    if(app.allcontacts().getCount() == 0) {
      app.allcontacts().createContactshort(new DataContact().withFirstName("Alexander13"));
    }
    addElementToGroup();
    GoToHomePage();
  }



  public void GoToHomePage() {
    driver.findElement(By.linkText("home")).click();
  }

  public void addElementToGroup() {
    driver.findElement(By.id("3")).click();
    driver.findElement(By.name("to_group")).click();
    {
      WebElement dropdown = driver.findElement(By.name("to_group"));
      dropdown.findElement(By.xpath("//option[. = 'SASHA']")).click();
    }
    driver.findElement(By.name("add")).click();
  }

  public void openAddressbookPage() {
    driver.get("http://localhost/addressbook/");
  }
}
