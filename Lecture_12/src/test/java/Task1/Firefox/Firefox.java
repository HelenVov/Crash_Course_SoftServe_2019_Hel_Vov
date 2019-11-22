package Task1.Firefox;

import Task1.Interface.IBrowser;
import Task1.Search.Search;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IBrowser {

    WebDriver driver;
    String resultSearch;
    Search searchClass = new Search();

    @Override
    public void setupWebDriverManager() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    public void setupDriver() {
        driver = new FirefoxDriver();
    }

    @Override
    public void driverQuit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean firefoxSearch(String search) {
        setupWebDriverManager();
        setupDriver();
        resultSearch = searchClass.search(search, driver);
        driverQuit();
        return resultSearch.contains(search);
    }

}
