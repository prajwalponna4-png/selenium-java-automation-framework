package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExtentManager;

public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By firstName = By.xpath("//input[@id='first-name']");
	By lastName = By.xpath("//input[@id='last-name']");
	By postalCode = By.xpath("//input[@id='postal-code']");
	By continueBtn = By.xpath("//input[@id='continue']");
	By finishBtn = By.xpath("//button[@id='finish']");

	public void enterDetails(String fName, String lName, String zip) {
		driver.findElement(firstName).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(postalCode).sendKeys(zip);
	}

	public void completeCheckout() {
		driver.findElement(continueBtn).click();
		driver.findElement(finishBtn).click();
		ExtentManager.log("Order Placed,Thank you for your order!");

	}

	public String getConfirmationMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))).getText();
	}
}