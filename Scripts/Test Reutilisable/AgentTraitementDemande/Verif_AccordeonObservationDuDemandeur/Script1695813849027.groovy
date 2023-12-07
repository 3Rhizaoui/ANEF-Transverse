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

/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()


/**Vérification De l'Accordéon OBSERVATIONS DU DEMANDEUR
 */
TestObject AccordeonObservatuionDuDemandeur=findTestObject('Object Repository/Page_Verif_AccordeonObservatuionDuDemandeur_Agent/span_AccordeonObservatuionDuDemandeur')
WebUI.verifyElementPresent(AccordeonObservatuionDuDemandeur, 1)

String TitreAccordeonObservatuionDuDemandeur = WebUI.getText(AccordeonObservatuionDuDemandeur)
if(!TitreAccordeonObservatuionDuDemandeur.contains('OBSERVATIONS DU DEMANDEUR')) {
	KeywordUtil.markFailed("Vérifier le titre de L'accordéon OBSERVATIONS DU DEMANDEUR.")}
else {KeywordUtil.markPassed("Le Titre de L'accordéon est bien Affiché : OBSERVATIONS DU DEMANDEUR.")}

