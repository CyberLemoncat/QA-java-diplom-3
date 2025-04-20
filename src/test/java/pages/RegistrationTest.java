package pages;
import org.junit.After;
import org.junit.Test;
import pages.*;
import user.UserClient;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseClass {
    private String accessToken;
    String email = RandomUser.TEST_USER_EMAIL;
    String password = RandomUser.TEST_USER_PASSWORD;
    String name = RandomUser.TEST_USER_NAME;

    @Test
    public void testSuccessfulRegistration() {
        Steps steps = new Steps(driver);
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();

        steps.inputCorrectRegistrationData(name, email, password);

        String actualUrl = driver.getCurrentUrl();
        assertEquals("Должна быть страница входа", "https://stellarburgers.nomoreparties.site/login", actualUrl);

        accessToken = UserClient.getAccessToken(email, password);
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
    }
}
