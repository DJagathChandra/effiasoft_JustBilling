package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReportManager {

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static Map<Long, ExtentTest> testMap = new HashMap<>();
    public static Map<String, ExtentTest> extentMap = new HashMap<>();

    public static void startReport() {

        if (htmlReporter == null) {
            String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
            String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/WebReports/" + dateStamp
                    + "/" + "JB-" + timeStamp + ".html");            // Create an object of Extent Reports
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "Just_Billing");
            extent.setSystemInfo("Environment", "Test Env");
            extent.setSystemInfo("User Name", "JAGATH CHANDRA");
            htmlReporter.config().setDocumentTitle("Just_Billing Mobile Application");
            // Name of the report
            htmlReporter.config().setReportName("Just_Billing Mobile Application");
            htmlReporter.config().isTimelineEnabled();
            // htmlReporter.config().setAutoCreateRelativePathMedia(true);
            // Dark Theme
            htmlReporter.config().setTheme(Theme.DARK);

        }

    }

    public static void startTest(String testName, String description, String categories) {

		/*
		 * for (int i = 0; i < ConfigReader.getIntValue("reTry"); i++) { if
		 * (extentMap.containsKey(testName)) {
		 * 
		 * extent.removeTest(extentMap.get(testName));
		 * 
		 * testName = "Rerun - " + testName;
		 * 
		 * } }
		 */

        ExtentTest test = extent.createTest(testName, description);
      //  test.assignCategory(categories);
        testMap.put(Thread.currentThread().getId(), test);
        extentMap.put(testName, test);

    }

    public static void logPass(String message) {
        getCurrentTest().log(Status.PASS, message);

    }

    /**
     * =============================================================================
     * Method: logScreenShot | Author: Jagath Chandra | Date:03 Oct 2023 |
     * Description: This method log take screenshot | Parameters: message | Return:
     * none
     * =============================================================================
     *
     * @param driver
     * @throws IOException
     */
    public static void logScreenshot() throws IOException {
        // getCurrentTest().addScreenCaptureFromBase64String(ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getWebDriver()));
        Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
                ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getMobileDriver())).build();
        getCurrentTest().fail("", mediaModel);

    }

    /**
     * =============================================================================
     * Method: logScreenShot | Author: Jagath Chandra | Date:03 Oct 2023 |
     * Description: This method log take screenshot | Parameters: message | Return:
     * none
     * =============================================================================
     *
     * @param driver
     * @throws IOException
     */
    public static void logScreenshotInfo() throws IOException {
        Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
                ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getMobileDriver())).build();
        getCurrentTest().info("", mediaModel);

    }

    /**
     * =============================================================================
     * Method: logScreenShot | Author: Jagath Chandra | Date:03 Oct 2023 |
     * Description: This method log take screenshot | Parameters: message | Return:
     * none
     * =============================================================================
     *
     * @param driver
     * @throws IOException
     */
    public static void logScreenshotInfo1() throws IOException {
        /*
         * Media mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
         * ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getWindowDriver()))
         * .build(); getCurrentTest().info("", mediaModel);
         */
    }

    public static void logFail(String message) {
        getCurrentTest().log(Status.FAIL, message);

    }

    public static void logInfo(String message) {
        getCurrentTest().log(Status.INFO, message);

    }

    public static void endCurrentTest() {

        getCurrentTest().getExtent().flush();

        testMap.remove(Thread.currentThread().getId());
    }

    public static ExtentTest getCurrentTest() {
        return testMap.get(Thread.currentThread().getId());

    }

    public static void endReport() {

        extent.flush();
    }

    public static ExtentSparkReporter htmlReporterMobile;
    public static ExtentReports extentMobile;
    public static Map<Long, ExtentTest> testMapMobile = new HashMap<>();

    public static void startReportMobile() {
        if (htmlReporter == null) {
            String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
            String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MobileReports/" + dateStamp
                    + "/" + "JB-" + timeStamp + ".html");
            // Create an object of Extent Reports
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "Just_Billing");
            extent.setSystemInfo("Environment", "Test Env");
            extent.setSystemInfo("User Name", "JAGATH CHANDRA");
            htmlReporter.config().setDocumentTitle("Just_Billing Mobile Application");
            // Name of the report
            htmlReporter.config().setReportName("Just_Billing Mobile Application");
            htmlReporter.config().isTimelineEnabled();
            // htmlReporter.config().setAutoCreateRelativePathMedia(true);
            // Dark Theme
            htmlReporter.config().setTheme(Theme.DARK);

        }

    }

    public static void startTestMobile(String testName, String description, String categories) {

		/*
		 * for (int i = 0; i < ConfigReader.getIntValue("reTry"); i++) { if
		 * (extentMap.containsKey(testName)) {
		 * 
		 * extent.removeTest(extentMap.get(testName));
		 * 
		 * testName = "Rerun - " + testName;
		 * 
		 * } }
		 */

        ExtentTest test = extent.createTest(testName, description);
       // test.assignCategory(categories);
        testMap.put(Thread.currentThread().getId(), test);
        extentMap.put(testName, test);



    }

    public static void logPassMobile(String message) {
        getCurrentTest().log(Status.PASS, message);

    }


    public static void logFailMobile(String message) {
        getCurrentTest().log(Status.FAIL, message);
   }

    public static void logInfoMobile(String message) {
        getCurrentTest().log(Status.INFO, message);

    }

    public static void endCurrentTestMobile() {
        getCurrentTest().getExtent().flush();

        testMap.remove(Thread.currentThread().getId());
    }

    public static ExtentTest getCurrentTestMobile() {
        return testMap.get(Thread.currentThread().getId());

    }

    public static void endReportMobile() {

        extent.flush();
    }

    public static void main(String[] args) {



	}

}
