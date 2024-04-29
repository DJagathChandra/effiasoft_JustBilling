package utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class GroupByFeatureInJava {

    public static void main(String[] args) throws IOException {
    	String csv = "./test.csv";
    	CSVWriter writer = new CSVWriter(new FileWriter(csv));
    	
    	String[] header = {"Reliance Freash","Test Case ID", "Description", "Result"}; 
		writer.writeNext(header); 
    	List<String[]> data = new ArrayList<String[]>();
    	
    	data.add(new String[] {"","TC_001", "Description", "PASS"});
    	data.add(new String[] {"","TC_002", "Description", "Fail"});
    	data.add(new String[] {"","TC_003", "Description", "PASS"});

    	writer.writeAll(data);

    	writer.close();
    }
}