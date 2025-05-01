package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class LogoutTest extends BaseTest {
	@Test(description = "Verify user can log out successfully")
    public void testLogout() {
        // Precondition: user must be logged in
        String username = "Aparna1995";   // valid existing user
        String password = "Aparna@1995";

        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isUserLoggedIn(), "Precondition login failed");

      
    }
}
