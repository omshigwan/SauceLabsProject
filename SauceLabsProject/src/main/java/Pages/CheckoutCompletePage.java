package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    WebDriver driver;
    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
    }

    private By orderCompleteFlag = By.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]");
    public WebElement orederComplete (){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(orderCompleteFlag));
        return driver.findElement(orderCompleteFlag);
    }
}
