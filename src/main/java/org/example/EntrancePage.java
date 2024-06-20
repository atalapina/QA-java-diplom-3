package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntrancePage extends BasePage {
    public EntrancePage(WebDriver driver) {
        super(driver);

    }

    private final By selectEmail = By.xpath("(//form[contains(@class,'Auth_form')]//input)[1]");
    private final By selectPassword = By.xpath("(//form[contains(@class,'Auth_form')]//input)[2]");

    private final By entranceButton = By.xpath("//button[text()='Войти']");
    private final By registration = By.xpath("//a[contains(@href,'register')]");
    private final By recoverPassword = By.xpath("//a[contains(@href,'forgot-password')]");
    private final By entrance = By.xpath("//h2[text()='Вход']");

    @Step("Ввести почту")
    public EntrancePage setEmail(String email) {
        getElement(selectEmail).sendKeys(email);
        return this;
    }
    @Step("Ввести пароль")

    public EntrancePage setPassword(String password) {
        getElement(selectPassword).sendKeys(password);
        return this;
    }
    @Step("Нажать на кнопку входа")

    public HeadPage clickEntranceButton() {
        getElement(entranceButton).click();
        return new HeadPage(driver);
    }

    @Step("Нажать на кнопку регистрация")

    public RegistrationPage clickRegistrationButton() {
        getElement(registration).click();
        return new RegistrationPage(driver);
    }

    public EntrancePage setCredentials(User user) {
        return this.setEmail(user.getEmail()).setPassword(user.getPassword());
    }
    @Step("Нажать на восстановить Выход")
    public EntrancePage WaitEntranceButton() {
        getElement(entranceButton);
        return this;
    }

    @Step("Нажать на Восстановить пароль")

    public RecoverPasswordPage clickRecoverPasswordButton(){
        getElement(recoverPassword).click();
        return new RecoverPasswordPage(driver);
    }
    public String getEntranceText(){
        return getElement(entrance).getText();
    }

}
