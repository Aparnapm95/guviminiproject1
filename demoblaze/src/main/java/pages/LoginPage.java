package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 WebDriver driver;

	    // Locators
	    private By loginLink = By.id("login2");
	    private By usernameField = By.id("loginusername");
	    private By passwordField = By.id("loginpassword");
	    private By loginButton = By.xpath("//button[text()='Log in']");
	    private By loggedUserLabel = By.id("nameofuser");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void openLoginModal() {
	        driver.findElement(loginLink).click();
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLoginButton() {
	        driver.findElement(loginButton).click();
	    }

	    public void login(String username, String password) {
	        openLoginModal();
	        try {
	            Thread.sleep(1000); // Wait for modal to appear
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        enterUsername(username);
	        enterPassword(password);
	        clickLoginButton();
	    }

	    public boolean isUserLoggedIn() {
	        try {
	            Thread.sleep(2000); // Wait for login to complete
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return driver.findElement(loggedUserLabel).isDisplayed();
	    }

}
