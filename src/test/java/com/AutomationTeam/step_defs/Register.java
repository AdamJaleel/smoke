package com.AutomationTeam.step_defs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;

import com.AutomationTeam.pages.HomePage;
import com.AutomationTeam.utilities.Base;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register extends Base {

	HomePage hp = new HomePage();
	
	@Given("^I am on homepage$")
	public void i_am_on_homepage() throws Throwable {
		driver.get("http://automationpractice.com/index.php");
	}

	@When("^I click on sign$")
	public void i_click_on_sign() throws Throwable {
		hp.signIn.click();
	}

	@Then("^I create an account$")
	public void i_create_an_account() throws Throwable {
		driver.findElement(By.id("email_create")).sendKeys("josh@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);
		String createAccount = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
		
		try{
		assertEquals("CREATE AN ACCOUNT", createAccount);
		}catch(Exception e){
			fail("does not exist");
		}
		}

}
