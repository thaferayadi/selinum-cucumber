package com.e2eTest.automation.setp_definitions;

import com.e2eTest.automation.Page_objects.LoginPage;
import com.e2eTest.automation.utils.ConfigFileReader;
import com.e2eTest.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {

    // Use lowercase for instance variables
    ConfigFileReader configFileReader;
    LoginPage loginPage;  

    public LoginStepDefinition() {
        // Use lowercase to initialize the variables
        configFileReader = new ConfigFileReader();
        loginPage=new LoginPage();
    }

    @Given("je me connecte sur l'application Orange")
    public void jeMeConnecteSurLApplicationOrange() throws InterruptedException {
        Setup.getDriver().get(configFileReader.getProperty("home.url"));
        WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));        
    
    }
    
    
	@When("Je saisis le username {string}")
	public void jeSaisisLeUsername(String username) {
    	loginPage.fillUsername(username); // Use the instance variable here
    }

	  @When("Je saisis le mot de passe {string}")
	    public void jeSaisisLeMotDePasse(String password) {
    	loginPage.fillPassword(password); // Use the instance variable here
    }

	    @When("je clique sur le bouton login")
	    public void jeCliqueSurLeBoutonLogin() throws InterruptedException {
	    	
    	loginPage.clickBtnLogin(); 
    }



@Then("redirection vers la page Dashboard")
public void redirectionVersLaPageDashboard() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")));
	   
	    final String expectedTEXT="Dashboard";
        String txtPage = loginPage.getDashboardTitle();
        
        try {
        	 Thread.sleep(3000);
            Assertions.assertEquals(expectedTEXT, txtPage);
            System.out.println("OK : Le titre correspond !");
        } catch (AssertionError e) {
            System.out.println("KO : Le titre ne correspond pas !");
        }

        
            

        

    }
    
    

    }





