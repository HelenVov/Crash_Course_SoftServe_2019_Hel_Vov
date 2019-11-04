package FactoriPattern;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class MozillaDriverManager extends DriverManager {

    private GeckoDriverService mzService;

    @Override
    public void startService() {
        if (null == mzService) {
            try {
                mzService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File(".\\geckodriver.exe"))
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
        driver = new FirefoxDriver();
    }

}