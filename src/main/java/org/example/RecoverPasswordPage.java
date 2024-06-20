package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RecoverPasswordPage extends BasePage {
    public RecoverPasswordPage(WebDriver driver) {
        super(driver);

    }
    private final By entranceButton = By.xpath("//a[contains(@href,'login')]");
    @Step("Нажать на Вход")

    public EntrancePage clickEntranceLink(){
        getElement(entranceButton).click();
        return new EntrancePage(driver);
    }
}