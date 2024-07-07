package org.moviesapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[starts-with(@class,'nav-link active-nav-link')]")
	private WebElement navText;
	@FindBy(xpath = "//*[contains(@class,'home-movie-heading')]")
	private WebElement bannerText;
	@FindBy(xpath = "//*[contains(@class,'movies-list-heading')]")
	private WebElement moviesListHead;
	@FindBy(xpath = "//*[contains(@class,'home-movie-play-button')]")
	private WebElement playBtn;
	@FindBy(xpath = "//*[starts-with(@class,'poster')]")
	private WebElement posterImg;
	
	public String getMoviesPosterNames() {
		return posterImg.getAttribute("alt");
	}
	public String getNavTex() {
		return navText.getText();
	}
	public String getBannerText() {
		return bannerText.getText();
	}
	public String getMoviesListHead() {
		return moviesListHead.getAttribute("alt");
	}
	public void checkforPlayButton() {
		Assert.assertTrue(playBtn.isDisplayed());
	}
}
