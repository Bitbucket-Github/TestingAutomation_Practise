package stepdefinitionpackage;

import io.cucumber.java.en.*;

public class sample {
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
	    System.out.println("given");
	}

	@When("I complete action")
	public void i_complete_action() {
		 System.out.println("when");
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		 System.out.println("then");
	}


}
