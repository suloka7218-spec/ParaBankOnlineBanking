package baseTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	public PropertyFileUtility putil = new PropertyFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;// Listener purpose

	@BeforeSuite(groups = { "smoke", "regression" })
	public void beforeSuite() {
		Reporter.log("DB Connectivity open", true);
	}

	// @Parameters("BROWSER")//this only for cross browser parallel execution
	@BeforeClass(groups = { "smoke", "regression" })
	// public void beforeClass(String BROWSER) throws Throwable//this only for cross
	// browser parallel execution
	public void beforeClass() throws Throwable {
		String BROWSER = putil.toReadDataFromPropertiesFile("Browser");// comment this for cross browser execution and
																		// cmdline execution
		// String BROWSER=System.getProperty("Browser");//Command line)
		if (BROWSER.equals("Chrome")) {
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("FireFox")) {
			driver = new FirefoxDriver();
		}

		sdriver = driver;// Listener Purpose
		Reporter.log("Launched Browser", true);
	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void beforeMethod() throws Throwable {
		String URL = putil.toReadDataFromPropertiesFile("Url");
		String USERNAME = putil.toReadDataFromPropertiesFile("Username");
		String PASSWORD = putil.toReadDataFromPropertiesFile("Password");

		wutil.waitForPagetoLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.getRegLink().click();
		String fname = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 0);
		String lname = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 1);
		String address = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 2);
		String city = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 3);
		String state = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 4);
		String zipCode = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 5);
		String pnoneNum = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 6);
		String ssn = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 7);
		int rn = jutil.genRandomNumber();
		String regUserName = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 8);
		String regPassword = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 9);
		String cnfrmPass = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 10);

		lp.registerToApp(fname, lname, address, city, state, zipCode, pnoneNum, ssn, regUserName, regPassword,
				cnfrmPass);

		// driver.findElement(By.id("customer.username.errors")).getText();
		if ((driver.findElement(By.id("customer.username.errors")).getText()).contains("exists")) {
			// lp.loginToApp(USERNAME, PASSWORD);
			lp.loginToApp(regUserName, regPassword);}
		
//		String regUserName = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 8);
//		String regPassword = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 9);
//		lp.loginToApp(regUserName, regPassword);

		Reporter.log("Login", true);

	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void afterMethod() {
		LoginPage lp = new LoginPage(driver);
		lp.getLogOutLink().click();

		Reporter.log("Logout", true);

	}

	@AfterClass(groups = { "smoke", "regression" })
	public void afterClass() {
		driver.quit();
		Reporter.log("Close Browser", true);
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void afterSuite() {
		Reporter.log("DB Close", true);
	}

}
