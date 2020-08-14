package RunnerClass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(features = "src\\test\\java\\Features\\BasicsTests.feature",
glue= "StepDefinitions", tags = "@EndToEnd", strict = true, plugin = {"pretty", "html:target/cucumber-reports/cucumber-report1","json:target/cucumber-reports/CucumberTestReport1.json"}
)

public class BasicsTestsRunner {

}


