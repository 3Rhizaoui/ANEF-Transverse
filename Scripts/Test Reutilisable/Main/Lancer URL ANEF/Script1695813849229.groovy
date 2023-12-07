import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.support.events.EventFiringWebDriver
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.selenium.driver.CRemoteWebDriver
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.github.kklisura.cdt.protocol.commands.Fetch as Fetch
import com.github.kklisura.cdt.protocol.commands.Page as Page
import com.github.kklisura.cdt.services.ChromeDevToolsService as ChromeDevToolsService
import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.protocol.commands.Network;
import com.github.kklisura.cdt.protocol.commands.Page;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.types.ChromeTab;
import com.katalon.cdp.CdpUtils as CdpUtils
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.logging.KeywordLogger
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.ProfilesIni
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.BuildInfo;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.net.NetworkUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.remote.http.HttpClient.Factory;
import org.openqa.selenium.remote.internal.OkHttpClient;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.kms.katalon.core.appium.driver.SwipeableAndroidDriver;
import com.kms.katalon.core.appium.exception.AppiumStartException;
import com.kms.katalon.core.appium.exception.MobileDriverInitializeException;
import com.kms.katalon.core.driver.DriverType;
import com.kms.katalon.core.event.EventBusSingleton;
import com.kms.katalon.core.event.TestingEvent;
import com.kms.katalon.core.event.TestingEventType;
import com.kms.katalon.core.exception.StepFailedException;
import com.kms.katalon.core.logging.KeywordLogger;
import com.kms.katalon.core.logging.LogLevel;
import com.kms.katalon.core.network.ProxyInformation;
import com.kms.katalon.core.network.ProxyOption;
import com.kms.katalon.core.util.internal.JsonUtil;
import com.kms.katalon.core.util.internal.ProxyUtil;
import com.kms.katalon.core.webui.common.WebUiCommonHelper;
import com.kms.katalon.core.webui.constants.CoreWebuiMessageConstants;
import com.kms.katalon.core.webui.constants.StringConstants;
import com.kms.katalon.core.webui.driver.firefox.CFirefoxDriver47;
import com.kms.katalon.core.webui.driver.firefox.CGeckoDriver;
import com.kms.katalon.core.webui.driver.ie.InternetExploreDriverServiceBuilder;
import com.kms.katalon.core.webui.exception.BrowserNotOpenedException;
import com.kms.katalon.core.webui.util.FileExcutableUtil;
import com.kms.katalon.core.webui.util.FileUtil;
import com.kms.katalon.core.webui.util.FirefoxExecutable;
import com.kms.katalon.core.webui.util.OSUtil;
import com.kms.katalon.core.webui.util.WebDriverPropertyUtil;
import com.kms.katalon.core.webui.util.WebDriverProxyUtil;
import com.kms.katalon.selenium.driver.CChromeDriver;
import com.kms.katalon.selenium.driver.CEdgeDriver;
import com.kms.katalon.selenium.driver.CFirefoxDriver;
import com.kms.katalon.selenium.driver.CInternetExplorerDriver;
import com.kms.katalon.selenium.driver.CRemoteWebDriver;
import com.kms.katalon.selenium.driver.CSafariDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AppiumCommandExecutor;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import internal.GlobalVariable as GlobalVariable
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.Files
import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.protocol.commands.Page;
import com.github.kklisura.cdt.protocol.types.page.PrintToPDF;
import com.github.kklisura.cdt.protocol.types.page.PrintToPDFTransferMode;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.factory.impl.DefaultWebSocketContainerFactory;
import com.github.kklisura.cdt.services.types.ChromeTab;
import java.io.FileOutputStream;
import java.util.Base64;
import java.net.URI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.eclipse.jetty.websocket.client.WebSocketClient
import org.eclipse.jetty.websocket.client.WebSocketUpgradeRequest
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.edge.EdgeOptions as EdgeOptions
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.client5.http.classic.methods.HttpPost
import org.apache.hc.core5.http.io.entity.StringEntity
import org.openqa.selenium.chrome.ChromeDriverService
import com.fasterxml.jackson.databind.ObjectMapper
import com.kms.katalon.core.util.internal.Base64 as Base64
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */

/**
	Runtime.getRuntime().exec('taskkill /f /im chrome.exe')
	Runtime.getRuntime().exec('taskkill /f /im chromedriver.exe')
	Runtime.getRuntime().exec('taskkill /f /im geckodriver.exe')
*/
'RunConfiguration: getProjectDir for LogDriver '
//String projDir = RunConfiguration.getProjectDir()
'RunConfiguration: getExecutionProperties Driver '
Map RunBrowserConfiguration = RunConfiguration.getExecutionProperties()
//println "Map RunBrowserConfiguration :" + RunBrowserConfiguration
String DriverName = ""
WebUI.openBrowser("")
EventFiringWebDriver driver = DriverFactory.getWebDriver()
WebDriver wrappedDriver = driver.getWrappedDriver()
System.out.println(wrappedDriver.getClass())


 if (wrappedDriver.class == CRemoteWebDriver) {
	wrappedDriver.setFileDetector(new LocalFileDetector())
	DriverName = RunBrowserConfiguration.get("drivers").get("system").get("Remote").get("browserType")
	println "DriverName :" + DriverName
	println "Driverpath :" + RunBrowserConfiguration.get("drivers")}
else {
	DriverName = RunBrowserConfiguration.get("drivers").get("system").get("WebUI").get("browserType")
	println "DriverName :" + DriverName
	println "Driverpath :" + RunBrowserConfiguration.get("drivers")
	}
GlobalVariable.DriverName = DriverName
  


 /**Lancer un navigateur avec l'URL de l'application ANEF pour Portail Usager:
 */
WebUI.delay(GlobalVariable.medium_wait)
WebUIDriverType executedBrowser = DriverFactory.getExecutedBrowser()

if (Profiles == 'Usager') {
	switch (DriverName) {
		case 'REMOTE_WEB_DRIVER':
	
			'Navigation à URL  Qualification et Création MDP'
			if (EnvExec == 'URL_ANEFQualif') { WebUI.navigateToUrl (GlobalVariable.URL_ANEFQualif)}
			'Navigation à URL Préprode  et Création MDP'
			if (EnvExec == 'URL_ANEFPreProd') {WebUI.navigateToUrl (GlobalVariable.URL_ANEFPreProd)}
				
			WebUI.maximizeWindow()
			'Appel de l\'action Réutilisable pour contourner l\'erreur lié à la confidentialité'
			WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			'Vérification de l\'étape :'
			WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
			
		break
		case 'CHROME_DRIVER':
			'Navigation à URL  Qualification et Création MDP'
			if (EnvExec == 'URL_ANEFQualif') { WebUI.navigateToUrl (GlobalVariable.URL_ANEFQualif)}
			'Navigation à URL Préprode  et Création MDP'
			if (EnvExec == 'URL_ANEFPreProd') {WebUI.navigateToUrl (GlobalVariable.URL_ANEFPreProd)}
				
			WebUI.maximizeWindow()
			System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
			System.setProperty('webdriver.chrome.logfile', RunConfiguration.getProjectDir()+ "/Dump/chromedriver.log")
			'Appel de l\'action Réutilisable pour contourner l\'erreur lié à la confidentialité'
			WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			'Vérification de l\'étape :'
			WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
			
		break
		case 'HEADLESS_DRIVER':
			'Navigation à URL  Qualification et Création MDP'
			if (EnvExec == 'URL_ANEFQualif') { WebUI.navigateToUrl (GlobalVariable.URL_ANEFQualif)}
			'Navigation à URL Préprode  et Création MDP'
			if (EnvExec == 'URL_ANEFPreProd') {WebUI.navigateToUrl (GlobalVariable.URL_ANEFPreProd)}
				
			WebUI.maximizeWindow()
			"Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité"
			WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.OPTIONAL)
			WebUI.delay(5)
			"Vérification de l'étape :"
			WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
			break;
			
		case 'FIREFOX_DRIVER':
			'Navigation à URL  Qualification et Création MDP'
			if (EnvExec == 'URL_ANEFQualif') { WebUI.navigateToUrl (GlobalVariable.URL_ANEFQualif)}
			'Navigation à URL Préprode  et Création MDP'
			if (EnvExec == 'URL_ANEFPreProd') {WebUI.navigateToUrl (GlobalVariable.URL_ANEFPreProd)}
				
			WebUI.maximizeWindow()
			"Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité"
			WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			"Vérification de l'étape :"
			WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
			break;

			
		case 'FIREFOX_HEADLESS_DRIVER':
			'Navigation à URL  Qualification et Création MDP'
			if (EnvExec == 'URL_ANEFQualif') { WebUI.navigateToUrl (GlobalVariable.URL_ANEFQualif)}
			'Navigation à URL Préprode  et Création MDP'
			if (EnvExec == 'URL_ANEFPreProd') {WebUI.navigateToUrl (GlobalVariable.URL_ANEFPreProd)}
				
			WebUI.maximizeWindow()
			"Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité"
			WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			"Vérification de l'étape :"
			WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
			break;
						
		case 'EDGE_CHROMIUM_DRIVER':
			'Navigation à URL  Qualification et Création MDP'
			if (EnvExec == 'URL_ANEFQualif') { WebUI.navigateToUrl (GlobalVariable.URL_ANEFQualif)}
			'Navigation à URL Préprode  et Création MDP'
			if (EnvExec == 'URL_ANEFPreProd') {WebUI.navigateToUrl (GlobalVariable.URL_ANEFPreProd)}
				
			WebUI.maximizeWindow()
			"Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité"
			WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			"Vérification de l'étape :"
			WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
			break;
			
		case  'EDGE_DRIVER':
			'Navigation à URL  Qualification et Création MDP'
			if (EnvExec == 'URL_ANEFQualif') { WebUI.navigateToUrl (GlobalVariable.URL_ANEFQualif)}
			'Navigation à URL Préprode  et Création MDP'
			if (EnvExec == 'URL_ANEFPreProd') {WebUI.navigateToUrl (GlobalVariable.URL_ANEFPreProd)}
				
			System.setProperty("webdriver.chrome.logfile", "'" +  projDir + "'" + "./chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			"Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité"
			WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			"Vérification de l'étape :"
			WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
			break;
		case  'IE_DRIVER':
			'Navigation à URL  Qualification et Création MDP'
			if (EnvExec == 'URL_ANEFQualif') { WebUI.navigateToUrl (GlobalVariable.URL_ANEFQualif)}
			'Navigation à URL Préprode  et Création MDP'
			if (EnvExec == 'URL_ANEFPreProd') {WebUI.navigateToUrl (GlobalVariable.URL_ANEFPreProd)}
				
			System.setProperty("webdriver.chrome.logfile", "'" +  projDir + "'" + "./chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			"Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité"
			WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			"Vérification de l'étape :"
			WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
			break;
	}
}






/**Lancer un navigateur avec l'URL de l'application ANEF pour Portail Agent:
 */
if (Profiles == 'Agent') {
	'Navigation à URL  Qualification et Création MDP'
	if (EnvExec == 'URL_ANEFQualif') { WebUI.openBrowser (GlobalVariable.URL_ANEFQualif)}
	'Navigation à URL Préprode  et Création MDP'
	if (EnvExec == 'URL_ANEFPreProd') {WebUI.openBrowser (GlobalVariable.URL_ANEFPreProd)}
				
	WebUI.maximizeWindow()
	System.setProperty("webdriver.chrome.logfile", "'" +  projDir + "'" + "./chromedriver.log");
	System.setProperty("webdriver.chrome.verboseLogging", "true");
	// Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité
	//WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)
	
	//Vérification de l'étape :
	//WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)
	}
	
else {
	println "Vérifier le Portail de votre connexion Usager ou Agent"
}