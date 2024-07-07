package org.movie.app.tests;

import java.time.Duration;
import java.util.List;

import org.moviesapp.pages.HeaderPage;
import org.moviesapp.pages.HomePage;
import org.moviesapp.pages.LoginPage;
import org.moviesapp.pages.PopularPage;
import org.moviesapp.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Index {

	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public HeaderPage headerPage;
	public PopularPage popularPage;
	public SearchPage searchPage;

	@BeforeTest
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qamoviesapp.ccbp.tech");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	/*
	 * @AfterTest public void close() { driver.quit(); }
	 */

	@Test
	public void LoginPageUI() throws Exception {
		loginPage = new LoginPage(driver);
		/* Test Whether the Website logo image is displayed */
		loginPage.isWebSiteLogoCheckPerformed();
		/* Test Whether the Heading text is "Login" */
		loginPage.isSigninHeadCheckPerformed();
		/* Test Whether the UserName label text is "UserName" */
		Assert.assertEquals(loginPage.gettextFromUsernameInputLabel(), "username".toUpperCase());
		/* Test Whether the Password label text is "Password" */
		Assert.assertEquals(loginPage.gettextFromPasswordLabel(), "password".toUpperCase());
		/* Test the Login Button */
		loginPage.isLoginWorkingProperly();
	}

	@Test
	public void LoginPage() throws Exception {
		loginPage = new LoginPage(driver);
		/* Test the login functionality with empty input fields */
		loginPage.performLogin();
		/* Test the login functionality with empty USERNAME */
		loginPage.Password("rahul@2021");
		loginPage.performLogin();
		loginPage.clearPassword();
		/* Test the login functionality with an empty PASSWORD */
		loginPage.Username("mrperfect");
		loginPage.performLogin();
		loginPage.clearUsername();
		/*
		 * Test the login functionality with Invalid Credentials (correct username and
		 * wrong password),
		 */
		loginPage.MovieAppLogin("hello", "world");
		loginPage.clearPassword();
		loginPage.clearUsername();
		/* Test the login functionality with Valid Credentials */
		loginPage.MovieAppLogin("rahul", "rahul@2021");

	}

	@Test
	public void HomePageTest() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.MovieAppLogin("rahul", "rahul@2021");
		System.out.println(homePage.getNavTex());
		System.out.println(homePage.getBannerText());
		List<WebElement> y = driver.findElements(By.xpath("//*[contains(@class,'movies-list-heading')]"));
		for (WebElement webElement : y) {
			System.out.println(webElement.getText());
		}
		homePage.checkforPlayButton();
		List<WebElement> z = driver.findElements(By.xpath("//img[starts-with(@class,'poster')]"));
		for (WebElement webElement : z) {
			System.out.println(webElement.getAttribute("alt"));
		}
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[starts-with(@class,'contact-us-paragraph')]")).isDisplayed());
	}
	
	@Test
	public void HeaderSectionUI() throws Exception {
		
		loginPage = new LoginPage(driver);
		headerPage = new HeaderPage(driver);
		loginPage.isWebSiteLogoCheckPerformed();
		loginPage.MovieAppLogin("rahul","rahul@2021");
		headerPage.getNavbarInfo();
	}
	
	@Test
	public void HeaderSectionFunctionalites() throws Exception {
		loginPage = new LoginPage(driver);
		headerPage = new HeaderPage(driver);
		loginPage.MovieAppLogin("rahul","rahul@2021");
		headerPage.Popular();
		headerPage.Profile();
		
	}
	@Test
	public void PopularPageUI() throws Exception {
		loginPage = new LoginPage(driver);
		headerPage = new HeaderPage(driver);
		popularPage = new PopularPage(driver);
		loginPage.MovieAppLogin("rahul","rahul@2021");
		headerPage.Popular();
		popularPage.getMovies();
		popularPage.checkMoviesDisplayed();
	}
	
	@Test
	public void SearchFunctionality() throws Exception {
		
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
		loginPage.MovieAppLogin("rahul", "rahul@2021");
		searchPage.clickSearch("a");
		driver.navigate().back();
		searchPage.clickSearch("sasi");
	}
	@Test
	public void MovieDetailsPage() throws Exception {
		
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		headerPage = new HeaderPage(driver);
		popularPage = new PopularPage(driver);
		loginPage.MovieAppLogin("rahul","rahul@2021");
		driver.findElement(By.xpath("//*[starts-with(@alt,'No Time to Die')]")).click();
		String a = driver.findElement(By.xpath("//*[starts-with(@class,'movie-overview')]")).getText();
		System.out.println(a);
		headerPage.Popular();
		driver.findElement(By.xpath("//*[starts-with(@alt,'The Amazing Spider-Man')]")).click();
		
	}

}
