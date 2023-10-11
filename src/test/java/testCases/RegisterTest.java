package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import pages.AccountSuccessPage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends Base {

	// on le cree a l'interieur de la class prq il soit accessible a ts les methodes
	public WebDriver driver;

	// preconditions
	@BeforeMethod // avant chaque test
	public void setup() {
		driver = initialiserNavigateurEtOuvrirUrl(prop.getProperty("browserName"));

	}      

	// postconditions
	/*@AfterMethod // apres chaque test
	public void tearDown() {
		driver.quit();
	}  */
//Exigence No 01: L'utilisateur peut s'inscrire dans l'application en fournissant tous les champs Obligatoires.
	@Test (priority=1)
	public void RegisterWithRequiredField(){
		RegisterPage registerPage = new RegisterPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		loginPage.clickMyAccount();
		loginPage.clickRegisterMenu();
		registerPage.registerWithAllRequiredFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),dataProp.getProperty("email"),(dataProp.getProperty("password")));
		registerPage.agreePolicy();
		registerPage.clickOnContinueButton();
		boolean displaStatus = accountSuccessPage.getDisplayStatusOfEditYourAccountInformationOption();
		//Assert.assertTrue(displaStatus);
	}
	//Exigence no 02: l'utilisateur peut s'inscrire à l'application en optant pour l'abonnement à la Newsletter 
	
	@Test (priority=2)
	public void RegisterWithRequiredFieldAndSubscribe(){
		RegisterPage registerPage = new RegisterPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		loginPage.clickMyAccount();
		loginPage.clickRegisterMenu();
		registerPage.registerWithAllRequiredFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),dataProp.getProperty("email"),(dataProp.getProperty("password")));
		registerPage.selectSubscribe(); //selectionner subscribe
		registerPage.agreePolicy();
		registerPage.clickOnContinueButton();
		boolean displaStatus = accountSuccessPage.getDisplayStatusOfEditYourAccountInformationOption();
		//Assert.assertTrue(displaStatus);

	}
	//xigence no 03 : L'utilisateur ne peut pas enregistrer un compte en double. 
	@Test (priority=3)
	public void RegisterWithDoubleInformationField(){
		RegisterPage registerPage = new RegisterPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		//AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		loginPage.clickMyAccount();
		loginPage.clickRegisterMenu();
		registerPage.registerWithAllRequiredFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),dataProp.getProperty("email"),(dataProp.getProperty("password")));
		registerPage.agreePolicy();
		registerPage.clickOnContinueButton();
		//Assert.assertEquals(registerPage.getWarningDoubleRegister(),dataProp.getProperty("warningDoubleRegister"));
	}	
	
	}
	
	

