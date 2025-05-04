package browser;


public class BrowserProvider {
    public static String getBrowserName() {

        String browser = System.getProperty("browser");
        if (browser != null) {
            return browser;
        }

        browser = System.getenv("BROWSER");
        if (browser != null) {
            return browser;
        }

        browser = ConfigReader.getProperty("browser");
        if (browser != null) {
            return browser;
        }

        return "chrome";
    }
}
