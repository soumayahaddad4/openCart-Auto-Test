package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='d-none d-md-inline' and text()='My Account']")
	private WebElement MyAccount;
	
	@FindBy(xpath="//a[@href='http://localhost/opencart/upload/index.php?route=account/login&language=en-gb']")
	private WebElement LoginMenu;
	
	@FindBy(xpath="//a[@href='http://localhost/opencart/upload/index.php?route=account/register&language=en-gb']")
	private WebElement RegisterMenu;
	
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	@FindBy(id="input-password")
	private WebElement passWord;
	
	@FindBy(css="button[type='submit']")
	private WebElement loginButton;
	
	@FindBy(css="alert-dismissible")
	private WebElement warningLogin;
	
	@FindBy(linkText="Forgotten Password")
	private WebElement forgotYourPassword;
	
	@FindBy(xpath="//div[text()=' Success: Your password has been successfully updated. ']")
	private WebElement updatePasswordAlert;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickMyAccount() {
		MyAccount.click();
	}
	public void clickLoginMenu() {
		LoginMenu.click();
	}
	
	public void clickRegisterMenu() {
		RegisterMenu.click();
	}
	public void typeEmail(String email) {
		emailAddress.sendKeys(email);
	}
	public void typePassword(String password) {
		passWord.sendKeys(password);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public String getErrorLoginMessage() {
		return warningLogin.getText();
	}
	public void clickforgotPassword() {
		forgotYourPassword.click();
	}
	
	public String getAlertUpdatePassword() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		 WebElement alert = wait.until(ExpectedConditions.visibilityOf(updatePasswordAlert));
		    
		return updatePasswordAlert.getText();
	}
	
	//methode pour regrouper les elements, pour notre fonctionalite login
	public void login(String eMail, String pass) {
		emailAddress.sendKeys(eMail);
		passWord.sendKeys(pass);
		loginButton.click();
		
	}
 public void GererAlerte(WebDriver driver) {
	 if(driver.getWindowHandles().size()>1)
	 {System.out.println("--------------------------"+driver.getWindowHandles().size()+"--------------------------------");
		 driver.switchTo().alert().accept();
	 driver.getWindowHandle();}
 }
	
}
