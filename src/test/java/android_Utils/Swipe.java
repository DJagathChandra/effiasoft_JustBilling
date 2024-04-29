package android_Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import utilities.DriverFactory;

public class Swipe {
	public static void swipe(String direction) {
	    Dimension size = DriverFactory.getInstance().getMobileDriver().manage().window().getSize();
	
	    int startX = 0;
	    int endX = 0;
	    int startY = 0;
	    int endY = 0;
	
	    switch (direction) {
	        case "RIGHTtoLEFT":
	            startY = (int) (size.height / 2);
	            startX = (int) (size.width * 0.90);
	            endX = (int) (size.width * 0.10);
	            new TouchAction(DriverFactory.getInstance().getMobileDriver())
	                    .longPress(PointOption.point(startX, startY))
	                    .moveTo(PointOption.point(endX, startY))
	                    .release()
	                    .perform();
	            break;
	
	        case "LEFTtoRIGHT":
	            startY = (int) (size.height / 2);
	            startX = (int) (size.width * 0.10);
	            endX = (int) (size.width * 0.90);
	            new TouchAction(DriverFactory.getInstance().getMobileDriver())
	                    .longPress(PointOption.point(startX, startY))
	                    .moveTo(PointOption.point(endX, startY))
	                    .release()
	                    .perform();
	
	            break;
	
	        case "DOWN":
	            endY = (int) (size.height * 0.70);
	            startY = (int) (size.height * 0.30);
	            startX = (size.width / 2);
	            new TouchAction(DriverFactory.getInstance().getMobileDriver())
	                    .longPress(PointOption.point(startX, startY))
	                    .moveTo(PointOption.point(endX, startY))
	                    .release()
	                    .perform();
	            break;
	
	
	        case "UP":
	            startY = (int) (size.height * 0.70);
	            endY = (int) (size.height * 0.30);
	            startX = (size.width / 2);
	            new TouchAction(DriverFactory.getInstance().getMobileDriver())
	                    .longPress(PointOption.point(startX, startY))
	                    .moveTo(PointOption.point(startX, endY))
	                    .release()
	                    .perform();
	
	            break;
	
	    }
	}
	/*usage:
	
	swipe(driver, Util.DIRECTION.RIGHT);
	Hope*/
}

