package org.example;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EntranceTest extends BaseTest {
    private final UserClient client = new UserClient();

    private final User user;

    public EntranceTest() {
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
    public void loginWithLoginAccountButton() {
        HeadPage headPage = new HeadPage(driver)
                .clickAccountButton(AccountButtonType.LOGIN)
                .setCredentials(user)
                .clickEntranceButton();

        assert headPage.getOrderButton().isEnabled();
    }
    @Test
    public void loginWithPersonalAccountButton() {
        HeadPage headPage = new HeadPage(driver)
                .clickAccountButton(AccountButtonType.PERSONAL)
                .setCredentials(user)
                .clickEntranceButton();

        assert headPage.getOrderButton().isEnabled();
    }

    @Test
    public void loginWithEntranceButtonFromRegistration() {
        HeadPage headPage = new HeadPage(driver)
                .clickAccountButton(AccountButtonType.PERSONAL)
                .clickRegistrationButton()
                .WaitEntranceButton()
                .clickEntranceButton()
                .WaitEntranceButton()
                .setCredentials(user)
                .clickEntranceButton();

        assert headPage.getOrderButton().isEnabled();
    }
    @Test
    public void loginWithClickRecoverPasswordButton() {
        HeadPage headPage = new HeadPage(driver)
                .clickAccountButton(AccountButtonType.PERSONAL)
                .clickRecoverPasswordButton()
                .clickEntranceLink()
                .setCredentials(user)
                .clickEntranceButton();

        assert headPage.getOrderButton().isEnabled();
    }
}
