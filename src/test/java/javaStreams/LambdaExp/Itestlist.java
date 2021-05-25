package javaStreams.LambdaExp;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Itestlist implements ITestListener {

	/**
	 * This Listener is calling with testngJavaStream.xml file. Validation will
	 * execute for all the methods define in testngJavaStream.xml file
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started ****** " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** Test Success " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** Test Failed " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** Test Skipped " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("###### Its in Failed result");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("****** Test End "+context.getName());
	}

}
