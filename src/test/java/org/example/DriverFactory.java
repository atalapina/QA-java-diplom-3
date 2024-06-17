package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private WebDriver driver;

    private void initFireFox(){
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.firefox.bin", "src/test/resources/properties/firefox");
        driver = new FirefoxDriver();
    }
    private void initChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            initFireFox();
        } else {
            initChrome();
        }
    }
    public WebDriver getDriver(){
        return driver;
    }
}

