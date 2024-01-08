package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By usernameInput = AppiumBy.accessibilityId("test-Username");
    private By passwordInput = AppiumBy.accessibilityId("test-Password");
    private By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    private By errorMessage = AppiumBy.accessibilityId("test-Error message");

    public HomePage performLogin(String username,String password){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(usernameInput));
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement( passwordInput).sendKeys(password);
        driver.findElement( loginButton).click();
        return new HomePage(driver);
    }

    public LoginPage performInvalidLogin(String username,String password){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(usernameInput));
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement( passwordInput).sendKeys(password);
        driver.findElement( loginButton).click();
        return new LoginPage(driver);
    }
    public WebElement errorMsg()
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(errorMessage));
        return driver.findElement(errorMessage);
    }
}
