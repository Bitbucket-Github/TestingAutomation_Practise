package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="C:\\Users\\Guest\\eclipse-workspace2\\MyStore\\FeaturesFiles\\MyStoreOrderHistory.feature",
//tags= "@Searchbar" ,// @Navigation And @OrderHistory"},
glue= {"stepdefinitionpackage"},
monochrome=true ) 
public class MyStoreRunner {

}





