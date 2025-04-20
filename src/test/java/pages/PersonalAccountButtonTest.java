package pages;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.UserClient;

import static org.junit.Assert.assertEquals;
import static pages.LoginPage.LOGIN_PAGE_URL;
import static pages.MainPage.MAIN_PAGE_URL;
import static pages.ProfilePage.PROFILE_PAGE_URL;

public class PersonalAccountButtonTest extends BaseClass{
    private String email = RandomUser.TEST_USER_EMAIL;
    private String password = RandomUser.TEST_USER_PASSWORD;
    private String name = RandomUser.TEST_USER_NAME;
    private String accessToken;



    @Test
    @DisplayName("Проверка перхода в личный кабинет")
    @Description("Переход в личнвй кабинетс главной страницы после в хода в аккаунт")
    public void testTransferToPersonalAccount() {
        Steps steps = new Steps(driver);
        steps.createUser(email, password, name);
        steps.clickPersonalAccountButton();

        steps.loginPersonalAccount(email, password);

        steps.clickPersonalAccountButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(PROFILE_PAGE_URL));
        String actualUrl = driver.getCurrentUrl();
        accessToken = UserClient.getAccessToken(email, password);
        assertEquals("Должна быть страница личного кабинета", PROFILE_PAGE_URL, actualUrl);
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
    }
    @Test
    @DisplayName("Проверка выходв из аккаунта")
    @Description("Выход из аккаунта из личного кабинета")
    public void testExitFromAccount() {
        Steps steps = new Steps(driver);
        steps.createUser(email, password, name);
        steps.clickPersonalAccountButton();

        steps.loginPersonalAccount(email, password);

        steps.clickPersonalAccountButton();

        steps.clickExitButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Должна быть страница входа в аккаунт", LOGIN_PAGE_URL, actualUrl);
        accessToken = UserClient.getAccessToken(email, password);
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
    }
    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    @Description("Переход в в конструктор главной страницы из личного кабинета")
    public void testTransferMainPageClickConstructorButton() {
        Steps steps = new Steps(driver);
        steps.createUser(email, password, name);
        steps.clickPersonalAccountButton();

        steps.loginPersonalAccount(email, password);

        steps.clickPersonalAccountButton();
        steps.clickConstructorButtonFromProfile();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
        String actualUrl = driver.getCurrentUrl();
        accessToken = UserClient.getAccessToken(email, password);
        assertEquals("Должна быть главная страница ", MAIN_PAGE_URL, actualUrl);
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
    }
}
