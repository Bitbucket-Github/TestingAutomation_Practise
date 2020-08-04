package RunnerClass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="C:\\EclipseWorkspace\\CucumberProject\\src\\test\\java\\Features\\BasicsTests.feature", 
glue= {"StepDefinitions"}, 
monochrome=true,
tags = "@NewsLetter")

public class BasicsTestsRunner {

}
