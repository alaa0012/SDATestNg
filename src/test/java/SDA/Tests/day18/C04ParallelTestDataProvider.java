package SDA.Tests.day18;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SDA.utilities.TestBase;

public class C04ParallelTestDataProvider extends TestBase {
    By userNameFiled = By.name("username");
    By passwordName = By.name("password");
    By buttonTag = By.tagName("button");
    By textByXpath = By.xpath("//*[.='Invalid credentials']");

    @Test(dataProvider = "invalidCredentials")
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(userNameFiled).sendKeys(userName);
        driver.findElement(passwordName).sendKeys(password);
        driver.findElement(buttonTag).click();

        Thread.sleep(1000);
        WebElement invalidText = driver.findElement(textByXpath);

        Assert.assertTrue(invalidText.isDisplayed());


    }


    @DataProvider(name = "invalidCredentials")
    public Object[][] getData() {
        return new Object[][]{
                {"adm", "admin23*"},
                {"cdmin", "admin123"},
        };
    }
}














