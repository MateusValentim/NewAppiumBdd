package br.com.rsinet.bdd.appium.managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppDriverManager {

	private AppiumDriver<MobileElement> driver;
	private DesiredCapabilities caps;

	public AppiumDriver<MobileElement> takeDriver() throws MalformedURLException {
		if (driver == null)
			driver = startDriver();
		return driver;
	}

	private AppiumDriver<MobileElement> startDriver() throws MalformedURLException {
		caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "RsiBdd");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("appPackage", "com.Advantage.aShopping");
		caps.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, caps);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public void closeDriver() {
		if (driver == null) {
			throw new NullPointerException("Driver don't started");
		}

		driver.quit();
	}
}
