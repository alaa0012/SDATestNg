package SDA.Tests.day16;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import SDA.utilities.TestBase;

/*
Test Case2: Parametrizes Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Click Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
You should execute this test with xml file
*/
public class D16HW02 extends TestBase {

    @Test
    @Parameters({"username", "password"})
    public void test1(String username, String password) {

        // Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username into Username field
        driver.findElement(By.id("username")).sendKeys(username);

        // Type password into Password field
        driver.findElement(By.id("password")).sendKeys(password);

        // Click Submit button.
        driver.findElement(By.id("submit")).click();

        // Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully"));

        // Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Congratulations") || pageSource.contains("successfully logged in"));

        // Verify button Log out is displayed on the new page.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wp-block-button aligncenter is-style-fill']")).isDisplayed());
    }
}