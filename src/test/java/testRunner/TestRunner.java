package testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/features",
                 glue= "stepsDefinations",
                 snippets = SnippetType.CAMELCASE,
                 dryRun = false,
                //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
                 plugin = {
                         "pretty",
                         "html:cucumber-reports/cucumber-report.html",
                         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                 }
		)
public class TestRunner {	
	
	
	
//code for parallel testing
	
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
 