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

def respons = WS.sendRequest(findTestObject('delay respons', [('resp') : '3\r\n']))

WS.verifyResponseStatusCode(respons, 200)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(respons.getResponseBodyContent())

def id = result.data[2].id
def mail = result.data[2].email
def nd = result.data[2].first_name
def nl = result.data[2].last_name


//validate id

assert id != null

assert id instanceof Integer

assert id == 3

//validate nama depan

assert nd != null

assert nd instanceof String

assert nd == 'Emma'

//validate nama belakang

assert nl != null

assert nl instanceof String

assert nl == 'Wong'

//validate email

assert mail != null

assert mail instanceof String

assert mail == 'emma.wong@reqres.in'


