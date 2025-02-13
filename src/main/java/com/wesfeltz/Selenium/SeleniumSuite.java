package com.wesfeltz.Selenium;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumSuite {
    public static void main(String[] args) {
    	//Manage chromedriver version and settings
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
        	//navigate to apnews
            driver.get("https://www.apnews.com");
            Thread.sleep(3000);
            //get all header text, but then only use ones that are 5+ words in length
            List<WebElement> articles = driver.findElements(By.cssSelector("h2, h3"));
            List<WebElement> validArticles = articles.stream().filter(e -> e.getText().trim().split("\\s+").length >= 5)
            		.collect(Collectors.toList());
            
            //if driver found article headers, state us a random one in the phrase of a question
            if (!articles.isEmpty()) {
            	Random random = new Random();
            	WebElement randomArticle = articles.get(random.nextInt(articles.size()));
            	System.out.println("Did you hear about " + randomArticle.getText() + "?");
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	driver.quit();
        }
    }
}
