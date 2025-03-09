package com.e2eTest.automation.Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTest.automation.utils.BasePage;
import com.e2eTest.automation.utils.Setup;

public class Logout extends BasePage {
	
	@FindBy(how = How.NAME, using = "username")
	private  WebElement username;
	@FindBy(how = How.NAME, using = "password")
	private  WebElement password ;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Login']")
	private  WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//h6[normalize-space()='Dashboard']")
	private static WebElement menu_dashboard;
	
	@FindBy(how = How.XPATH, using = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private static WebElement listederoulante;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Logout']")
	private static WebElement btnLogout;
	
	@FindBy(how = How.XPATH, using = "//label[normalize-space()='Username']")
	private static WebElement verifyLogout;
	// Constructor /
	public Logout() {

		super(Setup.getDriver());
	}

	// Methods /
	public  void fillUsername(String name) {

		username.sendKeys(name);
	}

	public  void fillPassword(String pswd) {

		password.sendKeys(pswd);
	}

	public  void clickBtnLogin() {

		btnLogin.click();
	}
	public String getDashboardTitle() {
		return menu_dashboard.getText();
	}
	public void  clickListederoulante() {
		listederoulante.click();
	}
	public void  clickBtnLogout()  {
		btnLogout.click();
	
	}
	public String getVerifyLogout() {
		return verifyLogout.getText();
	}

	
}
