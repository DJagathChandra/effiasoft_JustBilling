package utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.util.HashMap;
import java.util.Map;

public class ExcelUtil_Effia {
    private static final String EXCEL_FILE_PATH = "D:\\essentials_Appium\\07_workSpaceFolder\\05_JB_WorkSpace_Demo\\com.effia.justbilling\\src\\test\\resources\\Files\\TestData_JB.xlsx";
    private static Connection connection;

    static {
        Fillo fillo = new Fillo();
        try {
            connection = fillo.getConnection(EXCEL_FILE_PATH);
        } catch (FilloException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getDataFromSheet(String sheetName) throws FilloException {
        Map<String, String> dataMap = new HashMap<>();
        String query = "SELECT * FROM " + sheetName;
        Recordset recordset = connection.executeQuery(query);
        while (recordset.next()) {
            String key = recordset.getField("Key");
            String value = recordset.getField("Value");
            dataMap.put(key, value);
        }
        recordset.close();
        return dataMap;
    }

    public static String getDataByKey(String sheetName, String key) throws FilloException {
        Map<String, String> dataMap = getDataFromSheet(sheetName);
        return dataMap.get(key);
    }
}
