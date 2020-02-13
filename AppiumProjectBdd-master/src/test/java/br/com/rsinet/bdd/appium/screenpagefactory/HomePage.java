package br.com.rsinet.bdd.appium.screenpagefactory;

import java.time.Duration;

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
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HomePage {

	ConfigFileReader configFileReader;
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	ScrollScreen sc;

	public HomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(this.driver, 10);
		sc = new ScrollScreen();
	}

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement clickInitial;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView")
	private WebElement clickValid;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@content-desc=\"Laptops\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.ImageView")
	private WebElement notebookSelecionado;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement clickInitialConfirm;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement getUserName;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement getUserLogado;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewSingUpToday")
	private WebElement signUpToday;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement takeLupa;

	@FindBy(how = How.ID, using = "\"com.Advantage.aShopping:id/editTextSearch")
	private WebElement takePesquisar;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView")
	private WebElement clickChooseMice;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView")
	private WebElement productHomeNegative;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement userLogado;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")
	private WebElement clickSearchGlass;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewProduct")
	private WebElement clickProductGlass;

	public void writeGlass(String string) {
		wait.until(ExpectedConditions.visibilityOf(clickProductGlass)).click();
		clickProductGlass.sendKeys(string);
	}

	public void initClickPage() {
		clickInitial.click();
	}

	public void clickMicePositivo() {

		wait.pollingEvery(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(clickValid)).click();
	}

	public void clicandoParaPesquisa() {
		clickSearchGlass.click();
	}

	public void initClickPageConfirm() {
		wait.until(ExpectedConditions.elementToBeClickable(clickInitialConfirm)).click();

	}

	public void btnLogin() {
		getUserLogado.click();
	}

	public void btnSignUpToday() {
		signUpToday.click();
	}

	public void btnLupa() {
		takeLupa.click();
	}

	public void btnPesquisar() {
		takePesquisar.click();
	}

	public void clickProductNegative() {
		productHomeNegative.click();
	}

	public String takeConfirmLog() {
		wait.until(ExpectedConditions.visibilityOfAllElements(getUserLogado));
		return getUserLogado.getText();
	}

	public String getUserLogado() {
		wait.until(ExpectedConditions.visibilityOf(userLogado));
		return userLogado.getText();
	}

	public void selectNotebook() {

		wait.until(ExpectedConditions.elementToBeClickable(notebookSelecionado)).click();
	}

}
