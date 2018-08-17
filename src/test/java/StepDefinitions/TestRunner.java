package StepDefinitions;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="src/test/resources/Features",glue="StepDefinitions", tags={"@SmokeTest"})
public class TestRunner extends AbstractTestNGCucumberTests {
    static final Logger log = Logger.getLogger(TestRunner.class);
    static final String LOG_PROPERTIES_FILE = "log4j.properties";
	@BeforeClass
	public void setup() throws FileNotFoundException, IOException{
		System.out.println("Before Class");
		Properties logProperties = new Properties();
		log.info("started");
		logProperties.load(new FileInputStream(LOG_PROPERTIES_FILE));
        PropertyConfigurator.configure(logProperties);
        log.info("Logging initialized.");
	}
	
	

}


