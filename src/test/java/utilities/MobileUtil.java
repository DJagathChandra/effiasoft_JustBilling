/* Copyright (C) Eaton , Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Yogesh Bhalekar <yogeshpbhalekar@eaton.com>
 */

package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class MobileUtil{

	public static By returnBy(String locatorType, String locatorValue) {
		By by = null;
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			by = By.xpath(locatorValue);
			break;
		case "NAME":
			by = By.name(locatorValue);
			break;
		case "ID":
			by = By.id(locatorValue);
			break;
		case "CSS":
			by = By.cssSelector(locatorValue);
			break;
		}
		return by;
	}

	public static By returnByBasedOnPageNameAndObjectName(String page, String object)
	{
		
		String locatorType = JsonUtils.getLocatorType(page, object);
		String locatorValue = JsonUtils.getLocatorValue(page, object);
		return MobileUtil.returnBy(locatorType, locatorValue);
	}

	public static By returnByBasedOnPageNameAndObjectName(String page, String object, String textToReplace) {
		String locatorType = JsonUtils.getLocatorType(page, object);
		String locatorValue = JsonUtils.getLocatorValue(page, object).replaceAll("###", textToReplace);
		return MobileUtil.returnBy(locatorType, locatorValue);
	}

	public static String getLastWindowHandle(WebDriver webDriver) {
		String handle = null;
		for (String handleIterator : webDriver.getWindowHandles()) {
			handle = handleIterator;
		}
		return handle;
	}

}
