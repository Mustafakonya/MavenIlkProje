package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
   }

    @Before
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http:/bestbuy.com");
    }

    @Test
    public void test1(){
        String title = driver.getTitle();
        boolean iceriyorMu = title.contains("Best");
        Assert.assertTrue(iceriyorMu);
    }

    @Test
    public void test2(){
        WebElement logo = driver.findElement(By.className("logo"));
        boolean gorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(gorunuyorMu);
    }

    @Test
    public void test3(){
       WebElement link = driver.findElement(By.partialLinkText("mexico"));
       boolean tiklaniyorMu = link.isEnabled();
       Assert.assertTrue(tiklaniyorMu);
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }



}
