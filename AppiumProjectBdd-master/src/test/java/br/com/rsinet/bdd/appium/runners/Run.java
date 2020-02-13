package br.com.rsinet.bdd.appium.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.rsinet.bdd.appium.managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature", monochrome = true, glue = { "br.com.rsinet.bdd.appium.steps" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/report.html" })

public class Run {

	@AfterClass
	public static void performingTheLogExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));

	}

}
