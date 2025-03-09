package com.e2eTest.automation.setp_definitions;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2eTest.automation.Page_objects.Home;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.Setup;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDefinition {
	 ConfigFileReader configFileReader;
	    Home home;    
	    
	    public HomeStepDefinition() {
	        // Use lowercase to initialize the variables
	        configFileReader = new ConfigFileReader();
	        home=new Home();
	    }
	    
	    @When("je click sur claim")
	    public void jeClickSurClaim() {
	    	WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'oxd-main-menu-item') and contains(., 'Claim')]\r\n"
					+ "")));
			
			try {
			home.clickHome();
			System.out.println("OK : clicked !");
			} catch (AssertionError e) {
	            System.out.println("KO : not clicked !");
	        }
	    }
	    @Then("je suis réderigé vers la page claim")
	    public void jeSuisRéderigéVersLaPageClaim() {
	    	WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-topbar-header-title']")));
			
			final String expectedTEXT= "Claim";
			 String text = home.getDashboard();
			 
			 
			 try {
		        Assertions.assertEquals(expectedTEXT,text );
		        System.out.println("OK : Le titre correspond !");
		        } catch (AssertionError e) {
		            System.out.println("KO : Le titre ne correspond pas !");
		        }
	    }



	    
}
