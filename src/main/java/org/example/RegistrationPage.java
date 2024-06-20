package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);

    }
    private final By selectName = By.xpath("(//form[contains(@class,'Auth_form')]//input)[1]");
    private final By selectEmail = By.xpath("(//form[contains(@class,'Auth_form')]//input)[2]");
    private final By selectPassword = By.xpath("(//form[contains(@class,'Auth_form')]//input)[3]");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By errorMessage = By.className("input__error");
    private final By entranceButton = By.xpath("//a[contains(@href,'login')]");

    @Step("Ввести имя")
    public RegistrationPage setName(String name){
        getElement(selectName).sendKeys(name);
        return  this;
    }
    @Step("Ввести почту")

    public RegistrationPage setEmail(String email){
        getElement(selectEmail).sendKeys(email);
        return this;
    }
    @Step("Ввести пароль")
    public RegistrationPage setPassword(String password) {
        getElement(selectPassword).sendKeys(password);
        return this;
    }
    @Step("Нажать Зарегистрироваться")
    public EntrancePage clickRegistrationButton(){
        getElement(registrationButton).click();
        return new EntrancePage(driver);
    }
    @Step("Нажать Вход ")
    public EntrancePage clickEntranceButton(){
        getElement(entranceButton).click();
        return new EntrancePage(driver);
    }
    @Step("Текст ошибки")
    public String getErrorText(){
        return getElement(errorMessage).getText();
    }

    public RegistrationPage setCredentials(User user){
        return this.setName(user.getName()).setEmail(user.getEmail()).setPassword(user.getPassword());
    }
    @Step("Ожидание кнопки Входа")
    public RegistrationPage WaitEntranceButton() {
        getElement(entranceButton);
        return this;
    }

}
