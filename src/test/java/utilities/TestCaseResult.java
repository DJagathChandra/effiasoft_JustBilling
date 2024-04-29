package utilities;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

import lombok.Data;
import lombok.SneakyThrows;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TestCaseResult {
    String testId, language, deviceDetail, result;
    private static boolean isExcelReady = false;
    private static Connection connection;
    private static Fillo fillo = new Fillo();
    private static File excelFile;
    private static final String EXCEL_TEMPLATE_PATH = "src/test/resources/Files/JB_ReportTemplate.xlsx";
    private static List<TestCaseResult> testCaseResults = new ArrayList<>();

    static {
        try {
			initExcelReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public synchronized static int totalTests() {
        return testCaseResults.size();
    }

    public synchronized static void addResults(String testId, String language, String deviceDetail, String result) {
        TestCaseResult testCaseResult = new TestCaseResult();

        testCaseResult.setTestId(testId);

        if (language.isEmpty()) {
            testCaseResult.setLanguage("English");
        } else {
            testCaseResult.setLanguage(language);
        }

        testCaseResult.setDeviceDetail(deviceDetail);
        testCaseResult.setResult(result);

        testCaseResults.add(testCaseResult);
    }

    public synchronized static void initExcelReport() throws IOException {
        if (!isExcelReady) {
            copyTemplate();
            isExcelReady = excelFile.exists();
        }

    }

    public static synchronized void saveToExcel() throws IOException, InvalidFormatException {
        if (!isExcelReady) {
            throw new RuntimeException("Please initialize excel report before saving results.");
        }
        try {
            TestCaseResult.printToScreen();
            for (TestCaseResult testCaseResult : testCaseResults) {
                saveToExcel(testCaseResult);
            }

        } catch (FilloException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printToScreen() {

        System.out.println("\nTotal Results: " + TestCaseResult.totalTests());
        System.out.println("----------------------------------------------------------------------------------");
        for (TestCaseResult testCaseResult : testCaseResults) {
            System.out.println("\t" + testCaseResult.toString());
        }

        System.out.println("===================================================================================");
    }

    public synchronized static void saveToExcel(TestCaseResult testResult) throws FilloException {
        String strQuery = String.format("Update TestScenariosExecution Set %s='%s' Where TestCaseId='%s'", testResult.getLanguage(), testResult.getResult() + "-" + testResult.getDeviceDetail(), testResult.getTestId());
        int update = getConnection().executeUpdate(strQuery);
        if (update > 0) {
            System.out.println("Record update success...");
        } else {
            System.out.println("Record update failed...");
        }

    }

    private synchronized static Connection getConnection() throws FilloException {
        if (connection == null) {
            return fillo.getConnection(excelFile.getAbsolutePath());
        } else {
            return connection;
        }
    }

    @SneakyThrows
    private static void copyTemplate() throws IOException {
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HHmmss").format(new Date());
        String dateStamp = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String reportPath = String.format(System.getProperty("user.dir") + "/Reports/ExcelReports/" + dateStamp
                + "/" + "JB_TestReport-" + timeStamp + ".xlsx");
        File targetFile = new File(reportPath);
        FileUtils.copyFile(new File(EXCEL_TEMPLATE_PATH), targetFile);

        if (!(targetFile.exists()) && targetFile.length() < 1) {
            throw new RuntimeException(String.format("Error: Target file for the excel report not created: %s", targetFile.getAbsoluteFile()));
        }
        excelFile = targetFile;
    }
}
