package wdMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import dataProvider.ExcelDataProvider;

public class Hooks extends SeMethods{
	
	public String browserName ,dataSheetName, testcaseName;
	public String testDescription, authorName, category;

	@BeforeSuite
	public void beforeSuite(){
		startResult();		
	}

	@BeforeTest
	public void beforeTest(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testcaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authorName);
		startApp(browserName,"http://leaftaps.com/opentaps");
		type(locateElement("id", "username1"), "DemoSalesManager");
		type(locateElement("id", "password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));
	}
		
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterTest
	public void afterTest(){
	}
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		closeAllBrowsers();
		
	}
	
	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return new ExcelDataProvider().getExcelData(dataSheetName);		
	}	
	
}
