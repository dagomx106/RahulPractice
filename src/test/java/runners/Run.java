package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps.Steps;

@CucumberOptions(
        features = "src/test/resources/firstTest.feature",
        glue = {"steps"})
public class Run extends AbstractTestNGCucumberTests {

}
