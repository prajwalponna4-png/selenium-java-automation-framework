package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	By removeBtn = By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']");
	By checkoutBtn = By.id("checkout");

	public void removeItem() {
		driver.findElement(removeBtn).click();
	}

	public void clickCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='checkout']"))).click();
	}
}