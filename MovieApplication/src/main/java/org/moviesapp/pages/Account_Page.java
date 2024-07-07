package org.moviesapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Page {

	public WebDriver driver;
	
	public Account_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[starts-with(@alt,'profile')]")
	private WebElement profileBtn;
	@FindBy(xpath = "(//*[starts-with(@type,'button')])[3]")
	private WebElement logOut;
	
	public void Profile() {
		profileBtn.click();
	}
	public void Logout() {
		logOut.click();
	}
}
