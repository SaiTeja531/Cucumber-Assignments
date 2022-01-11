package stepDefinitions;

import java.util.function.BiPredicate;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutomationPracticeSteps {
	WebDriver driver = Hooks.driver;
	WebDriverWait wait = Hooks.wait;
	JavascriptExecutor js = Hooks.js;

	@Given("User navigates to automationpratice.com website")
	public void user_navigates_to() {
		System.out.println(driver.getTitle());
	}

	@When("User clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
		driver.findElement(By.cssSelector("a.login")).click();

	}

	@When("User enters a valid {string}")
	public void user_enters_a_valid(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email_create"))).sendKeys(email);

	}

	@When("User clicks on create an account button")
	public void user_clicks_on_create_an_account_button() {
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
	}

	@Then("User should land on registration page")
	public void user_should_land_on_registration_page() {
		System.out.println(driver.getTitle());
	}

	@When("User selects salutation {string}")
	public void user_selects_salutation(String salutation) {
		WebElement mr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@for='id_gender1']")));
		WebElement mrs = driver.findElement(By.xpath("//*[@for='id_gender2']"));
		BiPredicate<String, WebElement> p = (s, w) -> w.getText().contains(s);
		if (p.test(salutation, mr))
			mr.click();
		else
			mrs.click();

	}

	@When("User enters FirstName {string}")
	public void user_enters_first_name(String firstname) {
		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(firstname);
	}

	@When("User enters his LastName {string}")
	public void user_enters_his_last_name(String lastname) {
		driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(lastname);
	}

	@When("User enters new password {string}")
	public void user_enters_new_password(String password) {
		driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
	}

	@When("User selects date of birth {string}")
	public void user_selects_date_of_birth(String dob) {
		String[] d = dob.split("/");
		WebElement days = driver.findElement(By.cssSelector("#days"));
		new Select(days).selectByValue(d[0]);
		new Select(driver.findElement(By.cssSelector("#months"))).selectByIndex(Integer.parseInt(d[1]));
		new Select(driver.findElement(By.cssSelector("#years"))).selectByValue(d[2]);

	}

	@When("User enters company name {string}")
	public void user_enters_company_name(String company) {
		driver.findElement(By.cssSelector("#company")).sendKeys(company);
	}

	@When("User enters resident address {string}")
	public void user_enters_resident_address(String address) {
		driver.findElement(By.cssSelector("#address1")).sendKeys(address);
	}

	@When("User enters resident city {string}")
	public void user_enters_resident_city(String city) {
		driver.findElement(By.cssSelector("#city")).sendKeys(city);
	}

	@When("User selects state {string}")
	public void user_selects_state(String state) {
		new Select(driver.findElement(By.cssSelector("#id_state"))).selectByVisibleText(state);
	}

	@When("User enters zipCode {string}")
	public void user_enters_zip_code(String zipCode) {
		driver.findElement(By.cssSelector("#postcode")).sendKeys(zipCode);
	}

	@When("User selects country {string}")
	public void user_selects_country(String country) {
		new Select(driver.findElement(By.cssSelector("#id_country"))).selectByVisibleText(country);
		;
	}

	@When("Users enters mobile number {string}")
	public void users_enters_mobile_number(String mobile) {
		driver.findElement(By.cssSelector("#phone_mobile")).sendKeys(mobile);
	}

	@When("User clicks Register button")
	public void user_clicks_register_button() {
		driver.findElement(By.cssSelector("#submitAccount")).click();
	}

	@Then("verify user is successfully registered and landed on {string} page")
	public void verify_user_is_successfully_registered(String account) {
		Assert.assertTrue(driver.findElement(By.cssSelector("#center_column h1")).getText().contains(account));
	}

}
