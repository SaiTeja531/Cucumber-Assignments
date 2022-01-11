package stepDefinitions;

import java.util.List;
import java.util.function.Predicate;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AirasiaSteps {
	WebDriver driver = Hooks.driver;
	WebDriverWait wait = Hooks.wait;
	JavascriptExecutor js = Hooks.js;
	 String title;
	 String errorMsg;
	@Given("User navigates to airasia website")
	public void user_navigates_to() {
		 title=driver.getTitle();
	 }
	@Then("Verify the title of page")
	public void verify_the_title_of_page() {
		//Verifying the title
		Assert.assertEquals(title, driver.getTitle());
	   
	}

	@When("User selects source location")
	public void user_selects_source_as(DataTable sourceLocations) throws InterruptedException {
	   driver.findElement(By.xpath("//*[@id=\"flight-search-widget-super-div\"]/descendant::*[@class='flight-search-source-code'][1]")).click();
	   List<String> location=sourceLocations.asList();
	   driver.findElement(By.cssSelector("#basic-url")).sendKeys(location.get(0));
	   Thread.sleep(2000);
	   List<WebElement> source = driver.findElements(By.xpath("//*[@id='list-item']/div/div"));
	   for(WebElement s:source) {
		   if(s.getText().equalsIgnoreCase(location.get(0))) {
			   s.findElement(By.xpath("ancestor::button")).click();
			   break;
		   }
	   }
	}

	@When("Users selects destination location")
	public void users_selects_destination_as(DataTable destinationLocations) throws InterruptedException {
	   List<String> location=destinationLocations.asList();
	   driver.findElement(By.cssSelector("#basic-url")).sendKeys(location.get(0));
	   Thread.sleep(2000);
	   List<WebElement> destination = driver.findElements(By.xpath("//*[@id='list-item']/div/div"));
	   Predicate<WebElement> p = w -> w.getText().equalsIgnoreCase(location.get(0));
	   for(WebElement s:destination) {
		   if(p.test(s)) {
			   s.findElement(By.xpath("ancestor::button")).click();
			   break;
			   
		   }
	   }
	}

	@When("User selects departure date as {string}")
	public void user_selects_departure_date_as(String string) {
	    driver.findElement(By.cssSelector(".flight-search-date-picker-wrapper")).click();
	    WebElement date=driver.findElement(By.xpath("//*/*[normalize-space()='Dec 2022']/following-sibling::div/*/*[@id='15']"));
	    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*/*[normalize-space()='Dec 2022']/following-sibling::div/*/*[@id='1']")));
	    date.click();
	   
	}

	@When("User selects one way option")
	public void user_selects_one_way_option() {
	   WebElement oneWay=driver.findElement(By.xpath("//*[@id='One Way']"));
	   oneWay.click();
	}

	@When("User clicks on search fligh button")
	public void user_clicks_on_search_fligh_button() throws InterruptedException {
		 driver.findElement(By.xpath("//*[text()='Search Flights']")).click();
		 Thread.sleep(3000);
		 title =driver.getTitle();
	}

	@Then("verify user is navigated to search flight page")
	public void verify_user_is_navigated_to_search_flight_page() throws InterruptedException {
	    Assert.assertEquals(title,driver.getTitle());
	}
	
	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   driver.findElement(By.xpath("//*[@class='header-sidebar']/p")).click();
	   driver.findElement(By.xpath("//*[@class='img-div-sso']/img[2]")).click();
	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String email) throws InterruptedException {
	    WebElement ema=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-input-sso")));
	    ema.sendKeys(email);
	    driver.findElement(By.cssSelector(".modal-sso-body button")).click();
	    Thread.sleep(3000);
	}

	@When("User enters some random OTP")
	public void user_enters_some_random_otp() throws InterruptedException {
	    List<WebElement> ot = driver.findElements(By.cssSelector("input[inputmode='numeric']"));
	    ot.forEach(s->s.sendKeys("1"));
	    driver.findElement(By.cssSelector(".con button")).click();
	    Thread.sleep(3000);
	    errorMsg=driver.findElement(By.cssSelector(".div-otp-timer span span")).getText();
	    
	}

	@Then("Verify the error message is displayed or not")
	public void verify_the_error_message_is_displayed_or_not() {
	   Assert.assertTrue("Uh-oh! Incorrect OTP",errorMsg.contains("Uh-oh! Incorrect OTP"));
	}

}
