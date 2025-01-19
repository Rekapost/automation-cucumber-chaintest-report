package hooks;
import java.time.Duration;
import java.util.Map;
import Utilities.WebDriverFactory;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hook {
    public static WebDriver driver;

    public hook() {
    }
    
    @Before
    public static void setUp() {
      /*  System.setProperty("webdriver.chrome.driver", "C:/Users/nreka/vscodedevops/Automation/src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--remote-allow-origins=*");
        options.setAcceptInsecureCerts(true);
        options.setScriptTimeout(Duration.ofSeconds(30));
        options.setPageLoadTimeout(Duration.ofMillis(30000));
        options.setImplicitWaitTimeout(Duration.ofSeconds(20));
        //options.setExperimentalOption("w3c", false); // Disable W3C for older Chrome versions
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--incognito");
        options.setCapability("timeouts", Map.of("pageLoad", 120000));
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        System.out.println("Setup: Browser opened.");
    */
    WebDriverFactory factory= new WebDriverFactory();
    driver = factory.getDriver("chrome");
    }

    @After
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Teardown: Browser closed.");
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
