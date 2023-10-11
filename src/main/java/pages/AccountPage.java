package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccount;
	@FindBy(linkText = "Change your password")
	private WebElement changeYourPassword;
	@FindBy(linkText = "Modify your address book entries")
	private WebElement modifyYourAddress;
	@FindBy(linkText = "Modify your wish list")
	private WebElement modifyYourWishList;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchField;
	@FindBy(xpath = "//input[@name='search']/following-sibling::button")
	private WebElement searchButton;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void searchItem(String item) {
		searchField.sendKeys(item);
		searchButton.click();
	}
	
	
	
}
