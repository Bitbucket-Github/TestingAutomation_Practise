package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features= {"classpath:OpeningBrowser.feature", "classpath:ShippingMethod.feature"})
//tags= {"@OpeningBrowser", "@SendToFriend"}


@CucumberOptions(features = "C:\\EclipseWorkspace\\CucumberProject\\src\\test\\java\\Features",
glue= "StepDefinitions", strict = true,
tags= "@ShippingMethod"

)

public class ShippingMethodRunner {

}
