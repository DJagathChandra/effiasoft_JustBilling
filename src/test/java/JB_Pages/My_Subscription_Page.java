package JB_Pages;

import android_Utils.MobileActions;
import utilities.MobileUtil;
import utilities.ReportManager;

public class My_Subscription_Page {
	MobileActions mobileActions = new MobileActions();
	String actualText;
	String expectedText;
	boolean status;

	public void validate_My_Suscription_Title() {
		try {
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page", "txt_My_Subscription"));
			actualText = mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page", "txt_My_Subscription"))
					.trim();
			expectedText = "My Subscription";
			mobileActions.verifyText(actualText, expectedText);
			ReportManager.logPass("Success -- Validation of My Subscription page Title");

		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}

	public void get_Your_Suscription_Days_Details() {
		try {
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page",
					"txt_Subscription_Days_Left"));
			mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page",
					"txt_Subscription_Days_Left"));
			actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page",
					"txt_Subscription_Days_Left")).trim();
			mobileActions.getText(
					MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page", "txt_Subscription_Days"),
					actualText).trim();
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}

	public void verify_Click_on_Proceed() {
		try {
			mobileActions.swipeUsingTextAndSwipeCount("Proceed", 3);
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page", "txt_Proceed"));
			status = mobileActions.isElmPresent(
					MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page", "txt_Proceed"));
			if (status) {
				System.out.println("PROCEED BUTTON STATUS ---- " + status);
				mobileActions.click(
						MobileUtil.returnByBasedOnPageNameAndObjectName("My_Subscription_Page", "btn_Proceed"),
						"PROCEED BUTTON");
			}
		} catch (Exception e) {
			System.out.println("######## ERROR MESSAGE ########" + e.getMessage());
		}
	}

}
