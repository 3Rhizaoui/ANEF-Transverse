
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import java.lang.Object

import org.apache.poi.ss.usermodel.Workbook

import java.util.List

import org.apache.poi.ss.usermodel.Sheet

import java.util.Map

import org.apache.poi.ss.usermodel.Cell

import org.apache.poi.ss.usermodel.Row



def static "tools.JsonWriter.WriterFile"(
    	String JsonTxt	
     , 	String fileName	) {
    (new tools.JsonWriter()).WriterFile(
        	JsonTxt
         , 	fileName)
}

 /***
	 * Initialize the Services with the current page and current Network & clear Browser Cookies & clear Browser Cache
	 * This can be done after the opening of the page and Network
	 *
	 * @return null
	 */ 
def static "tools.EventsNetWorkChromeConsole.InitializeWebDriveDeleteAllNodeExe"() {
    (new tools.EventsNetWorkChromeConsole()).InitializeWebDriveDeleteAllNodeExe()
}

 /***
	 * Enable listen to Network and listen to the page trigger
	 * This sets the possibilities later for the Chrome listener
	 * 
	 * @param listenPage true if the listener for Page should be turned on
	 * @param listenNetwork if the listener for network should be turned on
	 * @return null
	 */ 
def static "tools.EventsNetWorkChromeConsole.RegisterListender"(
    	boolean listenPage	
     , 	boolean listenNetwork	) {
    (new tools.EventsNetWorkChromeConsole()).RegisterListender(
        	listenPage
         , 	listenNetwork)
}

 /***
	 * Reset the currently collected data
	 * 
	 * @return null
	 */ 
def static "tools.EventsNetWorkChromeConsole.ResetDataCollection"() {
    (new tools.EventsNetWorkChromeConsole()).ResetDataCollection()
}

 /***
	 * wait for the collection of the request data
	 * 	
	 * @return null
	 */ 
def static "tools.EventsNetWorkChromeConsole.WaitForRequestData"() {
    (new tools.EventsNetWorkChromeConsole()).WaitForRequestData()
}


def static "tools.EventsNetWorkChromeConsole.GetResponse"() {
    (new tools.EventsNetWorkChromeConsole()).GetResponse()
}

 /***
	 * get the collected request data as string
	 * @param dumpToFile true if the dumping to file should be turned on
	 * @return returns the request Json string as original not encoded since groovy can not handle them when parsing
	 */ 
def static "tools.EventsNetWorkChromeConsole.GetRequestString"(
    	boolean dumpToFile	) {
    (new tools.EventsNetWorkChromeConsole()).GetRequestString(
        	dumpToFile)
}

 /***
	 * Dump a string to a file
	 *  
	 * @param dumpFileName Name of the file
	 * @param data string data that should be written to the file
	 * @return null
	 * */ 
def static "tools.EventsNetWorkChromeConsole.DumpToFile"(
    	String dumpFileName	
     , 	String data	) {
    (new tools.EventsNetWorkChromeConsole()).DumpToFile(
        	dumpFileName
         , 	data)
}

 /***
	 * Take a screenshot of the page as it is
	 * @param outputFilename dump file location
	 * @return NULL
	 * */ 
def static "tools.EventsNetWorkChromeConsole.TakePageScreenshot"(
    	String outputFilename	) {
    (new tools.EventsNetWorkChromeConsole()).TakePageScreenshot(
        	outputFilename)
}

 /***
	 * Set the page of the browser to the full size of the content
	 * Remove the scroll bar of the given page
	 * Take a picture of it 
	 * 	
	 * @param devToolsService
	 * @param outputFilename
	 * @return NULL
	 */ 
def static "tools.EventsNetWorkChromeConsole.TakeFullPageScreenshot"(
    	String outputFilename	) {
    (new tools.EventsNetWorkChromeConsole()).TakeFullPageScreenshot(
        	outputFilename)
}

 /**
	 * Upload file using robot.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */ 
def static "tools.UploadMyFile.uploadFileUsingRobot"(
    	String file	) {
    (new tools.UploadMyFile()).uploadFileUsingRobot(
        	file)
}

 /**
	 * Upload file using robot.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */ 
def static "tools.UploadMyFile.setClipboardData"(
    	String string	) {
    (new tools.UploadMyFile()).setClipboardData(
        	string)
}

 /**
	 * Upload file.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */ 
def static "tools.UploadMyFile.uploadMyFile"(
    	TestObject object	
     , 	String file	) {
    (new tools.UploadMyFile()).uploadMyFile(
        	object
         , 	file)
}


def static "tools.MongoDBConnection.connectMongoDB"(
    	String mongoURI	
     , 	String dbase	
     , 	String collectionName	) {
    (new tools.MongoDBConnection()).connectMongoDB(
        	mongoURI
         , 	dbase
         , 	collectionName)
}


def static "tools.pdfReader2.ReadPDF"(
    	String FileName	) {
    (new tools.pdfReader2()).ReadPDF(
        	FileName)
}


def static "tools.deleteFileDirectory.cleanDirectory"() {
    (new tools.deleteFileDirectory()).cleanDirectory()
}


def static "tools.deleteFileDirectory.FilesgetName"() {
    (new tools.deleteFileDirectory()).FilesgetName()
}


def static "tools.CapabilitiesSpecificDownloadDirectory.SetSpecificDownloadDirectoryIfNeeded"() {
    (new tools.CapabilitiesSpecificDownloadDirectory()).SetSpecificDownloadDirectoryIfNeeded()
}


def static "tools.CustomWebDriverFactory.createWebDriver"() {
    (new tools.CustomWebDriverFactory()).createWebDriver()
}


def static "tools.WaitForLoadedPage.waitForElementRendering"() {
    (new tools.WaitForLoadedPage()).waitForElementRendering()
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectOptionByIndex"(
    	TestObject dropdownObject	
     , 	Object range	
     , 	boolean isSelect	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectOptionByIndex(
        	dropdownObject
         , 	range
         , 	isSelect)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectOptionByIndex"(
    	TestObject dropdownObject	
     , 	Object range	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectOptionByIndex(
        	dropdownObject
         , 	range)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.verifyOptionSelectedByName"(
    	TestObject dropdownObject	
     , 	String expectedName	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).verifyOptionSelectedByName(
        	dropdownObject
         , 	expectedName)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.verifyOptionItemsStatus"(
    	TestObject dropdownObject	
     , 	String listItemNames	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).verifyOptionItemsStatus(
        	dropdownObject
         , 	listItemNames)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.verifyOptionItemsStatus"(
    	TestObject dropdownObject	
     , 	String listItemNames	
     , 	boolean expectedStatus	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).verifyOptionItemsStatus(
        	dropdownObject
         , 	listItemNames
         , 	expectedStatus)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectOptionByName"(
    	TestObject dropdownObject	
     , 	String listItemNames	
     , 	boolean isSelect	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectOptionByName(
        	dropdownObject
         , 	listItemNames
         , 	isSelect)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectOptionByName"(
    	TestObject dropdownObject	
     , 	String listItemNames	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectOptionByName(
        	dropdownObject
         , 	listItemNames)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectSubOptionByIndex"(
    	TestObject dropdownObject	
     , 	String optionGroupName	
     , 	Object range	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectSubOptionByIndex(
        	dropdownObject
         , 	optionGroupName
         , 	range)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectSubOptionByIndex"(
    	TestObject dropdownObject	
     , 	String optionGroupName	
     , 	Object range	
     , 	boolean isSelect	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectSubOptionByIndex(
        	dropdownObject
         , 	optionGroupName
         , 	range
         , 	isSelect)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectSubOptionByName"(
    	TestObject dropdownObject	
     , 	String optionGroupName	
     , 	String listItemNames	
     , 	boolean isSelect	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectSubOptionByName(
        	dropdownObject
         , 	optionGroupName
         , 	listItemNames
         , 	isSelect)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectSubOptionByName"(
    	TestObject dropdownObject	
     , 	String optionGroupName	
     , 	String listItemNames	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectSubOptionByName(
        	dropdownObject
         , 	optionGroupName
         , 	listItemNames)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectAllOption"(
    	TestObject dropdownObject	
     , 	boolean isSelect	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectAllOption(
        	dropdownObject
         , 	isSelect)
}


def static "com.katalon.plugin.keyword.angularjs.DropdownKeywords.selectAllOption"(
    	TestObject dropdownObject	) {
    (new com.katalon.plugin.keyword.angularjs.DropdownKeywords()).selectAllOption(
        	dropdownObject)
}


def static "com.kms.katalon.keyword.testlink.TestlinkKeywords.updateResults"(
    	String testcaseName	
     , 	String exception	
     , 	String results	) {
    (new com.kms.katalon.keyword.testlink.TestlinkKeywords()).updateResults(
        	testcaseName
         , 	exception
         , 	results)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.createExcelSheets"(
    	Workbook workbook	
     , 	java.util.List<String> sheetNames	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).createExcelSheets(
        	workbook
         , 	sheetNames)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getCellIndexByAddress"(
    	Sheet sheet	
     , 	String cellAddress	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getCellIndexByAddress(
        	sheet
         , 	cellAddress)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getCellValueByIndex"(
    	Sheet sheet	
     , 	int rowIdx	
     , 	int colIdx	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getCellValueByIndex(
        	sheet
         , 	rowIdx
         , 	colIdx)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getCellValueByAddress"(
    	Sheet sheet	
     , 	String cellAddress	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getCellValueByAddress(
        	sheet
         , 	cellAddress)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getColumnsByIndex"(
    	Sheet sheet	
     , 	java.util.List<java.lang.Integer> columnIndexes	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getColumnsByIndex(
        	sheet
         , 	columnIndexes)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.setValueToCellByIndex"(
    	Sheet sheet	
     , 	int rowIndex	
     , 	int colIndex	
     , 	Object value	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).setValueToCellByIndex(
        	sheet
         , 	rowIndex
         , 	colIndex
         , 	value)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getRowIndexByCellContent"(
    	Sheet sheet	
     , 	String cellContent	
     , 	int columnIdxForCell	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getRowIndexByCellContent(
        	sheet
         , 	cellContent
         , 	columnIdxForCell)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getMapOfKeyValueRows"(
    	Sheet sheet	
     , 	int keyRowIdx	
     , 	int valueRowIdx	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getMapOfKeyValueRows(
        	sheet
         , 	keyRowIdx
         , 	valueRowIdx)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getCellValuesByRangeIndexes"(
    	Sheet sheet	
     , 	int rowInd1	
     , 	int colInd1	
     , 	int rowInd2	
     , 	int colInd2	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getCellValuesByRangeIndexes(
        	sheet
         , 	rowInd1
         , 	colInd1
         , 	rowInd2
         , 	colInd2)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getCellValueByRangeAddress"(
    	Sheet sheet	
     , 	String topLeftAddress	
     , 	String rightBottomAddress	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getCellValueByRangeAddress(
        	sheet
         , 	topLeftAddress
         , 	rightBottomAddress)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getExcelSheetByName"(
    	String filePath	
     , 	String sheetName	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getExcelSheetByName(
        	filePath
         , 	sheetName)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.setValueToCellByAddresses"(
    	Sheet sheet	
     , 	Map content	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).setValueToCellByAddresses(
        	sheet
         , 	content)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.setValueToCellByAddress"(
    	Sheet sheet	
     , 	String cellAddress	
     , 	Object value	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).setValueToCellByAddress(
        	sheet
         , 	cellAddress
         , 	value)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getWorkbook"(
    	String filePath	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getWorkbook(
        	filePath)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.createExcelSheet"(
    	Workbook workbook	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).createExcelSheet(
        	workbook)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.createExcelSheet"(
    	Workbook workbook	
     , 	String sheetName	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).createExcelSheet(
        	workbook
         , 	sheetName)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.saveWorkbook"(
    	String filePath	
     , 	Workbook workbook	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).saveWorkbook(
        	filePath
         , 	workbook)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getExcelSheet"(
    	Workbook wbs	
     , 	String sheetName	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getExcelSheet(
        	wbs
         , 	sheetName)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getExcelSheet"(
    	String filePath	
     , 	int sheetIndex	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getExcelSheet(
        	filePath
         , 	sheetIndex)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getExcelSheet"(
    	Workbook wbs	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getExcelSheet(
        	wbs)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getExcelSheet"(
    	String filePath	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getExcelSheet(
        	filePath)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.createExcelFile"(
    	String filePath	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).createExcelFile(
        	filePath)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.locateCell"(
    	Sheet sheet	
     , 	Object cellContent	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).locateCell(
        	sheet
         , 	cellContent)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getSheetNames"(
    	Workbook workbook	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getSheetNames(
        	workbook)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getCellByIndex"(
    	Sheet sheet	
     , 	int rowIdx	
     , 	int colIdx	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getCellByIndex(
        	sheet
         , 	rowIdx
         , 	colIdx)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.createWorkbook"(
    	String filePath	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).createWorkbook(
        	filePath)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getCellByAddress"(
    	Sheet sheet	
     , 	String cellAddress	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getCellByAddress(
        	sheet
         , 	cellAddress)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoCells"(
    	Cell cell1	
     , 	Cell cell2	
     , 	boolean isValueOnly	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).compareTwoCells(
        	cell1
         , 	cell2
         , 	isValueOnly)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoCells"(
    	Cell cell1	
     , 	Cell cell2	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).compareTwoCells(
        	cell1
         , 	cell2)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getCellValue"(
    	Cell cell	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getCellValue(
        	cell)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoRows"(
    	Row row1	
     , 	Row row2	
     , 	boolean isValueOnly	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).compareTwoRows(
        	row1
         , 	row2
         , 	isValueOnly)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoRows"(
    	Row row1	
     , 	Row row2	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).compareTwoRows(
        	row1
         , 	row2)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoExcels"(
    	Workbook workbook1	
     , 	Workbook workbook2	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).compareTwoExcels(
        	workbook1
         , 	workbook2)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoExcels"(
    	Workbook workbook1	
     , 	Workbook workbook2	
     , 	boolean isValueOnly	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).compareTwoExcels(
        	workbook1
         , 	workbook2
         , 	isValueOnly)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getDataRows"(
    	Sheet sheet	
     , 	java.util.List<java.lang.Integer> rowIndexs	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getDataRows(
        	sheet
         , 	rowIndexs)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.getTableContent"(
    	Sheet sheet	
     , 	int startRow	
     , 	int endRow	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).getTableContent(
        	sheet
         , 	startRow
         , 	endRow)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoSheets"(
    	Sheet sheet1	
     , 	Sheet sheet2	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).compareTwoSheets(
        	sheet1
         , 	sheet2)
}


def static "com.kms.katalon.keyword.excel.ExcelKeywords.compareTwoSheets"(
    	Sheet sheet1	
     , 	Sheet sheet2	
     , 	boolean isValueOnly	) {
    (new com.kms.katalon.keyword.excel.ExcelKeywords()).compareTwoSheets(
        	sheet1
         , 	sheet2
         , 	isValueOnly)
}


def static "com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords.deleteRangeOfText"(
    	TestObject toContainer	
     , 	int startPos	
     , 	int charCount	) {
    (new com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords()).deleteRangeOfText(
        	toContainer
         , 	startPos
         , 	charCount)
}


def static "com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords.selectRangeOfText"(
    	TestObject toContainer	
     , 	int startPos	
     , 	int charCount	) {
    (new com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords()).selectRangeOfText(
        	toContainer
         , 	startPos
         , 	charCount)
}


def static "com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords.setCaretPosition"(
    	TestObject toContainer	
     , 	int position	) {
    (new com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords()).setCaretPosition(
        	toContainer
         , 	position)
}


def static "com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords.getContentText"(
    	TestObject toContainer	) {
    (new com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords()).getContentText(
        	toContainer)
}


def static "com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords.selectTextFormat"(
    	TestObject toMenuBar	
     , 	String format	
     , 	boolean isActive	) {
    (new com.kms.katalon.webui.keyword.vuejs.RichTextEditorKeywords()).selectTextFormat(
        	toMenuBar
         , 	format
         , 	isActive)
}
