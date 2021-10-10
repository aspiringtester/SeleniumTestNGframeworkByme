package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Framework.AspiringTester.BaseTest;

public class Listeners extends BaseTest implements ITestListener {

	
	
	ExtentTest test;
	
	// To manage parallel thread execution safely
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentReports ext =ExtentReporting.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		//extent report
		
		 test = ext.createTest(result.getMethod().getMethodName());
		
		extentTest.set(test);
		
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//will log failure in extent report
		extentTest.get().fail(result.getThrowable());
		
		//GETTING AND PASSING DRIVER OF FAILED CLASS
		WebDriver driver = null;
		
		String failCaseName = result.getMethod().getMethodName();
		
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
		}
	
		//screenshot
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShot(failCaseName, driver), failCaseName);
			//getScreenShot(failCaseName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ext.flush();
	}
	
	

}
