package org.moviesapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PopularPage {

	public WebDriver driver;
	
	public PopularPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[starts-with(@class,'movie-image')]")
	private WebElement movieImages;
	
	public void getMovies() {
		List<WebElement> movieImage = driver.findElements(By.xpath("//img[starts-with(@class,'movie-image')]"));
		for (WebElement webElement : movieImage) {
			System.out.println(webElement.getAttribute("alt"));
		}
	}
	public void checkMoviesDisplayed() {
		Assert.assertTrue(movieImages.isDisplayed());
	}
}
