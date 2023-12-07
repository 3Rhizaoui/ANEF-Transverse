
package tools

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import java.net.URI
import java.net.URISyntaxException
import java.util.HashMap
import java.util.Map
import groovy.json.JsonSlurper
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.File
import org.apache.commons.lang3.StringUtils
import org.apache.http.HttpEntity
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import internal.GlobalVariable
import java.io.BufferedReader

import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.awt.Robot as Robot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.configuration.RunConfiguration
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonBuilder as JsonBuilder
import groovy.json.JsonOutput as JsonOutput
import groovy.io.FileType as FileType
import java.text.SimpleDateFormat as SimpleDateFormat
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper



public class JsonWriter {


	@Keyword
	public  String WriterFile (String JsonTxt, String fileName) {

		String PathFile = "C:\\" + fileName
		//String data = "This is the data in the output file";

		try {
			// Creates a FileWriter
			FileWriter file = new FileWriter(PathFile);

			// Creates a BufferedWriter
			BufferedWriter output = new BufferedWriter(file);

			// Writes the string to the file
			output.write(JsonTxt);

			// Closes the writer
			output.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}
	}

}