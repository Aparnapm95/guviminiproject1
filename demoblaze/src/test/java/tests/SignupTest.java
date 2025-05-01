package tests;

import java.util.UUID;

import org.openqa.selenium.Alert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.SignupPage;

@Listeners(listeners.TestListener.class)
public class SignupTest  extends BaseTest{
	 @Test(description = "Verify user can sign up with valid credentials")
	    public void testSignup() {
	        SignupPage signup = new SignupPage(driver);

	        String randomUsername = "user" + UUID.randomUUID().toString().substring(0, 5);
	        String password = "Password123";

	        signup.register(randomUsername, password);

	        // Wait for alert
	        try {
	            Thread.sleep(2000); // Give time for alert to show
	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	            test.info("Alert Message: " + alertText);
	            alert.accept();
	            test.pass("Signup successful with user: " + randomUsername);
	        } catch (Exception e) {
	            test.fail("Signup failed or alert not displayed: " + e.getMessage());
	        }
	    }

}
