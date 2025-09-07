package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Feature/Capstone2.feature", // Path to your feature file
        glue = {"StepDefinitions"}, // Package name where StepDefinition2.java is
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reports
        monochrome = true
)
public class MyTestRunner2 extends AbstractTestNGCucumberTests {
    // Nothing else needed here
}