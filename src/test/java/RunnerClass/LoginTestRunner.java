package RunnerClass;

import org.junit.runner.RunWith;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\EclipseWorkspace\\CucumberProject\\src\\test\\java\\Features\\LoginTest.feature",  strict = true,
glue= "StepDefinitions", monochrome= true

//plugin={"pretty","html:target/HtmlReports", "json:target/JSONReports/report.json"}
)


public class LoginTestRunner {
	
	//@DataProvider(parallel=true)
	//public Object[][] scenerios() {
		//return super.scenerios();
	}

