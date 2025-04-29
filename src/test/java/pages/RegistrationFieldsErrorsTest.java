package pages;

import browser.BaseClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistrationFieldsErrorsTest extends BaseClass {
    private static final String EXPECTED_ERROR_PASSWORD = "Некорректный пароль";
    String errorPassword = "1111";
@Test
    public void testErrorPasswordField(){
    MainPage objMainPAge = new MainPage(driver);
    objMainPAge.clickPersonalAccountButton();

    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickRegistrationButton();

    RegisterPage registerPage = new RegisterPage(driver);
    registerPage.clickNameField();
    registerPage.setName(RandomUser.TEST_USER_NAME);
    registerPage.clickEmailField();
    registerPage.setEmail(RandomUser.TEST_USER_EMAIL);
    registerPage.clickPasswordField();
    registerPage.setPassword(errorPassword);
    registerPage.clickRegistrationButton();
    String actualErrorPassword = registerPage.getErrorPassword();
    assertEquals("Неверная ошибка поля Пароль", EXPECTED_ERROR_PASSWORD, actualErrorPassword);
}
}
