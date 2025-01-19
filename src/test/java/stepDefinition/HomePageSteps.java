package stepDefinition;
import java.io.FileInputStream;
import java.io.IOException;
import Utilities.EncryptDecrypt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import hooks.hook;
import java.util.Properties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
    private static WebDriver driver;
    private static Properties properties;
    String encryptedPwd;
             @Given("Launch browser")
            public void launch_browser() {
            //System.setProperty("webdriver.chrome.driver", "C:/Users/nreka/vscodedevops/Automation/src/test/resources/chromedriver.exe");
            //driver = new ChromeDriver();
            //driver.manage().window().maximize();
            //System.out.println("Setup: Browser opened.");
            driver = hook.getDriver();  // Accessing the WebDriver from the hooks class
            System.out.println("Setup: Browser opened.");
        }
    
        @When("Navigate to url {string}")
        public void navigate_to_url(String url) {
            driver.get(url);
        }
   
        @Then("Verify that home page is visible successfully")
        public void verify_that_home_page_is_visible_successfully() { 
            String title = driver.getTitle();
            assert (title.equals("Automation Exercise"));
           
        }
    
        @Then("Click on {string} button")
        public void click_on_button(String string) {
            WebElement signupLoginButton = driver.findElement(By.linkText("Signup / Login"));
            signupLoginButton.click();
        }
    
        @Then("User should see {string} text")
        public void user_should_see_text(String string) {
            WebElement signupText = driver.findElement(By.xpath("//div[@class='signup-form']/h2[text()='New User Signup!']"));
            assert(signupText.isDisplayed());
        }
    
        public static Properties readProperties() throws IOException{
            properties = new Properties();
            FileInputStream stream = new FileInputStream("./src/test/resources/config.properties");
            properties.load(stream);
            return properties;
        }
        @Then("Enter name and email address")
        public void enter_name_and_email_address() {
            WebElement nameField = driver.findElement(By.name("name"));
            WebElement emailField = driver.findElement(By.name("email"));
            nameField.sendKeys("3admin3");
            //emailField.sendKeys("3admin3@gmail.com");
            try {
                //encryptedPwd = EncryptDecrypt.encrypt("3admin3@gmail.com");
                //System.out.println("Encrypted Text: " + encryptedPwd);
                //String decryptedPwd = EncryptDecrypt.decrypt(encryptedPwd);
                //System.out.println("Decrypted Text: " + decryptedPwd);
                //emailField.sendKeys(decryptedPwd);
                // write the encrypted password in config.properties file
                readProperties();
                encryptedPwd = properties.getProperty("password");
                emailField.sendKeys(EncryptDecrypt.decrypt(encryptedPwd));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    
        @Then("Click {string} button")
        public void click_button(String button) {
            WebElement signupButton = driver.findElement(By.xpath("//form[@action='/signup']/button[@type='submit']"));
            signupButton.click();
        }
    }


