package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task1 {

    ArrayList<String> servise=new ArrayList<String>();
    List<String> result= new ArrayList<String>();

    public void TestCount() {
        System.setProperty("webdriver.chrome.driver", "E:\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.softserveinc.com/uk-ua/");
        servise.addAll(Arrays.asList("ПРОГРАМНЕ ЗАБЕЗПЕЧЕННЯ","ХМАРНІ ТЕХНОЛОГІЇ","ВЕЛИКІ ДАНІ","ШТУЧНИЙ ІНТЕЛЕКТ","ІНТЕРНЕТ РЕЧЕЙ (IOT)","СЕРВІСНИЙ ДИЗАЙН","КІБЕРБЕЗПЕКА","ЦИФРОВІ ПЛАТФОРМИ","РОЗШИРЕНА РЕАЛЬНІСТЬ (XR)"));
        List<WebElement> s=driver.findElements(By.className("services-nav-link"));
        for (WebElement iy:s)
        {
            result.add(iy.getText());
        }
         driver.quit();
    }
    @Test(groups = "count")
    public void Count()
    {
        TestCount();
        Assert.assertEquals(servise.size(),result.size());
    }
    @Test(groups = "equals")
      public void Equals()
      {
          TestCount();
          Assert.assertEquals(servise.toString(),result.toString());
      }
}