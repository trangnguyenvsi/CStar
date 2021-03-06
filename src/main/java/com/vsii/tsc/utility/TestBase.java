package com.vsii.tsc.utility;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vsii.tsc.model.TCImageResults;

public class TestBase {
	public static String screeningDate;
	public static String teamCode;
	public static String userName;
	public static String password;
	public static WebDriver driver;
	public static Properties p;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static FirefoxProfile fprofile;
	public static String methodName;
	public static String imageName;
	public static String testStatus;
	public static List<TCImageResults> imageResultList;
	public static HashMap<String, List<TCImageResults>> tcImageResultsList;
	public RemoteWebDriver remoteDriver;

	@BeforeSuite
	public void setupSuite() throws IOException {
//		 DBConnection.revertDB("exec usp_CStar_RevertSnapshot");
		// Read config file
		p = CommonOperations.readConfig();

		// Get Date
		screeningDate = p.getProperty("screeningDate");
		teamCode = p.getProperty("teamCode");
		userName = p.getProperty("email");
		password = p.getProperty("pwd");

		tcImageResultsList = new HashMap<String, List<TCImageResults>>();

		if (p.getProperty("local").equals("No")) {

			// The parameter to run on sauce lab
			DesiredCapabilities caps = DesiredCapabilities.firefox();
			caps.setCapability("platform", "Windows 7");
			caps.setCapability("version", "42.0");
			caps.setCapability("name", "Guru Test 01");
			caps.setCapability("screenResolution", "1280x1024");

			driver = new RemoteWebDriver(
					new URL("http://trangnguyen:c8f52d3b-7d2a-431c-b217-27f6734f83fe@ondemand.saucelabs.com:80/wd/hub"),
					caps);
		} else {
			switch (p.getProperty("browserName")) {
			// Open Firefox browser
			case ("Firefox"):
				fprofile = new FirefoxProfile();

				DownloadUploadFile fileObj = new DownloadUploadFile(TestBase.fprofile);
				// Setup for Firefox profile
				fileObj.setupDownloadFile(p.getProperty("downloadLocation"));

				driver = new FirefoxDriver(fprofile);
				break;
			case ("Chrome"):
				System.setProperty(p.getProperty("chromeDriver"), p.getProperty("chromeDriverPath"));
				driver = new ChromeDriver();
				break;
			case ("IE"):
				System.setProperty(p.getProperty("ieDriver"), p.getProperty("ieDriverPath"));
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver(caps);
				break;
			case ("Safari"):
				driver = new SafariDriver();
				break;
			default:
				break;
			}
		}
		// Open base URL
		driver.get(p.getProperty("baseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void teardownSuite() throws Exception {
		// driver.quit();
		// SendMail.execute();
	}

}
