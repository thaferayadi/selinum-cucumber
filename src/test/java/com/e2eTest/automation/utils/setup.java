package com.e2eTest.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Setup {
	private static WebDriver driver;
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Setup.class.getName()); // Corrected Logger
																								// initialization

	/**
	 * Static method to initialize WebDriver based on the browser.
	 */
	@Before

	public void setWebDriver(Scenario scenario) {
		LOGGER.info("Scenario: " + scenario.getName() + " - Started -");

		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome"; // Default browser
		}

		switch (browser) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized"); // Fixed quotes here
			chromeOptions.addArguments("--disable-search-engine-choice-screen");
			setDriver(new ChromeDriver(chromeOptions));
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("platform", Platform.WIN11);
			setDriver(new FirefoxDriver(firefoxOptions));
			break;

		case "edge":
			setDriver(new EdgeDriver());
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
	}

	// GETTERS
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Setup.driver = driver;
	}

	// Corrected the method name and return type
	public static Logger getLogger() {
		return LOGGER;
	}
}
