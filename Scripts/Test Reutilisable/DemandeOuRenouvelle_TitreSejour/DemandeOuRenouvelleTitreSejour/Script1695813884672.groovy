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
WebUI.delay(3)
if (ChangementSituation == 'Non') {
	
	'Choisir le branchement demandé par mes JDD réutilisables  '
	WebUI.doubleClick(findTestObject('Object Repository/Page_Accueil_Usager/btn_DemandeOuRenouvelleTitreSejour'))
	
	/** Je sollicite le renouvellement de ce titre- dans l'un des cades suivant
	 * 1-Moi-même (à partir de 16 ans) [$Moi-même]
	 * 2- soit Pour:Un mineur bénéficiaire de la protection internationale de plus de 16 ans
	 *   a)En qualité de parent / représentant légal à titre individuel  [$Représentant Légal Personne Morale]
	 *   b)En qualité de représentant légal en tant que personne morale mandatée  [$Parent Représentant Légal Individuel]
	 */
	WebUI.delay(3)
	switch (GlobalVariable.PourQui) {
	
		case 'Moi-même':
			WebUI.check(findTestObject('Object Repository/Page_Accueil_Usager/CheckBox_Moi-meme'))
		break
		case 'Représentant Légal Personne Morale' :
			WebUI.check(findTestObject('Object Repository/Page_Accueil_Usager/CheckBox_MineurBeneficiaire'))
			WebUI.check(findTestObject('Object Repository/Page_Accueil_Usager/CheckBox_RepresentantLegalPersonneMorale'))
		break
		case 'Parent Représentant Légal Individuel' :
			WebUI.check(findTestObject('Object Repository/Page_Accueil_Usager/CheckBox_MineurBeneficiaire'))
			WebUI.check(findTestObject('Object Repository/Page_Accueil_Usager/Check_ParentRepresentantLegalIndividuel'))
		default :
		break
		}
}
else {
	'Choisir le branchement demandé par mes JDD réutilisables  '
	WebUI.doubleClick(findTestObject('Object Repository/Page_Accueil_Usager/btn_ChangementSituation'))
	WebUI.delay(3)

	switch (ChangementSituation) {

		case 'ChangementSituation':
			WebUI.check(findTestObject('Object Repository/Page_Accueil_Usager/CheckBox_ChangementSituation'), FailureHandling.OPTIONAL)
		break
		case 'PertVolDeterioration' :
			WebUI.check(findTestObject('Object Repository/Page_Accueil_Usager/CheckBox_PertVolDeterioration'), FailureHandling.OPTIONAL)
			WebUI.delay(5)
			'Je valide Mon choix'
			WebUI.click(findTestObject('Object Repository/Page_Accueil_Usager/btn_JeContinue'), FailureHandling.OPTIONAL)
			WebUI.delay(5)
			WebUI.check(findTestObject('Object Repository/Page_Accueil_Usager/CheckBox_ProlongerRenouvellementMonTitre'), FailureHandling.OPTIONAL)
			'Je valide Mon choix'
			WebUI.doubleClick(findTestObject('Object Repository/Page_Accueil_Usager/btn_JeContinue'), FailureHandling.OPTIONAL)
			WebUI.delay(5)
		default :
		break
		}
}

'Je valide Mon choix'
WebUI.click(findTestObject('Object Repository/Page_Accueil_Usager/btn_JeContinue'), FailureHandling.OPTIONAL)

if (ChangementSituation == 'Non') {
'Vérification s il y a un message Erreur :Votre Titre De séjour est Expiré Depuis 9 Mois.'
WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/Main/Verif_PopUpVotreTitreEstExpiréDepuis9Mois'), [:], FailureHandling.STOP_ON_FAILURE)
}