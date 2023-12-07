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
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()
WebUI.delay(05)
/**Je vérifie les informations que j'ai saisies en validant les 4 parties afin d'envoyer ma demande. Une fois la demande envoyée, je ne peux plus la modifier.
 *INFORMATIONS PERSONNELLES (1/4)
 *MOTIF DE LA DEMANDE (2/4)
 *RESSOURCES (3/4)
 *JUSTIFICATIFS (4/4)
 */
if(((TypeTitreDeSejour == "RenouvellementDeTitreSejour") || (TypeTitreDeSejour == "Visiteur"))  && ((Titre == 'Visiteur') || (Titre == 'Etudiant'))) {
	//INFORMATIONS PERSONNELLES (1/4)
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtVerifierLaSuiteDeMaSaisie_1sur4'))
	WebUI.delay(02)

	//MOTIF DE LA DEMANDE (2/4)
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtVerifierLaSuiteDeMaSaisie_2sur4'))
	WebUI.delay(02)

	//RESSOURCES (3/4)
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtVerifierLaSuiteDeMaSaisie_3sur4'))
	WebUI.delay(02)

	//JUSTIFICATIFS (4/4)
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtVerifierLaSuiteDeMaSaisie_4sur4'))
	WebUI.delay(02)

	/**Validation
	*/
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtTransmettreMaDemande'))
	WebUI.delay(30)
}

else { 
//(((TypeTitreDeSejour== ("TS-PT-SalarieQualifie"||"TS-PT-SalarieEntrepriseInnovante" ||"TS-PT-CarteBleueEuropeenne" || "TS-PT-SalarieEnMission")) && ((Titre == 'Visiteur') || (Titre == 'Etudiant'))) {

	//INFORMATIONS PERSONNELLES (1/4)
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtVerifierLaSuiteDeMaSaisie_1sur4'))
	WebUI.delay(02)
	
	//MOTIF DE LA DEMANDE (2/4)
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtVerifierLaSuiteDeMaSaisie_2sur4'))
	WebUI.delay(02)
	
	//RESSOURCES (3/4)
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtVerifierLaSuiteDeMaSaisie_3sur4'))
	WebUI.delay(02)

	/**Validation
	 */
	WebUI.click(findTestObject('Object Repository/Page_Recapitulatif_Usager/Btn_ValiderEtTransmettreMaDemande'))
	WebUI.delay(30)
}