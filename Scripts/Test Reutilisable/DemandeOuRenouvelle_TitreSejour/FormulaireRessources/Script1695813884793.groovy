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

/**L'ensemble de vos ressources doit être au moins égal à 615€ / mois.
 * Sélectionner Origine des ressources
 */

WebUI.click(findTestObject('Object Repository/Page_Ressources_Usager/span_DropDown_OrigineDesRessources'))
WebUI.click(findTestObject('Object Repository/Page_Ressources_Usager/List_OrigineDesRessources'))

/**Renseigner Le Montant Par Mois
 */
WebUI.setText(findTestObject('Object Repository/Page_Ressources_Usager/Input_MontantParMois'), '1500')

/**Hébergement à titre gratuit 
 */
WebUI.check(findTestObject('Object Repository/Page_Ressources_Usager/Check_HebergeTitreGratuit'))

/**Validation
 */
WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))