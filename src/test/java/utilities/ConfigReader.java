package utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class ConfigReader {

    private static Properties appiumProps = null;

    private ConfigReader() {

    }

    private static void initAppiumProps() {
        if (appiumProps == null)
            appiumProps = loadPropertyFile("src/test/resources/configfiles/appium.properties");
    }

    public static String getAppiumProp(String key) {
        initAppiumProps();
        return appiumProps.getProperty(key);
    }

    /**
     * =============================================================================
     * Method: loadPropertyFile | Author: Jagath Chandra | Date:04 Oct 2023 |
     * Description: This method loadPropertyFile method used for loading the
     * properties file | Parameters:filePath | Return: Properties
     * =============================================================================
     */
    public static Properties loadPropertyFile(String filePath) {
        // Read from properties file
        File file = new File(filePath);
        Properties prop = new Properties();

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
            prop.load(fileInput);
        } catch (Exception e) {
            // LogUtil.errorLog(ConfigReader.class, "Caught the exception", e);

        }
        return prop;

    }

    /**
     * =============================================================================
     * Method: getValue | Author: Jagath Chandra | Date:04 Oct 2023 | Description:
     * will get sting value from properties file | Parameters:key | Return: String
     * =============================================================================
     */
    public static String getValue(String key) {

        Properties prop = loadPropertyFile("src/test/resources/ConfigFiles/config.properties");

        return prop.getProperty(key);
    }

    /**
     * =============================================================================
     * Method: getValue | Author: Jagath Chandra | Date:04 Oct 2023 | Description:
     * will get int value from properties file | Parameters:key | Return: int
     * =============================================================================
     */
    public static int getIntValue(String key) {
        Properties prop = loadPropertyFile("src/test/resources/ConfigFiles/config.properties");

        String strKey = prop.getProperty(key);

        return Integer.parseInt(strKey);
    }

    /**
     * =============================================================================
     * Method: moveFile | Author: Jagath Chandra | Date:04 Oct 2023 | Description:
     * Move file one place to other place | Parameters: outFileName, sourcePath
     * destinationPath fileextention | Return: none
     * =============================================================================
     */
    public static void moveFile(String outFileName, String sourcePath, String destinationPath, String fileextention)
            throws IOException {
        File source = new File(sourcePath);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String ts = sdf.format(source.lastModified());
        File destination = new File(destinationPath + outFileName + ts);
        FileUtils.copyFile(source, destination);
        System.out.println(" new file name is " + outFileName);
    }



}
