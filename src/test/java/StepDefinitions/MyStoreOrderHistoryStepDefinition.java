package StepDefinitions;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class MyStoreOrderHistoryStepDefinition {
	
	WebDriver driver;
	@Given("User opens browser")
	public void user_opens_browser() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\semacha\\Desktop\\git_repo\\TestingAutomation_Practise\\drivers\\chromedriver.exe" );
	   driver =new ChromeDriver();
	   //driver.manage().window().maximize();
	   Thread.sleep(1000);
	}

	@And("user navigate to yourlogo")
	public void user_navigate_to_yourlogo() {
	driver.navigate().to("http://automationpractice.com/index.php"); 
	}

	@When("user click on signin option")
	public void user_click_on_signin_option() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	Thread.sleep(9000);
	}

	@And("user enters valid credentials")
	public void user_enters_valid_credentials() {
	driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("bitbucket76@gmail.com ");
	driver.findElement(By.xpath("//*[@id=\'passwd\']")).sendKeys("Github123");
	}

	@Then("click on sign in button")
	public void click_on_sign_in_button() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
	driver.manage().window().maximize();
	//--------------------------------------------------------------------------------
	driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirts");
	driver.findElement(By.xpath("//button[@name='submit_search']")).click();
	Thread.sleep(3000);
	//driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")).click();
	//driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
	WebElement target1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
	Actions actions = new Actions(driver);
	actions.moveToElement(target1).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
	
	}//--
//-----------------------------------------------------------------------------------------------------
	@Given("user click cart")
	public void user_click_cart() {
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\Guest\\eclipse-workspace2\\MyStore\\drivers\\chromedriver.exe" );
   // driver =new ChromeDriver();
	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
	}

	@Given("user click on  checkout option")
	public void user_click_on_checkout_option() {
		driver.findElement(By.xpath("//*[@id=\"button_order_cart\"]/span"));
	}
	@Given("user click on proceed to checkout option")
	public void user_click_on_proceed_to_checkout_option() throws InterruptedException {
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();;
   	}

	@Given("again user click on proceed to checkout option")
	public void again_user_click_on_proceed_to_checkout_option() {
		WebElement checkbox = driver.findElement(By.id("cgv"));
		System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
		//WebElement checkbox = driver.findElement(By.id("checkboxId"));
		 
		//If the checkbox is unchecked then isSelected() will return false 
		//and NOT of false is true, hence we can click on checkbox
		if(!checkbox.isSelected())
		    checkbox.click();
		System.out.println("The checkbox is selection state is - " + checkbox.isSelected());
		driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
	}

	@Then("user selects PayBY Check option")
	public void user_selects_pay_by_check_option() {
		driver.findElement(By.xpath("//a[@class='cheque']")).click();
		
	}

	@Then("user click on i confirm my order")
	public void user_click_on_i_confirm_my_order() {
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
	}

	/*//product is already in cart
	@And("user click on order history and details")
	public void user_click_on_order_history_and_details() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();
    boolean eleOrderlist= driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).isDisplayed();
		System.out.print("search result is displayed:"+eleOrderlist);
		Thread.sleep(3000);
		driver.close();
	}*/
}
