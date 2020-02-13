package br.com.rsinet.bdd.appium.managers;

import br.com.rsinet.bdd.appium.screenpagefactory.FormPage;
import br.com.rsinet.bdd.appium.screenpagefactory.GlassPage;
import br.com.rsinet.bdd.appium.screenpagefactory.HomePage;
import br.com.rsinet.bdd.appium.screenpagefactory.HomeSearchPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectManager {

	private AppiumDriver<MobileElement> driver;
	private HomePage homePage;
	private FormPage formPage;
	private GlassPage glassPage;
	private HomeSearchPage homeSearchPage;

	public PageObjectManager(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public FormPage getFormPage() {
		return (formPage == null) ? formPage = new FormPage(driver) : formPage;
	}

	public GlassPage getGlassPage() {
		return (glassPage == null) ? glassPage = new GlassPage(driver) : glassPage;
	}

	public HomeSearchPage getHomeSearchPage() {
		return (homeSearchPage == null) ? homeSearchPage = new HomeSearchPage(driver) : homeSearchPage;
	}
}
