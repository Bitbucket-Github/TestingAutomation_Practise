package stepdefinitions;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import util.ConfigReader;

public class Compare extends ConfigReader {


	//COMPARE
	public static WebDriver driver;
	
	// ConfigReader objectprop = new ConfigReader();
	
	
	

	@Given("user checks quantity total and shippind charge")
	public void user_checks_quantity_total_and_shippind_charge() throws Exception  {
		
		configreader();

		System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriver"));
		//System.setProperty("webdriver.chrome.driver", objectprop.getchromepath());
		System.out.println("Inside Step- i am on the google search page");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		
		driver.get(pro.getProperty("URL"));
		
		//driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.xpath(pro.getProperty("Signin"))).click();
		
	
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("bitbucket76@gmail.com");
		
		
		driver.findElement(By.id("passwd")).sendKeys("Github123");
		
		driver.findElement(By.xpath(pro.getProperty("submit"))).click();

		driver.findElement(By.xpath(pro.getProperty("cart"))).click();


		driver.findElement(By.xpath("//*[@id=\"product_3_13_0_354295\"]/td[5]/input[2]")).getText();

		driver.findElement(By.xpath("//*[@id=\"product_1_1_0_354295\"]/td[5]/input[2]")).getText();

		String prod1= driver.findElement(By.xpath("//*[@id=\"product_price_3_13_354295\"]/span")).getText();

		String prod2= driver.findElement(By.xpath("//*[@id=\"product_price_1_1_354295\"]/span")).getText();


	}


	@When("user calculates total")
	public void user_calculates_total() {

		double shipping = 2.00;

		String total =driver.findElement(By.xpath("//*[@id=\"total_product\"]")).getText();

	}

	@And("validates total and total+tax")
	public void validates_total_and_total_tax() {




		double finaltotal =Double.parseDouble("26.00")+ 2.00 +Double.parseDouble("16.15"); 

		String bill = driver.findElement(By.xpath("//*[@id=\"total_price\"]")).getText();

		String s=Double. toString(finaltotal);

		if (bill == s )
		{
			System.out.println("compare successfull");
		}
		else
		{
			System.out.println("fail");
		}
	}

	@Then("result should be equal")
	public void result_should_be_equal() {
		driver.close();
	}








}
