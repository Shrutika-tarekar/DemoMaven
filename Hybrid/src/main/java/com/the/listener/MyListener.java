package com.the.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.the.base.BaseClass;
import com.the.utilies.DriverUtils;

public class MyListener extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) { //beforemethod
		test=report.createTest(result.getName()); // to add testcase on report 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Testcase passed successfully"); // log is used to display message 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Testcase failed");
		String path=DriverUtils.captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(path); 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) { //before suit
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
