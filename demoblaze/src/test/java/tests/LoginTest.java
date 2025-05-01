package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest{
	@Test(description = "Verify login with valid credentials")
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);

        String username = "Aparna1995";   // Use a valid user you created
        String password = "Aparna@1995";

        loginPage.login(username, password);

        boolean isLoggedIn = loginPage.isUserLoggedIn();
        test.info("Login successful? " + isLoggedIn);

        Assert.assertTrue(isLoggedIn, "Login failed for valid credentials.");
        test.pass("Login verified successfully.");
    }

}
