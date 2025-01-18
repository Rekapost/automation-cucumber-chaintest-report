package runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/HomePage.feature",  // Path to the feature files
    glue = {"stepDefinition", "hooks"},       // Package where step definitions and hooks are located
    plugin = {
        "pretty",                            // Pretty output for the console
        "html:target/cucumber-report.html",   // HTML report location
        //"com.aventstack.chaintest.plugins.ChainTestCucumberListener:target/chaintest-cucumber-report" // Ensure this plugin is available and correctly configured
        "com.aventstack.chaintest.plugins.ChainTestCucumberListener:"
    },
    dryRun = false,                          // Skip execution of glue code
    monochrome = true
)
public class TestRunner  {
}


// mvn clean
// mvn test
// docker compose -f docker-compose-h2.yml up
// docker images 