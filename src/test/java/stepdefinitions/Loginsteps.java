package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import com.sun.org.apache.bcel.internal.generic.Select;

import java.nio.charset.Charset;
import java.util.Random;

//import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.Scanner;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.IdGenerator.UUID;

public class Loginsteps extends ConfigReader {


	public static WebDriver driver;
	
	@Given("I am on the Google search page")
	public void i_am_on_the_google_search_page() throws Exception {
	
		configreader();
		//Object user;
		//String projectPath = System.getProperty(user.dir);
		//loacation of project ie., cucmberjava 

		System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriver"));
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

	}

	@And("hits enter")
	public void hits_enter() {
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
	}

	@Then("the page title should start with {string}")
	public void the_page_title_should_start_with(String string) {

		System.out.println(driver.getTitle());
		driver.getPageSource().contains(pro.getProperty("Pageheader"));
	}



	///INVALID CREDENTIALS
	

	@Given("user navigate on sign in")
	public void user_navigate_on_sign_in() {
		
		driver.findElement(By.xpath(pro.getProperty("Signin"))).click();
	}


	@And("user do the authentication process")
	public void user_do_the_authentication_process() {
		/*Scanner sc1= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter a string: ");  
		String str1= sc1.nextLine();              //reads string  */
		System.out.print("You have entered: ");

	}

	@When("user the enters Emailnew and pwd")
	public void user_the_enters_Emailnewand_passwordnew() {
		driver.findElement(By.id("email")).sendKeys(pro.getProperty("Emailnew"));
		driver.findElement(By.id("passwd")).sendKeys(pro.getProperty("pwd"));

	}

	@And("clicks on the signin button")
	public void clicks_on_the_signin_button() {
		driver.findElement(By.xpath(pro.getProperty("submit"))).click();

	}

	@Then("error msg is displayed and user creates acoounr")
	public void error_msg_is_displayed_and_user_creates_acoounr() {
		// driver.findElement(By.linkText("Invalid email address.")).isDisplayed();
		
		
		driver.findElement(By.id("email_create")).click();
		    int length = 10;
		    boolean useLetters = true;
		    boolean useNumbers = true;
		    String Randomemail = RandomStringUtils.random(length, useLetters, useNumbers);

	 driver.findElement(By.id("email_create")).sendKeys(  Randomemail+"@gmail.com");
	 System.out.println("Randomemail is    "  + Randomemail+"@gmail.com" );

		driver.findElement(By.xpath(pro.getProperty("createaccount"))).click();

		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.xpath(pro.getProperty("firstname"))).sendKeys("git");
		driver.findElement(By.xpath(pro.getProperty("lastname"))).sendKeys("new");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(pro.getProperty("pwd"));
		driver.findElement(By.id("firstname")).sendKeys("git");   
		driver.findElement(By.id("lastname")).sendKeys("new");
		driver.findElement(By.id("address1")).sendKeys("new1,way colony");
		driver.findElement(By.id("city")).sendKeys("new");
		
		Select dropdown = new Select(driver.findElement(By.id("id_state"))); 
		dropdown.selectByVisibleText("Alabama");  

		driver.findElement(By.id("postcode")).sendKeys("00000");

		Select dropdowncountry = new Select(driver.findElement(By.id("id_country"))); 
		dropdowncountry.selectByVisibleText("United States");  

		driver.findElement(By.id("phone_mobile")).sendKeys("09909034343");

		driver.findElement(By.id("alias")).sendKeys("nonsense");
		driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
		driver.findElement(By.xpath(pro.getProperty("Signout"))).click();
	}




	//VALID CREDENTIALS


	@Given("user clicks on sign in")
	public void user_clicks_on_sign_in() {
		driver.findElement(By.xpath(pro.getProperty("Signin"))).click();
	}

	@And("user do the authentication")
	public void user_do_the_authentication() {
		/*Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		System.out.print("Enter a string: ");  
		String str= sc.nextLine();              //reads string  */
		System.out.print("You have entered: ");    


	}

	@When("user enters Email and password")
	public void user_enters_Email_and_password() {
		System.out.println("email is" +pro.getProperty("Email"));
		
		driver.findElement(By.id("email")).sendKeys(pro.getProperty("Email"));
		driver.findElement(By.id("passwd")).sendKeys(pro.getProperty("pwd"));


	}

	@And("clicks on signin buttonp")
	public void clicks_on_signin_button() {
		driver.findElement(By.xpath(pro.getProperty("submit"))).click();
	}

	@Then("check user is navigated to home page")
	public void check_user_is_navigated_to_home_page() {
		System.out.println("success");
		
	}



}