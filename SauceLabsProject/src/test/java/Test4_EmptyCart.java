import Pages.CartPage;
import Pages.LoginPage;
import Pages.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test4_EmptyCart {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException
    {
        driver= new Setup(driver).setupDeviceInNativeAppium();
    }
    @Test
    public void emptyCart() throws InterruptedException {
        new LoginPage(driver).performLogin("standard_user","secret_sauce")
                .addProductToCart()
                .goToCartPage()
                .removeItem();
        Assert.assertEquals(new CartPage(driver).itemsPresent(),"notPresent");
    }

    @AfterMethod
    public void EndSetup(){
        new Setup(driver).EndSetup();
    }

}
