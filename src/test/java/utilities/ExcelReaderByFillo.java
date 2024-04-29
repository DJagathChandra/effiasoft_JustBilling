package utilities;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReaderByFillo {

	static String path = "src/test/resources/Files/TestData.XLSX";
	static Fillo fillo = new Fillo();
	static Connection connection;

	public static Recordset reader(String sheetName) throws FilloException {
		connection = fillo.getConnection(path);

		String strQuery = String.format("Select * from %s", sheetName);

		Recordset recordset = connection.executeQuery(strQuery);
		connection.close();
		return recordset;

	}

	public static void main(String[] args) throws FilloException {
		Recordset test = reader("Languages");
		while (test.next()) {

			System.out.println(test.getField("Name"));

			System.out.println(test.getField("Enable"));
		}
		test.close();
	}
}
