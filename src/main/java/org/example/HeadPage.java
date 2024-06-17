package org.example;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeadPage extends BasePage {

    private final By personalAccount = By.xpath("//a[contains(@href,'account')]");
    private final By loginAccount = By.xpath("//button[contains(@class, 'button_button_type_primary')]");
    private final By bunLocator = By.xpath("//div[contains(@class, 'tab_tab')]//span[contains(text(),'Булки')]//parent::div");
    private final By sauceLocator = By.xpath("//div[contains(@class, 'tab_tab')]//span[contains(text(),'Соусы')]//parent::div");
    private final By fillingLocator = By.xpath("//div[contains(@class, 'tab_tab')]//span[contains(text(),'Начинки')]//parent::div");
    private final By orderLocator = By.xpath("//button[text()='Оформить заказ']");
    private final By bunListLocator = By.xpath("//h2[text()='Булки']");
    private final By sauceListLocator = By.xpath("//h2[text()='Соусы']");
    private final By fillingListLocator = By.xpath("//h2[text()='Начинки']");

    public HeadPage(WebDriver driver) {
        super(driver);
    }

    public EntrancePage clickAccountButton(AccountButtonType entranceButton) {
        if (entranceButton == AccountButtonType.PERSONAL) {
            getElement(personalAccount).click();
        } else if(entranceButton == AccountButtonType.LOGIN){
            getElement(loginAccount).click();
        }
        return new EntrancePage(driver);
    }
    @Step("Нажать на Личный кабинет")
    public PersonalPage clickPersonalAccountButton(AccountButtonType entranceButton) {
        if (entranceButton == AccountButtonType.PERSONAL) {
            getElement(personalAccount).click();
        } else if(entranceButton == AccountButtonType.LOGIN){
            getElement(loginAccount).click();
        }
        return new PersonalPage(driver);
    }
    public WebElement getOrderButton(){
        return getElement(orderLocator);
    }

    public WebElement getOrderButton1(){
        return getElement(orderLocator);
    }
    @Step("Нажать на переход")
    public HeadPage clickTransition(TransitionType transitionType){
        By locator;
        if (transitionType == TransitionType.BUN) {
            locator = bunLocator;
        } else if(transitionType == TransitionType.SAUCE){
            locator = sauceLocator;
        } else if(transitionType == TransitionType.FILLING){
            locator = fillingLocator;
        }else{
            return null;
        }
        getElementForClick(locator).click();
        return this;
    }
    @Step("Получить текст")
    public boolean getVisibleTransitionText(TransitionType transitionType){
        WebElement element;
        if (transitionType == TransitionType.BUN) {
            element = getElement(bunListLocator);
        } else if(transitionType == TransitionType.SAUCE){
            element = getElement(sauceListLocator);
        } else if(transitionType == TransitionType.FILLING){
            element = getElement(fillingListLocator);
        }else{
            return false;
        }
        return element.isDisplayed();
    }
}
