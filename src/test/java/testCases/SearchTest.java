package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends Base {
	// on le cree a l'interieur de la class prq il soit accessible a ts les methodes
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

	// Exigence no 06: l'utilisateur est en mesure de rechercher des produits
	@Test
	public void SearchExistantItem() {
		LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage= new AccountPage(driver);
		SearchPage searchPage= new SearchPage(driver);
		// login
		loginPage.clickMyAccount();
		loginPage.clickLoginMenu();
		loginPage.typeEmail(dataProp.getProperty("validEmail"));
		loginPage.typePassword(dataProp.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		//research validSearchProduct
		accountPage.searchItem(dataProp.getProperty("validSearchProduct"));
		boolean resultStatus = searchPage.displayOfValidProduct();
		Assert.assertTrue(resultStatus);
	}

	//Exigence no 07: l'Utilisateur est informé lorsque le produit recherché n'est pas disponible 
	@Test
	public void SearchNonExistantItem() {
		LoginPage loginPage = new LoginPage(driver);
		AccountPage accountPage= new AccountPage(driver);
		SearchPage searchPage= new SearchPage(driver);
		// login
		loginPage.clickMyAccount();
		loginPage.clickLoginMenu();
		loginPage.typeEmail(dataProp.getProperty("validEmail"));
		loginPage.typePassword(dataProp.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		//research invalid Search Product
		accountPage.searchItem(dataProp.getProperty("invalidSearchProduct"));
		String messageSearch = searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(messageSearch, dataProp.getProperty("noResultSearch"));
	}
}
