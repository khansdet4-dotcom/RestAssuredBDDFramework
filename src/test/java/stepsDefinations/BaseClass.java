package stepsDefinations;



import org.hamcrest.Matchers;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.GenericUtils;

public class BaseClass {
	RequestSpecification reqSpec;
	BaseUtil base;
	
	static String environment;
	static String url;
	
	public BaseClass(BaseUtil baseUtil) {
		this.base = baseUtil;
	}
	
	@BeforeAll
	public static void beforeAllScenarios() {
		System.out.println("------executing beforeAllScenarios -----------");
		environment = GenericUtils.getPropertyValue("global","environment");
		url = GenericUtils.getPropertyValue(environment,"URL");
	}
	
	@Before
	public void beforeScenario() {
		System.out.println("executes before Scenario");
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectHeader("Server",Matchers.equalTo("github.com"));
		RestAssured.responseSpecification = builder.build();
		RestAssured.baseURI = url;
		base.reqSpec = RestAssured.given();
	}
}
