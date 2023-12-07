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
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Vérification s il y a un message Erreur :Votre Titre De séjour est Expiré Depuis 9 Mois.'
'Verify text alert is correct or not'
MsgAlertPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Accueil_Usager/Verif_PopUpVotreTitreDeSejourEstExpireDepuis9Mois'), 1, FailureHandling.OPTIONAL)
if(MsgAlertPresent){ 
	'Get text Alert on the alert when it\'s shown'
	alertText = WebUI.getText(findTestObject('Object Repository/Page_Accueil_Usager/Verif_PopUpVotreTitreDeSejourEstExpireDepuis9Mois'),FailureHandling.OPTIONAL)
	//KeywordUtil.markPassed(alertText)
	CustomKeywords.'tools.markPasseAndStop.markPasseAndStopTest'(alertText)
	GlobalVariable.MsgStopTestCase = alertText
	return null	}

