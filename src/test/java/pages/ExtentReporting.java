package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
	
	
	public static ExtentReports  ext;
	public static ExtentReports getReportObject() {
	
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new 	ExtentSparkReporter(path);
	reporter.config().setReportName("Web Testing Result");
	
	ext = new ExtentReports();
	ext.attachReporter(reporter);
	ext.setSystemInfo("Tester", "Paramita Bhattacharya");
	
	return ext;
	}

}
