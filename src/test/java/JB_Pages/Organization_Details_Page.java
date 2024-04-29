package JB_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import android_Utils.MobileActions;
import utilities.DriverFactory;
import utilities.ExcelUtil_Effia;
import utilities.MobileUtil;
import utilities.ReportManager;

public class Organization_Details_Page {
	MobileActions mobileActions = new MobileActions();
	String actual;
	String expected;

	public void verify_Org_DetailsPage() {
		try {
			ReportManager.logInfo("##### GOING TO VERIFY ORGANIZATION DETAILS PAGE #####");
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Organization_Details"));
			expected = ExcelUtil_Effia.getDataByKey("registration_fields", "OrganizationDetailsPageHeader");
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Business_Type_Page", "txt_Logo_of_Page"))
					.trim();
			mobileActions.verifyText(actual, expected);
			ReportManager.logPass("##### SUCCESSFULLY VERIFIED BUSINESS TYPE PAGE #####");

		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verify_Deatils_Category() {
		try {
			ReportManager.logInfo("##### GOING TO VERIFY ORG-DETAILS-MAIN-CATEGORY #####");
			for (int i = 1; i <= 3; i++) {
				expected = ExcelUtil_Effia.getDataByKey("registration_fields", "Details_Header_" + i);
				mobileActions.swipeUsingTextAndSwipeCount(expected, 3);
				actual = mobileActions
						.getText(MobileUtil.returnBy("xpath", "//android.widget.TextView[@text='" + expected + "']"));
				mobileActions.verifyText(actual, expected);
			}

		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verify_CompanyDetailsFieldNames() {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Company Name", 2);
			;
			Thread.sleep(2000);
			ReportManager.logInfo("##### GOING TO VERIFY COMPANY DETAILS FIELDS LIST #####");
			for (int i = 1; i <= 6; i++) {
				expected = ExcelUtil_Effia.getDataByKey("registration_fields", "CompanyDetailsField_0" + i);
				mobileActions.swipeUsingTextAndSwipeCount(expected, 2);
				String xpath = "//android.widget.TextView[@text='" + expected + "']";
				actual = mobileActions.getText(MobileUtil.returnBy("xpath", xpath)).trim();
				mobileActions.verifyText(actual, expected);
			}
		} catch (Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verify_LocationFieldNames() {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("LOCATION", 2);
			Thread.sleep(2000);
			ReportManager.logInfo("##### GOING TO VERIFY LOCATION FIELDS LIST #####");
			for (int i = 1; i <= 4; i++) {
				expected = ExcelUtil_Effia.getDataByKey("registration_fields", "LocationField_0" + i);
				mobileActions.swipeUsingTextAndSwipeCount(expected, 2);
				String xpath = "//android.widget.TextView[@text='" + expected + "']";
				actual = mobileActions.getText(MobileUtil.returnBy("xpath", xpath)).trim();
				mobileActions.verifyText(actual, expected);
			}
		} catch (

		Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verify_MiscDetailsFieldNames() {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("MISC. DETAILS", 2);
			Thread.sleep(2000);
			ReportManager.logInfo("##### GOING TO VERIFY MISC. DETAILS FIELDS LIST #####");
			for (int i = 1; i <= 4; i++) {
				expected = ExcelUtil_Effia.getDataByKey("registration_fields", "MISC_ DetailsField_0" + i);
				mobileActions.swipeUsingTextAndSwipeCount(expected, 2);
				String xpath = "//android.widget.TextView[@text='" + expected + "']";
				actual = mobileActions.getText(MobileUtil.returnBy("xpath", xpath)).trim();
				mobileActions.verifyText(actual, expected);
			}
		} catch (

		Exception e) {
			System.out.println("########################## ERROR ########################## " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void verify_Fill_CompanyName(String CmpyName) {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Company Name", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Company_Name"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Company_Name"));
			mobileActions.verifyText(actual, "Company Name");
			mobileActions.clearAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"inputFeild_Company_Name"), CmpyName, "COMPANY NAME GIVEN AS: - ");
			mobileActions.to_Hide_keyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Fill_OwnerName(String OwnerName) {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Owner name", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Owner_Name"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Owner_Name"));
			mobileActions.verifyText(actual, "Owner name");
			mobileActions.clearAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"inputFeild_Owner_Name"), OwnerName, "OWNER NAME GIVEN AS: - ");
			mobileActions.to_Hide_keyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verify_Fill_MobileNumber(String Mobilenumber) {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Mobile No", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Mobile_No"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Mobile_No"));
			mobileActions.verifyText(actual, "Mobile No");
			mobileActions.clearAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"inputFeild_Mobile_No"), Mobilenumber, "MOBILE NUMBER GIVEN AS: - ");
			mobileActions.to_Hide_keyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Fill_EmailAddress(String EmailAddress) {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Email address", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Email_Address"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Email_Address"));
			mobileActions.verifyText(actual, "Email address");
			mobileActions.clearAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"inputFeild_Email_Address"), EmailAddress, "EMAIL ADDRESS GIVEN AS: - ");
			mobileActions.to_Hide_keyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verify_Fill_New_Password(String Password) {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Password", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_New_Password"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_New_Password"));
			mobileActions.verifyText(actual, "Password");
			mobileActions.clearAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"inputFeild_New_Password"), Password, "PASSWORD GIVEN AS: - ");

			mobileActions.swipeUsingTextAndSwipeCount("Confirm password", 2);
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_New_Confirm_Password"));
			actual = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_New_Confirm_Password"));
			mobileActions.verifyText(actual, "Confirm password");
			mobileActions.clearAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"inputFeild_New_Confirm_Password"), Password, "CONFIRM PASSWORD GIVEN AS: - ");
			mobileActions.to_Hide_keyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Select_CountryDropDown() {

		try {
			mobileActions.swipeUsingTextAndSwipeCount("Country", 2);
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Country_Details"));
			actual = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Country_Details"));
			mobileActions.verifyText(actual, "Country");
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"dropDown_Country_Name"), "COUNTRY NAME DROPDOWN");
			Thread.sleep(1000);
			mobileActions.swipeUsingTextAndSwipeCount("India", 5);
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"selection_Country_Name"));
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"selection_Country_Name"), "COUNTRY NAME");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Select_StateDropDown() {
		try {
			Thread.sleep(1000);
			mobileActions.swipeUsingTextAndSwipeCount("State", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_State_Details"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_State_Details"));
			mobileActions.verifyText(actual, "State");
			mobileActions.click(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "dropDown_State_Name"),
					"STATE NAME DROPDOWN");
			Thread.sleep(1000);
			mobileActions.swipeUsingTextAndSwipeCount("Telangana", 2);
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"selection_State_Name"), "STATE NAME");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verify_Select_CityDropDown() {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("City", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_City_Details"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_City_Details"));
			mobileActions.verifyText(actual, "City");
			mobileActions.click(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "dropDown_City_Name"),
					"CITY NAME DROPDOWN");
			Thread.sleep(1000);
			mobileActions.swipeUsingTextAndSwipeCount("Hyderabad", 3);
			mobileActions.click(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "selection_City_Name"),
					"CITY NAME");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verify_Fill_Address(String Address) {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Address", 2);
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Address_Details"));
			actual = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Address_Details"));
			mobileActions.verifyText(actual, "Address");
			mobileActions.clearAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"inputFeild_Address_Details"), Address, "ADDRESS GIVEN AS: - ");
			mobileActions.to_Hide_keyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Fill_GSTIN(String GSTIN) {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("GSTIN", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_GSTIN"));
			actual = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_GSTIN"));
			mobileActions.verifyText(actual, "GSTIN");
			mobileActions.clearAndSendKeys(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "inputFeild_GSTIN"),
					GSTIN, "GSTIN GIVEN AS: - ");
			mobileActions.to_Hide_keyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Fill_ReferralCode(String ReferralCode) {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Referral Code(Optional)", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Referral_Code"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Referral_Code"));
			expected = ExcelUtil_Effia.getDataByKey("registration_fields", "MISC_ DetailsField_04");
			mobileActions.verifyText(actual, "Referral Code (Optional)");
			mobileActions.clearAndSendKeys(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "inputFeild_GSTIN"),
					ReferralCode, "REFERRAL CODE GIVEN AS: - ");
			mobileActions.to_Hide_keyboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Select_CurrencyDropDown() {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Currency", 2);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Currency"));
			actual = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "txt_Currency"));
			mobileActions.verifyText(actual, "Currency");
			mobileActions.click(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "dropDown_Currency"),
					"CURRENCY DROPDOWN");
			Thread.sleep(1000);
			mobileActions.swipeUsingTextAndSwipeCount("Indian Rupee", 2);
			mobileActions.click(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "selection_Currency"),
					"CURRENCY TYPE");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verify_Select_Preferred_languauge_DropDown() {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Preferred Language", 2);
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Preferred_Language"));
			actual = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Preferred_Language"));
			mobileActions.verifyText(actual, "Preferred Language");
			mobileActions.click(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page", "dropDown_Preferred_Language"),
					"PREFERRED LANGUAGE DROPDOWN");
			Thread.sleep(1000);
			mobileActions.swipeUsingTextAndSwipeCount("English", 2);
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"selection_Preferred_Language"), "PREFERRED LANGUAGE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Check_Policy_and_Click_VerifyButton() {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("I agree to receive communication on WhatsApp", 2);
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Whatsapp_notifications"));
			actual = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Whatsapp_notifications"));
			mobileActions.verifyText(actual, "I agree to receive communication on WhatsApp");
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"rd_btn_Whatsapp_notifications"), "AGREE TO WHATSAPP COMMUNICATION");
			Thread.sleep(1000);
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"rd_btn_Whatsapp_notifications"), "DIS-AGREE TO WHATSAPP COMMUNICATION");
			mobileActions.swipeUsingTextAndSwipeCount(
					"I have read and agree with the SUBSCRIPTION AGREEMENT and PRIVACY POLICY", 2);
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Accept_TermsAndConditions"));
			actual = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Accept_TermsAndConditions"));
			mobileActions.verifyText(actual,
					"I have read and agree with the SUBSCRIPTION AGREEMENT and PRIVACY POLICY");
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"rd_btn_Accept_TermsAndConditions"), "AGREE TO SUBSCRIPTION AGREEMENT");
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Verify_Org_details"));
			actual = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"txt_Verify_Org_details"));
			mobileActions.verifyText(actual, "Verify");
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Organization_Details_Page",
					"btn_Verify_Org_details"), "VERIFY BUTTON OF ORG DETAILS");
			Thread.sleep(10000);
		} catch (Exception e) {
		}
	}
}
