import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import java.util.concurrent.TimeUnit as TimeUnit
import org.openqa.selenium.support.ui.Select as Select
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.interactions.Actions as Actions
import java.util.Iterator as Iterator
import java.util.Set as Set
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()
if (ChangementSituation == 'Non') {
/********************************************************************/
'Option Correspondant à votre situation :Renouvellement DeTitre Séjour  Ou Visiteur'
if ((TypeTitreDeSejour == 'RenouvellementDeTitreSejour') && (Titre == 'Etudiant')) {
    'Sélectionner Le List_TypeEtablissement'
    WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_JetaisEtudiantEnFrance_Non'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_TypeEtablissement'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_TypeEtablissement'))

    'Renseigner Nom de L établissement'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NomDeEtablissement'), 'Nom de L\'établissement')

    'Sélectionner  Cycle d études '
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_CycleEtudes'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_CycleEtudes'))

    'Sélectionner Niveau d études en fin d année'
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_NiveauEtudesEnFinDAnnee'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_NiveauEtudesEnFinDAnnee'))

    'Renseigner Diplôme visé en fin d études '
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DiplomeEnFinDEtudes'), 'Mon Diplôme en Fin D\'études')

    'Sélectionner Discipline '
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_Discipline'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_Discipline'))

    'Répondre par Oui/Non'
    WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_ValidationDAnnee'))

    'Validation'
    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))

    WebUI.delay(2)
}

/********************************************************************/
'Option Correspondant à votre situation : Visiteur'
if (((TypeTitreDeSejour == 'Visiteur') && (Titre == 'Etudiant')) || ((TypeTitreDeSejour == 'RenouvellementDeTitreSejour') && (Titre == 'Visiteur'))) {
    'ATTESTATION SUR L’HONNEUR'
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_NePasVivreEnPolygamie'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_NExercerAucuneActiviteProfessionnelle'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_AvoirConnaissanceDesSanctionsPenalesFausseAttestation'))

    'ASSURANCE MALADIE'
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_AvoirSouscritAUneAssuranceMaladie'))

    'Validation'
    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))

    WebUI.delay(2)
}

/********************************************************************/
'Option Correspondant à votre situation :Salarié Qualifié'
if ((TypeTitreDeSejour == 'TS-PT-SalarieQualifie') && ((Titre == 'Visiteur') || (Titre == 'Etudiant'))) {
    'INFORMATIONS RELATIVES À LA QUALIFICATION '
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_IntituleDuDiplome'), 'Intitulé du diplôme ')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDeDelivrance_JJ'), '10')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDeDelivrance_MM'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/click-select_DateDeDelivrance_MM'))

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDeDelivrance_AAAA'), '2010')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_EtablissementDeDelivrance'), 'Établissement De Délivrance')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NatureDeVotreEmploi'), 'Veuillez préciser la nature de votre emploi')

    'ÉLÉMENTS DU CONTRAT DE TRAVAIL :'

    'Type de contrat de travail'
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeContratDeTravail'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContratDeTravail'))

    'Date de début de contrat '
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDebutContrat_JJ'), '10')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_DateDebutContrat_MM'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDebutContrat_MM'))

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDebutContrat_AAAA'), '2010')

    /*
	'Date de fin de contrat'
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateFinContrat_JJ'),'23')
	WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateFinContrat_MM'),3)
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateFinContrat_AAAA'),'2024')
	*/
    'Vous devez disposer d’un salaire brut minimal de 41 022,72  euros annuel.'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'), '42000')

    'INFORMATIONS RELATIVES À L\'EMPLOYEUR :'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeur'), '44449577400531')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNumeroDeSiret'))

    'Validation'
    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))

    WebUI.delay(2)
}

/********************************************************************/
'Option Correspondant à votre situation :Salarié Entreprise Innovante'
if ((TypeTitreDeSejour == 'TS-PT-SalarieEntrepriseInnovante') && ((Titre == 'Visiteur') || (Titre == 'Etudiant'))) {
    'INFORMATIONS RELATIVES À L\'ACTIVITÉ PROFESSIONNELLE :'
    WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_EntrepriseInnovanteReconnuePublic'))

    WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_EntrepriseInnovanteReconnueOganismePublic'))

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_AttestationMinistereEconomie'), 'Entreprise innovante reconnue par un organisme public')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NatureEmploiEtLienNatureInnovanteEntreprise'), 
        'Veuillez préciser la nature de votre emploi et son lien avec la nature innovante de l’entreprise')

    'ÉLÉMENTS DU CONTRAT DE TRAVAIL :'

    'Type de contrat de travail'
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeContratDeTravail'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContratDeTravail'))

    'Date de début de contrat '
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDebutContrat_JJ'), '10')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_DateDebutContrat_MM'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDebutContrat_MM'))

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDebutContrat_AAAA'), '2010')

    'Vous devez disposer d’un salaire brut minimal de 41 022,72  euros annuel.'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'), '42000')

    'INFORMATIONS RELATIVES À L\'EMPLOYEUR :'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeur'), '44449577400531')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNumeroDeSiret'))

    'Validation'
    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))

    WebUI.delay(2)
}

/********************************************************************/
'Option Correspondant à votre situation :Carte Bleue Européenne'
if ((TypeTitreDeSejour == 'TS-PT-CarteBleueEuropeenne') && ((Titre == 'Visiteur') || (Titre == 'Etudiant'))) {
    WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-CarteBleueEuropeenne'))
	WebUI.delay(2)
    'INFORMATIONS RELATIVES À LA QUALIFICATION :'
    WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_DiplomeSanctionnantAuMoins3AnneesEtudesSuperieures_NON'))

    'INFORMATIONS RELATIVES À L’EXPÉRIENCE PROFESSIONNELLE :'
    WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_InformationsRelativesAMonExperienceProfessionnelle_NON'))

    'ÉLÉMENTS DU CONTRAT DE TRAVAIL :'

    'Type de contrat de travail'
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeContratDeTravail'))

    WebUI.doubleClick(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContratDeTravail'))

    'Date de début de contrat '
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDebutContrat_JJ'), '10')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_DateDebutContrat_MM'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDebutContrat_MM'))

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDebutContrat_AAAA'), '2010')


	if ((TypeTitreDeSejour == 'TS-PT-CarteBleueEuropeenne')) {
		'Vous devez disposer d’un salaire brut minimal de 53836.50  euros annuel.'
		WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'), '53836.50')}
	else {
		'Vous devez disposer d’un salaire brut minimal de 41 022,72  euros annuel.'
		WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'), '42000')}
	
	
	
    'INFORMATIONS RELATIVES À L\'EMPLOYEUR :'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeur'), '44449577400531')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNumeroDeSiret'))

    'Validation'
    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))

    WebUI.delay(2)
}

/********************************************************************/
'Option Correspondant à votre situation :Salarié En Mission'
if ((TypeTitreDeSejour == 'TS-PT-SalarieEnMission') && ((Titre == 'Visiteur') || (Titre == 'Etudiant'))) {
    'INFORMATIONS RELATIVES À L\'ACTIVITÉ PROFESSIONNELLE :'
    WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-SalarieEnMission'))

    'INFORMATIONS RELATIVES AU GROUPE :'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NomDuGroupe'), 'INFORMATIONS RELATIVES AU GROUPE ')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SiteInternetEmployeur'), 'https://www.capgemini.com/fr-fr/')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DureeDeAnciennete'), '15')

    'INFORMATIONS RELATIVES À L\'EMPLOYEUR EN FRANCE '
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeSociete'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeSociete'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeSociete'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeSociete'))

    'INFORMATIONS RELATIVES À L\'EMPLOYEUR :'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeurEnFrance'), '44449577400531')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeur'), '44449577400531')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNumeroDeSiret'))

    'ÉLÉMENTS DU CONTRAT DE TRAVAIL :'

    'Type de contrat de travail'
    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeContratDeTravail'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContratDeTravail'))

    'Date de début de contrat '
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDebutContrat_JJ'), '10')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_DateDebutContrat_MM'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDebutContrat_MM'))

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDebutContrat_AAAA'), '2010')

    'Vous devez disposer d’un salaire brut minimal de 41 022,72  euros annuel.'
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'), '42000')

    'Validation'
    WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))

    WebUI.delay(2)
}
/********************************************************************/
'Option Correspondant à votre situation :ChercheurEtChercheurEnMobilite'
if ((TypeTitreDeSejour == 'ChercheurEtChercheurEnMobilite') && ((Titre == 'Visiteur') || (Titre == 'Etudiant'))) {

	  'INFORMATIONS RELATIVES À LA QUALIFICATION '
    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_IntituleDuDiplome'), 'Intitulé du diplôme ')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDeDelivrance_JJ'), '10')

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDeDelivrance_MM'))

    WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/click-select_DateDeDelivrance_MM'))

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDeDelivrance_AAAA'), '2010')

    WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_EtablissementDeDelivrance'), 'Établissement De Délivrance')

	'INFORMATIONS RELATIVES À L’ACTIVITÉ DE RECHERCHE :'

    "Organisme d'accueil"
     WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_OrganismeDAccueil'), 'Organisme Accueil')
	 
	 "Programme de mobilité dans l'Union Européenne"
     WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_ProgrammeDeMobiliteDansUnionEuropeenne_Non'))
	
	 "Nature du lien avec l'organisme d'accueil"
	 WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click_Select_NatureDuLienOrganismeAccueil'))
	 WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click_Select_Value_NatureDuLienOrganismeAccueil'))
	 
	 'Validation'
	 WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	 
     WebUI.delay(2)
}
	/********************************************************************/
	'Option Correspondant à votre situation :Investisseur (French tech Visa for Investors)'
if ((TypeTitreDeSejour == 'FrenchTechVisaForInvestors') && ((Titre == 'Visiteur') || (Titre == 'Etudiant'))) {
		
	'INFORMATION EN LIEN AVEC LE PROJET D’INVESTISSEMENT'
	 WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_InvestissementPersonnel'))
	 "Montant investi en France "
	 WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_MontantInvestiEnFrance'), '400000')
	 'Validation'
	 WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	}

/********************************************************************/
'Option Correspondant à votre situation :Investisseur (French tech Visa for Investors)'
if (((TypeTitreDeSejour == 'CreateurDEntreprise') && (Titre == 'Visiteur')) || ((TypeTitreDeSejour == 'CreateurDEntreprise') && (Titre == 'Etudiant'))) {
	
	'INFORMATIONS RELATIVES À LA QUALIFICATION'
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_DiplomeDeNiveauMaster_Non'))
	
	"INFORMATIONS RELATIVES À L'EXPÉRIENCE PROFESSIONNELLE"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_NombreEntreprisesGerees'), '0')
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNombreEntreprises'))
	
	"ÉLÉMENTS RELATIFS À L'ENTREPRISE CRÉÉE"
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_EntrepriseANumeroSiret'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_NumeroSiret'), '47976684200724')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNumeroSiret'))

	"Nature des activités"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_NatureDesActivites'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_NatureDesActivites'))
	"activités sont-elles soumises à autorisation d'exercice"

	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_ActivitesSoumisesAutorisationExercice_Non'))
	"Fonction exercée au sein de cette société"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_FonctionExerceeDansLaSociete'), 'FonctionExerceeDansLaSociete')
	"Étes-vous mandaté par une société ayant son siège social à l'étranger"

	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_MandateParSocieteAEtranger_Non'))
	"MOYENS FINANCIERS À DESTINATION DE L'ENTREPRISE CRÉÉE"
	"Nombre de comptes"

	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_NombreDeComptes'), '1')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_confirmerNombreDeComptes'))
	"Informations sur le compte"
	"Nature du dépôt"

	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_NatureDuDepot'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_NatureDuDepot'))

	"Montant "
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_Montant'), '300000')
	"Dénomination de l'organisme tenant le compte"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_DenominationDeOrganismetenantCompte'), 'DenominationDeOrganismetenantCompte')
	"Adresse de l'organisme tenant le compte"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_AdresseOrganismeTenantCompte'), 'AdresseOrganismeTenantCompte')
	"Numéro du compte "
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_NumeroDuCompte'), 'NumeroDuCompte')

	"RESSOURCES"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_RESSOURCES'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_RESSOURCES'))

	"Montant €/mois "
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_MontantParMois'), '2500')
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
}

/********************************************************************/
'Option Correspondant à votre situation :Investisseur (French Tech Visa For Founders)'

if (((TypeTitreDeSejour == 'FrenchTechVisaForFounders') && (Titre == 'Etudiant')) || ((TypeTitreDeSejour == 'FrenchTechVisaForFounders') && (Titre == 'Visiteur'))) {
	
	'INFORMATION EN LIEN AVEC LE PROJET INNOVANT'
	"Veuillez préciser la nature de votre projet"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_PeciserLaNatureDeProjet'), 'Veuillez préciser la nature de votre projet')
	
	"RESSOURCES"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_RESSOURCES'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_RESSOURCES'))
	
	"Montant €/mois "
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_MontantParMois'), '2500')
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
}

/********************************************************************/
'Option Correspondant à votre situation :Investisseur (MandataireSocial)'

if (((TypeTitreDeSejour == 'MandataireSocial') && (Titre == 'Etudiant')) || ((TypeTitreDeSejour == 'MandataireSocial') && (Titre == 'Visiteur'))) {
	
	'INFORMATIONS RELATIVES AU GROUPE '
	"Nom du groupe, N° Siret, NSiret, Site Internet, Durée de l’ancienneté en tant que salarié ou de mandataire au sein du groupe "
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_NomGroupe'), 'Nom du groupe')
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_NSiretGROUPE'), '47976684200724')
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_SiteInternet'), 'Site Internet')
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_DureeAnciennete'), '17')
	
	"INFORMATIONS RELATIVES À LA SOCIÉTÉ ÉTABLIE EN FRANCE AU SEIN DE LAQUELLE VOUS ALLEZ EXERCER LES FONCTIONS DE MANDATAIRE SOCIAL"
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))

	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/imput_NSiretMandataire'),'47976684200724')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_confirmerNSiretMandataire'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_ContratMandataire_Salarie'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_TypeContratMandataireCDI_Salarie'))
	
	"Montant €/mois "
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_RemunerationBruteAnnuelle'), '61534.08')
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))}

/********************************************************************/
'Option Correspondant à votre situation :Passeport Talent/ArtisteNonSalarie'

if (((TypeTitreDeSejour == 'ArtisteNonSalarie') && (Titre == 'Etudiant')) || ((TypeTitreDeSejour == 'ArtisteNonSalarie') && (Titre == 'Visiteur'))) {
	
	"Veuillez sélectionner l'option correspondant à votre situation: Artiste non salarié"
	"Artiste non salarié"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_Artiste_NonSalarie'))
		
	"INFORMATIONS RELATIVES À L'ACTIVITÉ ARTISTIQUE"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_Domaine'), 'Domaine')
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_InformationsComplementaires'), 'Informations complémentaires')
	
	"RESSOURCES"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_RESSOURCES'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_RESSOURCES'))
	
	"Montant €/mois "
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_MontantParMois'), '1196.50')
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))}

/********************************************************************/
'Option Correspondant à votre situation :Passeport Talent/ArtisteSalarie'

if (((TypeTitreDeSejour == 'ArtisteSalarie') && (Titre == 'Etudiant')) || ((TypeTitreDeSejour == 'ArtisteSalarie') && (Titre == 'Visiteur'))) {
	
	"Veuillez sélectionner l'option correspondant à votre situation: Artiste salarié"
	"Artiste salarié"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_Artiste_Salarie'))
		
	"INFORMATIONS RELATIVES À L'ACTIVITÉ PROFESSIONNELLE"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_IntituleDeLEmploi'), 'IntituleDeLEmploi')
	//WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_InformationsComplementaires'), 'Informations complémentaires')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContrat'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_TypeDeContrat'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_Jour_TypeDeContratCDI'),'22')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Mois_TypeDeContratCDI'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_Mois_TypeDeContratCDI'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_Annee_TypeDeContratCDI'),'2020')
	"RESSOURCES"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_RESSOURCES'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_RESSOURCES'))
	
	"Montant €/mois "
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_MontantParMois'), '1196.50')
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))}


/********************************************************************/
'Option Correspondant à votre situation :Passeport Talent  (MembreDeFamillePasseportTalent_Conjoint)'

if (((TypeTitreDeSejour == 'MembreDeFamillePasseportTalent_Conjoint') && (Titre == 'Etudiant')) || ((TypeTitreDeSejour == 'MembreDeFamillePasseportTalent_Conjoint') && (Titre == 'Visiteur'))) {
	
	"Veuillez sélectionner l'option correspondant à votre situation: MembreDeFamillePasseportTalent_Conjoint"
	"Conjoint"

	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_NomConjoint'), 'Conjoint')
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_PrenomConjoint'), 'Prenom')
	
	
	"Date de naissance"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_DateDeNaissanceConjoint_JJ'), '21')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_DateDeNaissanceConjoint_MM'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_ValueDateDeNaissanceConjoint_MM'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_DateDeNaissanceConjoint_AAAA'), '2000')
	
	"N° Étranger "
//	def  NEtrangerConjoint = GlobalVariable.NumEtrangerVisa
//	NEtrangerConjoint = (NEtrangerConjoint - 1)

	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_NEtrangerConjoint'), '7703040689')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNEtrangerConjoint'))
	
	"MA SITUATION FAMILIALE"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_SituationFamiliale'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_SituationFamiliale'))
	
	
	"Date de début de l'union"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_DateDeNaissanceConjoint_JJ'), '21')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_DateDeNaissanceConjoint_MM'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_ValueDateDeNaissanceConjoint_MM'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/input_DateDeNaissanceConjoint_AAAA'), '2011')
	
	"Pays de l'union"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_PaysUnion'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_PaysUnion'))
	
	"ENFANTS"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_EnfantsAVotreCharge'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_EnfantsAChargeDeVotreConjoint'))}}
else {
	"ChangementSituation"
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_MotifChangementSituation'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_Value_MotifChangementSituation'))
}
'Validation'
WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))