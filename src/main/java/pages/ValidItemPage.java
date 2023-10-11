package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidItemPage {
WebDriver driver;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement AddToCart;
	@FindBy(xpath="//button[@*='dropdown']")
	private WebElement ItemsInCart;
	@FindBy(xpath="//*[text()=' Checkout']")
	private WebElement Checkout;
	//page factory
	public ValidItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickAddToCart() {
		AddToCart.click();
	}
	public void clickToViewItemsInCart() {
		ItemsInCart.click();
	}
	public void AddAndClickCheckout() throws InterruptedException {
		Thread.sleep(1000);
		AddToCart.click();
		Thread.sleep(10000);
		ItemsInCart.click();
		Thread.sleep(500);
		Checkout.click();
		Thread.sleep(500);
	}
	
}
