package StepDefinitions;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.InvalidArgumentException;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;

import io.cucumber.java.en.*;

public class MyStore {

	WebDriver driver;	
	@Given("User opens the chromebrowser")
	public void user_opens_the_chromebrowser() {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\EclipseWorkspace\\CucumberProject\\Lib\\chromedriver.exe" );
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
			driver.manage().window().maximize();

			//validate that user able to navigate given website 
			String expectedTitle = "My Store" ;
			String actualTitle = driver.getTitle();
			AssertJUnit.assertTrue("User not navigate to my store page..",expectedTitle.equals(actualTitle));

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

			driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirts ");
			driver.findElement(By.xpath("//button[@name='submit_search']")).click();
			//validate that user able to see the items on clicking search bar option
			String expectedSearchTitle = "Search - My Store" ;
			String actualSearchTitle = driver.getTitle();
			AssertJUnit.assertEquals(expectedSearchTitle,actualSearchTitle);

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
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirts ");
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		Thread.sleep(5000);
		WebElement target = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		Actions actions = new Actions(driver);
		actions.moveToElement(target).build().perform();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")).click();

		//validate that user able to see the more options for selected items 
		String expectedItemTitle = "Faded Short Sleeve T-shirts - My Store" ;
		String actualItemTitle = driver.getTitle();
		AssertJUnit.assertEquals(expectedItemTitle,actualItemTitle);
	}

	@Then("user selects add to wishlist")
	public void user_selects_add_to_wishlist() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"wishlist_button\"]")).click();

		Thread.sleep(3000);
		WebElement text= driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div/div/div/div/p"));
		String expectedPopup = text.getText();
		System.out.println("The popup text is :"+expectedPopup);
		AssertJUnit.assertEquals(expectedPopup,"You must be logged in to manage your wishlist.");
	}
	//***********************************PAYMENT SCENARIO *****************************************
	@Given("user click cart")
	public void user_click_cart() throws InterruptedException {

		try {
			user_click_on_signin_option();
			user_enters_valid_credentials();
			click_on_sign_in_button();
			user_searches_for_the_product();
			WebElement target = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
			Actions actions = new Actions(driver);
			actions.moveToElement(target).build().perform();
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
			//validate the product added into the cart
			WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Summary')]"));
			String str=element.getText();
			AssertJUnit.assertEquals("01. Summary", str);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@And("user click on  checkout option")
	public void user_click_on_checkout_option() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();

		//validate that user able to navigate address step on clicking proceed to checkout button
		String  actualSummaryStep ="03. Address";
		WebElement summaryStep = driver.findElement(By.xpath("//li[@class='step_current third']//span[contains(text(),'Address')]"));
		String expectedSummaryStep = summaryStep.getText();
		AssertJUnit.assertEquals(expectedSummaryStep,actualSummaryStep); 
	}

	@And("user click on proceed to checkout option")
	public void user_click_on_proceed_to_checkout_option() throws InterruptedException {
		try {	
			Thread.sleep(7000);
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();

			//validate that user able to navigate shipping step on clicking proceed to checkout button
			String  actualAddressStep ="04. Shipping";
			WebElement AddressStep = driver.findElement(By.xpath("//li[@class='step_current four']//span[contains(text(),'Shipping')]"));
			String expectedAddressStep = AddressStep.getText();
			AssertJUnit.assertEquals(expectedAddressStep,actualAddressStep);

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

			//validate that user able to navigate payment step on clicking proceed to checkout button
			String  actualShippingStep ="05. Payment";
			WebElement ShippingStep = driver.findElement(By.xpath("//span[contains(text(),'Payment')]"));
			String expectedShippingStep = ShippingStep.getText();
			AssertJUnit.assertEquals(expectedShippingStep,actualShippingStep);	

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects PayBY Check option")
	public void user_selects_pay_by_check_option() {
		driver.findElement(By.xpath("//a[@class='cheque']")).click();

		//validate that user able to see the payment summary oder on clicking proceed to checkout button
		String  actualOrderSummary ="CHECK PAYMENT";
		WebElement ShippingStep = driver.findElement(By.xpath("//h3[@class='page-subheading']"));
		String expectedOrderSummary = ShippingStep.getText();
		AssertJUnit.assertEquals(expectedOrderSummary,actualOrderSummary);	
	}

	@And("user click on i confirm my order")
	public void user_click_on_i_confirm_my_order() {
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();

		//validate that user able to see the confirmation oder on clicking confirm order button
		String  actualConfirmOrder ="Your order on My Store is complete.";
		WebElement ShippingStep = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		String expectedConfirmOrder = ShippingStep.getText();
		AssertJUnit.assertEquals(expectedConfirmOrder,actualConfirmOrder);
		System.out.println("Order confirmed successfully...");

	}
	//**************************************ORDERHISTORY***************************************
	@When("user click on signin option")
	public void user_click_on_signin_option()  {
		try {
			WebElement clickSignIn =driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
			clickSignIn.click();
			//validate that user navigated to login page
			String expectedLoginTitle = "Login - My Store" ;
			String actualLoginTitle = driver.getTitle();
			AssertJUnit.assertEquals(expectedLoginTitle,actualLoginTitle);
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
		//validate that user navigate to account page on clicking signing button
		String expectedTitleInAccount = "My account - My Store";
		String actualTitleInAccount = driver.getTitle();
		AssertJUnit.assertEquals(expectedTitleInAccount,actualTitleInAccount);
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
			System.out.println(e.getMessage());
		}
	}
}




