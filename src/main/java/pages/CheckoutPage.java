package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;
	// Adress Fields
	@FindBy(css = "#input-shipping-firstname")
	private WebElement FirstNameField;
	@FindBy(css = "#input-shipping-lastname")
	private WebElement LastNameField;
	@FindBy(xpath = "//input[@id='input-shipping-postcode']")
	private WebElement PostCodeField;
	@FindBy(xpath = "//input[@id='input-shipping-address-1']")
	private WebElement Address1Field;
	@FindBy(xpath = "//input[@id='input-shipping-city']")
	private WebElement CityField;
	@FindBy(xpath = "//select[@id='input-shipping-country']")
	private WebElement CountrySelector;
	@FindBy(xpath = "//option[text()='Canada']")
	private WebElement SelectCanadaOption;
	@FindBy(xpath = "//select[@id='input-shipping-zone']")
	private WebElement SelectorRegionField;
	@FindBy(xpath = "//option[text()='Québec']")
	private WebElement SelectQcOption;
	@FindBy(xpath = "//button[@id='button-shipping-address']")
	private WebElement ContinueButtonAddress;
	
	// Adress
	@FindBy(xpath = "//button[@class='btn-close']")
	private WebElement CloseAlertBtn;
	@FindBy(xpath = "//select[@name='address_id']")
	public WebElement SelectAdress;
	@FindBy(xpath = "//select[@name='address_id']/option[@value='2']")
	private WebElement SelectAdressOptionOne;
	// chipping
	@FindBy(xpath = "//button[@id='button-shipping-methods']")
	private WebElement ChooseShippingMethod;
	@FindBy(xpath = "//input[@type='radio' and@name='shipping_method']")
	private WebElement RadioFlatShippingRate;
	@FindBy(xpath = "//button[@type='submit' and @id='button-shipping-method']")
	private WebElement ContinueShippingMethod;
	// payement
	@FindBy(xpath = "//button[ @id='button-payment-methods']")
	private WebElement ChoosePaymentMethod;
	@FindBy(xpath = "//input[@type='radio' and@name='payment_method']")
	private WebElement RadioCashOnDelevery;
	@FindBy(xpath = "//button[@type='submit' and @id='button-payment-method']")
	private WebElement ContinuePaymentMethod;
	@FindBy(xpath = "//button[text()='Confirm Order']")
	private WebElement ConfirmOrder;

	// PageFactory
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods Checkout avec Address Enregistré
	public void Checkout() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		SelectAdress.click();
		SelectAdressOptionOne.click();
		//CloseAlertBtn.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ChooseShippingMethod);
		ChooseShippingMethod.click();
		Thread.sleep(5000);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", RadioFlatShippingRate);
		RadioFlatShippingRate.click();
		Thread.sleep(5000);
		ContinueShippingMethod.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ChoosePaymentMethod);
		ChoosePaymentMethod.click();
		Thread.sleep(5000);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", RadioCashOnDelevery);
		RadioCashOnDelevery.click();
		Thread.sleep(5000);
		ContinuePaymentMethod.click();
		Thread.sleep(5000);
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ConfirmOrder);	
		ConfirmOrder.click();
		
		
	}

	// Methods enregistrement addresse et Checkout
	public void SaveAddressAndCheckout(String FirstName, String lastName, String address1, String City,
			String CodePost) {
		// SaveAddress
		FirstNameField.sendKeys(FirstName);
		LastNameField.sendKeys(lastName);
		Address1Field.sendKeys(address1);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView();", CityField);
		CityField.sendKeys(City);
		PostCodeField.sendKeys(CodePost);
		CountrySelector.click();
		SelectCanadaOption.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", SelectorRegionField);
		SelectorRegionField.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", SelectQcOption);
		SelectQcOption.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ContinueButtonAddress);
		ContinueButtonAddress.click();
		// Checkout
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ChooseShippingMethod);
		ChooseShippingMethod.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", RadioFlatShippingRate);
		RadioFlatShippingRate.click();
		ContinueShippingMethod.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ChoosePaymentMethod);
		ChoosePaymentMethod.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", RadioCashOnDelevery);
		RadioCashOnDelevery.click();
		ContinuePaymentMethod.click();
		jsExecutor.executeScript("arguments[0].scrollIntoView();", ConfirmOrder);

		ConfirmOrder.click();

	}
}
