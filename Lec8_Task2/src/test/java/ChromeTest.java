import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChromeTest {
    private WebDriver driver;

    @BeforeTest
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setupTest() {
        driver = new ChromeDriver();
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
