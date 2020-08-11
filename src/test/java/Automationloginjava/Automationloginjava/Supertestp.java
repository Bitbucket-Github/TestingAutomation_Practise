package Automationloginjava.Automationloginjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.ConfigReader;

public class Supertestp {
	
	
	public static WebDriver driver;
	
	public ConfigReader obj = new ConfigReader();
			
	  @BeforeTest	
		@Given("I am on the Google search page")
		public void i_am_on_the_google_search_page() throws Exception {
		
			//configreader();
			//Object user;
			//String projectPath = System.getProperty(user.dir);
			//loacation of project ie., cucmberjava 
		  
			
		  

			System.setProperty("webdriver.chrome.driver", obj.getprop("ChromeDriver"));
			
			//System.setProperty("webdriver.chrome.driver", "C:/Users/abita/Documents/driversweb/chromedriver.exe");
			
			driver = new ChromeDriver();

			driver.navigate().to("https://www.google.com/");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		@When("I search for website")
		public void i_search_for_website() {

			driver.findElement(By.name("q")).sendKeys("automationpractise");

			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			//driver.get("http://demowebshop.tricentis.com/");
			//System.out.println(driver.getCurrentUrl());
			// Write code here that turns the phrase above into concrete actions

		}

		@And("hits enter")
		public void hits_enter() {
			driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
		}

		@Then("the page title should start with {string}")
		public void the_page_title_should_start_with(String string) throws Exception {

			System.out.println(driver.getTitle());
			
			driver.getPageSource().contains(obj.getprop("Pageheader"));
		}
		
		
	@AfterTest
	public void postConfig()

	{
	driver.close();
		
	}
}
