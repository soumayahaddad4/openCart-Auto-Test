package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;
import utils.Utilities;

public class LoginTest extends Base {

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

	@Test
	public void verifyLoginWithValidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		// creer un cas de test a partir d'un objet cree precedemment
		loginPage.clickMyAccount();
		loginPage.clickLoginMenu();
		loginPage.typeEmail(dataProp.getProperty("validEmail"));
		loginPage.typePassword(dataProp.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
	}
	@Test (priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentialsDDT(String email, String password) {
		LoginPage loginPage = new LoginPage(driver);
	
		// ramener les donnees valides a partir d'un fichier excel
		loginPage.clickMyAccount();
		loginPage.clickLoginMenu();
		loginPage.typeEmail(email);
		loginPage.typePassword(password);
		loginPage.clickOnLoginButton();
	}
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() throws Exception {
		
		Object[][] data = Utilities.getDataFromExcel("Login");
		return data;
	}
	@Test(priority=2)
	public void verifyLoginWithinValidCredentials() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		 String mailstamp= Utilities.generateTimeStamp();
		// le mail est généré avec timestimp
		loginPage.clickMyAccount();
		loginPage.clickLoginMenu();
		loginPage.typeEmail(mailstamp);
		loginPage.typePassword(dataProp.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		Thread.sleep(500);
		Assert.assertEquals(loginPage.getErrorLoginMessage(), dataProp.getProperty("emailLoginWarning"));
	}
}
