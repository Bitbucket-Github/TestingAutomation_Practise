package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src\\test\\java\\Features\\MyStore.feature", strict = true,
glue= {"StepDefinitions"}, plugin = {"pretty", "html:target/cucumber-reports/cucumber-report3","json:target/cucumber-reports/CucumberTestReport3.json"},
monochrome=true

) 


public class MyStoreRunner {

}
