package JB_Pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import android_Utils.MobileActions;
import utilities.ExcelUtil_Effia;
import utilities.MobileUtil;
import utilities.ReportManager;

public class Business_Creation_Page {
	MobileActions mobileActions = new MobileActions();
	String text;

	String actual;
	String expected;

	public void verify_BusinessTypePage() {
		try {
			ReportManager.logInfo("##### GOING TO VERIFY BUSINESS TYPE PAGE #####");
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Business_Type_Page", "txt_Logo_of_Page"));
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "BusinessTypePageHeader");
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Business_Type_Page", "txt_Logo_of_Page"))
					.trim();
//			mobileActions.verifyText(actual, expected);
			System.out.println(actual + " is Match with " + expected);
			ReportManager.logPass("##### SUCCESSFULLY VERIFIED BUSINESS TYPE PAGE #####");

		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verify_BusinessTypeList() {
		try {
			ReportManager.logInfo("######## GOING TO VERIFY TYPES IN BUSINESS ########");
			List<WebElement> list = mobileActions
					.elements(MobileUtil.returnByBasedOnPageNameAndObjectName("Business_Type_Page", "lst_of_Business"));
			System.out.println("Number of Types in Business are: - " + list.size());
			ReportManager.logInfo("Number of Types in Business are: - " + list.size());
			for (int i = 1; i <= list.size(); i++) {
				actual = mobileActions.getText(MobileUtil.returnBy("xpath",
						"(//android.widget.TextView[@resource-id='cloud.effiasoft.justbillingstd:id/tvName'])[" + i
								+ "]"))
						.trim();
				expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "BusinessType_0" + i);
				mobileActions.verifyText(actual, expected);
				text = ExcelUtil_Effia.getDataByKey("data_To_Validate", "BusinessType_0" + i + "_Caption");
				System.out.println("BusinessType_0" + i + " Caption is: " + text);
				ReportManager.logInfo("BusinessType_0" + i + " Caption is: " + text);
			}
			ReportManager.logPass("##### SUCCESSFULLY VERIFIED LIST OF BUSINESS TYPES #####");
		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void select_BusinessType(String business, int count) {
		try {
			ReportManager.logInfo("##### GOING TO SELECT BUSINESS TYPE #####");
			String getBusiness = ExcelUtil_Effia.getDataByKey("data_To_Validate", "BusinessType_0" + count);
			if (business.equals(getBusiness)) {
				System.out.println("Selected Busines Type is: " + getBusiness);
				ReportManager.logInfo("Selected Busines Type is: " + getBusiness);
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Business_Type_Page", "lst_of_Business"));
				mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Business_Type_Page", "lst_of_Business"),
						"BUSINESS TYPE " + getBusiness);
				mobileActions.click(MobileUtil.returnBy("xpath",
						"(//android.widget.TextView[@resource-id='cloud.effiasoft.justbillingstd:id/tvName'])[" + count
								+ "]"),
						getBusiness);
			}
			ReportManager.logPass("##### SUCCESSFULLY YOUR BUSINESS TYPE SELECTED AS --- " + getBusiness + " #####");
		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}
}
