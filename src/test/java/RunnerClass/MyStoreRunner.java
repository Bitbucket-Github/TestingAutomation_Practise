package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src\\test\\java\\Features\\MyStoreOrderHistory.feature",
//tags= "@Searchbar" ,// @Navigation And @OrderHistory"},
glue= {"stepdefinitionpackage"},
monochrome=true ) 
public class MyStoreRunner {

}





