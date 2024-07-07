package org.moviesapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[contains(@alt,'login website logo')]")
	private WebElement websiteLogo;
	
	@FindBy(xpath = "//*[contains(@class,'sign-in-heading')]")
	private WebElement signInText;
	
	@FindBy(xpath = "(//*[contains(@class,'input-label')])[1]")
	private WebElement userNameLabel;
	
	@FindBy(xpath = "(//*[contains(@class,'input-label')])[2]")
	private WebElement passwordNameLabel;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement submitBtn;
	
	@FindBy(xpath = "(//*[contains(@class,'input-field')])[2]")
	private WebElement passwordFieldInput;
	
	@FindBy(xpath = "(//*[contains(@class,'input-field')])[1]")
	private WebElement userNameFieldInput;
	
	@FindBy(xpath = "//*[starts-with(@class,'nav-link')]")
	private WebElement navlinks;
	
	
	public void MovieAppLogin(String uname,String passcode) {
		userNameFieldInput.sendKeys(uname);
		passwordFieldInput.sendKeys(passcode);
		submitBtn.click();
	}
	public void Username(String text) {
		userNameFieldInput.sendKeys(text);
		submitBtn.click();
	}
	public void Password(String text) {
		passwordFieldInput.sendKeys(text);
	}
	public void isWebSiteLogoCheckPerformed() {
		Assert.assertTrue(websiteLogo.isDisplayed());
	}
	public void isSigninHeadCheckPerformed() {
		Assert.assertTrue(signInText.isDisplayed());
	}
	public String gettextFromUsernameInputLabel() {
		return userNameLabel.getText();
	}
	public String gettextFromPasswordLabel() {
		return passwordNameLabel.getText();
	}
	public void isLoginWorkingProperly() {
		submitBtn.isDisplayed();
	}
	public void performLogin() {
		submitBtn.click();
	}
	public void clearUsername() {
		userNameFieldInput.clear();
	}
	public void clearPassword() {
		passwordFieldInput.clear();
	}
}
