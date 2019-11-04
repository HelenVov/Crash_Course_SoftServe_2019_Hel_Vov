package FactoriPattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService mzService;

    @Override
    public void startService() {
        if (null == mzService) {
            try {
                mzService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(".\\chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                mzService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createDriver() {
        driver = new ChromeDriver(mzService);
    }

}