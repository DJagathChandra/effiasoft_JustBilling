package JB_Pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import android_Utils.MobileActions;
import utilities.MobileUtil;
import utilities.ReportManager;


public class Retail_Business_Creation_Page {
	
	MobileActions mobileActions = new MobileActions();
	
	
	public void verify_RetailBusinessPage()
	{
		
	}
	
	public void select_SubCatogery_Of_Business(String category)
	{
		try {
			ReportManager.logInfo("######## GOING TO SELECT SUB CATEGORY OF BUSINESS - "+category+" ########");
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Retail_Business_Page", "type_Grocery"));
			boolean subCat = mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("Retail_Business_Page", "type_Grocery"));
			System.out.println("Successfully Grocery Sub Category Displayed: "+subCat);
			if(subCat)
			{
				String text = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Retail_Business_Page", "type_Grocery"));
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Retail_Business_Page", "type_Grocery"), "Clicked on "+text);
			}
			ReportManager.logPass("######## SUCCESSFULLY SELECTED SUB CATEGORY OF BUSINESS "+category+" ########");
		}catch (Exception e) {
			System.out.println("########################## ERROR ########################## "+ e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	public void verify_SubCatogery_Business()
	{
		try {
			ReportManager.logInfo("######## GOING TO VERIFY SUB CATEGORY OF BUSINESS ########");
			mobileActions.swipeUsingTextAndSwipeCount("Others", 3);
			List<WebElement> list = mobileActions.elements(MobileUtil.returnBy("xpath", "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"cloud.effiasoft.justbillingstd:id/rvSubCates\"]//android.widget.TextView[@resource-id=\"cloud.effiasoft.justbillingstd:id/tvName\"]"));
			System.out.println("Number of Sub Catogery in Retail Business are: - "+list.size());
			for(int i=1;i<=list.size();i++) {
				mobileActions.getText(MobileUtil.returnBy("xpath", "(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"cloud.effiasoft.justbillingstd:id/rvSubCates\"]//android.widget.TextView[@resource-id=\"cloud.effiasoft.justbillingstd:id/tvName\"])["+i+"]"),"SUB CATOGERY "+i+" : - ");
				
			}
			ReportManager.logPass("######## SUCCESSFULLY VERIFIED SUB CATEGORY OF BUSINESS ########");
		}catch (Exception e) {
			System.out.println("########################## ERROR ########################## "+ e.getMessage());
			e.printStackTrace();
		}
		
	}
}
