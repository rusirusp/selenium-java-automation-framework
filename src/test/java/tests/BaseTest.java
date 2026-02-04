package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.Config;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void setUp() {
        String browser = Config.get("browser");
        boolean headless = Boolean.parseBoolean(Config.get("headless"));

        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (headless) options.addArguments("--headless=new");
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser not supported yet: " + browser);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}