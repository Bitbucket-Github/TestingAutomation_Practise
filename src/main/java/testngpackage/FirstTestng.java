package testngpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import org.testng.annotations.Test;

public class FirstTestng {
	@Test
	  public void testMethod() {
		  
		  System.out.println("Test Method");
	  }
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("after Method");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println(" Method");
	  }
	  

}

  
