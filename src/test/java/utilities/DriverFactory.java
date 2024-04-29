package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
	private static DriverFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	ThreadLocal<AndroidDriver<WebElement>> appiumDriver = new ThreadLocal<AndroidDriver<WebElement>>();
	ThreadLocal<WiniumDriver> windowDriver = new ThreadLocal<WiniumDriver>();

	private DriverFactory() {

	}

	public static DriverFactory getInstance() {
		if (instance == null) {
			instance = new DriverFactory();
		}
		return instance;
	}

	public final void setWebDriver(String browser) throws Exception {

		DesiredCapabilities caps = null;

		switch (browser) {

		case "Chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chOptions = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("credentials_enable_service", false);
			chOptions.setExperimentalOption("prefs", chromePrefs);
			chOptions.addArguments("--disable-plugins", "--disable-extensions", "--disable-popup-blocking");
			caps = new DesiredCapabilities();
			caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
			caps.setCapability("applicationCacheEnabled", false);
			webDriver.set(new ChromeDriver(chOptions));
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver.set(new FirefoxDriver());
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			webDriver.set(new EdgeDriver());
			break;

		case "IE":
			WebDriverManager.iedriver().setup();
			webDriver.set(new InternetExplorerDriver());
			break;

		}
		WebDriver driver = getWebDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public final void setMobileDriver(String platform, String udid, String systemPort, String deviceName,
			String deviceVersion) throws Exception {
		String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

		String executionType = System.getProperty("browserstack", ConfigReader.getValue("browserstack"));

		if (executionType.equalsIgnoreCase("false")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities.setCapability("appPackage", "cloud.effiasoft.justbillingstd");
			capabilities.setCapability("appActivity", "com.effiasoft.justbilling.home.AppSplashScreen");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nokia");
			capabilities.setCapability(MobileCapabilityType.UDID, "4Z01Z3227Y372417074");
			capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")
					+ "/src/test/resources/MobileApps/JB_UI_UAT_SPARK_5.5.0.0[783]_18-03-2024_APK.apk");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
			capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");

			try {
//				appiumDriver.set(new AndroidDriver<WebElement>(new URL("http://192.168.0.161:4723"), capabilities));
				appiumDriver.set(new AndroidDriver<WebElement>(new URL("http://10.0.0.63:4723"), capabilities)); //
			} catch (MalformedURLException e) {
				System.out.println("Appium server not started.. Trying again " + e.getMessage());
			}
		}

//		getMobileDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		else {

			JSONParser parser = new JSONParser();
			JSONObject config = (JSONObject) parser
					.parse(new FileReader("src/test/resources/ConfigFiles/parallel.conf.json"));
			JSONArray envs = (JSONArray) config.get("environments");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("browserstack.idleTimeout", "300");
			capabilities.setCapability("browserstack.geoLocation", "IN");
			capabilities.setCapability("browserstack.gpsLocation", "12.9716,77.5946");
			@SuppressWarnings("unchecked")
			Map<String, String> envCapabilities = (Map<String, String>) envs.get(Integer.parseInt(deviceVersion));
			Iterator it = envCapabilities.entrySet().iterator();
			while (it.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry) it.next();
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}

			@SuppressWarnings("unchecked")
			Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
			it = commonCapabilities.entrySet().iterator();
			while (it.hasNext()) {
				@SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry) it.next();
				if (capabilities.getCapability(pair.getKey().toString()) == null) {
					capabilities.setCapability(pair.getKey().toString(), pair.getValue());
				}
			}

			String username = System.getenv("BROWSERSTACK_USERNAME");
			if (username == null) {
				username = (String) config.get("username");
			}

			String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
			if (accessKey == null) {
				accessKey = (String) config.get("access_key");
			}

			String app = System.getenv("BROWSERSTACK_APP_ID");
			if (app != null && !app.isEmpty()) {
				capabilities.setCapability("app", app);
			}
			appiumDriver.set(new AndroidDriver<WebElement>(
					new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"),
					capabilities));
			getMobileDriver().setLocation(new Location(12.9716, 77.5946, 920));
		}
	}

	public WebDriver getWebDriver() {
		return webDriver.get();
	}

	public AndroidDriver<WebElement> getMobileDriver() {
		return appiumDriver.get();
	}

	public void removeDriver() {
		appiumDriver.remove();
	}

}