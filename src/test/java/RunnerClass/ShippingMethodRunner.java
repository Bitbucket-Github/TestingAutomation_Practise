package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src\\test\\java\\Features\\ShippingMethod.feature",
glue= "StepDefinitions", 
monochrome = true
)

public class ShippingMethodRunner {

}
