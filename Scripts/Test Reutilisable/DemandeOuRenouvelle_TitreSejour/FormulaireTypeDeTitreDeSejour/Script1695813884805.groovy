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

/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

/**Vous êtes titulaire d'un titre de séjour en tant que <&&&&&>
 * Je sollicite le renouvellement de ce titre [$RenouvellementDeTitreSéjour]
 * Ou un autre Type de Titre De Séjour :
 * 1. [$étudiant]
 * 2. [$Visiteur]
 * 3. [$PasseportTalent]
 * 4. [$bénéficiaireProtectionInternationale]
 * 5. [$SolliciteTS_salarie-HorsPasseportTalent-HorsCitoyenUE]
 * 6. [$MembreDeFamille]
 * 7. [$SituationDeVulnérabilité]
 * 8. [$SolliciteTS_CitoyenDeUnionEuropéenne]
 * 9. [$SolliciteTS_RessortissantEtrangerNeEnFrance]
 * 10.[$SolliciteTS_MotifHumanitaire]
 * 11.[$SolliciteTS_JeuneAuPair-AncienCombattant-RetraiteAyantTravailleEnFrance]
 */
WebUI.delay(10)
switch (TypeTitreDeSejour) {

	case 'RenouvellementDeTitreSejour':
		if ((Titre== "Visiteur") || (Titre == "Etudiant")) {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteRenouvellementDeTitreSejour'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)
			}
	break
	case 'etudiant' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteEtudiant'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break
	case 'Visiteur' :
		if (Titre== "Visiteur") {
			
			alertTextVisiteur = "Un Profile  'Visiteur' ne peut pas demander un type Titre de séjour 'Visiteur' mais il peut plutôt renouvler son Titre de séjour"
 			KeywordUtil.markWarning(alertTextVisiteur)}
	
			else {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_Visiteur'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'2 éme Validation de mon choix'
			WebUI.doubleClick(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}

	break

//'Cas d'un Passeport Talent Salarié Qualifié'
/**********************************************/
	case 'TS-PT-SalarieQualifie' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_SalarieQualifie'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-SalarieQualifie'))
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'3 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break
	case 'TS-PT-SalarieEntrepriseInnovante' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_SalarieQualifie'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-SalarieEntrepriseInnovante'))
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'3 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break
	case 'TS-PT-CarteBleueEuropeenne' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_SalarieQualifie'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-CarteBleueEuropeenne'))
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'3 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break
	case 'TS-PT-SalarieEnMission' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_SalarieQualifie'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-SalarieEnMission'))
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'3 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break
	//'Cas d'un Passeport Talent
	/**********************************************/
	case 'ChercheurEtChercheurEnMobilite' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_ChercheurEtChercheurEnMobilite'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			'3 éme Validation de mon choix'
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break

	//'Cas d'un Passeport Talent :investisseur ou porteur d'un projet économique'
	/***************************************************/
	case 'FrenchTechVisaForInvestors' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_InvestisseurOuPorteurProjetEconomique'))
			'Valider mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-FrenchTechVisaForInvestors'))
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'3 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break

	case 'CreateurDEntreprise' :
	if (Titre== "Visiteur" || Titre == "Etudiant") {
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_InvestisseurOuPorteurProjetEconomique'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-CreateurDEntreprise'))
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
		WebUI.delay(5)
		'3 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
		WebUI.delay(5)}
	break

	case 'FrenchTechVisaForFounders' :
	if (Titre== "Visiteur" || Titre == "Etudiant") {
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_InvestisseurOuPorteurProjetEconomique'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-FrenchTechVisaForFounders'))
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
		WebUI.delay(5)
		'3 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
		WebUI.delay(5)}
	break
	
	case 'MandataireSocial' :
	if (Titre== "Visiteur" || Titre == "Etudiant") {
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_InvestisseurOuPorteurProjetEconomique'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-MandataireSocial'))
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
		WebUI.delay(3)
		'3 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))}
	break
	
	//'Cas d'un Passeport Talent
	/********************************************************************************/
		case 'ArtisteNonSalarie' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_Artiste'))
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
		    '3 éme Validation de mon choix'
		    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break
		case 'ArtisteSalarie' :
			if (Titre== "Visiteur" || Titre == "Etudiant") {
				WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_Artiste'))
			'2 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'3 éme Validation de mon choix'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
		break
	case 'MembreDeFamillePasseportTalent_Conjoint' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_MembreDeFamillePasseportTalent'))
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_MembreDeFamillePasseportTalent_Conjoint'))
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
			WebUI.delay(5)
			'3 éme Validation de mon choix'
		    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
			WebUI.delay(5)}
	break
	
	case 'MembreDeFamillePasseportTalent_EnfantEtJeuneMajeur' :
	if (Titre== "Visiteur" || Titre == "Etudiant") {
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_MembreDeFamillePasseportTalent'))
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
		WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_MembreDeFamillePasseportTalent_EnfantEtJeuneMajeur'))
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_JeCommence'))
		WebUI.delay(5)
		'3 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/Btn_JeContinue'))
		WebUI.delay(5)}
	break

	case 'PersonneDeRenomméeInternationale' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_PersonneDeRenommeeInternationale'))}
	break
	/********************************************************************************/
	
	case 'bénéficiaireProtectionInternationale' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_ProtectionInternationale'))}
	break
	case 'SolliciteTS_salarie-HorsPasseportTalent-HorsCitoyenUE' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_salarieHorsPasseportTalentHorsCitoyenUE'))}
	break
	case 'MembreDeFamille' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_MembreDeFamille'))}
	break
	case 'SituationDeVulnérabilité' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_SituationDeVulnerabilite'))}
	break
	case 'SolliciteTS_CitoyenDeUnionEuropéenne' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_CitoyenDeUnionEuropeenne'))}
	break
	case 'SolliciteTS_RessortissantEtrangerNeEnFrance' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_RessortissantEtrangerNeEnFrance'))}
	break
	case 'SolliciteTS_MotifHumanitaire' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_MotifHumanitaire'))}
	break
	case 'SolliciteTS_JeuneAuPair-AncienCombattant-RetraiteAyantTravailleEnFrance' :
		if (Titre== "Visiteur" || Titre == "Etudiant") {
			WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_JeuneAuPairAncienCombattantRetraiteAyantTravailleEnFrance'))}
	default :
	break
}

'Vérification s il y a un message Erreur : Il est trop tôt pour demander le renouvellement de votre titre.'
WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/Main/Verif_PopUpTropTotPourDemanderLeRenouvellementDeVotreTitre'), [:], FailureHandling.STOP_ON_FAILURE)


