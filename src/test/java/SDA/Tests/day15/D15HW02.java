package SDA.Tests.day15;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class D15HW02 extends TestBase {
     /*
        Test Case2: Negative Username Test
        Open page https://practicetestautomation.com/practice-test-login/
        Type username incorrectUser into Username field.
        Type password Password123 into Password field.
        Click Submit button.
        Verify error message is displayed.
        Verify error message text is Your username is invalid!

     */

    @Test
    public void softAssert02(){
        SoftAssert sa =new SoftAssert();
        driver.get("https://practicetestautomation.com/practice-test-login/");


        WebElement username =driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("incorrectUser");

        WebElement password =driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("Password123");

        WebElement submit =driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submit.click();
        //Verify error message is displayed.
        WebElement errorMessage = driver.findElement(By.xpath(" //*[@id=\"error\"]"));
        sa.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        //Verify error message text is Your username is invalid!
        String actualErrorMessageText = errorMessage.getText();
        String expectedErrorMessageText = "Your username is invalid!";
        sa.assertEquals(actualErrorMessageText, expectedErrorMessageText, "Error message text mismatch");
        sa.assertAll();


    }
    @Test
    public void hardAssert02(){
        driver.get("https://practicetestautomation.com/practice-test-login/");


        WebElement username =driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("incorrectUser");

        WebElement password =driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("Password123");

        WebElement submit =driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submit.click();
        //Verify error message is displayed.
        WebElement errorMessage = driver.findElement(By.xpath(" //*[@id=\"error\"]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        //Verify error message text is Your username is invalid!
        String actualErrorMessageText = errorMessage.getText();
        String expectedErrorMessageText = "Your username is invalid!";
        Assert.assertEquals(actualErrorMessageText, expectedErrorMessageText, "Error message text mismatch");

    }
}