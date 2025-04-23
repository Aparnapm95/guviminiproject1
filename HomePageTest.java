package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import utils.BaseClass;

public class HomePageTest extends BaseClass {
	@Test
    public void verifyRegisterButton() {
        HomePage home = new HomePage(driver);
        home.clickRegister();
        assert driver.getCurrentUrl().contains("register");
    }

    @Test
    public void verifyLoginButton() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        assert driver.getCurrentUrl().contains("login");

}
}
