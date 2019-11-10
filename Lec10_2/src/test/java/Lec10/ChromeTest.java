package Lec10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest extends AbsTest {
    private WebDriver driver;

    @BeforeTest
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void count() {
        testCount(driver);
        Assert.assertEquals(servise.size(), result.size());
        teardown(driver);
    }


}
