package com.e2eTest.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Teardown {
	@After
	public void quitDriver(Scenario scenario) {
		if (Setup.getDriver() != null) {
			if (scenario.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "screenshot");
			}
			Setup.getDriver().quit();
			Setup.getLogger().info("Scenario: " + scenario.getName() + " Finished " + scenario.getStatus());

		}
	}
}