package StepDefs;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ParallelTest.CrossBrowserScript;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*******************************************************************************************
 * SignUpSteps - Step Definition File for Application SignUp page
 *
 *******************************************************************************************/
public class SignUpSteps {

	static WebDriver driver;

	@Given("user is on the application sign up page")
	public void user_is_on_the_application_sign_up_page() throws Exception {
		CrossBrowserScript choice = new CrossBrowserScript();
		driver = choice.setup("firefox");

	}

	@When("I enter EmailID address as {string}")
	public void i_enter_email_id_address_as(String email) {

		if (email.equals("")) {
			WebElement emailID = driver.findElement(By.cssSelector("#email"));
			sendKeys(driver, emailID, 10, email);
			String expectedValue = emailID.getAttribute("value");
			System.out.println("This is the value from the text field," + expectedValue);
			assertEquals("Enter a value ", expectedValue, email);

		} else {

			WebElement emailID = driver.findElement(By.cssSelector("#email"));
			sendKeys(driver, emailID, 10, email);

		}

	}

	@And("I enter Username  {string}{string}")
	public void i_enter_username(String uName, String Newuser) {
        System.out.println(Newuser);
		if (Newuser.equalsIgnoreCase("Yes")) {
			if (uName.length() <= 100) {
				WebElement userName = driver.findElement(By.cssSelector("#new_username"));
				sendKeys(driver, userName, 10, uName);
			} else {
				WebElement userName = driver.findElement(By.cssSelector("#new_username"));
				sendKeys(driver, userName, 10, uName);
				String expectedValue = userName.getAttribute("value");
				System.out.println("This is the value from the text field," + expectedValue);
				assertEquals("Enter a value less than 100 characters long", expectedValue, uName);
			}
		} else {
			String userName = uName + new Random().nextInt(50);
			WebElement actualValue = driver.findElement(By.cssSelector("#new_username"));
			sendKeys(driver, actualValue, 10, userName);
			String expectedValue = actualValue.getAttribute("value");
			assertEquals("User already exists", expectedValue, userName);
		}
	}

	@And("I enter Password {string}")
	public void i_enter_password(String psw) {
		WebElement password = driver.findElement(By.cssSelector("#new_password"));
		sendKeys(driver, password, 10, psw);

	}

	@When("I click on the sign up")
	public void i_click_on_the_sign_up() {
		WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
		clickOn(driver, acceptCookies, 5);
		WebElement signupBtn = driver.findElement(By.id("create-account"));
		clickOn(driver, signupBtn, 10);
	}

	@Then("the new user should be created {string}")
	public void the_new_user_should_be_created(String Newuser) {

		if (Newuser.equalsIgnoreCase("Yes")) {
			String actualTitle = driver.getTitle();
			String expectedTitle = "Success | Mailchimp";
			assertEquals(expectedTitle, actualTitle);
		}
		quit();

	}

	@SuppressWarnings("deprecation")
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {

		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);

	}

	@SuppressWarnings("deprecation")
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	
	public void quit() {

		driver.quit();
	}

}
