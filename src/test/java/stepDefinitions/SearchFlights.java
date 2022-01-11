package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.function.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFlights {
	 WebDriver driver;
	 String title;
	 WebDriverWait wait;
	 JavascriptExecutor js;
	 String errorMsg;
	@Given("User navigates to {string}")
	public void user_navigates_to(String airAsiaWebsite) {
	   WebDriverManager.chromedriver().setup();
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--disable-notifications","--start-maximized");
	   driver = new ChromeDriver(options);
	   js = (JavascriptExecutor)driver;
	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   driver.get(airAsiaWebsite);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   title = driver.getTitle();
	}



}
