package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT));
    }

    protected BasePage() {
    }

    protected WebElement getElement(By selector){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        return driver.findElement(selector);
    }
    protected WebElement getElementForClick(By selector){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        wait.until(ExpectedConditions.elementToBeClickable(selector));
        return driver.findElement(selector);
    }


}