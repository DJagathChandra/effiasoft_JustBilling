package JB_Pages;

import com.codoid.products.exception.FilloException;

import android_Utils.LanguageDataProvider;
import android_Utils.MobileActions;
import utilities.ExcelUtil_Effia;
import utilities.MobileUtil;
import utilities.ReportManager;

import java.io.IOException;

public class Hello_Page {
	MobileActions mobileActions = new MobileActions();
	String optionUser;

	String actual;
	String expected;

	/**
	 * This method is to login on JB application
	 *
	 * @param mobileNumber
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws FilloException
	 */

	public void verify_HelloPage() {
		try {
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "HelloPageHeader");
			ReportManager.logInfo("##### GOING TO VERIFY LOGO TEXT " + expected + " #####");
			mobileActions
					.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "txt_Logo_Hello"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "txt_Logo_Hello"));
			mobileActions.verifyText(actual, expected);
			ReportManager.logPass("##### SUCCESSFULLY VERFIED LOGO TEXT " + actual + " #####");
		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verify_User_Options() {
		try {
			ReportManager.logInfo("##### GOING TO VERIFY USER-OPTIONS #####");
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "New_User");
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "txt_NewToJB"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "txt_NewToJB"));
			mobileActions.verifyText(actual, expected);
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "New_User_Caption");
			System.out.println("Caption for New User: - " + expected);
			ReportManager.logInfo("Caption for New User: - " + expected);
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Old_User");
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "txt_AlredyRegistered"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "txt_AlredyRegistered"));
			mobileActions.verifyText(actual, expected);
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Old_User_Caption");
			System.out.println("Caption for Old User: - " + expected);
			ReportManager.logInfo("Caption for Old User: - " + expected);

			ReportManager.logPass("##### SUCCESSFULLY VERIFIED USER OPTIONS #####");
		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void select_User_Option(String user_option) {
		try {
			ReportManager.logInfo("##### GOING TO SELECT USER " + user_option + " #####");
			if (user_option.equalsIgnoreCase("New")) {
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "txt_NewToJB"));
				boolean isRadioBtn = mobileActions.isElmPresent(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "btn_NewToJB"));
				if (isRadioBtn) {
					System.out.println("New to JustBilling Radio button Displayed successfully");
					mobileActions.click(
							MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "btn_NewToJB"),user_option);
				}
			} else if (user_option.equalsIgnoreCase("Already")) {
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "txt_AlredyRegistered"));
				boolean isRadioBtn = mobileActions.isElmPresent(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "btn_AlredyRegistered"));
				if (isRadioBtn) {
					System.out.println("Already Registered Radio button Displayed successfully");
					mobileActions.click(
							MobileUtil.returnByBasedOnPageNameAndObjectName("Hello_Page", "btn_AlredyRegistered"),user_option);
				}
			} else {
				System.out.println("##### ERROR #####" + user_option + " IS WENT WRONG");
			}
			ReportManager.logPass("##### SUCCESSFULLY SELECTED OPTION AS " + user_option + " #####");

		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}

	}
}
