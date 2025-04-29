package pages;

import browser.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class ConstructorTest extends BaseClass {

    @Test
    @DisplayName("Проверка кнопки 'Булки'")
    @Description("Проверка что по кнопке Булочки страница пролистывается до заголовка Булки")
    public void testClickBunsButton(){
        Steps steps = new Steps(driver);
        steps.clickSousesButton();

        steps.clickBunsButton();
        MainPage mainPage = new MainPage(driver);

        String actualHeader = mainPage.getBunsHeader();
        assertThat("Неверный текст заголовка", actualHeader, containsString("Булки"));
    }
    @Test
    @DisplayName("Проверка кнопки 'Соусы'")
    @Description("Проверка что по кнопке Соусы страница пролистывается до заголовка Соусы")
    public void testClickSousesButton(){
        Steps steps = new Steps(driver);
        steps.clickToppingsButton();
        steps.clickSousesButton();
        MainPage mainPage = new MainPage(driver);
        String actualHeader = mainPage.getSousesHeader();
        assertThat("Неверный текст заголовка", actualHeader, containsString("Соусы"));
    }
    @Test

    @DisplayName("Проверка кнопки 'Начинки'")
    @Description("Проверка что по кнопке Начинки страница пролистывается до заголовка Начинки")
    public void testClickToppingsButton(){
        Steps steps = new Steps(driver);
        steps.clickToppingsButton();
        MainPage mainPage = new MainPage(driver);
        String actualHeader = mainPage.getToppingsHeader();
        assertThat("Неверный текст заголовка", actualHeader, containsString("Начинки"));
    }
}
