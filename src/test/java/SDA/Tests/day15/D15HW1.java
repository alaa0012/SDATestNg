package SDA.Tests.day15;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class D15HW1 extends TestBase {
    /*
Test Case1: Positive Login Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field
Type password Password123 into Password field
Click Submit button.
Verify new page URL contains practicetestautomation.com/logged-in-successfully/
Verify new page contains expected text ('Congratulations' or 'successfully logged in')
Verify button Log out is displayed on the new page.
*/


    @Test
    public void softAssert01(){
        SoftAssert sa =new SoftAssert();
        driver.get("https://practicetestautomation.com/practice-test-login/");


        WebElement username =driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("student");

        WebElement password =driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("Password123");

        WebElement submit =driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submit.click();
        // Verify new page URL contains practicetestautomation.com/logged-in-successfully/

        //soft assert
        sa.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"),
                "URL doesn't contain the expected text");

        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String pageSource = driver.getPageSource();

        //soft assert
        sa.assertTrue(pageSource.contains("Congratulations") || pageSource.contains("successfully logged in"),
                "Expected text not found on the page");

        //Verify button Log out is displayed on the new page.
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));

        //soft assert
        sa.assertTrue(logoutButton.isDisplayed(), "Log out button is not displayed");
        sa.assertAll();
    }
    @Test
    public void hardAssert01(){
        driver.get("https://practicetestautomation.com/practice-test-login/");


        WebElement username =driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("student");

        WebElement password =driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("Password123");

        WebElement submit =driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submit.click();
        // Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        //hard assert
        Assert.assertTrue(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"),
                "URL doesn't contain the expected text");


        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String pageSource = driver.getPageSource();
        //hard assert
        Assert.assertTrue(pageSource.contains("Congratulations") || pageSource.contains("successfully logged in"),
                "Expected text not found on the page");


        //Verify button Log out is displayed on the new page.
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));
        //hard assert
        Assert.assertTrue(logoutButton.isDisplayed(), "Log out button is not displayed");

    }

}