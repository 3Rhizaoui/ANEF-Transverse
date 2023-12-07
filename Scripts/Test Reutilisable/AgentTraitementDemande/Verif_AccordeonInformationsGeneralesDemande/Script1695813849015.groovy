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
* so that they call Highlight.on() automatically
*/
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

/**Vérification De la PopUp Afficher Commentaires
 *
 */
TestObject LinkLesCommentaires=findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/LinkLesCommentaires')
WebUI.verifyElementPresent(LinkLesCommentaires, 1)
WebUI.click(LinkLesCommentaires)
TestObject PopUpAfficherCommentaires =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/PopUp_AfficherCommentaires')
WebUI.verifyElementPresent(PopUpAfficherCommentaires, 1)
String TitrePopUpAfficherCommentaires = WebUI.getText(PopUpAfficherCommentaires)
if(!TitrePopUpAfficherCommentaires.contains('AFFICHER LES COMMENTAIRES')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp AFFICHER LES COMMENTAIRES.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : AFFICHER LES COMMENTAIRES.")}


TestObject PopUpCommentairesBtnFermer =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_PopUpCommentaireFermer')
WebUI.verifyElementPresent(PopUpCommentairesBtnFermer, 1)
WebUI.click(PopUpCommentairesBtnFermer)


/**Vérification Du Texte Statut de La Demande Avec Vérification Du Numéro de La demande
 * 
 */
TestObject StatutDemandeurAvecNumEtranger = findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/h3_StatutDemandeurAvecNumEtranger')
WebUI.verifyElementPresent(StatutDemandeurAvecNumEtranger, 1)
String NumEtranger = WebUI.getText(StatutDemandeurAvecNumEtranger)
if(!NumEtranger.contains(GlobalVariable.NumEtrangerVisa)) {	
	KeywordUtil.markFailed("Vérifier le Numéro Etranger de la demande ouverte.")}
else {KeywordUtil.markPassed("Le Numéro Etranger de la demande est bien Affiché.")}


/**Vérification De la PopUp Historique de la demande
 * 
 */
TestObject AfficherHistorique= findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/Link_AfficherHistorique')
WebUI.verifyElementPresent(AfficherHistorique, 1)
WebUI.click(AfficherHistorique)
TestObject PopUpHistoriqueDeLaDemande =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/PopUp_HistoriqueDeLaDemande')
WebUI.verifyElementPresent(PopUpHistoriqueDeLaDemande, 1)
String TitreHistoriqueDeLaDemande = WebUI.getText(PopUpHistoriqueDeLaDemande)
if(!TitreHistoriqueDeLaDemande.contains('HISTORIQUE DE LA DEMANDE')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp Historique de la demande.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : Historique de la demande.")}

TestObject ListeAction =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/List_TypeAction')
WebUI.verifyElementPresent(ListeAction, 1)
WebUI.click(ListeAction)

TestObject PopUpHistoBtnFermer =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_PopUpHistoFermer')
WebUI.verifyElementPresent(PopUpHistoBtnFermer, 1)
WebUI.click(PopUpHistoBtnFermer)


/**Vérification De la PopUp Afficher Les Document Additionnels
 * 
 */
TestObject AfficherDocumentsAdditionnels= findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/Link_AfficherDocsAdditionnels')
WebUI.verifyElementPresent(AfficherDocumentsAdditionnels, 1)
WebUI.click(AfficherDocumentsAdditionnels)
TestObject PopUpDocsAdditionnels =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/PopUpDocsAdditionnels')
WebUI.verifyElementPresent(PopUpDocsAdditionnels, 1)
String TitrePopUpDocsAdditionnels = WebUI.getText(PopUpDocsAdditionnels)
if(!TitrePopUpDocsAdditionnels.contains('DOCUMENTS ADDITIONNELS')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp DOCUMENTS ADDITIONNELS.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : DOCUMENTS ADDITIONNELS.")}
/*
TestObject AjouterNouveauDocument =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_AjouterNouveauDocument')
WebUI.verifyElementPresent(AjouterNouveauDocument, 1)
WebUI.click(AjouterNouveauDocument)

TestObject TypeDocument =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/List_TypeDocument')
WebUI.verifyElementPresent(TypeDocument, 1)
WebUI.click(TypeDocument)
*/
TestObject PopUpDocumentAddBtnFermer =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_PopUpDocumentsAddFermer')
WebUI.verifyElementPresent(PopUpDocumentAddBtnFermer, 1)
WebUI.click(PopUpDocumentAddBtnFermer)



/**Vérification De la PopUp TRANSFERER
 * 
 */
TestObject LinkTransferer=findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/Link_Transferer')
WebUI.verifyElementPresent(LinkTransferer, 1)
WebUI.click(LinkTransferer)
TestObject PopUpTransferer =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/PopUp_TransfererLaDemande')
WebUI.verifyElementPresent(PopUpTransferer, 1)
String TitrePopUpTransferer = WebUI.getText(PopUpTransferer)
if(!TitrePopUpTransferer.contains('TRANSFÉRER LA DEMANDE')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp TRANSFÉRER LA DEMANDE.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : TRANSFÉRER LA DEMANDE.")}

TestObject TransfererA =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/List_TransfererA')
WebUI.verifyElementPresent(TransfererA, 1)
WebUI.doubleClick(TransfererA)
WebUI.delay(2)
TestObject PopUpTransfererBtnAnnuler =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_PopUpTransfererAnnuler')
WebUI.verifyElementPresent(PopUpTransfererBtnAnnuler, 2)
WebUI.click(PopUpTransfererBtnAnnuler)



/**Vérification De la PopUp REAFFECTER
 *
 */
TestObject LinkReaffecter=findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/Link_Reaffecter')
WebUI.verifyElementPresent(LinkReaffecter, 1)
WebUI.click(LinkReaffecter)
TestObject PopUpReaffecter =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/PopUp_ReaffecterLaDemande')
WebUI.verifyElementPresent(PopUpReaffecter, 1)
String TitrePopUpReaffecter = WebUI.getText(PopUpReaffecter)
if(!TitrePopUpReaffecter.contains('RÉAFFECTER LA DEMANDE')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp RÉAFFECTER LA DEMANDE.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : RÉAFFECTER LA DEMANDE.")}

TestObject ReaffecterA =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/List_ReaffecterA')
WebUI.verifyElementPresent(ReaffecterA, 1)
WebUI.doubleClick(ReaffecterA)

TestObject PopUpReaffecterBtnConfirmer =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_PopUpReaffecterAnnuler')
WebUI.verifyElementPresent(PopUpReaffecterBtnConfirmer, 1)
WebUI.click(PopUpReaffecterBtnConfirmer)


/**Vérification De la PopUp PRODUIRE UNE ATTESTATION DE PROLONGATION
 *
 */

TestObject LinkAttestationProlongation=findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/Link_AttestationProlongation')
WebUI.verifyElementPresent(LinkAttestationProlongation, 1)
WebUI.click(LinkAttestationProlongation)
TestObject PopUpAttestationProlongation =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/PopUp_AttestationProlongation')
WebUI.verifyElementPresent(PopUpAttestationProlongation, 1)
String TitrePopUpAttestationProlongation = WebUI.getText(PopUpAttestationProlongation)
if(!TitrePopUpAttestationProlongation.contains('PRODUIRE UNE ATTESTATION DE PROLONGATION')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp PRODUIRE UNE ATTESTATION DE PROLONGATION.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : PRODUIRE UNE ATTESTATION DE PROLONGATION.")}

TestObject MotifProlongation =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/List_MotifProlongation')
WebUI.verifyElementPresent(MotifProlongation, 1)
WebUI.doubleClick(MotifProlongation)

TestObject PopUpAttestationProlongationBtnAnnuler =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_PopUpAttestationProlongationAnnuler')
WebUI.verifyElementPresent(PopUpAttestationProlongationBtnAnnuler, 1)
WebUI.click(PopUpAttestationProlongationBtnAnnuler)


/**Vérification Des Boutons De La Page De Traitement De La Demande  (verifyElementPresent , verifyElementClickable)
 *Enregistrer et quitter
 *Suspendre l’instruction
 *Clôturer la demande
 *Valider l'adresse / Rapatrier le dossier
 * < RETOUR À TOUTES LES DEMANDES 
 */

TestObject Btn_EnregistrerQuitter =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_EnregistrerQuitter')
WebUI.verifyElementPresent(Btn_EnregistrerQuitter, 1)
WebUI.verifyElementClickable(Btn_EnregistrerQuitter)

TestObject Btn_SuspendreInstruction =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_SuspendreInstruction')
WebUI.verifyElementPresent(Btn_SuspendreInstruction, 1)
WebUI.verifyElementClickable(Btn_SuspendreInstruction)

TestObject Btn_ClôturerLaDemande =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_CloturerLaDemande')
WebUI.verifyElementPresent(Btn_ClôturerLaDemande, 1)
WebUI.verifyElementClickable(Btn_ClôturerLaDemande)

TestObject Btn_ValiderAdresseRapatrierLeDossier =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_ValiderAdresseRapatrierLeDossier')
WebUI.verifyElementPresent(Btn_ValiderAdresseRapatrierLeDossier, 1)
WebUI.verifyElementClickable(Btn_ValiderAdresseRapatrierLeDossier)

TestObject link_RetourAToutesLesDemandes =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_RetourAToutesLesDemandes')
WebUI.verifyElementPresent(link_RetourAToutesLesDemandes, 1)
WebUI.verifyElementClickable(link_RetourAToutesLesDemandes)