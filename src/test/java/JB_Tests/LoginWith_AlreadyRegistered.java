package JB_Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.MobileEvent;
import listeners.SuiteEvent;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class LoginWith_AlreadyRegistered {
    @Test (description = "[TC_02 Verify login Just Billing application with Already Registered successfully")
    public void verifyUserLoginWithOTP() throws Exception {
    	
    }
}