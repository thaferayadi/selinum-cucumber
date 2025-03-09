package com.e2eTest.automation.Page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.e2eTest.automation.utils.BasePage;
import com.e2eTest.automation.utils.Setup;

public class Home extends BasePage {
	@FindBy(how = How.XPATH, using = "//a[contains(@class, 'oxd-main-menu-item') and contains(., 'Claim')]\r\n"
			+ "")
	private  WebElement btn;
	@FindBy(how = How.XPATH, using = "//div[@class='oxd-topbar-header-title']")
	private  WebElement menu ;
	public Home() {

		super(Setup.getDriver());
	}
	public  void clickHome() {

		btn.click();
	}
	public String getDashboard() {
		return menu.getText();
	} 
}
