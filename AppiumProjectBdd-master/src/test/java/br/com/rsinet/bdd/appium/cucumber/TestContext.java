package br.com.rsinet.bdd.appium.cucumber;

import java.net.MalformedURLException;

import br.com.rsinet.bdd.appium.managers.AppDriverManager;
import br.com.rsinet.bdd.appium.managers.PageObjectManager;

public class TestContext {

	AppDriverManager manager;
	PageObjectManager pageObjectManager;

	public TestContext() throws MalformedURLException {
		manager = new AppDriverManager();
		pageObjectManager = new PageObjectManager(manager.takeDriver());
	}

	public AppDriverManager getWebDriverManager() {
		return manager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
