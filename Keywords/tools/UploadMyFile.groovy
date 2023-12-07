package tools

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import org.openqa.selenium.Capabilities
import org.openqa.selenium.Dimension
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.RemoteWebDriver
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.SmartWaitWebDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import groovy.transform.CompileStatic
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.slf4j.Logger;
import com.kms.katalon.core.configuration.RunConfiguration
import org.slf4j.LoggerFactory;
import java.awt.*;
import org.openqa.selenium.remote.RemoteWebElement
import org.openqa.selenium.support.events.EventFiringWebDriver
import org.openqa.selenium.remote.LocalFileDetector as LocalFileDetector
import org.openqa.selenium.By
import java.nio.file.Paths as Paths
import java.nio.file.Path as Path
import java.awt.datatransfer.*
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class 	UploadMyFile {

	static int timeoutSecond = 60
	static int timeoutMilisecond = 1000

	/**
	 * Upload file using robot.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */
	@CompileStatic
	@Keyword
	public void uploadFileUsingRobot( String file) {
//		WebDriver driver = DriverFactory.getWebDriver()
//		Capabilities caps = ((SmartWaitWebDriver) driver).getCapabilities()
//		String browserName = caps.getBrowserName().capitalize()

		//if (browserName.toLowerCase().equals("firefox")){
		//	clickJS(object, driver);
		//}
		//		else {
		//			try {
		//WebUiBuiltInKeywords.click(object)
		//			}
		//			catch (Exception e) {
		//				clickJS(object, driver);
		//			}
		//		}


		//		WebElement El = driver.findElement(By.xpath("//app-justificatifs/div[2]/div/p-accordion/div/p-accordiontab[1]/div[2]/div/div[1]/div/app-pieces-jointes[1]/div/span[1]/input"))
		//		((RemoteWebElement) El ).setFileDetector(new LocalFileDetector())
		//		El.sendKeys("C:\\")

		WebUI.delay(3)
		//StringSelection ss = new StringSelection(file);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		SecurityManager securityManager = System.getSecurityManager();
		System.out.println(securityManager)
		Clipboard  systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    StringSelection selectedData = new StringSelection(file);
            System.out.println("Copying " + file + " to system clipboard");
            systemClipboard.setContents(selectedData, null);
            System.out.println("Successfully copied");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		sleep(10)
		robot.keyRelease(KeyEvent.VK_ENTER);
		sleep(10)
		robot.keyPress(KeyEvent.VK_CONTROL);
		sleep(10)
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebUI.delay(10)

//		/** Change 'Blank.png' to any test image file being used **/
//		'Sets path to the test Blank.png Uploadfile'
//		String projectDir = "C://EtatCivil.pdf"
//		//(RunConfiguration.getProjectDir() + "/Data Files/EtatCivil.pdf").replace(/\//, '\\')
//		Path uploadFilePath = Paths.get(projectDir)
//		String upLoadFile = uploadFilePath
//		println('upLoadFile: ' + upLoadFile)
//
//		'Finds "Select Images" Link using by.xpath & creates object'
//		def selectImagesLinkXpath = "//app-justificatifs/div[2]/div/p-accordion/div/p-accordiontab[1]/div[2]/div/div[1]/div/app-pieces-jointes[1]/div/span[1]/input"
//		//TestObject selectImagesLink = WebUI.convertWebElementToTestObject(driver.findElement(By.xpath(selectImagesLinkXpath)))
//		WebUI.sendKeys(selectImagesLink, upLoadFile)
//
//		'Waits for file to load'
//		WebUI.delay(3)
//
//		'Finds "Upload" button using by.xpath & creates object'
//		//def uploadBtnXpath = "//button[@type='submit'][contains(.,'Upload...')]"
//		//TestObject uploadBtn = WebUI.convertWebElementToTestObject(driver.findElement(By.xpath(uploadBtnXpath)))
//		//WebUI.click(uploadBtn)
	}

	/**
	 * Upload file using robot.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */
	@CompileStatic
	@Keyword
	//First of all declare the method setClipboardData as below:
	public void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/**
	 * Upload file.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */
	@CompileStatic
	@Keyword
	public void uploadMyFile(TestObject object, String file) {
		WebUiBuiltInKeywords.uploadFile(object, file)
	}

	private clickJS(TestObject object, WebDriver driver) {
		WebElement element = WebUiCommonHelper.findWebElement(object, timeoutSecond)
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element)
	}
}
