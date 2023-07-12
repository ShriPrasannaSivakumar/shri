package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utils.TestUtil;



public class DashboardPage extends TestBase {
	public DashboardPage() throws IOException {
		super();
		
	}

	@FindBy(xpath = "//span[contains(text(),\"Dashboard\")]")
	public WebElement dashboard;
	@FindBy(xpath = "//span[@class='uqlCandidateInfo']")
	public WebElement candidateName;

	public void verifyDashboardPage() throws Exception {
		try {
			
			utils.CommonFunctions.checkCurrentPageTitle("DASHBOARD");
			System.out.println("SuccessFully Landed to the Dashboard page");
			Thread.sleep(3000);
			test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.takeScreenshotAtEndOfTest(driver)),"SuccessFully Landed to the Dashboard page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Dashboard page is not displayed upon successful registration");
		}
	}
}
