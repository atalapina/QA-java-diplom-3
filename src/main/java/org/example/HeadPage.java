package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeadPage extends BasePage {

    private final By personalAccount = By.xpath("//a[contains(@href,'account')]");
    private final By loginAccount = By.xpath("//button[contains(@class, 'button_button_type_primary')]");
    private final By bunLocator = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    private final By sauceLocator = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    private final By fillingLocator = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");
    private final By tabCurrentLocator = By.xpath("//div[contains(@class, 'tab_tab_type_current')]");
    private final By orderLocator = By.xpath("//button[text()='Оформить заказ']");

    public HeadPage(WebDriver driver) {
        super(driver);
    }

    public EntrancePage clickAccountButton(AccountButtonType entranceButton) {
        if (entranceButton == AccountButtonType.PERSONAL) {
            getElement(personalAccount).click();
        } else if (entranceButton == AccountButtonType.LOGIN) {
            getElement(loginAccount).click();
        }
        return new EntrancePage(driver);
    }

    @Step("Нажать на Личный кабинет")
    public PersonalPage clickPersonalAccountButton(AccountButtonType entranceButton) {
        if (entranceButton == AccountButtonType.PERSONAL) {
            getElement(personalAccount).click();
        } else if (entranceButton == AccountButtonType.LOGIN) {
            getElement(loginAccount).click();
        }
        return new PersonalPage(driver);
    }

    public WebElement getOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderLocator));
        return getElement(orderLocator);
    }
    public WebElement getIngredientTabCurrent() {
        return getElement(tabCurrentLocator);
    }

    public WebElement getIngredientTab(IngredientTabType ingredientTab) {
        By locator;
        if (ingredientTab == IngredientTabType.BUN) {
            locator = bunLocator;
        } else if (ingredientTab == IngredientTabType.SAUCE) {
            locator = sauceLocator;
        } else if (ingredientTab == IngredientTabType.FILLING) {
            locator = fillingLocator;
        } else {
            return null;
        }
        return getElement(locator);
    }

    @Step("Нажать на переход")
    public HeadPage clickIngredientTab(IngredientTabType ingredientTab) {
        var tab = getIngredientTab(ingredientTab);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(tab));
        tab.click();
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(tab, "class", "current"));
        return this;
    }

}
