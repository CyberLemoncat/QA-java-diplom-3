package browser;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.MainPage;


public abstract class BaseClass {
    protected WebDriver driver;

    @Before
    public void startUp() {
        String browserName = BrowserProvider.getBrowserName();
        driver = DriverFactory.createDriver(browserName);

        MainPage objMainPage = new MainPage(driver);

        driver.get(objMainPage.getUrl());
        driver.manage().window().fullscreen();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
