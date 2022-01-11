package runnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//src//test//resources"},
				glue = "stepDefinitions",monochrome = true, plugin = {"pretty","html:target/HtmlReports.html/","json:target/JsonReports.json/"},
				tags="@automation_practice",
				publish = true)
				
public class FlightsTest {

}
