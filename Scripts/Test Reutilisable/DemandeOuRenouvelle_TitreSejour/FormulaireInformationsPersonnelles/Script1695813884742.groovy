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


/** modify WebUI.* keywords which take TestObject as arg0
 * 
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/CheckBox_liensPersonnelsFamiliaux_1_Non'), 1, FailureHandling.OPTIONAL)) {
	WebUI.check(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/CheckBox_liensPersonnelsFamiliaux_1_Non'), FailureHandling.OPTIONAL)}
	WebUI.delay(2)


if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/CheckBox_liensPersonnelsFamiliaux_2_Non'), 1, FailureHandling.OPTIONAL)) {
	WebUI.check(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/CheckBox_liensPersonnelsFamiliaux_2_Non'), FailureHandling.OPTIONAL)}
	WebUI.delay(2)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/CheckBox_DesEnfantsACharge_Non'), 1, FailureHandling.OPTIONAL)) {
	WebUI.check(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/CheckBox_DesEnfantsACharge_Non'), FailureHandling.OPTIONAL)}
	WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/Input_AdresseUsager'), AdresseUsager, FailureHandling.OPTIONAL)
WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/select_AdresseUsager'))
WebUI.setText(findTestObject('Object Repository/Page_InformationPersonnelles_Usager/Input_NumeroDeTelephone'), NumeroTelephoneUsager, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
