package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver driver;
    static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    // кнопка Конструктор
    private final By constructorButton = By.xpath("//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    // кнопка главного экрана
    private final By mainPageButton = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");

    // кнопка Выхода из аккаунта
    private final By exitButton = By.xpath("//button[text()='Выход']");

    public ProfilePage (WebDriver driver) {
        this.driver = driver;
    }
    // клик по кнопке Конструктор
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    //клик по кнопке Главного экрана
    public void clickMainPageButton() {
        driver.findElement(mainPageButton).click();
    }
    //клик по кнопке Выход
    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }
    // подождать пока кнопка выход станет видимой
    public void waitUntilExitButtonBecomesVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }
}
