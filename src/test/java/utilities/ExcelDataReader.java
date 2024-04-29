package utilities;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import android_Utils.Language;

import java.util.*;

public class ExcelDataReader {
    private static Fillo fillo = new Fillo();
    private static Connection connection = null;

    private static final String TESTDATAPATH = "src/test/resources/Files/TestData_JB.xlsx";


    public static Recordset getSheetDataWithQuery(String query) throws FilloException {
        connection = fillo.getConnection(TESTDATAPATH);
        Recordset recordset = connection.executeQuery(query);
        connection.close();
        return recordset;
    }

    public static Recordset getSheetData(String sheetName) throws FilloException {
        connection = fillo.getConnection(TESTDATAPATH);
        Recordset recordset = connection.executeQuery(String.format("Select * from %s", "data_To_Validate")); //String sheetName
        connection.close();
        return recordset;
    }

    public static List<Language> getLanguages() throws FilloException {
        Recordset sheetDataWithQuery = getSheetDataWithQuery("Select * from Languages Where Enable ='Yes'");

        List<Language> languages = new ArrayList<>();
        while (sheetDataWithQuery.next()) {
            Language language = new Language();
            language.setLanguage(sheetDataWithQuery.getField("Name"));
            language.setEnable(sheetDataWithQuery.getField("Enable"));
            languages.add(language);
        }
        sheetDataWithQuery.close();
        return languages;
    }


    public static void main(String[] args) throws FilloException {
        List<Language> languages = getLanguages();
        for (Language language : languages) {
            System.out.println(language.getLanguage());
            System.out.println(language.getEnable());

        }
    }

    /**
     * This method is to get data from specific sheet
     * @param sheetName
     * @return
     * @throws FilloException
     */
    public static LinkedHashMap<String, String> getLanguagesFromHomePage(String sheetName) throws FilloException {
        Recordset sheetDataWithQuery = getSheetData(sheetName);
        LinkedHashMap<String, String> availableLanguages = new LinkedHashMap<>();

        while (sheetDataWithQuery.next()) {
            availableLanguages.put(sheetDataWithQuery.getField("Key"),sheetDataWithQuery.getField("Value"));
        }
        sheetDataWithQuery.close();
        return availableLanguages;
    }

    public static List<String> getMLKTextFromExcelSheet() throws FilloException {
        Recordset sheetDataWithQuery = getSheetDataWithQuery("Select * from PatasalaTab");

        List<String> patasalaText = new ArrayList<>();
        while (sheetDataWithQuery.next()) {
        	patasalaText.add(sheetDataWithQuery.getField("Value"));
        }
        sheetDataWithQuery.close();
        return patasalaText;
    }
}
