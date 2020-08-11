package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShippingMethod {

	WebDriver driver=null;

	@Given("User is on website page")
	public void user_is_on_website_page() {

		//navigate to website
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@When("User enters username, password and click on sign in button")
	public void user_enters_username_password_and_click_on_sign_in_button() {

		//enter username and password
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("bitbucket76@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Github123");
		//click on sign in button
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
	}

	@And("select the items in the category list")
	public void select_the_items_in_the_category_list() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//click on any one of the product category options like Womens
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		//click on sub-category product like tops
		driver.findElement(By.xpath("//div[@id='subcategories']//li[1]//div[1]//a[1]//img[1]")).click();
		//click on the sub-category of tops like Blouse
		driver.findElement(By.xpath("//div[@id='subcategories']//li[2]//div[1]//a[1]//img[1]")).click();
	}

	@Then("Add the items into the cart list")
	public void add_the_items_into_the_cart_list() {

		//select the grid option
		driver.findElement(By.className("icon-th-list")).click();
		//click on more option
		driver.findElement(By.xpath("//span[contains(text(),'More')]")).click(); 
		//select size
		WebElement size = driver.findElement(By.name("group_1"));
		Select selectSize= new Select(size);
		selectSize.selectByVisibleText("M");
		//click on Add to cart
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		System.out.println("user successfully added item into the cart...");
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	
	//Scenario 1 : Shipping Method

	@Given("User already added product into the cart")
	public void user_already_added_product_into_the_cart() {

		//product already added into the cart, so click on the cart for further proceed
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")).click();
		//click on proceed to checkout button in address method
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")).click();
	}

	@When("User want to change the delivery address")
	public void user_want_to_change_the_delivery_address() {

		//user don't want to change the delivery address, so click on proceed to checkout button
		driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();	
	}

	@Then("Accept the shipping mode and click on proceed to checkout button")
	public void accept_the_shipping_mode_and_click_on_proceed_to_checkout_button() {

		//to accept the condition for shipping mode
		driver.findElement(By.id("uniform-cgv")).click();
		//click on proceed to checkout for further process
		driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
		System.out.println("User successfully accept the shipping method...");
	}

	//--------------------------------------------------------------------------------------------------------------------------
	
	//Scenario 2 : Payment Method
	
	@When("User is on payment page")
	public void user_is_on_payment_page() {
	    
		System.out.println("user is on payment page and they can see 2 payment methods");
	}

	@Then("User click on any one of the payment method and click on confirm order")
	public void user_click_on_any_one_of_the_payment_method_and_click_on_confirm_order() {
	    
		String paymentMethod= "PayByBank";
		System.out.println("User paying " +paymentMethod+ " method");
		 
		if(paymentMethod.equals("PayByBank")) {
			
			//click on pay by bank 
			driver.findElement(By.xpath("//a[@class='bankwire']")).click();
			System.out.println("User can see the order summary history");
			driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
			
		}
		else if(paymentMethod.equals("PayByCheck")) {
			
			//click on pay by check
			driver.findElement(By.xpath("//a[@class='cheque']")).click();
			System.out.println("User can see the order summary history");
			driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
		}
		
		System.out.println("ORDER CONFIRMED...");	
	}

}
