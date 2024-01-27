package runner;

import io.cucumber.testng.CucumberOptions;

import tests.TestBase;


@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features = "src/test/java/features",
        glue = {"steps"}
)
public class TestRunner extends TestBase {


}
