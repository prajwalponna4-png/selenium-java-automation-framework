package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ExtentManager;

public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	By addToCart = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	By cartIcon = By.xpath("//a[@class='shopping_cart_link']");

	public void addItemToCart() {
		driver.findElement(addToCart).click();
		ExtentManager.log("Item added to cart");
	}

	public void goToCart() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement element = driver.findElement(cartIcon);

	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	    element.click();
	}
}