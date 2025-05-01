package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {
	private WebDriver driver;

    // Locator for “Log out” link
    private By logoutLink = By.id("logout2");
    // Locator for “Log in” link to verify logout
    private By loginLink = By.id("login2");

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Clicks the “Log out” link. */
    public void clickLogout() {
        driver.findElement(logoutLink).click();
        // brief wait for UI update
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
    }

    /** Returns true if login link is displayed (user is logged out). */
    public boolean isLoggedOut() {
        return driver.findElement(loginLink).isDisplayed();
    }
}
