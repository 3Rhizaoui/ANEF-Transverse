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
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import java.time.format.DateTimeFormatter
import com.github.kklisura.cdt.protocol.commands.Runtime
import com.github.kklisura.cdt.protocol.events.runtime.ConsoleAPICalled
import com.github.kklisura.cdt.protocol.events.runtime.ConsoleAPICalledType
import com.github.kklisura.cdt.protocol.types.runtime.RemoteObject
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.testng.IExecutionListener;
import com.kms.katalon.core.util.KeywordUtil


public class EventsNetWorkChromeConsole {

	// Variables
	static Network myNetwork
	static Page page
	static Map RequestMap = [:]
	static ChromeDevToolsService cdts
	static boolean isInitialized
	static Runtime runtime

	/***
	 * Initialize the console with the current page
	 * This can be done after the opening of the page
	 * It can also be done just before the part of the current page that is needed the be tracked
	 * 
	 * @return null
	 */
	def InitializeConsole(){
		cdts= CdpUtils.getService()
		runtime = cdts.getRuntime()
		runtime.enable()
		ResetDataCollection()
		page = cdts.getPage()
		myNetwork = cdts.getNetwork()
		isInitialized = true;
	}
	/***
	 * Initialize the Services with the current page and current Network & clear Browser Cookies & clear Browser Cache
	 * This can be done after the opening of the page and Network
	 *
	 * @return null
	 */
	@Keyword
	def InitializeWebDriveDeleteAllNodeExe(){
		println("[LOG] ==> Vérifier si node.exe est en cours d'exécution…")
		String namePC = System.getProperty('os.name')
		if (namePC.contains("Windows")){
			boolean node_exist = Utility.checkTaskList()
			if(node_exist == true){
				println("node.exe existe toujours depuis la dernière session ! Je vais l'arrêter...")
				try{
					Runtime. getRuntime().exec("cmd.exe /c start taskkill /IM node.exe /F")
					sleep(5000)//dormir un peu pour finir de tuer le processus avant de passer à une autre étape
				}catch(Exception ex){
					ex.printStackTrace()} }
		}
	}

	/***
	 * Enable listen to Network and listen to the page trigger
	 * This sets the possibilities later for the Chrome listener
	 * 
	 * @param listenPage true if the listener for Page should be turned on
	 * @param listenNetwork if the listener for network should be turned on
	 * @return null
	 */
	@Keyword
	def RegisterListender(boolean listenPage, boolean listenNetwork) {
		if(isInitialized == false)
		{
			InitializeConsole()
		}
		if(listenPage)
		{
			page.enable()
		}
		if(listenNetwork)
		{
			registerOnRequestSend()
			registerOnResponseReceived()
			myNetwork.enable()
		}
	}

	/***
	 * Registers the listener to request send
	 * 
	 * @return null
	 */
	def registerOnRequestSend()
	{
		//		myNetwork.onRequestWillBeSent({ def event ->
		//			if (event.type.toString() == 'XHR') {
		//				if (!(RequestMap.containsKey(event.requestId))) {
		//					def requestEnty = [('RequestID') : event.requestId, ('RespondeID') : '', ('ResponseStatusCode') : '', ('RequestBody') : ''
		//						, ('RequestUrl') : event.getRequest().getUrl(), ('RequestMethod') : event.getRequest().method]
		//
		//					RequestMap.put(event.requestId, requestEnty)
		//					WebUI.comment("REQ:" + RequestMap.size().toString())
		//
		//				}
		//			}
		//		})

	}

	/***
	 * Registers the listener to response received
	 *  
	 * @return null
	 */
	def registerOnResponseReceived()
	{
		//		myNetwork.onResponseReceived({ def event ->
		//			if (event.type.toString() == 'XHR') {
		//
		//				if (RequestMap.containsKey(event.requestId)) {
		//					def valueList = RequestMap.get(event.requestId)
		//					valueList.RespondeID = event.requestId
		//					valueList.ResponseStatusCode = event.response.status.toString()
		//					RequestMap.put(event.requestId, valueList)
		//					WebUI.comment("RESP:" + RequestMap.size().toString())
		//					println ("Ma liste est ======" + valueList)
		//				}
		//			}
		//		})
		//
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

	/***
	 * Reset the currently collected data
	 * 
	 * @return null
	 */
	@Keyword
	def ResetDataCollection() {
		RequestMap = [:]

	}

	/***
	 * wait for the collection of the request data
	 * 	
	 * @return null
	 */
	@Keyword
	def WaitForRequestData() {
		CheckHasAllRequestData()
		FillRequests()
	}

	@Keyword
	def Map GetResponse() {
		return RequestMap;
	}

	/***
	 * Wait that all logged request have the corresponding data in the map
	 * Waits till request and response have a ID
	 * @return null
	 */
	def CheckHasAllRequestData()
	{
		boolean hasNotAllRequest = true
		while (hasNotAllRequest)
		{
			def selfRequestMap = RequestMap.getClass().newInstance(RequestMap)
			def sizebefore = selfRequestMap.size()
			WebUI.comment("Check : " + sizebefore)

			for (def e : selfRequestMap)
			{
				if (e != null)
				{
					def valueList = e.value
					if (e.key == valueList.RespondeID)
					{
						hasNotAllRequest = false
					} else {
						hasNotAllRequest = true
					}
				}
			}

			//Check if we have new values in the current collection of events
			if (RequestMap.size() != sizebefore)
			{
				hasNotAllRequest = true
			}

			//If we have not all just wait
			if (hasNotAllRequest)
			{
				WebUI.delay(5)
			}
		}
	}

	/***
	 * Fill the Request map with the response body values
	 * 
	 * @return null
	 */
	def FillRequests()
	{
		'For all the values that there could be try and get the Respone body, if needed or not'
		for (def entry : RequestMap)
		{
			if (entry != null) {
				try {
					String body = myNetwork.getResponseBody(entry.key.toString()).body
					entry.value.RequestBody = body
				}
				catch (Exception e) {
					entry.value.RequestBody = e.message.toString()
					/*
					 * If there is no body an exception would be thrown this needs to be catch'ed.
					 * As there is no data in the body nothing will be added.
					 */

				}
			}
		}
	}

	/***
	 * get the collected request data as string
	 * @param dumpToFile true if the dumping to file should be turned on
	 * @return returns the request Json string as original not encoded since groovy can not handle them when parsing
	 */
	@Keyword
	def String GetRequestString(boolean dumpToFile) {
		def jsonValues = JsonOutput.toJson(RequestMap).bytes.encodeBase64().toString()
		DumpToFile("JsonRequest.json", jsonValues)
		byte[] decoded = jsonValues.decodeBase64()
		return new String(decoded)
	}

	/***
	 * Dump a string to a file
	 *  
	 * @param dumpFileName Name of the file
	 * @param data string data that should be written to the file
	 * @return null
	 * */
	@Keyword
	def DumpToFile(String dumpFileName, String data)
	{
		def dumpDir = RunConfiguration.getProjectDir() + "/Dump"
		FileOutputStream fileOutputStream = null
		String fileName = dumpDir + "/" + dumpFileName
		try
		{
			File file = new File(fileName)
			fileOutputStream = new FileOutputStream(file)
			fileOutputStream.write(Base64.getDecoder().decode(data))
		}
		catch (IOException e)
		{
			e.printStackTrace()
		}
		finally
		{
			if (fileOutputStream != null)
			{
				try
				{
					fileOutputStream.flush()
					fileOutputStream.close()
				}
				catch (IOException e)
				{
					e.printStackTrace()
				}
			}
		}
	}
	/***
	 * Take a screenshot of the page as it is
	 * @param outputFilename dump file location
	 * @return NULL
	 * */
	@Keyword
	def TakePageScreenshot(String outputFilename)
	{
		if(isInitialized == false)
		{
			InitializeConsole()
		}
		page.enable()
		DumpToFile(outputFilename, page.captureScreenshot())
	}
	/***
	 * Set the page of the browser to the full size of the content
	 * Remove the scroll bar of the given page
	 * Take a picture of it 
	 * 	
	 * @param devToolsService
	 * @param outputFilename
	 * @return NULL
	 */
	@Keyword
	def TakeFullPageScreenshot(String outputFilename)
	{
		if(isInitialized == false)
		{
			InitializeConsole()
		}
		WebDriver driver = DriverFactory.getWebDriver()
		def widthOriginal = driver.manage().window().getSize().getWidth()
		def heightOriginal = driver.manage().window().getSize().getHeight()
		//May be good to Limit that? 1024 ?
		double width = WebUI.executeJavaScript('return document.body.scrollWidth', null)
		double height = WebUI.executeJavaScript('return document.body.scrollHeight', null)
		Emulation emulation = cdts.getEmulation()
		//emulation.setDeviceMetricsOverride(Double.valueOf(widthOriginal).intValue(), Double.valueOf(height).intValue(), 1.0, Boolean.FALSE)
		emulation.setScrollbarsHidden(Boolean.TRUE)
		String image = page.captureScreenshot(CaptureScreenshotFormat.PNG, null, null,false)
		DumpToFile(outputFilename, image)
		emulation.setScrollbarsHidden(Boolean.FALSE)
		//emulation.setDeviceMetricsOverride(Double.valueOf(widthOriginal).intValue(), Double.valueOf(heightOriginal).intValue(), 1.0, Boolean.FALSE)
		//emulation.clearDeviceMetricsOverride()
	}
}