package JB_Pages;

import org.openqa.selenium.Alert;

import android_Utils.LanguageDataProvider;
import android_Utils.MobileActions;
import utilities.ExcelUtil_Effia;
import utilities.MobileUtil;
import utilities.ReportManager;

public class Permissions_Page {
	MobileActions mobileActions = new MobileActions();
	boolean status;
	String actual;
	String expected;

	public void verify_Permissions_Page() {
		try {
			ReportManager.logInfo("##### GOING TO VERIFY PERMISSIONS PAGE #####");
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "txt_Permissions"));
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "PermissionsPageHeader");
			actual= mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "txt_Permissions")).trim();
			mobileActions.verifyText(actual, expected);
			
		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void select_Permission(String choiceOfPermission) {
		try {
			ReportManager.logInfo("##### GOING TO SELECT/GRANT PERMISSION #####");
			if (choiceOfPermission.equals("I Agree")) {
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "txt_I_Agree"));
				status = mobileActions.isElmPresent(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "txt_I_Agree"));
				System.out.println("Successfully Permission I Agree displayed: " + status);
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "btn_I_Agree"));
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "btn_I_Agree"),
						"Clicked Permission successfully");
				try {
					Alert locationalert = mobileActions.handleAlert();
					locationalert.accept();
				} catch (Exception e) {
					System.out.println("Try again for Alert");
					Alert locationalert = mobileActions.handleAlert();
					locationalert.accept();

				}
			} else if (choiceOfPermission.equals("Disagree")) {
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "txt_Disagree"));
				status = mobileActions.isElmPresent(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "txt_Disagree"));
				System.out.println("Successfully Permission Disagree displayed: " + status);
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "btn_Disagree"));
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Permissions_Page", "btn_Disagree"),
						"Denied Permission successfully");
			} else {
				System.out.println("##### Check Once Again #####");
			}
			ReportManager.logPass("##### SUCCESSFULLY SELECT/GRANTED PERMISSION " + choiceOfPermission + " #####");

		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}

	}

}
