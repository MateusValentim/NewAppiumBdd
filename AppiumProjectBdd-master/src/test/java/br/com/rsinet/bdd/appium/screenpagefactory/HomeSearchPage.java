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

public class HomeSearchPage {

	ConfigFileReader configFileReader;
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	public HomeSearchPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(this.driver, 10);
	}

	@FindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"Mice\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.ImageView")
	private WebElement selectProductExisting;

	@FindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"Headphones\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.ImageView")
	private WebElement clickChooseHeadPhone;

	@FindBy(id = "com.Advantage.aShopping:id/buttonProductAddToCart")
	private WebElement addToCart;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewCart")
	private WebElement addToCartCarrinhoSuperior;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText")
	private WebElement userNameToBuy;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText")
	private WebElement passwordToBuy;

	@FindBy(id = "com.Advantage.aShopping:id/buttonLogin")
	private WebElement btnLoginToBuy;

	@FindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\\\"Headphones\\\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[2]/android.widget.TextView")
	private WebElement clickProductInvalidHomeSearch;

	@FindBy(id = "com.Advantage.aShopping:id/textViewProductOutOfStock")
	private WebElement confirmSoldOut;

	@FindBy(id = "com.Advantage.aShopping:id/textViewNoProductsToShow")
	private WebElement noItemsInCart;

	public void selectProductType() {
		wait.until(ExpectedConditions.visibilityOf(selectProductExisting));
		selectProductExisting.click();
	}

	public void selectProductInvalidType() {
		wait.until(ExpectedConditions.visibilityOf(clickProductInvalidHomeSearch));
		clickProductInvalidHomeSearch.click();
	}

	public void clickChoose() {
		wait.until(ExpectedConditions.visibilityOf(clickChooseHeadPhone)).click();
	}

	public void addToCart() {
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
}
