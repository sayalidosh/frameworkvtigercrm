/**
 * 
 */
package commonutils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 */
public class ListenerImplimentation implements ITestListener{
	ExtentReports et;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"testscript execution started",true);
		test=et.createTest(methodname);
	    
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"testcript is passed");
		//Reporter.log(methodname+"testscript is passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	  String methodname = result.getMethod().getMethodName();
		Throwable message = result.getThrowable();
		test.log(Status.FAIL, methodname+"testcript is failed");
		//Reporter.log(methodname+"testscript is failed"+message,true);
		Webdriverutil wutil=new Webdriverutil();
		javautils jutil=new javautils();
		String screenshotname = methodname+jutil.getRandomnumver();
		try {
			
			String path = wutil.TakeScreenshot(Baseclass.sd1, screenshotname);
			//to add screenshot to the extent reports
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"testcript is skipped");
		//Reporter.log(methodname+"testscript is skippped",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		javautils jutil=new javautils();
		//configuration of extent report
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./extentReport/report1"+jutil.getRandomnumver()+".html");
		htmlreport.config().setDocumentTitle("vtiger contact module");
		htmlreport.config().setReportName("contact");
		//htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setTheme(Theme.STANDARD);
		
		//to attach all data to the report 
		 et=new ExtentReports();
		et.attachReporter(htmlreport);
		et.setSystemInfo("os", "window");
		et.setSystemInfo("Browser", "chrome");
		et.setSystemInfo("author", "Sayali doshi");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//adding info to the report which is written in onstart method
		et.flush();
	}
	
	
	

}
