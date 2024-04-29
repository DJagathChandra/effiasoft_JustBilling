package utilities;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.codec.binary.Base64;

public class MobilescreenRecord {
	
	private static String timestamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");
	public void startRecording() {
		DriverFactory.getInstance().getMobileDriver().startRecordingScreen();
	}
	
	public void stopRecording(String testName) throws IOException {
		String media = DriverFactory.getInstance().getMobileDriver().stopRecordingScreen();
		String dirPath =   "D:\\essentials_Appium\\07_workSpaceFolder\\05_JB_WorkSpace_Demo\\com.effia.justbilling\\Reports\\MobileVideos";
		  
		   File videoDir = new File(dirPath);
		   FileOutputStream stream = null;
		try {
		 stream = new FileOutputStream(videoDir + File.separator +testName+ " "+timestamp+ ".mp4");
		            stream.write(Base64.decodeBase64(media));
		            stream.close();
		            
		        } catch (Exception e) {
		            
		        } finally {
		            if(stream != null) {
		                stream.close();
		            }
		        }
	}
}
