package com.AutomationTeam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationTeam.utilities.Base;

public class HomePage extends Base {
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Sign in")
	public WebElement signIn;

}
