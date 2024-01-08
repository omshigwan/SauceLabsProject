package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInformationPage {
    WebDriver driver;
    public CheckoutInformationPage(WebDriver driver){
        this.driver = driver;
    }
    private By firstNameSection = AppiumBy.accessibilityId("test-First Name");
    private By lastNameSection = AppiumBy.accessibilityId("test-Last Name");
    private By zipcodeSection = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    public CheckoutOverviewPage enterInformation(String firstName,String lastName,String zipCode){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> driver.findElement(firstNameSection));
        driver.findElement(firstNameSection).sendKeys(firstName);
        driver.findElement(lastNameSection).sendKeys(lastName);
        driver.findElement(zipcodeSection).sendKeys(zipCode);
        driver.findElement(continueButton).click();
        return new CheckoutOverviewPage(driver);
    }
}
