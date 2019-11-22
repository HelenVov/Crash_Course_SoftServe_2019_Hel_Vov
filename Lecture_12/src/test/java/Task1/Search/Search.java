package Task1.Search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {
    public String search(String search, WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://www.google.com/en");
        WebElement searchGoogle = driver.findElement(By.name("q"));
        searchGoogle.sendKeys(search);
        searchGoogle.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String searchResultHeader = wait.until(ExpectedConditions.elementToBeClickable(By.className("S3Uucc"))).getText();
        return searchResultHeader;
    }


}
