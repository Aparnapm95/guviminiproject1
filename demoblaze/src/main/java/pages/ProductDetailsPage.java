package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
	private WebDriver driver;

    // Locators
    private By productTitle = By.cssSelector(".name");
    private By productPrice = By.cssSelector(".price-container");
    private By addToCartButton = By.xpath("//a[text()='Add to cart']");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Gets the product title displayed on the details page. */
    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    /** Gets the product price string (e.g. "$360"). */
    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    /** Clicks the "Add to cart" button. */
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }
}
