package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http:/www.amazon.com");

        WebElement arama = driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("bose soundsport wireless headphones" + Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("span[@dir='auto']"));
        System.out.println(sonuc.getText());

    }
}
