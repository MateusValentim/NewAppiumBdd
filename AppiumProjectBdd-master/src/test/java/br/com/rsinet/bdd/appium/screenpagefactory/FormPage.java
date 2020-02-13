package br.com.rsinet.bdd.appium.screenpagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.bdd.appium.dataprovider.ConfigFileReader;
import br.com.rsinet.bdd.appium.utility.ScrollScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class FormPage {

	WebDriverWait wait;
	ConfigFileReader configFileReader;
	AppiumDriver<MobileElement> driver;
	ScrollScreen sc;

	public FormPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		sc = new ScrollScreen();
		wait = new WebDriverWait(this.driver, 10);
	}

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement fieldUserName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement fieldEmail;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement fieldPassword;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement fieldConfirmPassword;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement fieldFirstName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement fieldLastName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement fieldPhone;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewCountriesTitle")
	private WebElement fieldCountry;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement fieldCity;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement fieldAddress;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement fieldState;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement fieldPostalCode;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement fieldRegisterButton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement confirmLogin;

	public void userName(String sUserName) {
		wait.until(ExpectedConditions.visibilityOf(fieldUserName));
		fieldUserName.click();
		fieldUserName.sendKeys(sUserName);
	}

	public void email(String sEmail) {
		wait.until(ExpectedConditions.visibilityOf(fieldEmail));
		fieldEmail.click();
		fieldEmail.sendKeys(sEmail);
		driver.hideKeyboard();

	}

	public void password(String sPassword) {
		wait.until(ExpectedConditions.visibilityOf(fieldPassword)).click();
		fieldPassword.sendKeys(sPassword);
		driver.hideKeyboard();

	}

	public void confirmPass(String sConfirmPassword) {
		wait.until(ExpectedConditions.visibilityOf(fieldConfirmPassword)).click();
		driver.hideKeyboard();
		fieldConfirmPassword.sendKeys(sConfirmPassword);
	}

	public void firstName(String sFirstName) {

		wait.until(ExpectedConditions.elementToBeClickable(fieldFirstName)).sendKeys(sFirstName);

	}

	public void lastName(String sLastName) {
		wait.until(ExpectedConditions.elementToBeClickable(fieldLastName)).sendKeys(sLastName);
		TouchAction<?> touchAction = new TouchAction(driver);
		touchAction.press(PointOption.point(1053, 1743)).moveTo(PointOption.point(1050, 322)).perform();
	}

	public void phoneNumber(String sPhone) {
		wait.until(ExpectedConditions.elementToBeClickable(fieldPhone)).sendKeys(sPhone);

		@SuppressWarnings("rawtypes")
		TouchAction<?> touchAction = new TouchAction(driver);
		touchAction.press(PointOption.point(663, 1564)).moveTo(PointOption.point(646, 546)).perform();

	}

	@SuppressWarnings("rawtypes")
	public void country(String sCountry) {
		wait.until(ExpectedConditions.visibilityOf(fieldCountry)).click();
		ScrollScreen.scrollAndClick((AndroidDriver) driver, sCountry);

	}

	public void city(String sCity) {
		wait.until(ExpectedConditions.visibilityOf(fieldCity)).sendKeys(sCity);

	}

	public void address(String sAddress) {
		wait.until(ExpectedConditions.visibilityOf(fieldAddress)).sendKeys(sAddress);

	}

	public void state(String sState) {
		wait.until(ExpectedConditions.visibilityOf(fieldState)).sendKeys(sState);

	}

	public void postalCode(String sPostalCode) {
		wait.until(ExpectedConditions.visibilityOf(fieldPostalCode)).sendKeys(sPostalCode);

	}

	public void registerButton() {
		wait.until(ExpectedConditions.elementToBeClickable(fieldRegisterButton)).click();

	}

	public WebElement takeUserName() {
		wait.until(ExpectedConditions.visibilityOf(confirmLogin));
		return fieldUserName;
	}

	public boolean askCorrectPassword(String incorrectPass) {

		if (driver.getPageSource().contains(incorrectPass))
			return true;
		return false;
	}

}
