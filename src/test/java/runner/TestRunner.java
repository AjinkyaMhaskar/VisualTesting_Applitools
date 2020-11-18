package runner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.cucumber.listener.Reporter;

import commonFunctions.CommonUIFunctions;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import dataProviders.ConfigFileReader;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/features", glue = "seleniumgluecode", plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/html/CustomExtentReport.html" })

public class TestRunner extends AbstractTestNGCucumberTests {

	public static WebDriver driver = null;
	protected static Eyes eyes = null;
	protected static Configuration suitConfiguration = null;
	protected static EyesRunner runner = null;

	@BeforeSuite(alwaysRun = true)
	public void initSetup() throws Exception {
		// Property file
		initPropertyData();

		// Browser
		initBrowser();
	}

	@AfterSuite(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		eyes.abortIfNotClosed();
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Adobe - Ajinkya Mhaskar");
	}

	// Method for screen shot of failed methods
	@AfterMethod(alwaysRun = true)
	public void tearDownr(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String failureImageFileName = result.getMethod().getMethodName() + "_"
					+ new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(
					System.getProperty("user.dir") + "/target/screenshots/" + failureImageFileName);
			FileUtils.copyFile(imageFile, failureImageFile);
		}
	}

	// Method to generate extent report
	@AfterClass
	public static void setup() throws Exception {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", "Ajinkya Mhaskar");
		Reporter.setSystemInfo("Application Name", "Applitool");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", ConfigFileReader.getMainPageTitle());
	}

	// Method to instantiate ConfigFileReader
	public void initPropertyData() throws Exception {
		@SuppressWarnings("unused")
		dataProviders.ConfigFileReader ConfigFileReader = new dataProviders.ConfigFileReader();
	}

	public void initBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();

		// Create a runner with concurrency of 1
		runner = new VisualGridRunner(5);
		// Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
		eyes = new Eyes(runner);
		// Initialize eyes Configuration
		suitConfiguration = new Configuration();
		// You can get your api key from the Applitools dash-board
		suitConfiguration.setApiKey(dataProviders.ConfigFileReader.getAPI_KEY());
		// create a new batch info instance and set it to the configuration
		suitConfiguration.setBatch(new BatchInfo("Testing Lifecycle"));
		// Add browsers with different view-ports
		suitConfiguration.addBrowser(1200, 800, BrowserType.CHROME).addBrowser(1200, 800, BrowserType.FIREFOX)
				.addBrowser(1200, 800, BrowserType.EDGE_CHROMIUM).addBrowser(1200, 800, BrowserType.SAFARI)
				.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.LANDSCAPE);

		// Set the configuration object to eyes
		eyes.setConfiguration(suitConfiguration);
		CommonUIFunctions.implicitWait(10);
		driver.get(dataProviders.ConfigFileReader.getBaseURL());
	}

	/*
	 * Method to apply window checkpoint | Application Name |Test name |Step name |
	 */
	public static void validateWindow(List<List<String>> data) {
		driver = eyes.open(driver, data.get(1).get(0), data.get(1).get(1));
		eyes.setForceFullPageScreenshot(true);
		eyes.checkWindow(data.get(1).get(2));
		eyes.close();
	}

	/*
	 * Method to apply region checkpoint | Application Name |Test name |Step name |
	 */
	public static void validateRegion(List<List<String>> data, By Locator) {
		driver = eyes.open(driver, data.get(1).get(0), data.get(1).get(1));
		eyes.checkRegion(Locator, data.get(1).get(2));
		eyes.close();
	}
}
