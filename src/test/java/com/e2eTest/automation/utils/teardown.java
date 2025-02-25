package com.e2eTest.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.Scenario;

public class teardown {
  
	public void quitDriver(Scenario scenario) {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) setup.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");

		}
	setup.getDriver().quit();
		setup.getLogger().info("Scenario: " + scenario.getName() + "Finished" + scenario.getStatus());

	}
	
}
