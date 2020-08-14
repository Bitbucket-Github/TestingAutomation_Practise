package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features= {"classpath:OpeningBrowser.feature", "classpath:ShippingMethod.feature"})
//tags= {"@OpeningBrowser", "@SendToFriend"}


@CucumberOptions(features = "src\\test\\java\\Features",
glue= "StepDefinitions", strict = true, plugin = {"pretty", "html:target/cucumber-reports/cucumber-report4","json:target/cucumber-reports/CucumberTestReport4.json"}

)

public class ShippingMethodRunner {

}
