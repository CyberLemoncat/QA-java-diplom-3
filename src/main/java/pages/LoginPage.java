package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private final WebDriver driver;

    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private final By emailField = By.xpath("//label[text()='Email']/following-sibling::input[@type='text' and @name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль' and @type='password']");
    private final By loginButton = By.xpath("//button[contains(text(),'Войти')]");
    private final By registrationButton = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    private final By recoverThePasswordButton = By.xpath("//a[text()='Восстановить пароль']");
    private final By mainPageButton = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    //ввести в поле Email
    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    //ввести в пароль в поле Пароль
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    // ожидание кнопки Войти
    public void waitUntilLoginButtonBecomesVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }
    // клик по кнопке Войти
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    // клик по кнопке Зарегистрироваться
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    // клик по кнопке Восстановить пароль
    public void clickRecoverThePasswordButton() {
        driver.findElement(recoverThePasswordButton).click();
    }
    //клик по кнопке Главного экрана
    public void clickMainPageButton(){
        driver.findElement(mainPageButton).click();
    }
    public void waitUntilLoginPageIsVisible(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }
}
