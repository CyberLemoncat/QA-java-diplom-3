package pages;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.UserClient;
import user.UserData;

import static pages.LoginPage.LOGIN_PAGE_URL;


public class Steps {

    final String deleteUserDataUrl = "api/auth/user";

    final String createUserUrl = "api/auth/register";

    private static WebDriver driver;

    public Steps(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Кликаем по кнопке 'Личный кабинет'")
    public static void clickPersonalAccountButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();
    }

    @Step("Кликаем по кнопке 'Войти в аккаунт'")
    public static void clickEnterAccountButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitUntilEnterButtonBecomesVisible();
        mainPage.clickEnterAccountButton();
    }

    @Step("Кликаем по кнопке 'Булки'")
    public static void clickBunsButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBunsButton();
        mainPage.waitUntilBunsHeaderBecomesVisible();
    }

    @Step("Кликаем по кнопке 'Соусы'")
    public static void clickSousesButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSousesButton();
        mainPage.waitUntilSousesHeaderBecomesVisible();
    }

    @Step("Кликаем по кнопке 'Начинки'")
    public static void clickToppingsButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickToppingsButton();
        mainPage.waitUntilToppingsHeaderBecomesVisible();
    }

    @Step("Кликаем по элементу {linkName} окна регистрации")
    public static void clickLinkRegistrationPage() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.scrollToRegistrationButton();
        registerPage.clickRegistrationButton();
    }
    @Step("Клик по кнопке регистрации в окне авторизации")
    public static void clickRegistrationButtonOnLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
    }
    @Step("Кликаем по элементу {linkName} окна восстановления пароля")
    public static void clickLinkPasswordRecoveryPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRecoverThePasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginButton();
    }


    @Step("Кликаем по кнопке 'Конструктор' на странице личного кабинета")
    public static void clickConstructorButtonFromProfile() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructorButton();
    }

    @Step("Кликаем по логотипу Stellar Burgers на странице личного кабинета")
    public void clickLogoButtonFromProfile() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickMainPageButton();
    }

    @Step("Вводим корректные данные регистрации")
    public void inputCorrectRegistrationData(String name, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickNameField();
        registerPage.setName(name);
        registerPage.clickEmailField();
        registerPage.setEmail(email);
        registerPage.clickPasswordField();
        registerPage.setPassword(password);
        registerPage.clickRegistrationButton();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }




    @Step("Входим в личный кабинет")
    public static void loginPersonalAccount(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Step("Создание пользователя")
    public static void createUser(String email, String password, String name) {
        UserData user = new UserData(email, password, name);
        Response response = UserClient.createNewUser(user);
    }


    @Step("Кликаем по кнопке Выход")
    public static void clickExitButton() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.waitUntilExitButtonBecomesVisible();
        profilePage.clickExitButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
    }

    }