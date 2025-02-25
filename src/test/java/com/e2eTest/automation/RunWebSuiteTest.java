package com.e2eTest.automation;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
@RunWith(Cucumber.class)
@CucumberOptions(
		
	features={"src/spec/feautures"},
	plugin={"pretty","html:target/report/cucumber-report.html","json:target/report/cucumber.json"},
	//glue={"src.test.java.com.e2eTest.automation.setp_definitions"},
	tags=("@Login_valid_credential"),
	monochrome=true,
	snippets=CAMELCASE
		)
public class RunWebSuiteTest {

}
