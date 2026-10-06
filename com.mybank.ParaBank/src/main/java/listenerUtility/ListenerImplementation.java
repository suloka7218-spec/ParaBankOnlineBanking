package listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.BaseClass;



public class ListenerImplementation implements ITestListener,ISuiteListener
{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) 
	{
		Reporter.log("Report Config",true);
		Date dt=new Date();
		String newDate = dt.toString().replace(":", "_").replace(" ", "_");
		
		spark=new ExtentSparkReporter("./AdvancedReport/report_"+newDate+".html");
		spark.config().setDocumentTitle("ParaBank Test Suite Result");
		spark.config().setReportName("ParaBank Report");
		spark.config().setTheme(Theme.DARK);
			
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", "Window10");
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		report.flush();
		Reporter.log("Report Backup",true);	
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"==="+result.getMethod().getMethodName()+"STARTED===");	
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS,"==="+result.getMethod().getMethodName()+"SUCCESS===");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{	
		String testname = result.getMethod().getMethodName();
		Date dt=new Date();
		String newDate = dt.toString().replace(":", "_").replace(" ", "_");
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp);
		test.log(Status.FAIL,"==="+result.getMethod().getMethodName()+"FAILED===");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP,"==="+result.getMethod().getMethodName()+"SKIPPED===");
	}
	

}
