package com.AutomationTeam.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	
	private WebDriver driver;
	
	@Before
	public void setUp(){
		if(driver == null){
			System.setProperty("webdriver.chrome.driver", 
					"/Users/Smirjalilov/Documents/Selenium/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}
		Base.driver = driver;
	}
	
	@After
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()){
			final byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(
					OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			
		}
		//driver.quit();
	}

}
