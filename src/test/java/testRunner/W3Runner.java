package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        publish = true,
        features = {"/Users/haziqbullah/IdeaProjects/W3SchoolsTest/src/test/resources/features/LoginFeatures.feature"},
        glue = {"stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)

public class W3Runner {
}
