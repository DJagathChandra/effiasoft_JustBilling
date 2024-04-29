package android_Utils;

import com.google.common.collect.ImmutableMap;

import utilities.DriverFactory;
import utilities.MobileUtil;
import utilities.ReportManager;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class CommonHelper {
    public static MobileActions mobileActions = new MobileActions();

    /**
     * This method is to click on Home icon from footer bar
     * @throws IOException
     */
    public static void clickOnHomeButton() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "homeButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "homeButton"),
                "Click on Home button");
    }

    /**
     * This method is to click on Edit button from Profile page
     * @throws IOException
     */
    public static void clickOnEditButtonFromProfilePage() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "editProfileButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "editProfileButton"),
                "Click on Edit button from Profile page");
    }

    /**
     * This method is to logout the user
     * @throws IOException
     */
    public static void logOutUser() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser"),
                "Logout user");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser_popup"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser_popup"),
                "Logout user successfully");
    }

    /**
     * This method is to click on cancel button from logout popup
     * @throws IOException
     */
    public static void clickCancelButtonOnLogOutAndDeleteAccountPopUp() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "cancelButtonOnLogOutPopUp"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "cancelButtonOnLogOutPopUp"),
                "Cancel for logout popup");
    }

    /**
     * This method is to click on cancel link from search result
     * @throws IOException
     */
    public static void clickOnCancelLinkFromSearchBar() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "cancelButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "cancelButton"),
                "Click on Cancel button from search bar");
    }

    /**
     * This method is to click on Profile
     * @throws IOException
     */
    public static void clickOnProfile() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"),
                "Click on Profile icon");
    }

    /**
     * This method is to click on back button from profile page
     * @throws IOException
     */
    public static void verifyAndClickOnBackButtonOnProfilePage() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton"),
                "Verify Back button is present"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton"),
                "Click on Back button");
        ReportManager.logPass("Clicked on Back button successfully");
    }

    /**
     * This method is click on back arrow
     * @throws IOException
     */
    public static void clickOnBackArrow() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton_arrow"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton_arrow"),
                "Click on Back button");
    }

    /**
     * This method is to verify profile username
     * @param userName
     */
    public static void verifyProfileUserName(String userName){
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "profileUserName",userName),
                "Verify profile username is present"));
    }

    /**
     * This method is to create and post koo with default selected language
     * @param text
     * @param postButton
     * @throws IOException
     */
    public static void createAndPostKoo(String language, String text, String postButton) {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"), text);
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", postButton),
                "Click on Post Button");
        if(language.equalsIgnoreCase("English")){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_okScheduleKoo"),
                    "Click ok Schedule Koo button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "languageDoneButton"),
                    "Click on Done button");
        }
    }

    /**
     * This method is to click on search ico
     * @throws IOException
     */
    public static void clickOnSearchIcon() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "search_icon"),
                "Click on Search icon");
    }

    /**
     * This method is to click o ack arrow after searching value
     * @throws IOException
     */
    public static void clickOnBackArrowFromSearchBar() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "backArrowFromSearch"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "backArrowFromSearch"),
                "Click on ack Arrow from search bar");
    }

    /**
     * This method is to click on Enter button
     */
    public static void clickEnterButton(){
        DriverFactory.getInstance().getMobileDriver().executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }

    /**
     * This method is to click on Enter button
     */
    public static void clickSearchedProfileFromSearchResult(String profileID) throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "profileIDOnSearchResult",profileID),
                "Click on searched profile by ID from search bar result");
    }

    /**
     * This method is to click on search bar field
     * @throws IOException
     */
    public static void clickOnSearchBarField() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "searchBar_field"), "Click on search bar field");
    }

    /**
     * This method is to enter value in search bar field
     * @param value
     * @throws IOException
     */
    public static void enterValueInSearchBar(String value) {
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "searchBar_field"), value);
    }

    /**
     * This method is to type value from keyboard
     * @param value
     */
    public static void enterValueFromKeyboard(String value){
        Actions actions = new Actions(DriverFactory.getInstance().getMobileDriver());
        actions.sendKeys(value).perform();
    }

    /**
     * This method is to hide keyboard
     */
    public static void hideKeyboard(){
        DriverFactory.getInstance().getMobileDriver().hideKeyboard();
    }

    /**
     * Click on No or Cancel button
     * @throws IOException
     */
    public static void clickOnNoOrCancelButton() throws IOException {
        boolean element = mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "noButton"));
        if(element){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "noButton"), "Click on No Or Cancel button");
        }else {
        	DriverFactory.getInstance().getMobileDriver().navigate().back();
        }
    }

    /**
     * Click on Cross button for close tab
     * @throws IOException
     */
    public static void clickOnCrossButton() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "crossButtonForCloseTab"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "crossButtonForCloseTab"), "Click on Cross button");
    }

    /**
     * This method is to click on Chat icon from bottom bar
     * @throws IOException
     */
    public static void clickOnChatButton() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "chatIcon"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "chatIcon"),
                "Click on Chat button from bottom bar");
    }

    /**
     * This method is to click on Notification icon from bottom bar
     * @throws IOException
     */
    public static void clickOnNotificationButton() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "notificationIcon"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "notificationIcon"),
                "Click on Notification button from bottom bar");
    }

    /**
     * This method is to click on Koo bird
     * @throws IOException
     */
    public static void clickOnKooBird() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooBirdIcon"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooBirdIcon"),
                "Click on Koo Bird Icon");
    }

    /**
     * This method is to click on small cross button
     * @throws IOException
     */
    public static void clickOnSmallCrossButton() throws IOException, InterruptedException {
        Thread.sleep(5000);
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "crossButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "crossButton"),
                "Click on cross button");
    }

    /**
     * This method is to normal swipe up
     * @return
     */
    public static <T> T swipeUp(T landingPage, int i){
        mobileActions.swipeUp(i);
        return landingPage;
    }

    /**
     * This method is to click on three dots from profile of user
     *
     * @throws IOException
     */
    public static void clickOnThreeDotsOProfilePage() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"),
                "Click on three dots");
        ReportManager.logPass("Clicked on three dots successfully");
    }

    /**
     * This method is to click on settings button
     *
     * @return
     * @throws IOException
     */
    public static void clickSettingsButton() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "Click on Settings button");
    }

    /**
     * This method is to click on settings button
     *
     * @return
     * @throws IOException
     */
    public static void clickTrendingKooIcon() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "trendingKooIcon"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "trendingKooIcon"),
                "Click on Trending Koo icon from home/feed page");
    }

    /**
     * This method is to create and post koo with default selected language
     * @param text
     * @param postButton
     * @throws IOException
     */
    public static void createAndPostKooWithAttachment(String language, String text, String postButton) {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"), text);
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "addImageButton"),
                "Click on Add Image Button");
        if(mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "enablePermissionButton"))){
            mobileActions.click(
                    MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "enablePermissionButton"),
                    "Click on Enable Permission Button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "allowPermission"),
                    "Click on Allow button for handle permission");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "allowPermission"),
                    "Click on Allow button for handle permission");
            ReportManager.logInfo("Click on Allow button for handle permission");
        }
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "selectImage"),
                "Click on first image from gallery to select");
        if(mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "nextButton"))){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "nextButton"),
                    "Click on Next button after selecting picture");
        }
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", postButton),
                "Click on Post Button");
        if(language.equalsIgnoreCase("English")){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_okScheduleKoo"),
                    "Click ok Schedule Koo button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "languageDoneButton"),
                    "Click on Done button");
        }
    }

    /**
     * This method is to click on view koo button
     */
    public static void clickOnViewPostedKooButtonAfterPostingKooOrComment(){
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "viewPostedKooButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "viewPostedKooButton"),
                "Click on View Koo button from footer bar");
    }

    /**
     * This method is to click on like button
     * @return
     */
    public static void clickOnLikeIcon(){
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "btn_like"),
                "Click on Like button");
    }

    /**
     * This method is to click on comment icon and post comment
     * @param commentText
     * @return
     */
    public static void clickOnCommentIconAndPostComment(String commentText){
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "btn_comment"),
                "Click on Comment button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "write_commentSection"),
                commentText,"Enter comment");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "button_post"),
                "Click on post button");
    }

    /**
     * This method is to click on rekoo button and then click on No rekoo button
     */
    public static void clickOnReKooIconAndNoReKooButton(){
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "reeKooIcon"),
                "Click on ReKoo button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "reeKooNoButton"),
                "Click on ReKoo No button");
    }

    /**
     * Click on refresh icon to refresh comments
     */
    public static void clickOnRefreshIconToRefreshComments(){
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "refreshButtonOnTrendingKooPage"),
                "Click on Refresh icon/button");
    }

    /**
     * This method is to create and post koo with default selected language
     * @param text
     * @param postButton
     * @throws IOException
     */
    public static void createAndPostMLKKoo(String language, String text, String postButton, List<String> languageContentDesc) throws InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"), text);
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", postButton),
                "Click on Post Button");
        if(language.equalsIgnoreCase("English")){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_okScheduleKoo"),
                    "Click ok Yes button to select multiple languages");
            for(int i = 0; i < languageContentDesc.size(); i++){
                mobileActions.swipeUpFindElement(10,MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation",
                        "chkbox_everyone", languageContentDesc.get(i)));
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "chkbox_everyone",
                                languageContentDesc.get(i)),
                        "Click on checkbox to select multiple languages = "+languageContentDesc.get(i));
            }
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "languageDoneButton"),
                    "Click on Done button");
            mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "postButton",postButton));
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "postButton",postButton),
                    "Click on Post button");
        }
    }
}