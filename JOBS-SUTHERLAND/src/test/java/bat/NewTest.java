package bat;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import flows.LoginFlow;
import pages.DashboardPage;
import pages.RegisterPage;
import utils.CommonFunctions;
import utils.TestUtil;



public class NewTest extends TestBase {
	
	TestBase testbase;
	LoginFlow loginflow;
	DashboardPage dashboard;
	RegisterPage registerpage;
	CommonFunctions commonfunctions;
	TestUtil testutil;
	String sheetName ="data";
	
	
	
	public NewTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void setUp() throws InterruptedException, IOException
	{
		invokeBrowser();
		testbase = new TestBase();
		loginflow = new LoginFlow();
		dashboard = new DashboardPage();
		registerpage = new RegisterPage();
		commonfunctions = new CommonFunctions();
		testutil = new TestUtil();
		
	}
	
	@DataProvider
	public Object[][] getRegistrationTestData(){
	   Object data[][] = TestUtil.getTestData(sheetName);
	   return data;
	}

	@Test(priority= 1,dataProvider="getRegistrationTestData")
	public void userTest(String firstname, String lastname, String country, String phonenumber, String password, String confirmpassword) throws Exception {
		
		test.log(LogStatus.INFO,"Browser successfully Launched");
		setUp();
		new LoginFlow().userLoginOneSutherLandPage(firstname,lastname,country,phonenumber,password,confirmpassword);
//		TestUtil.takeScreenshotAtEndOfTest(driver);
		
	}
	
}