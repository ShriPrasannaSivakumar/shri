package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestUtil;

public class TestBase {


	public static WebDriver driver;

	public static Properties prop;
	public static ExtentTest test;
	public static ExtentReports report;



	public TestBase() throws IOException {
		try {


			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/Config.properties");
			prop.load(ip);
			prop.setProperty("log4j.rootLogger", "WARN");
			PropertyConfigurator.configure(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}


	@BeforeTest
	public void report() {
		report = new ExtentReports(System.getProperty("user.dir") + "/reports/ONESUTHERLAND.html",true);
		test = report.startTest("Sutherland Job registration");

	}


	@AfterTest
	public void endReport() {
		//			driver.close();
		report.endTest(test);
		report.flush();
	}



	public void invokeBrowser() {
		String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));
		}



	}
}
