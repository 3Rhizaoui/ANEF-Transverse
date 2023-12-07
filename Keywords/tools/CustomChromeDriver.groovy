package tools

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.UnexpectedAlertBehaviour as UnexpectedAlertBehaviour
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.remote.CapabilityType as CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver
import internal.GlobalVariable as GlobalVariable


public class CustomChromeDriver {
	public static void createChromeWebDriverCustomDownload(String downloadPath) {
		String projDir = RunConfiguration.getProjectDir()

		// add Chrome preferences
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>()
		chromePrefs.put("download.default_directory", downloadPath)
		chromePrefs.put("download.prompt_for_download", false)

		// specify path to ChromeDriver
		System.setProperty("webdriver.chrome.driver", projDir + "\\Drivers\\chromedriver.exe")
		ChromeOptions options = new ChromeOptions()
		options.setExperimentalOption("prefs", chromePrefs)

		// create web driver
		WebDriver driver = new ChromeDriver(options)

		// use your driver instead of default one
		DriverFactory.changeWebDriver(driver)
	}
}
