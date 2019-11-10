package Lec10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MozilleTest extends AbsTest {
    private WebDriver driver;

    @BeforeTest
    public void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeTest
    public void setupTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void equals() {
        testCount(driver);
        Assert.assertEquals(servise.toString(), result.toString());
        teardown(driver);
    }


}
