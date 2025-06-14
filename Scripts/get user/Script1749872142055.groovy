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

def respons = WS.sendRequest(findTestObject('get-user', [('page') : '2']))

WS.verifyResponseStatusCode(respons, 200)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(respons.getResponseBodyContent())

def id = result.data[4].id

def first_name = result.data[1].first_name

def last_name = result.data[1].last_name

def email = result.data[1].email

//validate id

assert id != null

assert id instanceof Integer

assert id == 11

//validate nama depan

assert first_name != null

assert first_name instanceof String

assert first_name == 'Lindsay'

//validate nama belakang

assert last_name != null

assert last_name instanceof String

assert last_name == 'Ferguson'

//validate email

assert email != null

assert email instanceof String

assert email == 'lindsay.ferguson@reqres.in'
