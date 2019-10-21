package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task1 {
    @Test
    public void task1() {
        System.setProperty("webdriver.chrome.driver", "E:\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("softserve it academy");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        String nameOf = driver.findElement(By.className("LC20lb")).getText();
        System.out.println(nameOf);
        Assert.assertEquals(nameOf, "Школа програмування : SoftServe провідна IT-компанія");
        driver.findElement(By.className("LC20lb")).click();
        String urlSoft = driver.getCurrentUrl();
        System.out.println(urlSoft);
        Assert.assertEquals(urlSoft, "https://career.softserveinc.com/uk-ua/technology");

        driver.close();
    }
}