package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

	@Before(order=0)
	public void launch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications", "--start-maximized");
		driver = new ChromeDriver(options);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Before(value="@flight",order=1)
	public void setup() {

		driver.get("https://www.airasia.com/en/home.page\"");
	}

	@Before(value="@login",order=1)
	public void lauuchAirasia() {

		driver.get("https://www.airasia.com/en/home.page\"");
	}

	@Before(value="@travel",order=1)
	public void lauuchNewTravels() {
		driver.get("http://demo.guru99.com/test/newtours/");
	}

	@Before(value="@automation_practice",order=1)
	public void lauuchAutomationPractice() {

		driver.get("http://automationpractice.com/index.php");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
