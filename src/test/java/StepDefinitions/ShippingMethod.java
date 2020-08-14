package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShippingMethod {

	WebDriver driver=null;

	@Given("User is on website page")
	public void user_is_on_website_page() {

		//navigate to website
		System.setProperty("webdriver.chrome.driver", "C:\\EclipseWorkspace\\CucumberProject\\Lib\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

		//validate that user able to navigate given website 
		String expectedTitle = "My Store" ;
		String actualTitle = driver.getTitle();
		AssertJUnit.assertTrue("User not navigate to my store page..",expectedTitle.equals(actualTitle));
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

		//validate the product added into the cart
		//click on the cart button
		driver.findElement(By.xpath("//b[contains(text(),'Cart')]")).click();
		WebElement element=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/small[2]"));
		String str=element.getText();
		AssertJUnit.assertEquals("Color : Black, Size : M", str);
		System.out.println("Successfully product added into the cart");
	}

	//------------------------------------------------------------------------------------------------------------------------

		//Scenario 1 : Shipping Method

	@Given("User already added product into the cart")
	public void user_already_added_product_into_the_cart() {

		//product already added into the cart, so click on the cart to see the product details
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")).click();
		//click on proceed to checkout button in the summary 
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")).click();

		//validate that user able to navigate address step on clicking proceed to checkout button
		String  actualSummaryStep ="03. Address";
		WebElement summaryStep = driver.findElement(By.xpath("//li[@class='step_current third']//span[contains(text(),'Address')]"));
		String expectedSummaryStep = summaryStep.getText();
		AssertJUnit.assertEquals(expectedSummaryStep,actualSummaryStep);
	}

	@When("User is on delivery address page")
	public void user_is_on_delivery_address_page() {

		//user don't want to change the delivery address, so click on proceed to checkout button
		driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();

		//validate that user able to navigate shipping step on clicking proceed to checkout button
		String  actualAddressStep ="04. Shipping";
		WebElement AddressStep = driver.findElement(By.xpath("//li[@class='step_current four']//span[contains(text(),'Shipping')]"));
		String expectedAddressStep = AddressStep.getText();
		AssertJUnit.assertEquals(expectedAddressStep,actualAddressStep);
	}

	@Then("Accept the shipping mode and click on proceed to checkout button")
	public void accept_the_shipping_mode_and_click_on_proceed_to_checkout_button() {

		//to accept the condition for shipping mode
		WebElement ele=driver.findElement(By.id("uniform-cgv"));
		ele.click();

		//click on proceed to checkout for further process
		driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
		System.out.println("User successfully accept the shipping method...");

		//validate that user able to navigate payment step on clicking proceed to checkout button
		String  actualShippingStep ="05. Payment";
		WebElement ShippingStep = driver.findElement(By.xpath("//span[contains(text(),'Payment')]"));
		String expectedShippingStep = ShippingStep.getText();
		AssertJUnit.assertEquals(expectedShippingStep,actualShippingStep);

	/*	//validating the terms of services for shipping mode
		String actual_terms_services = "You must agree to the terms of service before continuing.";
		WebElement varning =driver.findElement(By.xpath("//p[@class='fancybox-error']"));
		String expected_terms_services = varning.getText();
		System.out.println("Warning : " +expected_terms_services);
		AssertJUnit.assertEquals(expected_terms_services,actual_terms_services); */	
		driver.quit();
	}
}
