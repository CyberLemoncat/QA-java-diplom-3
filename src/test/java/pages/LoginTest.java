package pages;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static pages.MainPage.MAIN_PAGE_URL;

public class LoginTest extends BaseClass {
    String email = "myemail@mail.com";
    String password = "password";

    @Test
    @DisplayName("Check login of button 'Войти в аккаунт'")
    @Description("Проверка входа по кнопке Войти в аккаунт на главной странице")
    public void loginButtonEnterAccount() {
        Steps steps = new Steps(driver);
        steps.clickEnterAccountButton();
        steps.loginPersonalAccount(email, password);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Должна быть главная страница",MAIN_PAGE_URL, actualUrl);
    }

    @Test
    @DisplayName("Check login of button 'Личный кабинет'")
    @Description("Проверка входа по кнопке Личный кабинет")
    public void loginButtonPersonalAccount() {
        Steps steps = new Steps(driver);
        steps.clickPersonalAccountButton();
        steps.loginPersonalAccount(email, password);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Должна быть главная страница",MAIN_PAGE_URL, actualUrl);
    }

    @Test
    @DisplayName("Check login from registration window")
    @Description("Проверка входа через кнопку в форме регистрации")
    public void loginRegistrationWindow() {
        Steps steps = new Steps(driver);
        steps.clickPersonalAccountButton();
        steps.clickRegistrationButtonOnLoginPage();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginLButton();
        steps.loginPersonalAccount(email, password);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Должна быть главная страница",MAIN_PAGE_URL, actualUrl);
    }

    @Test
    @DisplayName("Check login from password recovery window")
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void loginPasswordRecoveryWindow() {
        Steps steps = new Steps(driver);
        steps.clickPersonalAccountButton();
        steps.clickLinkPasswordRecoveryPage();
        steps.loginPersonalAccount(email, password);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Должна быть главная страница",MAIN_PAGE_URL, actualUrl);
    }
}
