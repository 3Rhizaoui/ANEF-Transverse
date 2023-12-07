package tools

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


public class CapabilitiesSpecificDownloadDirectory {
	/**
	 * Executes before every test case starts.
	 * --remote-allow-origins=*
	 *  * "--no-sandbox",
	 "--start-maximized",
	 "--incognito",
	 "--disable-popup-blocking",
	 "--remote-debugging-port=9222",
	 "--disable-extensions",
	 "--disable-gpu",
	 "--remote-allow-origins=*",
	 "--test-type",
	 "--disable-dev-shm-usage"
	 */

	//"RunConfiguration: getExecutionProperties Driver "
	Map RunBrowserConfiguration = RunConfiguration.getExecutionProperties()
	String DriverName = RunBrowserConfiguration.get("drivers").get("system").get("WebUI").get("browserType")
	String DriverNameDriver = RunBrowserConfiguration.get("drivers")

	@Keyword
	def SetSpecificDownloadDirectoryIfNeeded() {
		switch (DriverName) {
			case 'CHROME_DRIVER':

				'Init standard WebDrive Chrome session Capabilities Specific for Download Directory'
				GlobalVariable.downloadPath =RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
				Map desiredCapabilities = RunConfiguration.getDriverPreferencesProperties("WebUI")
				String projectDir = (RunConfiguration.getProjectDir()+ "/Data Files/Downloads/").replace(/\//, '\\\\')
				Path projectPath = Paths.get(projectDir)
				Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
				def customizedDownloadDirectory = downloadPath.toString()
			//
				Map prefs = desiredCapabilities.get("prefs")
			//				List  args = ["--incognito", "--disable-dev-shm-usage", "--start-maximized"]
			//
			//				if (prefs == null) {
			//					prefs = [:]	}
			//				//capabilities capabilities = DesiredCapabilities.chrome() = DesiredCapabilities.chrome()
			//				KeywordUtil.logInfo("BeforeTc3SetSpecificDownloadDirectoryIfNeeded: We detected test name contains \"download\" so we get current desiredCapabilities prefs =" + prefs.toString())
			//				KeywordUtil.logInfo("BeforeTc3SetSpecificDownloadDirectoryIfNeeded: ...and set desiredCapabilities to work with a customized download directory = RunConfiguration.getProjectDir() + / + GlobalVariable.downloadPath = : $customizedDownloadDirectory")
			//				prefs.put("download.default_directory", customizedDownloadDirectory)
			//				prefs.put("download_dir", customizedDownloadDirectory)
			//				prefs.put("download.prompt_for_download", false)
			////				'Set the incoming buffer to 24MB For hromeDevtools client'
			////				System.setProperty(DefaultWebSocketContainerFactory.WEBSOCKET_INCOMING_BUFFER_PROPERTY,Long.toString((long) DefaultWebSocketContainerFactory.MB * 900));
			////				" Utilisation de l'adresse IP à la place de localhost"
			////				java.net.InetAddress i = java.net.InetAddress.getLocalHost();
			//				System.out.println(i.getHostAddress());
			//				ChromeOptions options = new ChromeOptions()
			//
			//				System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
			//				System.setProperty('webdriver.chrome.logfile', RunConfiguration.getProjectDir()+ "/Dump/chromedriver.log")
			//				RunConfiguration.setDriverPreferencesProperty("webdriver.chrome.driver","prefs",prefs)
			////				options.setExperimentalOption("prefs", prefs)
			//				//options.addArguments(args)
			//				WebDriver driver = new ChromeDriver(options)
			//				DriverFactory.changeWebDriver(driver)

				break;

			case 'HEADLESS_DRIVER':

				'Init standard WebDrive Chrome session Capabilities Specific for Download Directory'
				GlobalVariable.downloadPath =RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
				Map desiredCapabilities = RunConfiguration.getDriverPreferencesProperties("WebUI")
				String projectDir = (RunConfiguration.getProjectDir()+ "/Data Files/Downloads/").replace(/\//, '\\\\')
				Path projectPath = Paths.get(projectDir)
				Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
				def customizedDownloadDirectory = downloadPath.toString()

				Map prefs = desiredCapabilities.get("prefs")
				List  args = ["--incognito"]
			//"--start-maximized",
				if (prefs == null) {
					prefs = [:]	}
				KeywordUtil.logInfo("BeforeTc3SetSpecificDownloadDirectoryIfNeeded: We detected test name contains \"download\" so we get current desiredCapabilities prefs =" + prefs.toString())
				KeywordUtil.logInfo("BeforeTc3SetSpecificDownloadDirectoryIfNeeded: ...and set desiredCapabilities to work with a customized download directory = RunConfiguration.getProjectDir() + / + GlobalVariable.downloadPath = : $customizedDownloadDirectory")
				prefs.put("download.default_directory", customizedDownloadDirectory)
				prefs.put("download_dir", customizedDownloadDirectory)
				prefs.put("download.prompt_for_download", false)
				'Set the incoming buffer to 24MB For hromeDevtools client'
				System.setProperty(DefaultWebSocketContainerFactory.WEBSOCKET_INCOMING_BUFFER_PROPERTY,Long.toString((long) DefaultWebSocketContainerFactory.MB * 900));
				" Utilisation de l'adresse IP à la place de localhost"
				java.net.InetAddress i = java.net.InetAddress.getLocalHost();
				System.out.println(i.getHostAddress());
				ChromeOptions options = new ChromeOptions()
				System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
				System.setProperty('webdriver.chrome.logfile', RunConfiguration.getProjectDir()+ "/Dump/chromedriver.log")

			//options.addArguments(args)

				options.setExperimentalOption("prefs", prefs)
				WebDriver driver = new ChromeDriver(options)
			//DriverFactory.changeWebDriver(driver)

			//				'Init standard WebDrive Chrome session Capabilities Specific for Download Directory'
			//				GlobalVariable.downloadPath =RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
			//				Map desiredCapabilities = RunConfiguration.getDriverPreferencesProperties("WebUI")
			//				String projectDir = RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
			//				Path projectPath = Paths.get(projectDir)
			//				Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
			//				def customizedDownloadDirectory = downloadPath.toString()
			//
			//				Map prefs = desiredCapabilities.get("prefs")
			//				List  args = ["--incognito"]
			//				if (prefs == null) {
			//					prefs = [:]	}
			//				KeywordUtil.logInfo("BeforeTc3SetSpecificDownloadDirectoryIfNeeded: We detected test name contains \"download\" so we get current desiredCapabilities prefs =" + prefs.toString())
			//				KeywordUtil.logInfo("BeforeTc3SetSpecificDownloadDirectoryIfNeeded: ...and set desiredCapabilities to work with a customized download directory = RunConfiguration.getProjectDir() + / + GlobalVariable.downloadPath = : $customizedDownloadDirectory")
			//				prefs.put("download.default_directory", customizedDownloadDirectory)
			//				prefs.put("download_dir", customizedDownloadDirectory)
			//				prefs.put("download.prompt_for_download", false)
			//				'Set the incoming buffer to 24MB For hromeDevtools client'
			//				System.setProperty(DefaultWebSocketContainerFactory.WEBSOCKET_INCOMING_BUFFER_PROPERTY,Long.toString((long) DefaultWebSocketContainerFactory.MB * 100));
			//				" Utilisation de l'adresse IP à la place de localhost"
			//				java.net.InetAddress i = java.net.InetAddress.getLocalHost();
			//				System.out.println(i.getHostAddress());
			//
			//				ChromeOptions options = new ChromeOptions()
			//				System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
			//				System.setProperty('webdriver.chrome.logfile', RunConfiguration.getProjectDir()+ "/Dump/chromedriver.log")
			//				options.setExperimentalOption("prefs", prefs)
			//				WebDriver driver = new ChromeDriver(options)
			//				DriverFactory.changeWebDriver(driver)

				break;


			case 'FIREFOX_DRIVER':
				'Init standard WebDrive FireFox session Capabilities Specific for Download Directory customizedDownloadDirectory'
				GlobalVariable.downloadPath =(RunConfiguration.getProjectDir()+ "/Data Files/Downloads/").replace(/\//, '\\')
				String projectDir = (RunConfiguration.getProjectDir()+ "/Data Files/Downloads/").replace(/\//, '\\')
				Path projectPath = Paths.get(projectDir)
				Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
				def customizedDownloadDirectory =( downloadPath.toString()).replace(/\//, '\\')
				'Init standard WebDrive FireFox profile '
				String profileName = "default";
				FirefoxProfile fp = new ProfilesIni().getProfile(profileName)
				FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(fp)
				'Init standard WebDrive FireFox DesiredCapabilities '
				DesiredCapabilities firefoxDesiredCapabilities = new DesiredCapabilities(); //Initializing desired capabilities
				firefoxOptions.addPreference("browser.download.folderList", 2); //Last downloaded folder
				firefoxOptions.addPreference("browser.download.defaultFolder", customizedDownloadDirectory); // Set your default download directory's path
				firefoxOptions.addPreference("browser.download.dir", customizedDownloadDirectory); // Set your default download directory's path
				firefoxOptions.addArguments("\t-inprivate");//for incognito
				firefoxOptions.addArguments("\t-remote-allow-origins=*", "http://127.0.0.1:45411/");//listenNetwork if the listener for network should be turned
				firefoxOptions.setCapability("moz:firefoxOptions",firefoxOptions); //Load all options to desired capabilities
				'Load all options to desired capabilities'
				firefoxDesiredCapabilities.setCapability("moz:firefoxOptions",firefoxOptions);
			// note: You HAVE TO choose Firefox in Katalon Studio GUI
				String geckoDriverPath = DriverFactory.getGeckoDriverPath()
				println "Mon geckoDriverPath : " + geckoDriverPath
				System.setProperty('webdriver.gecko.driver', geckoDriverPath)
				System.setProperty('webdriver.gecko.logfile', RunConfiguration.getProjectDir()+ "/Dump/gecko.log")
				RunConfiguration.setWebDriverPreferencesProperty('moz:firefoxOptions', firefoxDesiredCapabilities)
				WebDriver driver = new FirefoxDriver(firefoxOptions)
				assert driver != null
			//DriverFactory.changeWebDriver(driver)
				break;


			case 'FIREFOX_HEADLESS_DRIVER':
				'Init standard WebDrive FireFox session Capabilities Specific for Download Directory customizedDownloadDirectory'
				GlobalVariable.downloadPath =(RunConfiguration.getProjectDir()+ "/Data Files/Downloads/").replace(/\//, '\\')
				String projectDir = (RunConfiguration.getProjectDir()+ "/Data Files/Downloads/").replace(/\//, '\\')
				Path projectPath = Paths.get(projectDir)
				Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
				def customizedDownloadDirectory =( downloadPath.toString()).replace(/\//, '\\')
				'Init standard WebDrive FireFox profile '
				String profileName = "default";
				FirefoxProfile fp = new ProfilesIni().getProfile(profileName)
				FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(fp)
				'Init standard WebDrive FireFox DesiredCapabilities '
				DesiredCapabilities firefoxDesiredCapabilities = new DesiredCapabilities(); //Initializing desired capabilities
				firefoxOptions.addPreference("browser.download.folderList", 2); //Last downloaded folder
				firefoxOptions.addPreference("browser.download.defaultFolder", customizedDownloadDirectory); // Set your default download directory's path
				firefoxOptions.addPreference("browser.download.dir", customizedDownloadDirectory); // Set your default download directory's path
				firefoxOptions.addArguments("-private");//for incognito
				firefoxOptions.addArguments("-allow-origins", "http://127.0.0.1:45411/");//listenNetwork if the listener for network should be turned
				firefoxOptions.setCapability("moz:firefoxOptions",firefoxOptions); //Load all options to desired capabilities
				'Load all options to desired capabilities'
				firefoxDesiredCapabilities.setCapability("moz:firefoxOptions",firefoxOptions);
			// note: You HAVE TO choose Firefox in Katalon Studio GUI
				String geckoDriverPath = DriverFactory.getGeckoDriverPath()
				println "Mon geckoDriverPath : " + geckoDriverPath
				System.setProperty('webdriver.gecko.driver', geckoDriverPath)
				System.setProperty('webdriver.gecko.logfile', RunConfiguration.getProjectDir()+ "/Dump/gecko.log")
				RunConfiguration.setWebDriverPreferencesProperty('moz:firefoxOptions', firefoxDesiredCapabilities)
				WebDriver driver = new FirefoxDriver(firefoxOptions)
				assert driver != null
			//DriverFactory.changeWebDriver(driver)
				break;


			case  'EDGE_DRIVER':
				'Init standard WebDrive Chrome session Capabilities Specific for Download Directory'
			//				GlobalVariable.downloadPath =RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
			//				Map desiredCapabilities = RunConfiguration.getDriverPreferencesProperties("WebUI")
			//				String projectDir = RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
			//				Path projectPath = Paths.get(projectDir)
			//				Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
			//				def customizedDownloadDirectory = downloadPath.toString()
			//
			//				WebUI.comment("executedBrowser:${DriverFactory.getExecutedBrowser().getName()}")
			//				WebUI.comment("chromeDriverPath:${DriverFactory.getChromeDriverPath()}")
			//				WebUI.comment("edgeDriverPath:${DriverFactory.getEdgeDriverPath()}")
			//				WebUI.comment("geckoDriverPath:${DriverFactory.getGeckoDriverPath()}")
			//				WebUI.comment("ieDriverPath:${DriverFactory.getIEDriverPath()}")
			//
			//				System.setProperty("webdriver.ie.driver", DriverFactory.getIEDriverPath());
			//				println "webdriver.ie.driver" + DriverFactory.getIEDriverPath()
			//				InternetExplorerOptions edgeIe11Options = new InternetExplorerOptions();
			//				Map<String, Object> ops = (Map<String, Object>) edgeIe11Options.getCapability("se:ieOptions");
			//				ops.put("ie.edgechromium", true);
			//			//ops.put("ie.edgepath", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
			//				ops.put("ie.edgepath", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
			//				edgeIe11Options.setCapability("ignoreProtectedModeSettings", true);
			//				edgeIe11Options.setCapability("ignoreZoomSetting", true);
			//				WebDriver driver = new InternetExplorerDriver(edgeIe11Options);
			//				DriverFactory.changeWebDriver(driver)
				break;

			case  'IE_DRIVER':
			/*		'Init standard WebDrive Chrome session Capabilities Specific for Download Directory'
			 GlobalVariable.downloadPath =RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
			 Map desiredCapabilities = RunConfiguration.getDriverPreferencesProperties("WebUI")
			 String projectDir = RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
			 Path projectPath = Paths.get(projectDir)
			 Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
			 def customizedDownloadDirectory = downloadPath.toString()
			 System.setProperty("webdriver.ie.driver", DriverFactory.getIEDriverPath());
			 println "webdriver.ie.driver" + DriverFactory.getIEDriverPath()
			 InternetExplorerOptions edgeIe11Options = new InternetExplorerOptions();
			 Map<String, Object> ops = (Map<String, Object>) edgeIe11Options.getCapability("se:ieOptions");
			 ops.put("ie.edgechromium", true);
			 //ops.put("ie.edgepath", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
			 //ops.put("ie.edgepath", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
			 System.setProperty("webdriver.ie.driver", DriverFactory.getEdgeDriverPath())
			 //System.setProperty("edgeDriverPath",  DriverFactory.getIEDriverPath())
			 edgeIe11Options.setCapability("ignoreProtectedModeSettings", true);
			 edgeIe11Options.setCapability("ignoreZoomSetting", true);
			 WebDriver driver = new InternetExplorerDriver(edgeIe11Options);
			 DriverFactory.changeWebDriver(driver)*/
				break;

			case 'EDGE_CHROMIUM_DRIVER':
				'Init standard WebDrive Chrome session Capabilities Specific for Download Directory'
				GlobalVariable.downloadPath =(RunConfiguration.getProjectDir()+ "/Data Files/Downloads/").replace(/\//, '\\')
				Map desiredCapabilities = RunConfiguration.getDriverPreferencesProperties("WebUI")
				String projectDir = (RunConfiguration.getProjectDir()+ "/Data Files/Downloads/").replace(/\//, '\\')
				Path projectPath = Paths.get(projectDir)
				Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
				def customizedDownloadDirectory = downloadPath.toString().replace(/\//, '\\')

				System.setProperty("webdriver.edge.driver",DriverFactory.getEdgeChromiumDriverPath());
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory",customizedDownloadDirectory);
				prefs.put("profile.default_content_settings.popups", 2);
				prefs.put("download.default_directory", customizedDownloadDirectory);
				prefs.put("browser.download.defaultFolder", customizedDownloadDirectory);

				EdgeOptions options = new EdgeOptions();
				Map<String, Object> edgePrefs = new HashMap<String, Object>()

				options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				List<String> args = Arrays.asList("\t-inprivate", "\t-remote-allow-origins=*", "use-fake-ui-for-media-stream", "use-fake-device-for-media-stream");
				Map<String, Object> map = new HashMap<>();
				map.put("args", args);
				map.put("prefs", prefs);
				options.setCapability("ms:edgeOptions", map);
				WebDriver driver = new EdgeDriver(options);
			//DriverFactory.changeWebDriver(driver)

				break;
		}
	}
}


