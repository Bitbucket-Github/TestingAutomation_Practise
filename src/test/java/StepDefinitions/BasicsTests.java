package StepDefinitions;

import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.List;
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
	WebElement element;

	@Given("User is on MyStore page")
	public void user_is_on_mystore_page() {

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

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {

		//enter username and password
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("bitbucket76@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("Github123");
	}

	@And("Click on sign in button")
	public void click_on_sign_in_button() {
		//click on sign in button
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();

		//validate that user navigate to account page on clicking signing button
		String expectedTitleInAccount = "My account - My Store";
		String actualTitleInAccount = driver.getTitle();
		AssertJUnit.assertTrue("After clicking signing button user unable to navigate my account page ",expectedTitleInAccount.equals(actualTitleInAccount));

		//validating an empty email address
		/*	String actualWarning ="An email address required.";
		WebElement errorMessage =driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/ol/li"));
		String expectedWarning = errorMessage.getText();
		System.out.println("Warning : " +expectedWarning);
		AssertJUnit.assertEquals(expectedWarning,actualWarning);
		System.out.println("Sign in failed..");  */
	}

	@Then("User navigate to home page")
	public void user_navigate_to_home_page() {

		//validate user navigate to home page
		String actualUrl="http://automationpractice.com/index.php?controller=my-account"; 
		String expectedUrl= driver.getCurrentUrl();
		AssertJUnit.assertEquals(expectedUrl,actualUrl);
		System.out.println("Sign in Successfully....user is on home page");
	}

	@When("User select the product in the category list")
	public void user_select_the_product_in_the_category_list() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//click on any one of the product category options like Women
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		//click on sub-category product like tops
		driver.findElement(By.xpath("//div[@id='subcategories']//li[1]//div[1]//a[1]//img[1]")).click();
		//click on the sub-category of tops like Blouse
		driver.findElement(By.xpath("//div[@id='subcategories']//li[2]//div[1]//a[1]//img[1]")).click();
	}

	@And("Add the product into the cart list")
	public void add_the_product_into_the_cart_list() {

		//select the grid option
		driver.findElement(By.className("icon-th-list")).click();
		//click on more option
		driver.findElement(By.xpath("//span[contains(text(),'More')]")).click(); 
		//select size
		WebElement size = driver.findElement(By.name("group_1"));
		Select selectSize= new Select(size);
		selectSize.selectByVisibleText("M");
		//click on Add to cart button
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
	}

	@Then("Product should be added in the cart successfully")
	public void product_should_be_added_in_the_cart_successfully() {

		//validate the product added into the cart
		//click on the cart button
		driver.findElement(By.xpath("//b[contains(text(),'Cart')]")).click();
		WebElement element=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/small[2]"));
		String str=element.getText();
		AssertJUnit.assertEquals("Color : Black, Size : M", str);
		System.out.println("Successfully product added into the cart");
	}


	//--------------------------------------------------------------------------------------------------------------

	//Scenario 2 : Send to a Friend

	@When("User select the product in the category options")
	public void user_select_the_product_in_the_category_options() {

		//click on any one of the product category option
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();
		//click on the sub-category option of the product
		driver.findElement(By.xpath("//div[@id='subcategories']//li[3]//div[1]//a[1]//img[1]")).click();
		//click on any one of item you want
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

		/*	//validate that user get success message on clicking send button
		String  actualMesg ="Your e-mail has been sent successfully";
		WebElement mesg = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/p[1]"));
		String expectedMesg = mesg.getText();
		AssertJUnit.assertEquals(expectedMesg,actualMesg);  */

		/*	//validating an empty email address for send to friend
		String actual_send_friend ="You did not fill required fields";
		WebElement send_friend_error =driver.findElement(By.xpath("//div[@id='send_friend_form_error']"));
		String expected_send_friend = send_friend_error.getText();
		System.out.println("Warning : " +expected_send_friend);
		AssertJUnit.assertEquals(expected_send_friend,actual_send_friend);
		//System.out.println("Sign in failed..");  */
		driver.quit();		
	}

	//--------------------------------------------------------------------------------------------------------------

	//Scenario 3 : News Letter

	String email= "arpanshaikh88@gmail.com";

	@When("User enter email id for subscription")
	public void user_enter_email_id_for_subscription() {

		//user enter email id 
		WebElement ele = driver.findElement(By.id("newsletter-input"));
		ele.sendKeys(email);
	}

	@Then("Click on the send forward button for notification")
	public void click_on_the_send_forward_button_for_notification() {

		//click on the forward button for future notification
		driver.findElement(By.name("submitNewsletter")).click();

		//validate that user get success message on subscribing newsletter
		String  actualSuccessMesg ="Newsletter : You have successfully subscribed to this newsletter.";
		WebElement mesg = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		String expectedSuccessMesg = mesg.getText();
		AssertJUnit.assertEquals(expectedSuccessMesg,actualSuccessMesg);

		/*	//validate email notification
		if(email!="bitbucket76@gmail.com") {

			//validating invalid email address
			String actual1="Newsletter : Invalid email address.";
			WebElement alertMesg1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/p[1]"));
			String expected1=alertMesg1.getText();
			System.out.println(expected1);
			AssertJUnit.assertEquals(expected1,actual1);
		}else {

			//validating email address already taken
			String actual2="Newsletter : This email address is already registered.";
			WebElement alertMesg2 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/p[1]"));
			String expected2=alertMesg2.getText();
			System.out.println(expected2);
			AssertJUnit.assertEquals(expected2,actual2);  
		} */
		driver.quit();
	}

	//---------------------------------------------------------------------------------------------------------------

	//Scenario 4 : Social Media

	@When("Click on the social media icon")
	public void click_on_the_social_media_icon() {

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
	}

	@Then("User should be successfully navigated to media page")
	public void user_should_be_successfully_navigated_to_media_page() {

		//validating the media page
		String actualUrl = "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA";
		List<String> handles = new ArrayList<String> (driver.getWindowHandles());

		for (String handle1 : handles) {

			String url = driver.switchTo().window(handle1).getCurrentUrl();
			if(actualUrl.equals(url)) {

				System.out.println("User successfully navigated to media page");
			}
		} 
	}


	//---------------------------------------------------------------------------------------------------------------

	//Scenario 5 : ContactUs

	@When("User click on contact us button")
	public void user_click_on_contact_us_button() {

		//click on the contact us button
		driver.findElement(By.xpath("//div[@id='contact-link']//a[contains(text(),'Contact us')]")).click();

		//validate that user able to navigate contact us page on clicking Contact us button
		String  actualContactMesg ="CUSTOMER SERVICE - CONTACT US";
		WebElement mesg = driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']"));
		String expectedContactMesg = mesg.getText();
		AssertJUnit.assertEquals(expectedContactMesg,actualContactMesg);
	}

	String email_id= "bitbucket76@gmail.com";
	String mesg= "related casual dress products";

	@When("user enters valid credentials for message send")
	public void user_enters_valid_credentials_for_message_send() {

		//to select subject heading
		WebElement subjectHeading = driver.findElement(By.xpath("//select[@id='id_contact']"));
		Select selectSubHeading= new Select(subjectHeading);
		selectSubHeading.selectByVisibleText("Customer service");
		//enter email address
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email_id);
		//enter a message you want to send
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(mesg);	
	}

	@Then("Click on the send button")
	public void click_on_the_send_button() {

		//click on the send button
		driver.findElement(By.xpath("//span[contains(text(),'Send')]")).click();

		if(email_id.isEmpty()) {

			String actual_email_contactus ="Invalid email address.";
			WebElement email_error_contactus =driver.findElement(By.xpath("//li[contains(text(),'Invalid email address.')]"));
			String expected_email_contactus = email_error_contactus.getText();
			System.out.println("Warning : " +expected_email_contactus);
			AssertJUnit.assertEquals(expected_email_contactus,actual_email_contactus);
		}
		else if(mesg.isEmpty()){

			String actual_mesg_contactus ="The message cannot be blank.";
			WebElement mesg_error_contactus =driver.findElement(By.xpath("//li[contains(text(),'The message cannot be blank.')]"));
			String expected_mesg_contactus = mesg_error_contactus.getText();
			System.out.println("Warning : " +expected_mesg_contactus);
			AssertJUnit.assertEquals(expected_mesg_contactus,actual_mesg_contactus);

		}else {
			
			//validate that user get success message from their team after clicking send button
			String  actualMesgSend ="Your message has been successfully sent to our team.";
			WebElement mesg = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
			String expectedMesgSend = mesg.getText();
			AssertJUnit.assertEquals(expectedMesgSend,actualMesgSend);
			System.out.println("Message sent successfully...");
			driver.quit();
		}

	}
}
