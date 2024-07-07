package org.moviesapp.pages;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[starts-with(@class,'search-empty-button')]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//*[starts-with(@class,'search-input-field')]")
	private WebElement searchInputText;
	
	@FindBy(xpath = "//*[contains(@class,'search-button')]")
	private WebElement actualSearchBtn;
	
	public void clickSearch(String text) {
		searchBtn.click();
		searchInputText.sendKeys(text);
		actualSearchBtn.click();
		searchInputText.sendKeys(Keys.BACK_SPACE);
	}
	
}
