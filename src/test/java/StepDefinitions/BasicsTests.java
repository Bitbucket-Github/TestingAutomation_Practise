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

public class BasicsTests {

	WebDriver driver=null;

	@Given("User is on YourLogo page")
	public void user_is_sign_in_page() {

		//navigate to website
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

		@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {

		//enter username and password
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("bitbucket76@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Github123");
	}

	@And("Click on sign in button")
	public void click_on_sign_in_button() {

		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
	}

	@Then("User navigate to home page")
	public void user_navigate_to_home_page() {

		System.out.println("Sign in Successfully....user is on home page");
		String expectedTitle = "My account - My Store";
		String actualTitle = null;
		actualTitle=driver.getTitle();
		if(actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Title Matched...");
		}
		else {
			System.out.println("Title not match..." );
		}	
	}

	@When("User select the product in the category list")
	public void user_select_the_product_in_the_category_list() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//click on any one of the product category options like Womens
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		//click on sub-category product like tops
		driver.findElement(By.xpath("//div[@id='subcategories']//li[1]//div[1]//a[1]//img[1]")).click();
		//click on the sub-category of tops like Blouse
		driver.findElement(By.xpath("//div[@id='subcategories']//li[2]//div[1]//a[1]//img[1]")).click();
	}

	@Then("Add the product into the cart list")
	public void add_the_product_into_the_cart_list() {

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
		driver.quit();	
	}

	//--------------------------------------------------------------------------------------------------------------

	//Scenario 2 : Send to a Friend

	@When("User select the product in the category options")
	public void user_select_the_product_in_the_category_options() {

		//click on any one of the product category option
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();
		//click on the sub-category option of the product
		driver.findElement(By.xpath("//div[@id='subcategories']//li[3]//div[1]//a[1]//img[1]")).click();
		//click on any one of item u want
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).click();
	}

	@And("Click on the send to a friend option")
	public void click_on_the_send_to_a_friend_option() {

		//click on send to a friend
		driver.findElement(By.id("send_friend_button")).click();
	}

	@Then("user enters name, email address of friend and click on the send button")
	public void user_enters_name_email_address_of_friend_and_click_on_the_send_button() {

		//enter name and address of a friend
		driver.findElement(By.name("friend_name")).sendKeys("Anjali Jain");
		driver.findElement(By.cssSelector("#friend_email")).sendKeys("bitbucket76@gmail.com");
		//click on the send button 
		driver.findElement(By.xpath("//button[@id='sendEmail']//span[contains(text(),'Send')]")).click();
		driver.quit();		
	}

	//--------------------------------------------------------------------------------------------------------------

	//Scenario 3 : News Letter

	@When("User enter email id for subscription")
	public void user_enter_email_id_for_subscription() {

		//user enter email id 
		driver.findElement(By.id("newsletter-input")).sendKeys("bitbucket76@gmail.com");
	}

	@Then("Click on the send forward button for notification")
	public void click_on_the_send_forward_button_for_notification() {

		//click on the forward button for future notification
		driver.findElement(By.name("submitNewsletter")).click();
		driver.quit();
	}

	//---------------------------------------------------------------------------------------------------------------

	//Scenario 4 : Social Media

	@Then("Click on the social media icon then user should be navigate to that page")
	public void click_on_the_social_media_icon_then_user_should_be_navigate_to_that_page() {

		String media = "youtube";
		if(media.equals("facebook")) {
			driver.findElement(By.xpath("//li[@class='facebook']//a")).click();
			System.out.println("Facebook page opened");
		}
		else if(media.equals("twitter")) {
			driver.findElement(By.xpath("//li[@class='twitter']//a")).click();
			System.out.println("Twitter page opened");
		}
		else if(media.equals("youtube")) {
			driver.findElement(By.xpath("//li[@class='youtube']//a")).click();
			System.out.println("Youtube page opened");
		}
		else if(media.equals("google")) {
			driver.findElement(By.xpath("//li[@class='google-plus']//a")).click();
			System.out.println("Google page opened");
		}
		driver.quit();
	}  

	//---------------------------------------------------------------------------------------------------------------

	//Scenario 5 : ContactUs
	
	@When("User click on contact us button")
	public void user_click_on_contact_us_button() {

		//click on the contact us button
		driver.findElement(By.xpath("//div[@id='contact-link']//a[contains(text(),'Contact us')]")).click();
	}

	@When("user enters valid credentials for message send")
	public void user_enters_valid_credentials_for_message_send() {

		//enter valid credentials for message send
		//to select subject heading
		WebElement subjectHeading = driver.findElement(By.xpath("//select[@id='id_contact']"));
		Select selectSubHeading= new Select(subjectHeading);
		selectSubHeading.selectByVisibleText("Customer service");
		//enter email address
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("bitbucket76@gmail.com");
		//enter a message you want to send
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("about items");	
	}

	@Then("Click on the send button")
	public void click_on_the_send_button() {

		//click on the send button
		driver.findElement(By.xpath("//span[contains(text(),'Send')]")).click();
		System.out.println("Message sent successfully to our team...");
		driver.quit();
	}
}
