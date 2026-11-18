package stepsDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.GenericUtils;

public class PostStepDefination {
	
	BaseUtil base;
	RequestSpecification reqSpec;
	public PostStepDefination(BaseUtil bu) {
		this.base =bu;
		this.reqSpec = bu.reqSpec;
	}

	@Given("I use Authorization")
	public void i_use_authorization() {
	    String token = GenericUtils.getPropertyValue(BaseClass.environment, "Token");
	    base.reqSpec.header("Authorization",token);
	}
	@Given("body param from file {string}")
	public void body_param_from_file(String filename) throws FileNotFoundException {
	    System.out.println("Eexcuting given post method");
	    FileInputStream fis = new FileInputStream("src/test/resources/inputJSON/"+filename);
	    base.reqSpec.body(fis).contentType(ContentType.JSON).log().all();
	}

	@When("I do a POST request with url {string}")
	public void i_do_a_post_request_with_url(String url) {
		base.res = base.reqSpec.post(url);
	}

	@Then("validate Status Code is {int}")
	public void validate_status_code_is(Integer ststuscode) {
	    System.out.println("Executing then method");
	    base.res.then() .statusCode(ststuscode).log().all();
	}
}
