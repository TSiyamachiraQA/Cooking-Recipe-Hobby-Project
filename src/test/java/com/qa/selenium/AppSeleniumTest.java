package com.qa.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class AppSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void seleniumExampleTest() throws InterruptedException {
        driver.manage().window().maximize();
        sleep(2000);
        driver.get("http://www.google.com.");
        sleep(2000);
        WebElement googleSearchBar = driver.findElement(By.name("q"));
        googleSearchBar.sendKeys("funny dog pics");
        sleep(2000);
        googleSearchBar.submit();
        sleep(2000);
        WebElement linkToPictures = driver.findElement(By.partialLinkText("Images for funny dog"));
        linkToPictures.click();
        sleep(2000);
        //WebElement imagesLink = driver.findElement(By.className("rQEFy"))
    }
}
