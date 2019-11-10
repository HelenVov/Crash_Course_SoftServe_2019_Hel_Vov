package Lec10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;

public abstract class AbsTest implements InrFTest {

    public void testCount(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://www.softserveinc.com/uk-ua/");
        servise.addAll(Arrays.asList("ПРОГРАМНЕ ЗАБЕЗПЕЧЕННЯ", "ХМАРНІ ТЕХНОЛОГІЇ", "ВЕЛИКІ ДАНІ", "ШТУЧНИЙ ІНТЕЛЕКТ", "ІНТЕРНЕТ РЕЧЕЙ (IOT)", "СЕРВІСНИЙ ДИЗАЙН", "КІБЕРБЕЗПЕКА", "ЦИФРОВІ ПЛАТФОРМИ", "РОЗШИРЕНА РЕАЛЬНІСТЬ (XR)"));
        List<WebElement> temp = driver.findElements(By.className("services-nav-link"));
        for (WebElement iy : temp) {
            result.add(iy.getText());
        }

    }

    public void teardown(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
