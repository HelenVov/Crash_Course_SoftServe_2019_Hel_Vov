package FactoriPattern;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        driver = new FirefoxDriver(mzService, capabilities);

    }

}