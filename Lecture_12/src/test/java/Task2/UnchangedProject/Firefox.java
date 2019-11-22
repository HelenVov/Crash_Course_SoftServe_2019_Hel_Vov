package Task2.UnchangedProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Firefox {

    String resultSearchToString;
    WebDriver driver;
    List<String> resultSearch = new ArrayList<String>();

    public void setupWebDriverManager() {
        WebDriverManager.firefoxdriver().setup();
    }

    public void setupDriver() {
        driver = new FirefoxDriver();
    }

    public void driverQuit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String firefox() {
        setupWebDriverManager();
        setupDriver();
        resultSearchToString = firefoxSearch();
        driverQuit();
        return resultSearchToString;
    }

    public String firefoxSearch() {
        driver.manage().window().maximize();
        driver.get("https://www.softserveinc.com/uk-ua/");
        List<WebElement> listService = driver.findElements(By.className("services-nav-link"));
        for (WebElement service : listService) {
            resultSearch.add(service.getText());
        }
        return resultSearch.toString();
    }
}
