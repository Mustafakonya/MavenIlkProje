package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http:/google.com");
        String title = driver.getTitle();

        Assert.assertEquals("Google Arama Sayfasi",title);
    }

    @Test
    public void test2(){
    driver.get("http:/amazon.com");
    String title = driver.getTitle();
    boolean iceriyormu = title.contains("Amazon");
    Assert.assertTrue(iceriyormu);
    }

    @Test
    public void test3(){
        driver.get("http:/facebook.com");
        String title = driver.getTitle();
        boolean iceriyormu = title.contains("Youtube");
        Assert.assertFalse(iceriyormu);

    }

    @Test
    public void test4(){
        driver.get("http:/google.com");
        String title = driver.getTitle();
        System.out.println("Merhabalar");
        Assert.assertEquals("Google Arama Sayfasi",title);
        System.out.println("Test dogrulama islemi bitti.");
    }

    @Test
    public void test5(){
        driver.get("http:/facebook.com");
        String title = driver.getTitle();
        boolean iceriyormu = title.contains("Youtube");
        Assert.assertFalse(iceriyormu);
        System.out.println("Test dogrulama islemi bitti.");
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


}
