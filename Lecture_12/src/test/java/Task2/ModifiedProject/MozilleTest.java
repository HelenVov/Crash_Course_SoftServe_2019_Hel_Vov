package Task2.ModifiedProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MozilleTest {

    private WebDriver driver;

    @BeforeTest
    public static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeTest
    public void setupTest() {
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    ArrayList<String> servise = new ArrayList<String>();
    List<String> result = new ArrayList<String>();

    public void testCount() {
        driver.manage().window().maximize();

        driver.get("https://www.softserveinc.com/uk-ua/");
        List<WebElement> temp = driver.findElements(By.className("services-nav-link"));
        for (WebElement iy : temp) {
            result.add(iy.getText());
        }
    }

    @Test
    public void equals() {
        testCount();
        Assert.assertEquals(servise.toString(), result.toString());
    }

}

