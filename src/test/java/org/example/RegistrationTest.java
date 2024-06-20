package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest {
    private final AccountButtonType accountButtonType;
    private final User user;

    public RegistrationTest(AccountButtonType accountButtonType) {
        this.accountButtonType = accountButtonType;
        this.user = User.random();
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {AccountButtonType.LOGIN},
                {AccountButtonType.PERSONAL},
        };
    }

    @Test
    public void registration() {

        HeadPage headPage = new HeadPage(driver)
                .clickAccountButton(accountButtonType)
                .clickRegistrationButton()
                .setCredentials(user)
                .clickRegistrationButton()
                .WaitEntranceButton()
                .setCredentials(user)
                .clickEntranceButton();

        assert headPage.getOrderButton().isEnabled();
    }

    @Test
    public void registrationFailed() {

        user.setPassword(user.getPassword().substring(0, 5));

        var registrationPage = new HeadPage(super.driver)
                .clickAccountButton(accountButtonType)
                .clickRegistrationButton()
                .setCredentials(user);

        registrationPage.clickRegistrationButton();

        assert registrationPage.getErrorText().equals("Некорректный пароль");
    }
}
