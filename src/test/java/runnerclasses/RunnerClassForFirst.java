package runnerclasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="C:\\Users\\Guest\\eclipse-workspace2\\MavenClass\\Features\\MyStoreWebsite.feature", glue= {"stepdefinitions"}, 
monochrome=true ) 
public class RunnerClassForFirst {

}
