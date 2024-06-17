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

        HeadPage headPage = new HeadPage(driver);

        EntrancePage entrancePage = headPage.clickAccountButton(accountButtonType);

        RegistrationPage registrationPage = entrancePage.clickRegistrationButton();

        entrancePage = registrationPage.setCredentials(user).clickRegistrationButton();

        entrancePage.WaitEntranceButton();

        headPage = entrancePage.setCredentials(user).clickEntranceButton();

        assert headPage.getOrderButton().isEnabled();
    }
    @Test
    public void registrationFailed() {

        HeadPage headPage = new HeadPage(super.driver);

        EntrancePage entrancePage = headPage.clickAccountButton(accountButtonType);

        user.setPassword(user.getPassword().substring(0,5));

        RegistrationPage registrationPage = entrancePage.clickRegistrationButton();

        registrationPage.setCredentials(user).clickRegistrationButton();

        assert registrationPage.getErrorText().equals("Некорректный пароль");
    }
}
