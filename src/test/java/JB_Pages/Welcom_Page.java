package JB_Pages;

import com.codoid.products.exception.FilloException;

import android_Utils.LanguageDataProvider;
import android_Utils.MobileActions;
import utilities.ConfigReader;
import utilities.ExcelUtil_Effia;
import utilities.MobileUtil;
import utilities.ReportManager;

public class Welcom_Page {
	MobileActions mobileActions = new MobileActions();
	String actual;
	String expected;
	boolean field;

	public void verify_WelcomeBack_Page() {
		try {
			ReportManager.logInfo("##### GOING TO VERIFY WELCOME-BACK PAGE #####");
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Welcome_back"));
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "WelComePageHeader");
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Welcome_back"))
					.trim();
			mobileActions.verifyText(actual, expected);
			ReportManager.logPass("##### SUCCESSFULLY VERIFIED WELCOME-BACK PAGE #####");
		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verify_Fields_WelComeBack_Page() throws FilloException {
		mobileActions
				.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Org_code"));
		expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Txt_Org_Code");
		actual = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Org_code")).trim();
		mobileActions.verifyText(actual, expected);
		mobileActions
				.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Acc_code"));
		expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Txt_Acc_ID");
		actual = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Acc_code")).trim();
		mobileActions.verifyText(actual, expected);
	}

	public void fill_Org_Code(String orgCode) {
		try {
			field = mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "inputField_Org_code"),
					"ORGANIZATION CODE INPUT FIELD");
			if (field) {
				System.out.println("ORGANIZATION CODE INPUT FIELD STATUS ---- " + field);
				mobileActions.click(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "inputField_Org_code"),
						"ORGANIZATION CODE INPUT FIELD");
				mobileActions.clearAndSendKeys(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "inputField_Org_code"),
						orgCode);
				mobileActions.hideKeyboard();
			} else {
				System.out.println("Something went worng with - ORGANIZATION CODE INPUT FIELD");
			}
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}

	public void fill_Acc_ID(String accid) {
		try {
			field = mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "inputField_Acc_code"),
					"ACCOUNT ID INPUT FIELD");
			if (field) {
				System.out.println("ACCOUNT ID INPUT FIELD STATUS ---- " + field);
				mobileActions.click(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "inputField_Acc_code"),
						"ACCOUNT ID INPUT FIELD");
				mobileActions.clearAndSendKeys(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "inputField_Acc_code"),
						accid);
				mobileActions.hideKeyboard();
			} else {
				System.out.println("Something went worng with - ACCOUNT ID INPUT FIELD");
			}
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}

	public void verifyAndClickon_Next(boolean status) {

		try {
			if (status == true) {
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Next"));
				actual = mobileActions
						.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Next"))
						.trim();
				expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Btn_Next");
				mobileActions.verifyText(actual, expected);
				field = mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "btn_Next"),
						"NEXT BUTTON");
				if (field) {
					System.out.println("NEXT BUTTON STATUS ---- " + field);
					mobileActions.click(
							MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "btn_Next"),
							"NEXT BUTTON");
					Thread.sleep(15000);
					field = mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_ERROR"));
					if(field==true)
					{
						ReportManager.logInfo("##### ERROR MESSAGE DISPLAYED #####");
						mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_ERROR"), "POP-UP: - ");
						mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_Msg_ERROR"), "ERROR: - ");
						mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "txt_ERROR_OK"),"ACCEPT BUTTON: - ");
						ReportManager.logScreenshotInfo();
						mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "btn_ERROR_OK"), "ERROR POP-UP ACCEPT/OK BUTTON");
						ReportManager.logPass("##### SUCCESSFULLY HANDLED ERROR MESSAGE #####");
						System.out.println("--------------- ENTER VALID ORG CODE AND ACCOUNT ID ----------------");
						ReportManager.logInfo("--------------- ENTER VALID ORG CODE AND ACCOUNT ID ----------------");
						ReportManager.logScreenshotInfo();
						fill_Org_Code(ConfigReader.getValue("orgCode"));
						fill_Acc_ID(ConfigReader.getValue("accountID"));
						ReportManager.logScreenshotInfo();
						mobileActions.click(
								MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "btn_Next"),
								"NEXT BUTTON");
					}
					else {
						System.out.println("ERROR NOT DISPLAYED");
					}
				} else {
					System.out.println("Something went wrong with - NEXT BUTTON");
				}
			} else {
				ReportManager.logInfo("GOING TO PREVIOUS TO SELECT CUSTOMER TYPE");
				mobileActions.waitForVisible(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "btn_BackToPrevious"));
				mobileActions.click(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Welcome_Back_Page", "btn_BackToPrevious"),
						"BACK ARROW BUTTON");
			}

		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}
}
