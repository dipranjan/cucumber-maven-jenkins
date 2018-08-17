package StepDefinitions;

import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
public class Hooks
{
public static WebDriver driver;

@Before
public void openBrowser() throws MalformedURLException {
System.out.println("Called openBrowser");
TestRunner.log.info("webdriver initialized");
System.setProperty("webdriver.gecko.driver","D:\\workspace\\Demo\\geckodriver.exe");
driver = new FirefoxDriver();
driver.manage().window().maximize();
}

@After
/**
* Embed a screenshot in test report if test is marked as failed
*/
public void embedScreenshot(Scenario scenario) {
if(scenario.isFailed()) {
try {
scenario.write("Current Page URL is " + driver.getCurrentUrl());
byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
scenario.embed(screenshot, "image/png");
} 
catch (WebDriverException somePlatformsDontSupportScreenshots) {
System.err.println(somePlatformsDontSupportScreenshots.getMessage());
} 
}
driver.quit();
}
}