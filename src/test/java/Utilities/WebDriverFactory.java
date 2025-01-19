package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverFactory {
    public Map<String, Supplier<WebDriver>> driverMap= null;
   
    public WebDriverFactory() {
        driverMap = new HashMap<>();
        // Add your drivers here
        driverMap.put("chrome", this::createChromeDriver);
        driverMap.put("firefox", this::createFirefoxDriver);
        driverMap.put("edge", this::createEdgeDriver);
    }
    private WebDriver createChromeDriver() {
        // Set the path to the chromedriver executable if necessary
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        return new ChromeDriver();
    }
    private WebDriver createFirefoxDriver() {
        // Set the path to the geckodriver executable if necessary
        // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        return new FirefoxDriver();
    }

    private WebDriver createEdgeDriver() {
        // Set the path to the edgedriver executable if necessary
        // System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
        return new EdgeDriver();
    }

   public WebDriver getDriver(String browserName) {
        return driverMap.getOrDefault(browserName.toLowerCase().trim(),() -> {
            System.out.println("browser name :"+ browserName);
            throw new RuntimeException("Invalid browser name");
            }).get(); 
    } 

}
