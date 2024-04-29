package JB_Pages;

import android_Utils.LanguageDataProvider;
import android_Utils.MobileActions;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ExcelUtil_Effia;
import utilities.MobileUtil;
import utilities.ReportManager;

public class Sign_In_Page {

	MobileActions mobileActions = new MobileActions();
	String actual;
	String expected;
	boolean status;

	public void validate_Sign_In_And_Logo() {
		try {
			ReportManager.logInfo("##### GOING TO VERIFY SIGN IN PAGE #####");
			mobileActions
					.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_Sign_In"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_Sign_In")).trim();
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "SignInPageHeader");
			mobileActions.verifyText(actual, expected);
			status = mobileActions
					.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "logo_JB_Image"));
			if (status) {
				ReportManager.logPass("##### SUCCESSFULLY VERIFIED SIGN IN PAGE #####");
			} else {
				ReportManager.logFail("######## SOMETHING WENT WRONG ########");
			}
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}

	
	public void fill_User_ID() {
		try {
			mobileActions
					.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_User_ID"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_User_ID")).trim();
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Text_userId");
			mobileActions.verifyText(actual, expected);
			status = mobileActions.isElmPresent(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "inputField_User_ID"));
			if (status) {
				System.out.println("USER ID INPUT FIELD STATUS ---- " + status);
				mobileActions.clearAndSendKeys(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "inputField_User_ID"), ConfigReader.getValue("userID"));
				mobileActions.hideKeyboard();
			} else {
				System.out.println("Something went worng with - USER ID INPUT FIELD");
			}

		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}

	}

	public void fill_Password() {
		try {
			mobileActions
					.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_Password"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_Password")).trim();
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Text_Password");
			mobileActions.verifyText(actual, expected);
			status = mobileActions.isElmPresent(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "inputField_Password"));
			if (status) {
				System.out.println("PASSWORD INPUT FIELD STATUS ---- " + status);
				mobileActions.clearAndSendKeys(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "inputField_Password"),
						ConfigReader.getValue("password"));
				mobileActions.hideKeyboard();
			} else {
				System.out.println("Something went worng with - PASSWORD INPUT FIELD");
			}
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}

	}

	public void verify_Forgot_Password() {
		try {
			mobileActions
					.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "forgot_Password"));
			status = mobileActions
					.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "forgot_Password"));
			if (status) {
				System.out.println("FORGOT PASSWORD STATUS ---- " + status);
				actual = mobileActions
						.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "forgot_Password"))
						.trim();
				expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Text_ForgotPassword");
				mobileActions.verifyText(actual, expected);
			} else {
				System.out.println("Something went worng with - FORGOT PASSWORD INPUT FIELD");
			}

		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}

	}

	public void click_On_Forgot_Password(boolean clickOption) {
		try {
			mobileActions
					.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "forgot_Password"));
			if (clickOption == true) {
				System.out.println("You choose FORGOT PASSWORD option to click");
				ReportManager.logInfo("You choose FORGOT PASSWORD option to click");
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "forgot_Password"),
						"FORGOT PASSWORD");
			}
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}

	public void createUser_Via_SignIn(boolean createNewUser) {
		try {
			mobileActions
					.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_New_User"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_New_User")).trim();
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Text_NewUser");
			mobileActions.verifyText(actual, expected);
			status = mobileActions
					.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "btn_New_User"));
			if (status) {
				System.out.println("NEW USER BUTTON STATUS ---- " + status);
				if (createNewUser == true) {
					mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "btn_New_User"),
							"NEW USER BUTTON");
				}
			}
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}

	public void click_on_SignIn() {
		try {
			mobileActions
					.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_Sign_in_btn"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_Sign_in_btn")).trim();
			expected = ExcelUtil_Effia.getDataByKey("data_To_Validate", "Text_SignIn");
			mobileActions.verifyText(actual, expected);
			status = mobileActions
					.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "btn_Sign_in_btn"));
			if (status) {
				System.out.println("SIGN IN BUTTON STATUS ---- " + status);
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "btn_Sign_in_btn"),
						"SIGN IN BUTTON");
				if (mobileActions
						.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_Error"))) {
					System.out.println("ERROR POP-UP DISPLAYED PLEASE ACCEPT AND CHECK YOUR CREDENTIALS");
					ReportManager.logInfo("ERROR POP-UP DISPLAYED PLEASE ACCEPT AND CHECK YOUR CREDENTIALS");
					mobileActions.getText(
							MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "txt_Error_Message"),
							"ERROR BANNER MESSAGE: ");
					mobileActions.click(
							MobileUtil.returnByBasedOnPageNameAndObjectName("Sign_In_Page", "btn_Error_Accept_Ok"),
							"OK (ACCEPT) BUTTON");
					fill_User_ID();
					fill_Password();
				}
			}
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}
}
