package tools

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.mongodb.client.MongoCursor
import com.mongodb.MongoClient
import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import com.mongodb.DBCursor
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.MongoClientURI
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.FindIterable
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
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.MongoCredential
import com.mongodb.ServerApiVersion;
import com.mongodb.reactivestreams.client.MongoClients;
import internal.GlobalVariable
import com.mongodb.ServerAddress;
import org.bson.Document;


public class MongoDBConnection {
	@Keyword
	def connectMongoDB(String mongoURI, String dbase, String collectionName) {

		// Creating a Mongo client
		MongoClient mongoClient = MongoClients.create(mongoURI)

		// Accessing the database
		MongoDatabase database = mongoClient.getDatabase(dbase)
		println("\nConnected Successfully to Database: " +database)

		// Retrieving collections
		println('\nList of DB Collections in Database - "'+dbase+'" are: ');
		for (String collectionList : database.listCollectionNames()) {
			println("--	"+collectionList)
		}

		// Connect to a Collection
		MongoCollection<Document> collection = database.getCollection(collectionName);
		println("\nConnected Successfully to Collection: " +collection)
	}
}
