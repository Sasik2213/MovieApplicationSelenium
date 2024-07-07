package org.moviesapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

	public WebDriver driver;

	public HeaderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Pop")
	private WebElement popularBtn;
	
	@FindBy(xpath = "//img[contains(@class,'avatar-img')]")
	private WebElement profilePicLogo;
	
	public void Profile() {
		profilePicLogo.click();
	}

	public void getNavbarInfo() {

		List<WebElement> x = driver.findElements(By.xpath("//*[starts-with(@class,'nav-link')]"));
		for (WebElement webElement : x) {
			System.out.println(webElement.getAttribute("text"));
		}
	}
	
	public void Popular() {
		popularBtn.click();
	}
	
	
}
