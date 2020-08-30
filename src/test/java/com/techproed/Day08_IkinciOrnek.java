package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IkinciOrnek {






    static WebDriver driver;



    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void tearDown(){

        driver.quit();
    }
    @Before
    public void testtenOnce(){

        driver.get("http:/www.google.com");

    }

    @After
    public void testtenSonra(){

        WebElement sonuc = driver.findElement(By.id("result-stats"));
        System.out.println(sonuc.getText());
    }

    @Test
    public void test1(){

        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("headphones");
        arama.submit();
    }

    @Test
    public void test2(){

        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("samsung headphones");
        arama.submit();
    }


}
