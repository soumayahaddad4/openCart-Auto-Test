package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.CheckoutPage;
import pages.CheckoutSuccessPage;
import pages.LoginPage;
import pages.SearchPage;
import pages.ValidItemPage;

public class CheckoutSuccessTest extends Base {
	public WebDriver driver;

	// preconditions
	@BeforeMethod // avant chaque test
	public void setup() {
		driver = initialiserNavigateurEtOuvrirUrl(prop.getProperty("browserName"));

	}

	// postconditions
	@AfterMethod // apres chaque test
	public void tearDown() {
		driver.quit();
	}
	//Exigence no 08: l'utilisateur peut passer une commande 
	@Test
	public void CheckoutSuccess() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage = new AccountPage(driver);
		SearchPage searchPage = new SearchPage(driver);
		ValidItemPage validItemPage = new ValidItemPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		CheckoutSuccessPage checkoutSuccessPage= new CheckoutSuccessPage(driver);
		// login
		loginPage.clickMyAccount();
		loginPage.clickLoginMenu();
		loginPage.typeEmail(dataProp.getProperty("validEmail"));
		loginPage.typePassword(dataProp.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		//search a Valid Item and Checkout
		accountPage.searchItem(dataProp.getProperty("validSearchProduct"));
		Thread.sleep(2000);
		searchPage.SelectProduct();
		validItemPage.AddAndClickCheckout();
		if(checkoutPage.SelectAdress.isDisplayed() ){
			checkoutPage.Checkout();
		}
		else {
		checkoutPage.SaveAddressAndCheckout(dataProp.getProperty("FirstName"),dataProp.getProperty("lastName"),dataProp.getProperty("address1"),dataProp.getProperty("City"),dataProp.getProperty("CodePost"));
		}
		String actualMessage=checkoutSuccessPage.getMessageOrder();
		//Validate Success Checkout
		Assert.assertEquals(actualMessage,dataProp.getProperty("ActualMessagePlacedOrder"));
	
	}
	
	}

