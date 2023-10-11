package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.ForgotYourPasswordPage;
import pages.LoginPage;

public class ForgotYourPassword extends Base {
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
	//L utilisateur peut changer le mot de passe oublie
		@Test 
		public void ChangeForgottenPassword() {
			LoginPage loginPage = new LoginPage(driver);
			ForgotYourPasswordPage forgotYourPasswordPage= new ForgotYourPasswordPage(driver);
			loginPage.clickMyAccount();
			loginPage.clickLoginMenu();
			loginPage.clickforgotPassword();
			forgotYourPasswordPage.typeEmail(dataProp.getProperty("validEmail"));
			forgotYourPasswordPage.clickContinue();
			Assert.assertEquals(loginPage.getAlertUpdatePassword(),dataProp.getProperty("successUpdatePassword"));

		}
}