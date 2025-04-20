package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;


    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    private final By personalAccountButton = By.xpath("//a[@href='/account']");
    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By bunsButton = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By bunsHeader = By.xpath("//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Булки']");
    private final By sousesButton = By.xpath("//span[text()='Соусы']");
    private final By sousesHeader = By.xpath("//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Соусы']");
    private final By toppingsButton = By.xpath("//span[text()='Начинки']");
    private final By toppingsHeader = By.xpath("//h2[@class = 'text text_type_main-medium mb-6 mt-10' and text() = 'Начинки']");

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }
    public String getUrl(){
        return MAIN_PAGE_URL;
    }

    // клик по кнопке личного кабинет
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    //скролл до кнопки войти в аккаунт
    public void scrollToEnterAccountButton() {
        WebElement element = driver.findElement(enterAccountButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // ожидание кнопки Войти
    public void waitUntilEnterButtonBecomesVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(enterAccountButton));
    }
    // клик по кнопке войти в аккаунт
    public void clickEnterAccountButton(){
        driver.findElement(enterAccountButton).click();
    }
    //клик по кнопке создать заказ
    public void clickCreateOrderButton(){
        driver.findElement(createOrderButton).click();
    }
    //клик по кнопке Булочки
    public void clickBunsButton(){
        driver.findElement(bunsButton).click();
    }
    // клик по кнопке Соусы
    public void clickSousesButton(){
        driver.findElement(sousesButton).click();
    }
    // клик по кнопке Начинки
    public void clickToppingsButton(){
        driver.findElement(toppingsButton).click();
    }

    //Подождать пока появится заголовок Булочки
    public void waitUntilBunsHeaderBecomesVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(bunsHeader));
    }
    // Подождать пока появится заголовок Соусы
    public void waitUntilSousesHeaderBecomesVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(sousesHeader));
    }
    //Подождать пока появится заголовок Начинки
    public void waitUntilToppingsHeaderBecomesVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(toppingsHeader));
    }
    public String getSousesHeader() {
        return driver.findElement(sousesHeader).getText();
    }
    public String getBunsHeader() {
        return driver.findElement(bunsHeader).getText();
    }
    public String getToppingsHeader() {
        return driver.findElement(toppingsHeader).getText();
    }
}
