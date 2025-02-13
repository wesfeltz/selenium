package com.wesfeltz.Selenium;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {
    public static void main(String[] args) {
    	 // Setup WebDriverManager to automatically handle the ChromeDriver installation
        WebDriverManager.chromedriver().setup();

        // Set ChromeOptions (optional)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run Chrome in headless mode (without UI)

        // Instantiate ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Navigate to Google
        driver.get("https://www.google.com");

        // Output the page title
        System.out.println("Page Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
