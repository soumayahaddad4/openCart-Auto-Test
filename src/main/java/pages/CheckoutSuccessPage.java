package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSuccessPage {
	WebDriver driver;
	
	@FindBy(xpath="//h1")
	private WebElement SuccessOrderMessage;
	
	public CheckoutSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public String getMessageOrder() {
		return SuccessOrderMessage.getText();
	}
	
}
