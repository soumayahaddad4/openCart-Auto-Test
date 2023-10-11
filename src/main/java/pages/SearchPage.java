//dans ce package pages on definit les webelements , les localisateurs de chaque page: 
//c le POM ou le page factory usine des objets qui constituent les pages de notre projet
package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	// on ajoute cette partie, pour naviguer (back et forward) entre les pages de l'application 
	//sans exception error message: stale element exception; StaleElementReferenceException
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//annotations page factory
	//creer les webelements de la search page
	@FindBy(xpath="//div[@class='description']//a[text()='iMac']")
	private WebElement validProduct;
	@FindBy(xpath="//h2//following-sibling::p")
	private WebElement noProductMessage;
	
	
//On cree des methodes pour manipuler les webElements de cette page
	public String retrieveNoProductMessageText() {
		return noProductMessage.getText();
	}
	
	public void SelectProduct() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", validProduct);
        Thread.sleep(500);
        validProduct.click();
		
	}
	
	public boolean displayOfValidProduct() {
		return validProduct.isDisplayed();
	}

	
}
