package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="C:\\EclipseWorkspace\\CucumberProject\\src\\test\\java\\Features\\MyStore.feature", strict = true,
glue= {"StepDefinitions"}, 
monochrome=true,
tags = "@MyStorePayment"

) 


public class MyStoreRunner {

}
