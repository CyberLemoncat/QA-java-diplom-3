package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
// org.openqa.selenium.firefox.FirefoxOptions;

public abstract class BaseClass {
    protected WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();

        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver(options);

        MainPage objMainPage = new MainPage(driver);

        driver.get(objMainPage.getUrl());

        driver.manage().window().fullscreen();

    }
    @After
    public void tearDown() {

        driver.quit();
    }
}
