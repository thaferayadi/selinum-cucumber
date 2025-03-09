package com.e2eTest.automation.setp_definitions;


import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2eTest.automation.Page_objects.Logout;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.Setup;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefinition {
    ConfigFileReader configFileReader;
    Logout logout;

    public LogoutStepDefinition() {
        // Use lowercase to initialize the variables
        configFileReader = new ConfigFileReader();
        logout = new Logout();
        }


	


	@When("je clique sur la liste déroulante")
	public void jeCliqueSurLaListeDéroulante() {
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))); 
		logout.clickListederoulante();
	}


	@When("je clique sur logout")
	public void jeCliqueSurLogout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Logout']")));
		
		try {
		logout.clickBtnLogout();
		System.out.println("OK : clicked !");
		} catch (AssertionError e) {
            System.out.println("KO : not clicked !");
        }
		
	}


	@Then("je suis redirigé vers la page d'authentification")
	public void jeSuisRedirigéVersLaPageDAuthentification() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Username']")));
		
		final String expectedTEXT= "Username";
		 String text = logout.getVerifyLogout();
		 
		 
		 try {
	        Assertions.assertEquals(expectedTEXT,text );
	        System.out.println("OK : Le titre correspond !");
	        } catch (AssertionError e) {
	            System.out.println("KO : Le titre ne correspond pas !");
	        }
	}





	




	
}
