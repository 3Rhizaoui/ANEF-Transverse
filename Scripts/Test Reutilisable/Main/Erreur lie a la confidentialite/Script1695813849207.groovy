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
import com.kms.katalon.core.configuration.RunConfiguration
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


'waiting for the number of elements in the DOM to stop changing'
CustomKeywords.'tools.WaitForLoadedPage.waitForElementRendering'()

/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
'Call Highlight.on() automatically'
//CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

'RunConfiguration: getExecutionProperties Driver '
def DriverName = GlobalVariable.DriverName
//CustomKeywords.'tools.GetExecutionProperties.PropertieNameDriver'()

"contournement du message d'erreur lié à la confidentialité :"
if ((DriverName =='CHROME_DRIVER') || ('EDGE_CHROMIUM_DRIVER') || 'HEADLESS_DRIVER'){
	if(WebUI.verifyElementPresent(findTestObject('Object Repository/Connexion Usager/Btn_Parametres Avances'),2,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Object Repository/Connexion Usager/Btn_Parametres Avances'),FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/Connexion Usager/Link_Proceed-Link'),FailureHandling.OPTIONAL)}}

"contournement du message d'erreur lié à la confidentialité :"
if ((DriverName =='IE_DRIVER')){
	if(WebUI.verifyElementPresent(findTestObject('Object Repository/Connexion Usager/Btn_Parametres Avances'),2,FailureHandling.OPTIONAL)){
		WebUI.click(findTestObject('Object Repository/Connexion Usager/Btn_Parametres Avances'),FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/Connexion Usager/Link_Proceed-Link'),FailureHandling.OPTIONAL)}}
WebUI.delay(3)