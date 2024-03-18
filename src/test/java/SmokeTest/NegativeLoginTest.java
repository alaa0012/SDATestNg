package SmokeTest;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class NegativeLoginTest extends TestBase {

    @Test(dataProvider = "loginData")
    public void test(String username, String password, String expectedErrorMessage) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button#submit")).click();

        SoftAssert softAssert = new SoftAssert();

        WebElement actualErrorMessage = driver.findElement(By.cssSelector("div[id='error']"));
        softAssert.assertTrue(actualErrorMessage.isDisplayed());
        softAssert.assertEquals(actualErrorMessage.getText(), expectedErrorMessage);

        softAssert.assertAll();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"student", "incorrectPassword", "Your password is invalid!"},

        };
    }
}