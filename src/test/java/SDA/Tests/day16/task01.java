package SDA.Tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import SDA.utilities.TestBase;

public class task01 extends TestBase {
    @Test
    @Parameters("KeyWord")
    public void javaTest(String KeyWord) {
        //Go to URL: https://www.google.com
        driver.get("https://www.google.com");
        //Search words: Java
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(KeyWord + Keys.ENTER);
        //Assert get text result est that the result text contains the searched Word.
        WebElement searchResults = driver.findElement(By.id("search"));
        String searchResultsText = searchResults.getText();
        Assert.assertTrue(searchResultsText.contains(KeyWord), "Search results do not contain " + KeyWord);
    }
}
