package SDA.Tests.day17;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SDA.utilities.TestBase;

public class D17HW02 extends TestBase {

    @Test(dataProvider = "searchQueries")
    public void searchProduct(String searchQuery) {
// Open the site
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

// Login
        driver.findElement(By.id("input-email")).sendKeys("clarusway@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

// Search for the product
        driver.findElement(By.name("search")).sendKeys(searchQuery);
        driver.findElement(By.cssSelector("button[type='button'][class='btn btn-default btn-lg']")).click();

// Add verification steps as needed
    }

    @DataProvider(name = "searchQueries")
    public Object[][] searchQueriesProvider() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}