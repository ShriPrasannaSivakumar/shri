package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

public class RegisterPage extends TestBase {
	private JavascriptExecutor jse = null;
	@FindBy(id = "UserID")
	private WebElement UserName;
	@FindBy(id = "Password")
	private WebElement passwordInput;
	@FindBy(id = "confirmPassword")
	private WebElement confirmPassword;
	@FindBy(xpath = " //*[@type='submit']")
	private WebElement confirmSubmit;
	@FindBy(id = "icon")
	private WebElement pageicon;
	@FindBy(xpath = "//a[@class='uqlRegisterBtn']")
	public WebElement register;
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement firstname;
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastname;
	@FindBy(xpath = "//div[@class='arrow']")
	public WebElement countrydropdown;
	@FindBy(xpath = "//li[@class='country']")
	public WebElement countrylist;
	@FindBy(xpath = "//input[@id='phoneNumber']")
	public WebElement phonenumber;
	@FindBy(xpath = "//input[@id='emailAddress']")
	public WebElement emailid;
	@FindBy(xpath = "//input[@id='passwordInput']")
	public WebElement password;
	@FindBy(xpath = "//input[@id='confirmPassword']")
	public WebElement confirmpassword;
	@FindBy(xpath = "//div[@class='dmWidget button-action button-register']")
	public WebElement cnregister;

	public RegisterPage() throws IOException {
		jse = (JavascriptExecutor) driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	JavascriptExecutor e = (JavascriptExecutor) driver;

	public void clickRegister() throws Exception {
		try {
			// utils.CommonFunctions.findPopUp();
			driver.findElement(By.xpath("//a[@class='uqlRegisterBtn']")).click();
			test.log(LogStatus.PASS,"Register button is clicked");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterfirstname(String firstname_input) throws Exception {
		try {
			firstname.click();
			firstname.sendKeys(firstname_input);
			System.out.println("User entered first name as " + firstname_input);
			test.log(LogStatus.PASS,"User entered first name as " + firstname_input);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User first name is not entered");
		}
	}

	public void enterlasname(String lastname_input) throws Exception {
		try {
			lastname.click();
			lastname.sendKeys(lastname_input);
			System.out.println("User entered last name as " + lastname_input);
			test.log(LogStatus.PASS,"User entered last name as " + lastname_input);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User last name is not entered");
		}
	}

	public void enterPhoneNumber(String phone_input) throws Exception {
		try {
			phonenumber.click();
			phonenumber.sendKeys(phone_input);
			System.out.println("User entered phone number as " + phone_input);
			test.log(LogStatus.PASS,"User entered phone number as " + phone_input);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User phone number is not entered");
		}
	}

	public void enterPassword(String password_input) throws Exception {
		try {
			utils.CommonFunctions.clickWebelement(password, "Password field");
			//         password.click();
			password.sendKeys(password_input);
			System.out.println("User entered password as " + password_input);
			test.log(LogStatus.PASS,"User entered password as " + password_input);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User password is not entered");
		}
	}

	public void enterConfirmPassword(String Confirmpassword_input) throws Exception {
		//         confirmpassword.click();
		try {
			utils.CommonFunctions.clickWebelement(confirmpassword, "Password field");
			confirmpassword.sendKeys(Confirmpassword_input);
			System.out.println("User entered confirm password as " + Confirmpassword_input);
			test.log(LogStatus.PASS,"User entered confirm password as " + Confirmpassword_input);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User confirm password is not entered");
		}
	}

	public void enterEmail(String email_id) throws Exception {
		try {
			emailid.click();
			emailid.sendKeys(email_id);
			System.out.println("User entered email id as " + email_id);
			test.log(LogStatus.PASS,"User entered email id as " + email_id);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User email is not entered");
		
		}
	}

	public void cnclickRegister() throws Exception {
		//         cnregister.click();
		try {
			utils.CommonFunctions.clickWebelement(cnregister, "Register button");
			test.log(LogStatus.PASS,"Register button is clicked after filling all the mandatory fields");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Register button is not clicked");
		}
	}

	/**
	 * This method to select country from dropdown
	 *
	 * @throws Exception
	 */
	public void selectCountryFromDropDown(String Country) throws Exception {
		try {
			countrydropdown.click();
			List<WebElement> options = driver
					.findElements(By.xpath("((//div[@class='input-field-container'])[3]//div//div//ul//li//span)"));
			for (WebElement webElement : options) {
				if (webElement.getText().equals(Country)) {
					webElement.click();
					break;
				}
			
			}
			test.log(LogStatus.PASS,"Country is selected as INDIA");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "country is not selected");
		}
	}

}