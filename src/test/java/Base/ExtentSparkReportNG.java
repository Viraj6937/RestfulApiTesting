package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSparkReportNG {

	
	public static ExtentSparkReporter reporter;
	
	public static  ExtentReports getReportObject() {
	
		String file = System.getProperty("user.dir")+"/reports/index.html";
		
		reporter = new ExtentSparkReporter(file);
		
		reporter.config().setDocumentTitle("API Testing Result");
		
		reporter.config().setReportName("Test Result");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester","Viraj D. Utekar");
		
		return extent;
	}
	
}
