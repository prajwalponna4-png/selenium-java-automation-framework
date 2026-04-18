package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ExtentManager;
import utils.LoggerUtil;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By loginBtn = By.xpath("//input[@id='login-button']");

    public void login(String user, String pass) {
        LoggerUtil.log.info("Logging in");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
        ExtentManager.log("Login successful");
    }
}