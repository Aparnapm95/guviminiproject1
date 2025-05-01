package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	private WebDriver driver;

    // Locators
    private By cartButton = By.id("cartur");
    private By productRows = By.cssSelector(".success");
    private By totalPrice = By.cssSelector("h3#totalp");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Navigates to the cart page */
    public void openCart() {
        driver.findElement(cartButton).click();
    }

    /** Returns a list of product rows in the cart */
    public List<WebElement> getCartItems() {
        return driver.findElements(productRows);
    }

    /** Returns the total price displayed in the cart */
    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

}
