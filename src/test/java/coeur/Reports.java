package coeur;

import java.io.IOException;

import javax.net.ssl.SNIHostName;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import fonctionscommunes.CommonFunction;
import gherkin.formatter.model.Feature.*;
import gherkin.formatter.model.Scenario.*;

public class Reports {
	static ExtentTest Test;
	static ExtentReports report;

	public static  ExtentTest getInstance(String name)  {
		
		String path = Properties.getProperties("Reportpath")+"/"+name+".html";

		report = new ExtentReports(path,true);
		Test = report.startTest(name);
		
		return Test;
		
		}
	
public static void updateReportLog(LogStatus status, String stepname, String description) {
	
	if(status.equals(LogStatus.PASS))
	Test.log(LogStatus.PASS, stepname,Test.addScreenCapture(CommonFunction.takeScreenshot(stepname)));
	if(status.equals(LogStatus.FAIL))
	Test.log(LogStatus.FAIL, stepname,Test.addScreenCapture(CommonFunction.takeScreenshot(stepname)));
	if(status.equals(LogStatus.ERROR))
	Test.log(LogStatus.ERROR, stepname,Test.addScreenCapture(CommonFunction.takeScreenshot(stepname)));
	if(status.equals(LogStatus.INFO))
	Test.log(LogStatus.INFO, stepname,Test.addScreenCapture(CommonFunction.takeScreenshot(stepname)));
	if(status.equals(LogStatus.SKIP))
	Test.log(LogStatus.SKIP, stepname,Test.addScreenCapture(CommonFunction.takeScreenshot(stepname)));
	if(status.equals(LogStatus.FATAL))
	Test.log(LogStatus.FATAL, stepname,Test.addScreenCapture(CommonFunction.takeScreenshot(stepname)));
	

}

public static void closeReport() {
	
	
	report.endTest(Test);
	report.flush();	
	
}

public static String addScreenCapture(String takeScreenshot) {
	Test.addScreenCapture(takeScreenshot);
	return null;
}


}
