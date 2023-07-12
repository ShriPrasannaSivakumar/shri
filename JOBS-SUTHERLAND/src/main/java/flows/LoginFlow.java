package flows;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.TestBase;
import pages.DashboardPage;
import pages.RegisterPage;


public class LoginFlow extends TestBase {
	private JavascriptExecutor jse = null;

	public LoginFlow() throws IOException {
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	JavascriptExecutor e = (JavascriptExecutor) driver;

	/**
	 * This Method for OneSutherLandRegistration
	 *
	 * @throws Exception
	 *
	 */
	public void userLoginOneSutherLandPage(String firstname, String lastname, String country, String phonenumber, String password, String confirmpassword) throws Exception {
		System.out.println("****User Login page***** ");
		new RegisterPage().clickRegister();
		Thread.sleep(3);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		new RegisterPage().enterfirstname(firstname);
		Thread.sleep(3);
		new RegisterPage().enterlasname(lastname);
		Thread.sleep(20);
		js.executeScript("window.scrollBy(100,200)", "");
		new RegisterPage().selectCountryFromDropDown(country);
		Thread.sleep(10);
		new RegisterPage().enterPhoneNumber(phonenumber);
		Thread.sleep(10);
		js.executeScript("window.scrollBy(200,250)", "");
		new RegisterPage().enterEmail(utils.CommonFunctions.getRamdonString(5) + "@gmail.com");
		Thread.sleep(10);
		js.executeScript("window.scrollBy(250,300)", "");
		new RegisterPage().enterPassword(password);
		Thread.sleep(10);
		new RegisterPage().enterConfirmPassword(confirmpassword);
		Thread.sleep(10);
		js.executeScript("window.scrollBy(350,400)", "");
		new RegisterPage().cnclickRegister();
		Thread.sleep(180);
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		System.out.println("Navigated");
		new DashboardPage().verifyDashboardPage();
		Thread.sleep(60);
	}
}