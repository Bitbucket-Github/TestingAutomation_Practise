package stepdefinitionpackage;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class MyStoreSearchStepDefinition {
	WebDriver driver;
	@Given("User opens the chromebrowser")
	public void user_opens_the_chromebrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Guest\\eclipse-workspace2\\MyStore\\drivers\\chromedriver.exe" );
		   driver =new ChromeDriver();
		   //driver.manage().window().maximize();
		   Thread.sleep(1000);
	}

	@And("user navigate to the application")
	public void user_navigate_to_the_application() {
		driver.navigate().to("http://automationpractice.com/index.php");
	}
//Searching a product through search bar
	@When("user searches for the product")
	public void user_searches_for_the_product() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirts");
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		Thread.sleep(3000);
		}

	@Then("the search result page is displayed")
	public void the_search_result_page_is_displayed() throws InterruptedException {
		boolean eleSearch= driver.findElement(By.className("lighter")).isDisplayed();
		System.out.print("search result is displayed:"+eleSearch);
		Thread.sleep(3000);
	    //driver.close();
		}
//Searching a product by navigator
	@When("user points on anyone category")
	public void user_points_on_anyone_category() throws InterruptedException {
		WebElement target = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(target).build().perform();
		Thread.sleep(3000);	   
	}

	@And("user select the subcategory")
	public void user_select_the_subcategory() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")).click();
		boolean eleSearch= driver.findElement(By.className("cat-name")).isDisplayed();
		System.out.print("search result is displayed:"+eleSearch);
		Thread.sleep(3000);
		driver.close();
	}

}
