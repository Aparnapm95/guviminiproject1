package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
	WebDriver driver;

    // Locators
    private By signupLink = By.id("signin2");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signupButton = By.xpath("//button[text()='Sign up']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSignupModal() {
        driver.findElement(signupLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public void register(String username, String password) {
        openSignupModal();
        try {
            Thread.sleep(1000); // Wait for modal to appear
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterUsername(username);
        enterPassword(password);
        clickSignupButton();
    }
}
