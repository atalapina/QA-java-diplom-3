package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalPage extends BasePage {

    public PersonalPage(WebDriver driver) {
        super(driver);

    }

    private final By profile = By.xpath("//a[contains(@href,'account/profile')]");
    private final By logo = By.xpath("(//a[@href='/'])[2]");
    private final By constructor = By.xpath("(//a[@href='/'])[1]");
    private final By exit = By.xpath("//button[text()='Выход']");


    public String getProfileText(){
        return getElement(profile).getText();
    }

    public HeadPage clickLogoButton(){
        getElement(logo).click();
        return new HeadPage(driver);
    }
    public HeadPage clickConstructorButton(){
        getElement(constructor).click();
        return new HeadPage(driver);
    }
    public EntrancePage clickExitButton(){
        getElement(exit).click();
        return new EntrancePage(driver);
    }


}

