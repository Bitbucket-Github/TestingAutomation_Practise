package stepdefinitions;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import util.ConfigReader;

public class Compare extends ConfigReader {

	// COMPARE
	public static WebDriver driver;

	@Given("user checks quantity total and shippind charge")
	public void user_checks_quantity_total_and_shippind_charge() throws Exception {


		//driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();

		driver.findElement(By.xpath(pro.getProperty("cart"))).click();

		driver.findElement(By.xpath("//*[@id=\"product_3_13_0_354295\"]/td[5]/input[2]")).getText();

		driver.findElement(By.xpath("//*[@id=\"product_1_1_0_354295\"]/td[5]/input[2]")).getText();
	}

	@When("user calculates total")
	public void user_calculates_total() {
		String prod1 = driver.findElement(By.xpath("//*[@id=\"product_price_3_13_354295\"]/span")).getText();

		String prod2 = driver.findElement(By.xpath("//*[@id=\"product_price_1_1_354295\"]/span")).getText();
		System.out.println("ok");
		//String total = driver.findElement(By.xpath("//*[@id=\"total_product\"]")).getText();

	}

	@And("validates total and total+tax")
	public void validates_total_and_total_tax() {

		double shipping = 2.00;
		String totalprod = driver.findElement(By.xpath("//*[@id=\"total_product\"]")).getText();

		String finaltotal = totalprod + Double.toString(shipping);

		System.out.println(finaltotal);

		String total = driver.findElement(By.xpath("//*[@id=\"total_price\"]")).getText();

		if (total == finaltotal) {
			System.out.println("compare successfull");
		} else {
			System.out.println("fail");
		}
	}

	@Then("result should be equal")
	public void result_should_be_equal() {
		System.out.println("go to checkout");
	}

}