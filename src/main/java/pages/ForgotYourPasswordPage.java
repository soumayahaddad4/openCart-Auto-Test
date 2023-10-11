package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotYourPasswordPage {
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement ContinueButton;
	
	@FindBy (xpath="//button[@class='btn-close']")
	private WebElement btnCloseMessageUpdate;
	
	public ForgotYourPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void typeEmail(String email) {
		emailField.sendKeys(email);
	}
	public void clickContinue() {
		ContinueButton.click();
	}
	
	public void clickClose_Success_Update() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	    WebElement bouton = wait.until(ExpectedConditions.visibilityOf(btnCloseMessageUpdate));
	    bouton.click();
	}
}
