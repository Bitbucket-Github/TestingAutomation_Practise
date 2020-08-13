package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OpeningBrowser {

	WebDriver driver=null;

	@Given("Open the browser and navigate to application page")
	public void open_the_browser_and_navigate_to_application_page() {

		String browser_name = "chrome";
		System.out.println("Running Browser is : " +browser_name);
		if(browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\EclipseWorkspace\\CucumberProject\\Lib\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser_name.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\EclipseWorkspace\\CucumberProject\\Lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser_name.equals("IE")) {
			driver = new InternetExplorerDriver();
		}
		else if(browser_name.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
	    
		String expectedTitle = "My Store" ;
		String actualTitle = driver.getTitle();
		Assert.assertTrue("User not navigate to my store page..",expectedTitle.equals(actualTitle));
	}
	
} 
