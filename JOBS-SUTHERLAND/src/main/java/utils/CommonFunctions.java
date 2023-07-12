package utils;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CommonFunctions extends TestBase {
	public CommonFunctions() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static JavascriptExecutor jse = null;

	/**
	 *      * @author Shri Prasanna This method for scrolling the webpage for the
	 *      * webelement specified      *      * @param ele - the element to be
	 * scrolled to view      * @throws Exception     
	 */
	public static void scrollIntoView(WebElement ele) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		} catch (Exception e) {
			System.err.println("Exception while scrolling the window");
		}
	}

	public static String getRamdonString(int chars) {
		String CharSet = "abcdefghijkmnopqrstuvwxyz1234567890";
		String name = "";
		for (int a = 1; a <= chars; a++) {
			name += CharSet.charAt(new Random().nextInt(CharSet.length()));
		}
		return name;
	}

	public static void checkCurrentPageTitle(String pageName) throws Exception {
		try {
			if (!driver.getTitle().contains(pageName)) {
				waitForPageLoad(driver);
			}
		} catch (Exception e) {
			System.err.println("Failed due to page not loaded");
		}
	}

	/**
	 *      * This method for action click      *      * @param webele      * @param
	 * Ele_name      *      * @throws Exception     
	 **/
	public static void actionClick(WebElement webele, String Ele_name) throws Exception {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(webele));
			Actions ob = new Actions(driver);
			Action action = ob.moveToElement(webele).click().build();
			action.perform();
			System.out.println("The " + Ele_name + " is clicked");
		} catch (Exception e) {
			System.err.println("The " + Ele_name + " is not avilable pls refer the report\n");
		}
	}

	/**
	 *      * This method for Clicking the Web element      *      * @throws
	 * Exception     
	 **/
	public static void clickWebelement(WebElement webele, String Ele_name) throws Exception {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(webele));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", webele);
			System.out.println("The " + Ele_name + " is clicked");
		} catch (Exception e) {
			System.err.println("The " + Ele_name + " is not avilable pls refer the screenshot\n");
		}
	}

	/**
	 *      * This method for Sending the values to the Web element      *     
	 * * @throws Exception     
	 **/
	public static void Sendkeys(WebElement webele, String value, String Ele_name) throws Exception {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webele));
			webele.click();
			webele.clear();
			webele.sendKeys(value);
			System.out.println(value + " is entered into the " + Ele_name + " textbox");
		} catch (Exception e) {
			System.err.println("\nThe " + Ele_name + " is not avilable pls refer the screenshot\n");
		}
	}

	/**
	 *      * @author Shri Prasanna      *      * @apiNote This method for Sending
	 * the values to the Web element by clearing      * field using attribute      *
	 *      * @param webele      * @param attrib      * @param value      * @param
	 * Ele_name      *      * @throws Exception     
	 **/
	public static void SendkeysAttrib(WebElement webele, String attrib, String value, String Ele_name)
			throws Exception {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webele));
			webele.click();
			while (!webele.getAttribute(attrib).equals("")) {
				webele.sendKeys(Keys.BACK_SPACE);
			}
			webele.sendKeys(value);
			System.out.println(value + " is entered into the " + Ele_name + " textbox");
		} catch (Exception e) {
			System.err.println("\nThe " + Ele_name + " is not avilable pls refer the screenshot\n");
		}
	}

	/**
	 *      *      * @author Shri Prasanna      *      * @apiNote This method for
	 * Sending the values to the Web element by clearing      * field using delete
	 * all key press      *      * @throws Exception     
	 **/
	public static void sendKeysWithDeleteAll(WebElement webele, String value, String Ele_name) throws Exception {
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(webele));
			while (!webele.getAttribute("value").equals("")) {
				if (System.getProperty("os.name").contains("OS X")) {
					webele.sendKeys(Keys.COMMAND + "a");
				} else {
					webele.sendKeys(Keys.CONTROL + "a");
				}
				Thread.sleep(500);
				webele.sendKeys(Keys.DELETE);
			}
			webele.sendKeys(value);
			System.out.println(value + " is entered into the " + Ele_name + " textbox");
		} catch (Exception e) {
			System.err.println("\nThe " + Ele_name + " is not avilable pls refer the screenshot\n");
		}
	}

	/**
	 *      * @author Shri Prasanna This method for Sending the values to the Web
	 *      * element and without any log message      *      * @throws Exception
	 *     
	 **/
	public static void SendkeysWithoutInputLog(WebElement webele, String value, String Ele_name) throws Exception {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(webele));
			webele.click();
			webele.clear();
			webele.sendKeys(value);
			System.out.println("Authentic " + Ele_name + " is entered into the " + Ele_name + " textbox");
		} catch (Exception e) {
			System.err.println("\nThe " + Ele_name + " is not avilable pls refer the report\n");
		}
	}

	/**
	 *      * @author Shri Prasanna This method for selecting the dropdown value
	 * using      * select class      *      * @throws Exception     
	 **/
	public static void selectDropDownValue(WebElement webele, String value, String Ele_name) throws Exception {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(webele));
			Select select = new Select(webele);
			select.selectByValue(value);
			System.out.println(value + " is selected into the " + Ele_name + " dropdown");
		} catch (Exception e) {
			System.err.println("\nThe " + Ele_name + " is not avilable pls refer the report\n");
		}
	}

	/**
	 *      * @author Shri Prasanna This method for selecting the dropdown text
	 * using      * select class      *      * @throws Exception     
	 **/
	public static void selectDropDownText(WebElement webele, String value, String Ele_name) throws Exception {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(webele));
			Select select = new Select(webele);
			select.selectByVisibleText(value);
			System.out.println(value + " is selected into the " + Ele_name + " dropdown");
		} catch (Exception e) {
			System.err.println("\nThe " + Ele_name + " is not avilable pls refer the report\n");
		}
	}

	/**
	 *      * This method for checking the page is displayed or Not      *     
	 * * @param webele We have to pass the web element to check that is Clickable or
	 *      * not      * @return     
	 */
	public static boolean checkCurrentPage(WebElement webele) {
		try {
			new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(webele));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 *      * This Method for checking the page is loaded or not and return the
	 * boolean      * value true or false      *      * @param driver      * @throws
	 * InterruptedException     
	 */
	public static void waitForPageLoad(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	/**
	 *      * This method for switching the one window to next window      *     
	 * * @param driver      * @throws InterruptedException     
	 */
	public static void switchNextWindow(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		int i = 0;
		for (String Child_Window : driver.getWindowHandles()) {
			if (i > 0) {
				driver.switchTo().window(Child_Window);
			}
			i++;
		}
	}

	/**
	 *      * This Method for checking the web element is visible or not      *     
	 * * @param webele pass the web element.      * @param name we have to pass the
	 * name of the element if it is not displayed      * it prints the error message
	 *      * @throws Exception     
	 */
	public static boolean elementIsVisible(WebElement webele) throws Exception {
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(webele));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
