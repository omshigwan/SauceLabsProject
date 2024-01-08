package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    private By titleShown = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");
    private By priceShown = By.xpath("//android.widget.TextView[@text=\"$29.99\"]");
    private By itemsInCart = AppiumBy.accessibilityId("test-Item");
    private By removeButton = AppiumBy.accessibilityId("test-REMOVE");
    private By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");

    public CartPage removeItem() throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(removeButton).getAttribute("clickable").equals("true"));
        driver.findElement(removeButton).click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }
    public CheckoutInformationPage pressCheckout(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(checkoutButton));
        driver.findElement(checkoutButton).click();
        return new CheckoutInformationPage(driver);
    }
    public String productName(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(titleShown));
        return driver.findElement(titleShown).getText();
    }
    public String productPrice(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(priceShown));
        return driver.findElement(priceShown).getText();
    }
    public String itemsPresent() {

        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(d -> driver.findElement(itemsInCart));
            return "present";
        } catch (org.openqa.selenium.TimeoutException e) {
            return "notPresent";
        }
    }

}
