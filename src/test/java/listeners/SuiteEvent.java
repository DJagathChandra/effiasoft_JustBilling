package listeners;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.SneakyThrows;
import utilities.ReportManager;
import utilities.TestCaseResult;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.opencsv.CSVWriter;

public class SuiteEvent extends TestListenerAdapter implements ISuiteListener, IExecutionListener, IReporter {
	CSVWriter writer;
	public List<String[]> data = new ArrayList<String[]>();

	@Override
	public void onFinish(ISuite arg0) {

	}

	@Override
	public void onStart(ISuite arg0) {

	}

	@Override
	public void onExecutionStart() {
		String suite = System.getProperty("suite","Default suite picked");
		System.out.println("Going to start suite: "+ suite);
		ReportManager.startReportMobile();

	}

	@SneakyThrows
	@Override
	public void onExecutionFinish() {
		try {
			TestCaseResult.saveToExcel();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReportManager.endReportMobile();
		

	}

	@Override
	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String outputDirectory) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String csv = System.getProperty("user.dir") + "/Reports/CSV/TestResults.csv";

		try {
			writer = new CSVWriter(new FileWriter(csv));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (ISuite iSuite : arg1) {
			Map<String, ISuiteResult> results = iSuite.getResults();
			Set<String> keys = results.keySet();
			for (String key : keys) {
				ITestContext context = results.get(key).getTestContext();
				IResultMap resultMap = context.getFailedTests();

				// -------------------------FAILED TEST CASE-----------------------------
				Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();
				for (ITestNGMethod iTestNGMethod : failedMethods) {
					Date DateTime = new Date(iTestNGMethod.getDate());
					String dateDate = dateFormat.format(DateTime);
					String[] array_DataTime = dateDate.split(" ");
					data.add(new String[] { array_DataTime[0], array_DataTime[1], iTestNGMethod.getMethodName(),
							iTestNGMethod.getDescription(), "FAIL" });
				}

				// -------------------------PASSED TEST CASE-----------------------------

				IResultMap resultMapPass = context.getPassedTests();
				Collection<ITestNGMethod> passMethods = resultMapPass.getAllMethods();
				for (ITestNGMethod iTestNGMethod : passMethods) {
					Date DateTime = new Date(iTestNGMethod.getDate());
					String dateDate = dateFormat.format(DateTime);
					String[] array_DataTime = dateDate.split(" ");
					data.add(new String[] { array_DataTime[0], array_DataTime[1], iTestNGMethod.getMethodName(),
							iTestNGMethod.getDescription(), "PASS" });

				}

			}

		}
		String[] header = { "Date", "Time", "Test Case ID", "Description", "Result" };
		writer.writeNext(header);
		writer.writeAll(data);
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
