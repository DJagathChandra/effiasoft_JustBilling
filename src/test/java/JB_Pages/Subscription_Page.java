package JB_Pages;

import android_Utils.MobileActions;
import utilities.MobileUtil;

public class Subscription_Page {
	MobileActions mobileActions = new MobileActions();
	String text;

	
	public void verify_SubscriptionPage() {
		
	}
	
	
	public void select_Subscription_Type(String typeOfSubscription) {
		try {
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "txt_Subscription"));
			boolean isSub = mobileActions.isElmPresent(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "txt_Subscription"));
			System.out.println("Successfully displayed Subscription: " + isSub);
			if (isSub) {
				text = mobileActions.getText(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "txt_Subscription"));
				if (typeOfSubscription.equalsIgnoreCase("free")) {
					mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page",
							"txt_Free_Subscription"));
					text = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page",
							"txt_Free_Subscription"));
					mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page",
							"btn_Free_Subscription"), "FREE SUBSCRIPTION BUTTON");
				} else if (typeOfSubscription.equalsIgnoreCase("Professional")) {
					mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page",
							"txt_Professional_Subscription"));
					text = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page",
							"txt_Professional_Subscription"));
					mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page",
							"btn_Professional_Subscription"), "PROFESSIONAL SUBSCRIPTION BUTTON");
				} else {
					System.out.println("############################ Ufff you missed by giving text wrong");
				}
			} else {
				System.out.println("########################### Ufff you missed ");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void select_SubCatogery_In_Professional(String code) {
		try {
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "txt_Free_trail"));
			text = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "txt_Free_trail"));
			if (code == null) {
				mobileActions.click(
						MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "btn_Free_trail"),
						"15 DAYS FREE TRAIL BUTTON");
			} else if (code != null) {
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", ""),
						"15 DAYS FREE TRAIL BUTTON");
			}
			mobileActions.waitForVisible(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "txt_Proceed_Subscription"));
			text = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "txt_Proceed_Subscription"));
			mobileActions.click(
					MobileUtil.returnByBasedOnPageNameAndObjectName("Subscription_Page", "btn_Proceed_Subscription"),
					"PROCEED BUTTON");
		} catch (Exception e) {
			System.out.println("############################## Ufff you missed to give code");
		}
	}

}
