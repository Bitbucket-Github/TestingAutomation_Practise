package Runnertest;
//import org.testng.annotations.DataProvider;


import org.junit.runner.RunWith;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Feature\\Compare.feature",
							glue= "stepdefinitions",

//tags= "@openbrowser,@Register,@login,@compare",

monochrome= true,


plugin={"pretty","html:target/HtmlReports",
		"json:target/JSONReports/report.json"}
)



public class TestRunner {
	

	//@DataProvider(parallel=true)
	//public Object[][] scenerios() {
		//return super.scenerios();
	}

