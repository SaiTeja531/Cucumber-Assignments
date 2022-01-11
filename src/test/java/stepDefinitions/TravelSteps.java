package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TravelSteps {
	WebDriver driver = Hooks.driver;
	WebDriverWait wait = Hooks.wait;
	JavascriptExecutor js = Hooks.js;

	@Given("User navigates to newtourtravels website")
	public void user_navigates_to() {
		System.out.println(driver.getTitle());
	}

	@When("User clicks on register button")
	public void user_clicks_on_register_button() {
		driver.findElement(By.xpath("//*[text()='REGISTER']")).click();
	}

	@Then("User enters firstname {string}")
	public void user_enters_firstname(String firstName) {
		driver.findElement(By.name("firstName")).sendKeys(firstName);
	}

	@Then("User enters lastname {string}")
	public void user_enters_lastname(String lastName) {
		driver.findElement(By.name("lastName")).sendKeys(lastName);
	}

	@Then("User enters Phone {string}")
	public void user_enters_phone(String phone) {
		driver.findElement(By.name("phone")).sendKeys(phone);
	}

	@Then("User enters Email {string}")
	public void user_enters_email(String userName) {
		driver.findElement(By.name("userName")).sendKeys(userName);
	}

	@Then("User enters Address {string}")
	public void user_enters_address(String address1) {
		driver.findElement(By.name("address1")).sendKeys(address1);
	}

	@Then("User enters City {string}")
	public void user_enters_city(String city) {
		driver.findElement(By.name("city")).sendKeys(city);
	}

	@Then("User enters State {string}")
	public void user_enters_state(String state) {
		driver.findElement(By.name("state")).sendKeys(state);
	}

	@Then("User enters Postal {string}")
	public void user_enters_postal(String postalCode) {
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);
	}

	@Then("User enters Country {string}")
	public void user_enters_country(String country) {
		WebElement cou = driver.findElement(By.name("country"));
		new Select(cou).selectByVisibleText(country);
	}

	@Then("User enters User {string}")
	public void user_enters_user(String email) {
		driver.findElement(By.name("email")).sendKeys(email);
	}

	@Then("User enters Password {string}")
	public void user_enters_password(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("User enters Confirm {string}")
	public void user_enters_confirm(String confirmPassword) {
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
	}

	@Then("User clicks on submit button")
	public void user_clicks_on_submit_button() {
		driver.findElement(By.name("submit")).click();
		driver.quit();
	}

}
