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
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


/** modify WebUI.* keywords which take TestObject as arg0
 * 
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

'Connexion et Positionnement des Habilitations Agent'
WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/AgentTraitementDemande/ConnexionPositionnementSiteDeTraitementAgent'), [:], FailureHandling.STOP_ON_FAILURE)

'recherche de la demande En cours'
//WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_DemandeDeTitreDeSejour'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_Liste_MesDemandes'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/a_link_TitreDeSejour'))
WebUI.setText(findTestObject('Object Repository/Page_Accueil_Agent/Input_RechercherUneDemande'), GlobalVariable.NumEtrangerVisa)

/** S'affecter et Ouvrir la demande
 * 
 */
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/div_Tab_tr1NumDemande'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_AffecterLaDemande'))
WebUI.delay(3)
'Vérification de la Popup Reaffecter La Demande'
TestObject PopUpReaffecter =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/PopUp_ReaffecterLaDemande')
WebUI.verifyElementPresent(PopUpReaffecter, 1)
String TitrePopUpReaffecter = WebUI.getText(PopUpReaffecter)
if(!TitrePopUpReaffecter.contains('RÉAFFECTER LA DEMANDE')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp RÉAFFECTER LA DEMANDE.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : RÉAFFECTER LA DEMANDE.")}

TestObject ReaffecterA =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/List_ReaffecterA')
WebUI.verifyElementPresent(ReaffecterA, 1)
WebUI.click(ReaffecterA)
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/select_ElementList_ReaffecterA'))
TestObject PopUpReaffecterBtnConfirmer =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_PopUpReaffecterConfirmer')
WebUI.verifyElementPresent(PopUpReaffecterBtnConfirmer, 1)
WebUI.click(PopUpReaffecterBtnConfirmer)
'retrouver la demande'
WebUI.setText(findTestObject('Object Repository/Page_Accueil_Agent/Input_RechercherUneDemande'), GlobalVariable.NumEtrangerVisa)
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/btn_LoopRecherche'))

'Sélectionner et Ouvrir La Demande'
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/div_Tab_tr1NumDemande'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_VoirLaDemande'))

"Retour à l'accueil"
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/btn_Retour_Accueil_Agent'))
WebUI.setText(findTestObject('Object Repository/Page_Accueil_Agent/Input_RechercherUneDemande'), GlobalVariable.NumEtrangerVisa)

/** Ouvrir la demande
 *
 */
WebUI.delay(3)
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/div_Tab_tr1NumDemande'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_VoirLaDemande'))
WebUI.delay(3)



