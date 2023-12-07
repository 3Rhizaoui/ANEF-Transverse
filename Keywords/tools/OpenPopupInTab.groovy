package tools

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
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.WebElement as WebElement
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.chrome.ChromeDriver;
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObjectProperty

public class OpenPopupInTab {
	/**
	 * Ouvrir une PopUp dans un onglet.
	 */

	def OpenBrowserTab(TestObject to) {

		String Myxpath = to.getSelectorCollection().get(SelectorMethod.XPATH)
		'Vérifier Photographie et voir Document '
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement  VoirDocPhotographie = driver.findElement(By.xpath(Myxpath))
		Actions actions = new Actions(DriverFactory.getWebDriver());
		actions.keyDown(Keys.LEFT_CONTROL)
				.click(VoirDocPhotographie)
				.keyUp(Keys.LEFT_CONTROL)
				.build()
				.perform();
	}

	/**
	 * Detecter les onglets ouvert et les Fermer & active la page Parent.
	 */

	def CloseBrowserTab() {

		WebDriver driver = DriverFactory.getWebDriver()
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext()){
			String child_window=I1.next();
			if(!parent.equals(child_window)){
				driver.switchTo().window(child_window);
				WebUI.delay(2)
				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.close();}
		}
		//switch to the parent window
		driver.switchTo().window(parent);
		driver.close()
	}




	def killProcess() {
		Runtime.getRuntime().exec('taskkill /f /im chrome.exe')
		Runtime.getRuntime().exec('taskkill /f /im chromedriver.exe')
		Runtime.getRuntime().exec('taskkill /f /im geckodriver.exe')
		Runtime.getRuntime().exec('taskkill /f /im IEDriverServer.exe')
	}

}
