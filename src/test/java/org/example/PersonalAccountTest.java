package org.example;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonalAccountTest extends BaseTest {
    private final UserClient client = new UserClient();

    private final User user;

    public PersonalAccountTest() {
        user = User.random();
    }

    @Before
    @Step("Создать пользователя")
    public void createUser() {
        client.createUser(user);
    }

    @After
    @Step("Удалить пользователя")
    public void deleteUser() {
        String token = client.loginUser(UserLoginCredentials.from(user))
                .extract().path("accessToken");
        client.deleteUser(UserCredentials.from(user), token);
    }

    @Test
    public void personalAccountClickSuccess() {
        PersonalPage personalPage = new HeadPage(driver)
                .clickAccountButton(AccountButtonType.PERSONAL)
                .setCredentials(user)
                .clickEntranceButton()
                .clickPersonalAccountButton(AccountButtonType.PERSONAL);

        assert personalPage.getProfileText().equals("Профиль");
    }
    @Test
    public void logoClickSuccess() {
        HeadPage headPage = new HeadPage(driver)
                .clickAccountButton(AccountButtonType.PERSONAL)
                .setCredentials(user)
                .clickEntranceButton()
                .clickPersonalAccountButton(AccountButtonType.PERSONAL)
                .clickLogoButton();

        assert headPage.getOrderButton().isEnabled();
    }
    @Test
    public void constructorClickSuccess() {
        HeadPage headPage = new HeadPage(super.driver)
                .clickAccountButton(AccountButtonType.PERSONAL)
                .setCredentials(user)
                .clickEntranceButton()
                .clickPersonalAccountButton(AccountButtonType.PERSONAL)
                .clickConstructorButton();

        assert headPage.getOrderButton().isEnabled();
    }

    @Test
    public void exitClickSuccess() {
        EntrancePage entrancePage = new HeadPage(super.driver)
                .clickAccountButton(AccountButtonType.PERSONAL)
                .setCredentials(user)
                .clickEntranceButton()
                .clickPersonalAccountButton(AccountButtonType.PERSONAL)
                .clickExitButton();

        assert entrancePage.getEntranceText().equals("Вход");
    }

}
