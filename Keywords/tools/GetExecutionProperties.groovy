package tools

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By.ByCssSelector
import com.github.kklisura.cdt.protocol.commands.Emulation as Emulation
import com.github.kklisura.cdt.protocol.commands.Page as Page
import com.github.kklisura.cdt.protocol.commands.Network as Network
import com.github.kklisura.cdt.protocol.commands.Log as Log
import com.github.kklisura.cdt.protocol.commands.Overlay as Overlay
import com.github.kklisura.cdt.protocol.commands.DOM as DOM
import com.github.kklisura.cdt.protocol.types.dom.PerformSearch
import com.github.kklisura.cdt.protocol.types.dom.RGBA
import com.github.kklisura.cdt.protocol.types.network.ErrorReason as ErrorReason
import com.github.kklisura.cdt.protocol.types.network.RequestPattern as RequestPattern
import com.github.kklisura.cdt.protocol.types.overlay.HighlightConfig
import com.github.kklisura.cdt.protocol.types.page.CaptureScreenshotFormat as CaptureScreenshotFormat
import com.github.kklisura.cdt.services.ChromeDevToolsService as ChromeDevToolsService
import com.github.kklisura.cdt.protocol.events.network.DataReceived as DataReceived
import com.katalon.cdp.CdpUtils as CdpUtils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import java.awt.Color
import java.awt.Rectangle
import groovy.json.JsonOutput as JsonOutput
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.types.ChromeTab;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Collections;
import java.util.HashMap;
import java.util.List
import java.util.Map
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver as EventFiringWebDriver
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

public class GetExecutionProperties {
	/***
	 * 'RunConfiguration: getExecutionProperties Driver '
	 * @return String[] 
	 */
	def String[]  PropertieNameDriver(){
		Map RunBrowserConfiguration = RunConfiguration.getExecutionProperties()
		String NameDriver = RunBrowserConfiguration.get("drivers").get("system").get("WebUI").get("browserType")
		return NameDriver
	}
}
