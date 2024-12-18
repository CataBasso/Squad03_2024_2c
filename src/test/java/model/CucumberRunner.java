package model;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "model",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class CucumberRunner {
        // This class is used to initialize Cucumber tests
}