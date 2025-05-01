package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	 private WebDriver driver;

	    // Locator for category header on page
	    private By categoryHeader = By.cssSelector("h2.name");

	    // Locator for all product name links
	    private By productNames = By.cssSelector(".card-title a");

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    /** Clicks on a category in the left side bar by visible text. */
	    public void selectCategory(String category) {
	        By locator = By.xpath(String.format("//a[text()='%s']", category));
	        driver.findElement(locator).click();
	        // brief wait for products to load
	        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
	    }

	    /** Returns the displayed category header text (e.g. "Phones"). */
	    public String getCategoryHeader() {
	        return driver.findElement(categoryHeader).getText();
	    }

	    /** Returns a list of all product names currently visible. */
	    public List<String> getAllProductNames() {
	        List<WebElement> elems = driver.findElements(productNames);
	        return elems.stream()
	                    .map(WebElement::getText)
	                    .collect(Collectors.toList());
	    }
}
