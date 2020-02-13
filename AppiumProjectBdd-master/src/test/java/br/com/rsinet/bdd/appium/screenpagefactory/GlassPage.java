package br.com.rsinet.bdd.appium.screenpagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.bdd.appium.dataprovider.ConfigFileReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GlassPage {

	ConfigFileReader configFileReader;
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	public GlassPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		configFileReader = new ConfigFileReader();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.Advantage.aShopping:id/imageViewProduct")
	private WebElement clickProductGlass;

	@FindBy(id = "com.Advantage.aShopping:id/buttonProductAddToCart")
	private WebElement addToCart;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText")
	private WebElement userNameToBuy;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText")
	private WebElement passwordToBuy;

	@FindBy(id = "com.Advantage.aShopping:id/buttonLogin")
	private WebElement btnLoginToBuy;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewProduct")
	private WebElement clickProductSelectGlass;

	@FindBy(id = "com.Advantage.aShopping:id/textViewNoProductsToShow")
	private WebElement nothingFound;

	public void writeGlass(String produto) {
		wait.until(ExpectedConditions.visibilityOf(clickProductGlass)).sendKeys(produto);
	}

	public void clickProductSelectedGlass() {
		wait.until(ExpectedConditions.visibilityOf(clickProductSelectGlass));
		clickProductSelectGlass.click();
	}

	public void addTo() {
		wait.until(ExpectedConditions.visibilityOf(addToCart));
		addToCart.click();
	}

	public void userNameToBuy(String suserName) {
		wait.until(ExpectedConditions.visibilityOf(userNameToBuy));
		userNameToBuy.sendKeys(suserName);
	}

	public void passwordToBuy(String spassword) {
		wait.until(ExpectedConditions.visibilityOf(passwordToBuy));
		passwordToBuy.sendKeys(spassword);
	}

	public void loginClickTo() {
		wait.until(ExpectedConditions.visibilityOf(btnLoginToBuy));
		btnLoginToBuy.click();
	}

	public boolean messageNothingFound(String texto) {
		wait.until(ExpectedConditions.textToBePresentInElement(nothingFound, "- No results for \"" + texto + "\" -"));
		if (driver.getPageSource().contains("- No results for \"" + texto + "\" -")) {
			return true;
		}
		return false;
	}
}
