package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day10_DropDownOrnek {

    static WebDriver driver; // instance variable

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void before(){
        driver.get("http:/amazon.com");
    }

    @Test
    public void test1(){
        WebElement arama = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(arama);
        select.selectByVisibleText("Software");
        WebElement arama2 = driver.findElement(By.id("twotabsearchtextbox"));
        arama2.sendKeys("Java" + Keys.ENTER);


        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuc.getText());
        Assert.assertTrue(sonuc.getText().contains("Java"));

    }


}
