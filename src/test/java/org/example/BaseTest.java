package org.example;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected org.example.DriverFactory driverFactory = new org.example.DriverFactory();
    protected WebDriver driver;
    @Before
    @Step("Открыть страницу")
    public void setUp() {

        driverFactory.initDriver();
        driver = driverFactory.getDriver();
        driver.get(EnvConfig.BASE_URL);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
