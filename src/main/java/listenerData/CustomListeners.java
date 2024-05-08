package listenerData;

import java.io.IOException;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Utilities.TestUtil;
import BaseEngine.baseEngine;

public class CustomListeners extends baseEngine implements ITestListener {

	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Name of the site:::"+arg0.getName().toUpperCase());
		rep.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult err) {
		// TODO Auto-generated method stub
		
		test.log(Status.FAIL, err.getName().toUpperCase()+" Fail with exception: "+err.getThrowable());
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenShotName).build());	
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a target=\"_blank\" href="+ TestUtil.screenShotName +">Screenshot</a>");
		rep.flush();
	}

	@Override
	public void onTestSkipped(ITestResult skip) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, skip.getName().toUpperCase()+" SKIP");
		rep.flush();
	}

	@Override
	public void onTestStart(ITestResult arg0) {

		test=rep.createTest(arg0.getName().toUpperCase());
	}

	@Override
	public void onTestSuccess(ITestResult pass) {
		// TODO Auto-generated method stub
		
		System.out.println("Status from custom listeners:::"+pass.getStatus());
		
		test.log(Status.PASS, pass.getName().toUpperCase()+" Pass");
		this.pass=pass.getName();
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.setProperty("org.uncommons.reportng.escape-output", "false");
//		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+">Screenshot</a>");
		//Reporter.log("<a target=\"_blank\" href=\"C://Users//Aditya.Chavali//OneDrive - GVC Group//Desktop//Selenium//ss.JPG\">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenShotName+"><img href="+TestUtil.screenShotName+" height=200 width=200></img></a>");
		rep.flush();
		
	}

}
