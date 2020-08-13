package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
//import org.openqa.selenium.InvalidArgumentException;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.*;

public class MyStoreStepDefinition {
	
	WebDriver driver;	
	@Given("User opens the chromebrowser")
	public void user_opens_the_chromebrowser() {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Guest\\eclipse-workspace2\\MyStore\\drivers\\chromedriver.exe" );
		    driver =new ChromeDriver();
		   //driver.manage().window().maximize();
		   Thread.sleep(1000);
		} catch (NullPointerException e) {
	       System.out.println("Please check whether you are not giving either key or value for browser");
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("The exception is :"+e.getMessage());
		}
	}
	@And("user navigate to the application")
	public void user_navigate_to_the_application() {
		try {
			driver.get("http://automationpractice.com/index.php");
		} catch (InvalidArgumentException iae) {
			
			//e.printStackTrace();
			System.out.println(iae.getMessage());
			System.out.println("The Exception is : Please Provide valid argument");

		}
}
//********************************Searching a product through search bar******************************************
	
	@When("user searches for the product")
	public void user_searches_for_the_product() throws InterruptedException  {
		try {
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirts ");
			  driver.findElement(By.xpath("//button[@name='submit_search']")).click();
			  Thread.sleep(5000);
			} catch (InvalidSelectorException e) {
				//e.printStackTrace();
				System.out.println("The Exception is : "+e.getMessage());
				System.out.println("Please check webelement location");
				}
		}

	@Then("the search result page is displayed")
	public void the_search_result_page_is_displayed(){
		
			try {
				boolean eleSearch= driver.findElement(By.className("lighter")).isDisplayed();
				System.out.print("search result is displayed:"+eleSearch);
				Thread.sleep(4000);
				driver.close();
				//driver.quit();
			} catch (InterruptedException e) {
					
					System.out.println("The Exception is :"+e.getMessage());
			}
		    
	}
//****************************************Searching a product by navigator**************************************

@When("user points on anyone category")
	public void user_points_on_anyone_category()  {
		try {
			driver.manage().window().maximize();
			WebElement target = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
			Actions actions = new Actions(driver);
			actions.moveToElement(target).build().perform();
			Thread.sleep(4000);
		} catch (NoSuchElementException e) {
			//e.printStackTrace();
			System.out.println("Exception is :webelement adddress is not correct");
		}catch (TimeoutException e) {
			System.out.println("WebDriver couldn’t locate the element");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@And("user select the subcategory")
	public void user_select_the_subcategory() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")).click();
			boolean eleSearch= driver.findElement(By.className("cat-name")).isDisplayed();
			System.out.print("search result is displayed:"+eleSearch);
			Thread.sleep(4000);
			driver.close();
		}catch (NoSuchElementException e) {
				//e.printStackTrace();
			System.out.println("Exception is :webelement adddress is not correct");
		} catch (InterruptedException e) {
			
			
		}
	}
//***********************************ADDTOWISHLIST***********************************
	@Given("user clicks on more option")
	public void user_clicks_on_more_option() throws InterruptedException {
		/*driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirts ");
		  driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		  Thread.sleep(5000);
		WebElement target = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		Actions actions = new Actions(driver);
		actions.moveToElement(target).build().perform();*/
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")).click();
	
	}

	@Then("user selects add to wishlist")
	public void user_selects_add_to_wishlist() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"wishlist_button\"]")).click();
		Thread.sleep(3000);
		WebElement text= driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div/div/p"));
		System.out.println("The popup text is :"+text.getText());
	}
//***********************************PAYMENT SCENARIO *****************************************
	@Given("user click cart")
	public void user_click_cart() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
	}//ElementNotInteractableException

	@And("user click on  checkout option")
	public void user_click_on_checkout_option() {
		driver.findElement(By.xpath("//*[@id=\"button_order_cart\"]/span")).click();
	}

	@And("user click on proceed to checkout option")
	public void user_click_on_proceed_to_checkout_option() throws InterruptedException {
	try {	
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch(NoSuchElementException nse) {
			System.out.println("unable to find element"+nse.getMessage());
		}
	}

	@And("again user click on proceed to checkout option")
	public void again_user_click_on_proceed_to_checkout_option() {
		try {
			WebElement checkbox = driver.findElement(By.id("cgv"));
			System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
			if(!checkbox.isSelected())
			    checkbox.click();
			System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
			driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Then("user selects PayBY Check option")
	public void user_selects_pay_by_check_option() {
		driver.findElement(By.xpath("//a[@class='cheque']")).click();
	}

	@And("user click on i confirm my order")
	public void user_click_on_i_confirm_my_order() {
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
	}
//**************************************ORDERHISTORY***************************************
	@When("user click on signin option")
	public void user_click_on_signin_option()  {
		try {
			WebElement clickSignIn =driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
			clickSignIn.click();
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@And("user enters valid credentials")
	public void user_enters_valid_credentials() {
		try {
			driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("bitbucket76@gmail.com ");
			driver.findElement(By.xpath("//*[@id=\'passwd\']")).sendKeys("Github123");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Then("click on sign in button")
	public void click_on_sign_in_button() {
		
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		driver.manage().window().maximize();
	}

	@And("user click on order history and details")
	public void user_click_on_order_history_and_details() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();
			boolean eleOrderlist= driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).isDisplayed();
				System.out.print("order history and details is displayed:"+eleOrderlist);
				Thread.sleep(11000);
				
				driver.close();
		}  catch(NoSuchElementException e1)
		{
			System.out.println(e1.getMessage());
		}catch(Exception e)
		{
		
		}
		}
}
	
	
	

