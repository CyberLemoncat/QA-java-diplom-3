package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;

    private static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    protected final By nameField = By.xpath("//input[contains(@class, 'input__textfield') and contains(@name, 'name')]");
    protected final By emailField = By.xpath("//label[text()='Email']/following-sibling::input[@type='text' and @name='name']");
    protected final By passwordField = By.xpath("//input[@name='Пароль' and @type='password']");

    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginLButton = By.xpath("//a[text()='Войти']");
    private final By errorPassword = By.xpath("//p[@class = 'input__error text_type_main-default' and text() = 'Некорректный пароль']");
    public RegisterPage (WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return REGISTER_PAGE_URL;
    }
    //кликнуть в поле Имя
    public void clickNameField(){
        driver.findElement(nameField).click();
    }
    // Ввести имя в поле Имя
    public void setName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    // Кликнуть в поле Email
    public void clickEmailField(){
        driver.findElement(emailField).click();
    }
    // Ввести почту в поле Email
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    //кликнуть в поле Пароль
    public void clickPasswordField(){
        driver.findElement(passwordField).click();
    }
    // Ввести пароль в поле Пароль
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    // ожидание появления страницы Регистрации
    public void waitUntilRegistrationPageBecomesVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.urlToBe(REGISTER_PAGE_URL));
    }

    // скролл до кнопки Регистрация
    public void scrollToRegistrationButton() {
        WebElement element = driver.findElement(registrationButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // Клик по кнопке Регистрация
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    // Клик по кнопке Войти
    public void clickLoginLButton() {
        driver.findElement(loginLButton).click();
    }
    //текст ошибки Неверный пароль
    public String getErrorPassword(){
        return driver.findElement(errorPassword).getText();
    }
    public void inputRegistrationData(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
    }
}
