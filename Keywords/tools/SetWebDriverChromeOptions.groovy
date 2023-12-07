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
import org.openqa.selenium.By
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
import java.awt.Color
import java.awt.Rectangle
import groovy.json.JsonOutput as JsonOutput
import org.openqa.selenium.Cookie
import org.apache.commons.lang3.StringUtils
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import java.time.format.DateTimeFormatter
import com.github.kklisura.cdt.protocol.commands.Runtime
import com.github.kklisura.cdt.protocol.events.runtime.ConsoleAPICalled
import com.github.kklisura.cdt.protocol.events.runtime.ConsoleAPICalledType
import com.github.kklisura.cdt.protocol.types.runtime.RemoteObject
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.testng.IExecutionListener;
import com.kms.katalon.core.util.KeywordUtil


public class GetWebCookieByNamedCollected  {
	public WebDriver GetWebCookie(){

		/***
		 *  get the collected Cookies data and split Token as string
		 *  Save Token in GlobalVariable
		 */
		def ck = new Cookie("name", "value");
		//myNetwork.enable()
		//page.enable()
		WebDriver driver = DriverFactory.getWebDriver()
		driver.manage().getCookieNamed("Authorization")
		String CookiesBody =driver.manage().getCookies().toString()
		String Token = StringUtils.substringBetween(CookiesBody,"[Authorization=","; path=")
		driver.manage().addCookie(ck)
		GlobalVariable.Token = Token
		println ("mon Token ======== " + Token)

	}
}
