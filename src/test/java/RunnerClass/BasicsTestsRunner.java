package RunnerClass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(features = "src\\test\\java\\Features\\BasicsTests.feature", glue= "StepDefinitions", strict = true,
tags= "@ContactUs"
)

public class BasicsTestsRunner {

}


