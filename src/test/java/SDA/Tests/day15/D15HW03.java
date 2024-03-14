package SDA.Tests.day15;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D15HW03 extends TestBase {

    /*Test Case3: Negative Password Test
Open page https://practicetestautomation.com/practice-test-login/
Type username student into Username field.
Type password incorrectPassword into Password field.
Puch Submit button.
Verify error message is displayed.
Verify error messagetext is Your password is invalid!*/
    @Test
    public void softAssert03(){
        SoftAssert sa =new SoftAssert();
        driver.get("https://practicetestautomation.com/practice-test-login/");


        WebElement username =driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password =driver.findElement(By.id("password"));
        password.sendKeys("incorrectPassword");

        WebElement submit =driver.findElement(By.id("submit"));
        submit.click();
        //Verify error message is displayed.
        WebElement errorMessage = driver.findElement(By.xpath(" //*[@id=\"error\"]"));
        sa.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        //Verify error message text is Your password is invalid!
        String actualErrorMessageText = errorMessage.getText();
        String expectedErrorMessageText = "Your password is invalid!";
        sa.assertEquals(actualErrorMessageText, expectedErrorMessageText, "Error message text mismatch");
        sa.assertAll();

    }
}

