package listeners;

import com.aventstack.extentreports.model.Test;

import android_Utils.LanguageDataProvider;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.InitDriver;
import utilities.MobilescreenRecord;
import utilities.ReportManager;
import utilities.TestCaseResult;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class MobileEvent implements ITestListener {

	InitDriver initDriver = new InitDriver();
	private static final String KEY = "platform";
	private static final String KEY1 = "udid";
	private static final String KEY2 = "systemPort";
	private static final String KEY3 = "deviceName";

	private static final String KEY4 = "deviceVersion";

	public String Platform;
	public String Udid;
	public String SystemPort;
	public String DeviceName = "Android Nokia";

	public String DeviceVersion = "13.0";
	MobilescreenRecord mobilescreenRecord = new MobilescreenRecord();

	@Override
	public void onTestStart(ITestResult arg0) {
		String language = "English";
		ReportManager.startTestMobile(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
				ConfigReader.getValue("Execution_Mobile"));
		try {

			// If Test is directly running by dev team then it will value from appium config
			// file
			if (Platform == null) {
				Platform = ConfigReader.getAppiumProp("platform");
				Udid = ConfigReader.getAppiumProp("udid");
				SystemPort = ConfigReader.getAppiumProp("port");
				DeviceName = ConfigReader.getAppiumProp("DeviceName");
				DeviceVersion = ConfigReader.getAppiumProp("DeviceVersion");
			}

			System.out.println("key: " + Platform);
			System.out.println("key1: " + Udid);
			System.out.println("key2: " + SystemPort);
			System.out.println("key3: " + DeviceVersion);

			initDriver.startMobileDriver(Platform, Udid, SystemPort, DeviceName, DeviceVersion);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		String description = arg0.getMethod().getDescription();
//		String temp = description.split("]")[0];
//		String[] split = temp.replace("[", "").split(", ");
//		for (String s : split) {
//			if (LanguageDataProvider.getCurrentLanguage() != null) {
//				language = LanguageDataProvider.getCurrentLanguage();
//			}
//		}
//		if (ConfigReader.getValue("browserstack").equalsIgnoreCase("true")) {
//
//			JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
//			jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\""
//					+ arg0.getMethod().getMethodName()+"-"+language + "\" }}");
//		}else {
//			mobilescreenRecord.startRecording();
//		}
//
//		MobileActions mobileActions = new MobileActions();
//		mobileActions.sleep(2000);
//
//		By allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
//		if (mobileActions.isElmPresent(allow)) {
//			mobileActions.click(allow, "Click on allow");
//		}

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());
		String language = "English";

		try {

			ReportManager.logScreenshotInfo();
			String description = iTestResult.getMethod().getDescription();
			String temp = description.split("]")[0];
			String[] split = temp.replace("[", "").split(", ");
			for (String s : split) {
				String testId = s;
				if (LanguageDataProvider.getCurrentLanguage() != null) {
					language = LanguageDataProvider.getCurrentLanguage();
				}
				TestCaseResult.addResults(testId, language, Platform, "PASS");
			}
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ConfigReader.getValue("browserstack").equalsIgnoreCase("true")) {
			JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"\"}}");
		}else {
			try {
				mobilescreenRecord.stopRecording(iTestResult.getMethod().getMethodName() + "_" + language);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ReportManager.logPassMobile("Test case passed");

		Test model = ReportManager.getCurrentTest().getModel();
		String oldName = model.getName();
		model.setName(oldName + "_" + language);
		
		ReportManager.endCurrentTestMobile();
		initDriver.tearDownMobileDriver();
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		String language = "English";
		try {
			String description = iTestResult.getMethod().getDescription();
			String temp = description.split("]")[0];
			String[] split = temp.replace("[", "").split(", ");
			for (String s : split) {
				String testId = s;
				if (LanguageDataProvider.getCurrentLanguage() != null) {
					language = LanguageDataProvider.getCurrentLanguage();
				}
				TestCaseResult.addResults(testId, language, Platform, "FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ConfigReader.getValue("browserstack").equalsIgnoreCase("true")) {
			JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getInstance().getMobileDriver();
			String errorMessage = iTestResult.getThrowable().getMessage().substring(0, 150);

			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \""
							+ errorMessage + "\"}}");
		}else {
			try {
				mobilescreenRecord.stopRecording(iTestResult.getMethod().getMethodName() + "_" + language);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
		ReportManager.logFailMobile("Test case Fail");
		ReportManager.logFailMobile(iTestResult.getThrowable().getMessage());
		try {
			ReportManager.logScreenshotInfo();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Test model = ReportManager.getCurrentTest().getModel();
		String oldName = model.getName();
		model.setName(oldName + "_" + language);
		
		ReportManager.endCurrentTestMobile();
		initDriver.tearDownMobileDriver();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext arg0) {
		try {
			TestCaseResult.saveToExcel();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InvalidFormatException e) {
			throw new RuntimeException(e);
		}
		ReportManager.endReportMobile();

	}

	@Override
	public void onStart(ITestContext arg0) {
		Platform = arg0.getCurrentXmlTest().getParameter(KEY);
		Udid = arg0.getCurrentXmlTest().getParameter(KEY1);
		SystemPort = arg0.getCurrentXmlTest().getParameter(KEY2);
		DeviceName = arg0.getCurrentXmlTest().getParameter(KEY3);
		DeviceVersion = arg0.getCurrentXmlTest().getParameter(KEY4);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
// TODO Auto-generated method stub

	}

}