package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLdata {
	
	/**
	 * =============================================================================
	 * Method: getData | Author: Jagath Chandra | Date:04 Oct 2023 |
	 * Description: This method fetches the data from excel and provide to the test script,
	 * Excel name should be same as test case name
	 * | Parameters:null | Return: excel data
	 * =============================================================================
	 * @throws InvalidFormatException 
	 */

	@DataProvider(name="Testdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		String excelSheetName=m.getName();
	File f = new File("/Users/jagathchandra/Documents/PATASALA_Automation/src/test/resources/ConfigFiles/TestData.XLSX");
    FileInputStream fis= new FileInputStream(f);
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sheetName = wb.getSheetAt(0);
	int totalRows=sheetName.getLastRowNum();
	
	Row rowCells= sheetName.getRow(0);
	int totalCols= rowCells.getLastCellNum();
	
	DataFormatter format=new DataFormatter();
	String testData[][]= new String[totalRows][totalCols];
	for(int i=1;i<=totalRows;i++)
	{
		for(int j=0;j<totalCols;j++)
		{
			testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
			System.out.println(testData[i-1][j]);
		}
	}
	return testData;
	
	}	
}
