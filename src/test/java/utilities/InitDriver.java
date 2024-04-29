package utilities;
import java.net.MalformedURLException;





public class InitDriver {

	DriverFactory driverFactory = DriverFactory.getInstance();
	int port = 4723;

	private String str_Execution_Web = ConfigReader.getValue("Execution_Web");
	private String str_BrowserType = ConfigReader.getValue("Browser");
	//private String str_BrowserType = System.getProperty("Browser");
	private String str_MobileOSType = ConfigReader.getValue("MobileOSType");
	private String str_Execution_Mobile = ConfigReader.getValue("Execution_Mobile");
	private String str_Execution_Desktop = ConfigReader.getValue("Execution_Desktop");

	public void startWebDriver() throws Exception {
		System.out.println(str_Execution_Web);
		if (str_Execution_Web.equalsIgnoreCase("Web_Application")) {
			System.out.println("Execution started @ " + str_BrowserType + " browser & for type : " + str_Execution_Web);
			DriverFactory.getInstance().setWebDriver(str_BrowserType.trim());
		}

	}

	public void startMobileDriver(String platform, String udid, String systemPort, String deviceName, String deviceVersion) throws Exception {
		System.out.println(str_Execution_Mobile);
		if (str_Execution_Mobile.equalsIgnoreCase("Mobile_Application")) {
			System.out.println("Execution started Mobile_Application @ " + str_MobileOSType);
			switch (str_MobileOSType.trim()) {

			case "IOS_Native":

				break;
			case "IOS_Browser":

				break;
			case "Android_Native":
				
				driverFactory.setMobileDriver(platform, udid, systemPort, deviceName, deviceVersion);
				break;
			case "Android_Browser":

				break;

			default:
				System.out.println(
						"[-] Please set the value for Mobile OS type - IOS_Native or IOS_Browser or Android_Native or Android_Browser");

			}

		}

	}

	
	

	public void tearDownWebDriver() throws InterruptedException, MalformedURLException {
		System.out.println("Execution ended - " + str_BrowserType + " browser & for type : " + str_Execution_Web);
		if (driverFactory.getWebDriver() != null) {
			driverFactory.getWebDriver().quit();
		}

	}

	public void tearDownMobileDriver() {

		System.out.println("Execution ended - " + str_MobileOSType);
		if (driverFactory.getMobileDriver() != null) {
			driverFactory.getMobileDriver().quit();
			driverFactory.removeDriver();
		}

	}

}
