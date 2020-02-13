package br.com.rsinet.bdd.appium.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "C:\\Users\\mateus.oliveira\\eclipse-workspace\\AdvantageAppiumBdd\\config.properties";
	private BufferedReader reader;

	public ConfigFileReader() {
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("*****");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties don't found in the path " + propertyFilePath);
		}

	}

	public String getDeviceName() {
		String deviceName = properties.getProperty("deviceName");
		if (deviceName != null)
			return deviceName;

		throw new RuntimeException("deviceName don't specify in the config.properties");

	}

	public String getDeviceId() {
		String deviceId = properties.getProperty("udid");
		if (deviceId != null)
			return deviceId;

		throw new RuntimeException(" deviceId don't specify in the config.properties");

	}

	public String getPlatformName() {
		String platformName = properties.getProperty("platformName");
		if (platformName != null)
			return platformName;

		throw new RuntimeException("platformName don't specify in the config.properties");

	}

	public String getPlatformVersion() {
		String platformVersion = properties.getProperty("platformVersion");
		if (platformVersion != null)
			return platformVersion;

		throw new RuntimeException("platformVersion don't specify in the config.properties");

	}

	public String getAppPackage() {
		String appPackage = properties.getProperty("appPackage");
		if (appPackage != null)
			return appPackage;

		throw new RuntimeException("appPackage don't specify in the config.properties");

	}

	public String getAppActivity() {
		String appActivity = properties.getProperty("appActivity");
		if (appActivity != null)
			return appActivity;

		throw new RuntimeException("appActivity don't specify in the config.properties");

	}

	public String getURL() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;

		throw new RuntimeException("url don't specify in the config.properties");
	}

	public String getReportConfigPath() {
		String path = properties.getProperty("reportPath");
		if (path != null)
			return path;

		throw new RuntimeException("Path don't specify in the config.properties");
	}

}
