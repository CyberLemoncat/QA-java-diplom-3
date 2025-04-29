package pages;

import browser.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import user.UserClient;
import user.UserData;


import static org.junit.Assert.assertEquals;
import static pages.LoginPage.LOGIN_PAGE_URL;
import static pages.MainPage.MAIN_PAGE_URL;
import static pages.ProfilePage.PROFILE_PAGE_URL;

public class PersonalAccountButtonTest extends BaseClass {

    private String accessToken;
    public UserData randomUser;

    @Before
    public void setUp() {
        Steps steps = new Steps(driver);

        randomUser = new UserData(RandomUser.TEST_USER_EMAIL, RandomUser.TEST_USER_PASSWORD, RandomUser.TEST_USER_NAME);
        steps.createUser(randomUser.getEmail(), randomUser.getPassword(), randomUser.getName());
        accessToken = UserClient.getAccessToken(randomUser);
    }

    @Test
    @DisplayName("Проверка перхода в личный кабинет")
    @Description("Переход в личнвй кабинетс главной страницы после в хода в аккаунт")
    public void testTransferToPersonalAccount() {
        Steps steps = new Steps(driver);
        steps.clickPersonalAccountButton();

        steps.loginPersonalAccount(randomUser.getEmail(), randomUser.getPassword());

        steps.clickPersonalAccountButton();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitUntilProfilePageIsVisible();
        String actualUrl = driver.getCurrentUrl();

        assertEquals("Должна быть страница личного кабинета", PROFILE_PAGE_URL, actualUrl);

    }

    @Test
    @DisplayName("Проверка выходв из аккаунта")
    @Description("Выход из аккаунта из личного кабинета")
    public void testExitFromAccount() {
        Steps steps = new Steps(driver);
        steps.clickPersonalAccountButton();

        steps.loginPersonalAccount(randomUser.getEmail(), randomUser.getPassword());

        steps.clickPersonalAccountButton();

        steps.clickExitButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitUntilLoginPageIsVisible();

        String actualUrl = driver.getCurrentUrl();
        assertEquals("Должна быть страница входа в аккаунт", LOGIN_PAGE_URL, actualUrl);

    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    @Description("Переход в в конструктор главной страницы из личного кабинета")
    public void testTransferMainPageClickConstructorButton() {
        Steps steps = new Steps(driver);

        steps.clickPersonalAccountButton();

        steps.loginPersonalAccount(randomUser.getEmail(), randomUser.getPassword());

        steps.clickPersonalAccountButton();
        steps.clickConstructorButtonFromProfile();
        MainPage mainPage = new MainPage(driver);
        mainPage.waitUntilMainPAgeUrlIsVisible();
        String actualUrl = driver.getCurrentUrl();

        assertEquals("Должна быть главная страница ", MAIN_PAGE_URL, actualUrl);

    }

    @After
    public void tearDownUser() {
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
    }
}
