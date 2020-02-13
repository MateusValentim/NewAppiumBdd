package br.com.rsinet.bdd.appium.utility;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollScreen {
	

	public static void scrollAndClick(AndroidDriver driver, String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();
	}

	public static void swipe(int fromX, int fromY, int toX, int toY, AndroidDriver driver) {

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(fromX, fromY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000))).moveTo(PointOption.point(toX, toY))
				.release().perform();
	}

	public static RemoteWebElement scrollAndClick(AndroidDriver<MobileElement> driver) {

		return null;
	}
}
