import FactoriPattern.DriverManager;
import FactoriPattern.DriverManagerFactory;
import FactoriPattern.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactoryPatternMozille {

    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.MOZILLE);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    ArrayList<String> servise = new ArrayList<String>();
    List<String> result = new ArrayList<String>();

    public void testCount() {
        driver.manage().window().maximize();
        driver.get("https://www.softserveinc.com/uk-ua/");
        servise.addAll(Arrays.asList("ПРОГРАМНЕ ЗАБЕЗПЕЧЕННЯ", "ХМАРНІ ТЕХНОЛОГІЇ", "ВЕЛИКІ ДАНІ", "ШТУЧНИЙ ІНТЕЛЕКТ", "ІНТЕРНЕТ РЕЧЕЙ (IOT)", "СЕРВІСНИЙ ДИЗАЙН", "КІБЕРБЕЗПЕКА", "ЦИФРОВІ ПЛАТФОРМИ", "РОЗШИРЕНА РЕАЛЬНІСТЬ (XR)"));
        List<WebElement> temp = driver.findElements(By.className("services-nav-link"));
        for (WebElement iy : temp) {
            result.add(iy.getText());
        }
    }

    @Test
    public void count() {
        testCount();
        Assert.assertEquals(servise.size(), result.size());
    }

}