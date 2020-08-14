package RunnerClass;

import org.junit.runner.RunWith;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\Features\\LoginTest.feature",  strict = true,
glue= "StepDefinitions", monochrome= true, plugin = {"pretty", "html:target/cucumber-reports/cucumber-report2","json:target/cucumber-reports/CucumberTestReport2.json"}

//plugin={"pretty","html:target/HtmlReports", "json:target/JSONReports/report.json"}
)


public class LoginTestRunner {
	
	//@DataProvider(parallel=true)
	//public Object[][] scenerios() {
		//return super.scenerios();
	}

