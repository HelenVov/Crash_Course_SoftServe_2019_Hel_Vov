package test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class task2 {
    String element2 ="";
    String element3 ="";
    String a="Результатів не знайдено.";
    String b="Програмне забезпечення";
    WebDriver driver;
    public void Restart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.softserveinc.com/uk-ua/");
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".header-search.header-nav-item")).click();
        Thread.sleep(5000);
    }
    public void Restart1() throws InterruptedException
    {
        Restart();
        WebElement element = driver.findElement(By.name("p$lt$ctl04$pageplaceholder$p$lt$ctl01$SmartSearchBox$txtWord"));
        element.sendKeys("GGG!");
        driver.findElement(By.name("p$lt$ctl04$pageplaceholder$p$lt$ctl01$SmartSearchBox$btnSearch")).click();
        element2 = driver.findElement(By.id("p_lt_ctl04_pageplaceholder_p_lt_ctl01_SmartSearchResults_srchResults_pnlSearchResults")).getText();
        driver.quit();
    }
    public void Restart2() throws InterruptedException
    {
        Restart();
        WebElement element = driver.findElement(By.name("p$lt$ctl04$pageplaceholder$p$lt$ctl01$SmartSearchBox$txtWord"));
        element.sendKeys("Програмне забезпечення");
        WebElement element3 = driver.findElement(By.name("p$lt$ctl04$pageplaceholder$p$lt$ctl01$SmartSearchBox$btnSearch"));
        element3.click();
        element2 = driver.findElement(By.className("search-result-link")).getText();
        driver.quit();
    }
     @Test
     public void ReturnDate() throws InterruptedException {
         Restart1();
         Assert.assertEquals(element2,a);
     }
     @Test
     public void ReturnNotNull() throws InterruptedException {
        Restart1();
        Assert.assertNotNull(element2);
    }
     @Test
     public void ReturnDateProg() throws InterruptedException {
        Restart2();
        boolean k=element2.contains(b);
        Assert.assertEquals(k, true);
    }
}

