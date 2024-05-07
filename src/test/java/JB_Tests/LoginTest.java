package JB_Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import JB_Pages.Business_Creation_Page;
import JB_Pages.Hello_Page;
import JB_Pages.My_Subscription_Page;
import JB_Pages.Organization_Details_Page;
import JB_Pages.Permissions_Page;
import JB_Pages.Retail_Business_Creation_Page;
import JB_Pages.Sign_In_Page;
import JB_Pages.Subscription_Page;
import JB_Pages.Welcom_Page;
import android_Utils.LanguageDataProvider;
import listeners.MobileEvent;
import listeners.SuiteEvent;
import utilities.ConfigReader;
import utilities.ReportManager;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class LoginTest {
	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_01 Verify ***login_Hello_New_To_JB*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_New_To_JB() throws Exception {
		ReportManager.logInfo("##### login_Hello_New_To_JB #####");
		Hello_Page hello_Page = new Hello_Page();
		Permissions_Page pPage = new Permissions_Page();
		hello_Page.verify_HelloPage();
		hello_Page.verify_User_Options();
		hello_Page.select_User_Option("New");
		pPage.verify_Permissions_Page();
		pPage.select_Permission("I Agree");
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_New_To_JB #####");
	}

	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_02 Verify ***login_Hello_New_To_JB_Business*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_New_To_JB_Business() throws Exception {
		ReportManager.logInfo("##### login_Hello_New_To_JB_Business #####");
		Business_Creation_Page bcPage = new Business_Creation_Page();
		login_Hello_New_To_JB();
		bcPage.verify_BusinessTypePage();
		bcPage.verify_BusinessTypeList();
		bcPage.select_BusinessType("Retail", 1);
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_New_To_JB_Business #####");
	}

	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_03 Verify ***login_Hello_New_To_JB_Retail*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_New_To_JB_Retail() throws Exception {
		ReportManager.logInfo("##### login_Hello_New_To_JB_Retail #####");
		login_Hello_New_To_JB_Business();
		Retail_Business_Creation_Page rbc_Page = new Retail_Business_Creation_Page();
		Thread.sleep(5000);
		rbc_Page.verify_SubCatogery_Business();
		rbc_Page.select_SubCatogery_Of_Business("Grocery");
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_New_To_JB_Retail #####");
	}

	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_04 Verify ***login_Hello_New_To_JB_SubScription*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_New_To_JB_SubScription() throws Exception {
		ReportManager.logInfo("##### login_Hello_New_To_JB_SubScription #####");
		login_Hello_New_To_JB_Retail();
		Subscription_Page sub_Page = new Subscription_Page();
		Thread.sleep(5000);
		sub_Page.select_Subscription_Type("Professional");
		sub_Page.select_SubCatogery_In_Professional(null);
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_New_To_JB_SubScription #####");
	}

	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_05 Verify ***login_Hello_New_To_JB_Org_Details*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_New_To_JB_Org_Details() throws Exception {
		ReportManager.logInfo("##### login_Hello_New_To_JB_Org_Details #####");
		login_Hello_New_To_JB_SubScription();
		Organization_Details_Page orgDetails_Page = new Organization_Details_Page();
		Thread.sleep(2000);
		orgDetails_Page.verify_Org_DetailsPage();
		orgDetails_Page.verify_Deatils_Category();
		orgDetails_Page.verify_CompanyDetailsFieldNames();
		orgDetails_Page.verify_LocationFieldNames();
		orgDetails_Page.verify_MiscDetailsFieldNames();
		orgDetails_Page.verify_Fill_CompanyName("Effia");
		orgDetails_Page.verify_Fill_OwnerName("Ramu");
		orgDetails_Page.verify_Fill_MobileNumber("9440570107");
		orgDetails_Page.verify_Fill_EmailAddress("jagath.donthoju@effiasoft.com");
		orgDetails_Page.verify_Fill_New_Password("abc123");
		orgDetails_Page.verify_Select_CountryDropDown();
		orgDetails_Page.verify_Select_StateDropDown();
		orgDetails_Page.verify_Select_CityDropDown();
		orgDetails_Page.verify_Fill_Address("1-3-45, RP NILAYAM, Alwal");
		orgDetails_Page.verify_Fill_GSTIN("");
		orgDetails_Page.verify_Select_CurrencyDropDown();
		orgDetails_Page.verify_Select_Preferred_languauge_DropDown();
		orgDetails_Page.verify_Fill_ReferralCode("");
		orgDetails_Page.verify_Check_Policy_and_Click_VerifyButton();
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_New_To_JB_Org_Details #####");
	}

	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_06 Verify ***login_Hello_Already_To_JB*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_Already_To_JB() throws Exception {
		ReportManager.logInfo("##### login_Hello_Already_To_JB #####");
		Hello_Page hello_Page = new Hello_Page();
		Permissions_Page pPage = new Permissions_Page();
		hello_Page.verify_HelloPage();
		hello_Page.verify_User_Options();
		hello_Page.select_User_Option("Already");
		pPage.verify_Permissions_Page();
		pPage.select_Permission("I Agree");
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_Already_To_JB #####");
	}

	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_07 Verify ***login_Hello_Already_To_JB_Welcome*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_Already_To_JB_Welcome() throws Exception {
		ReportManager.logInfo("##### login_Hello_Already_To_JB_Welcome #####");
		Welcom_Page welcome_Page = new Welcom_Page();
		login_Hello_Already_To_JB();
		welcome_Page.fill_Org_Code(ConfigReader.getValue("orgCode"));
		welcome_Page.fill_Acc_ID(ConfigReader.getValue("accountID"));
		welcome_Page.verifyAndClickon_Next(true);
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_Already_To_JB_Welcome #####");
	}
	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_08 Verify ***login_Hello_Already_To_JB_Welcome_Negative*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_Already_To_JB_Welcome_Negative() throws Exception {
		ReportManager.logInfo("##### login_Hello_Already_To_JB_Welcome_Negative #####");
		Welcom_Page welcome_Page = new Welcom_Page();
		login_Hello_Already_To_JB();
		welcome_Page.fill_Org_Code(ConfigReader.getValue("orgCode"));
		welcome_Page.fill_Acc_ID(ConfigReader.getValue("wrong_accountID"));
		welcome_Page.verifyAndClickon_Next(true);
		Thread.sleep(5000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_Already_To_JB_Welcome_Negative #####");
	}

	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_09 Verify ***login_Hello_Already_To_JB_SignIN*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_Already_To_JB_SignIN() throws Exception {
		ReportManager.logInfo("##### login_Hello_Already_To_JB_SignIN #####");
		Sign_In_Page s_Page = new Sign_In_Page();
		login_Hello_Already_To_JB_Welcome();
		Thread.sleep(5000);
		s_Page.validate_Sign_In_And_Logo();
		s_Page.fill_User_ID();
		s_Page.fill_Password();
		s_Page.click_on_SignIn();
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_Already_To_JB_SignIN #####");
	}

	@Test(dataProviderClass = LanguageDataProvider.class, description = "[TC_10 Verify ***login_Hello_Already_To_JB_MySub*** successfully", groups = {
			"Smoke", "JB_Login" })
	public void login_Hello_Already_To_JB_MySub() throws Exception {
		ReportManager.logInfo("##### login_Hello_Already_To_JB_MySub #####");
		My_Subscription_Page m_s_Page = new My_Subscription_Page();
		Thread.sleep(5000);
		login_Hello_Already_To_JB_SignIN();
		Thread.sleep(5000);
		m_s_Page.validate_My_Suscription_Title();
		m_s_Page.get_Your_Suscription_Days_Details();
		m_s_Page.verify_Click_on_Proceed();
		Thread.sleep(2000);
		ReportManager.logPass("##### SUCCESS ---- login_Hello_Already_To_JB_MySub #####");
	}
}
