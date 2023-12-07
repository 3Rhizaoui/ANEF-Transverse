package tools

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.apache.pdfbox.pdfparser.PDFParser
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.apache.pdfbox.text.PDFTextStripperByArea;
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDPage;
import com.kms.katalon.core.configuration.RunConfiguration
import org.apache.commons.lang3.StringUtils

public class pdfReader2 {
	//'RunConfiguration for get Execution Properties Driver'
	Map RunBrowserConfiguration = RunConfiguration.getExecutionProperties()
	String DriverName = RunBrowserConfiguration.get("drivers").get("system").get("WebUI").get("browserType")
	String pdfFilePath = ""
	@Keyword
	def  ReadPDF(String FileName){
		def boolean MATCH = false
		KeywordUtil logger = new KeywordUtil()

		if (DriverName =='FIREFOX_DRIVER' || 'FIREFOX_HEADLESS_DRIVER') {
			pdfFilePath = (RunConfiguration.getProjectDir() + "/Data Files/Downloads/" + FileName).replace(/\//, '\\')
		}
		else {
			pdfFilePath = GlobalVariable.downloadPath 
		}
		System.out.println("pdfFilePath:" + pdfFilePath);
		File MyFile = new File(pdfFilePath)
		WebUI.navigateToUrl(pdfFilePath, FailureHandling.OPTIONAL)

		String text = ""
		PDDocument document = PDDocument.load(MyFile)
		if (!document.isEncrypted()) {
			PDFTextStripper stripper = new PDFTextStripper();
			text = stripper.getText(document);
			System.out.println("Text:" + text);
		}
		document.close();
		def lines = text.split("(\r\n|\r|\n)", -1);
		String pattern = '^.*Person ([\\S\\s])([\\S\\s])([\\S\\s]+)';
		String searchString = GlobalVariable.NumEtrangerVisa
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);
		// Now create matcher object.
		for(String line:lines){
			Matcher m = r.matcher(line);

			if (line.contains(searchString)) {
				MATCH= true
				System.out.println("MATCH OKKKK");
				System.out.println("Found value: " + line );
				MATCH = true
				String[] NumEtrangerVisaInPDF=line.split (":")
				GlobalVariable.NumEtrangerVisaInPDF = NumEtrangerVisaInPDF[1]

			}else {
				System.out.println("NO MATCH");
			}
		}
		return MATCH
		WebUI.closeBrowser()
	}

}


















