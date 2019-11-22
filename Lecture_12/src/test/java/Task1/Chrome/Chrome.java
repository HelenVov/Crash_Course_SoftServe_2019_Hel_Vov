package Task1.Chrome;

import Task1.Interface.IBrowser;
import Task1.Search.Search;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IBrowser {
    WebDriver driver;
    String resultSearch;
    Search searchClass = new Search();

    @Override
    public void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public void setupDriver() {
        driver = new ChromeDriver();
    }

    @Override
    public void driverQuit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean chromeSearch(String search) {
        setupWebDriverManager();
        setupDriver();
        resultSearch = searchClass.search(search, driver);
        driverQuit();
        return resultSearch.contains(search);

    }

}

