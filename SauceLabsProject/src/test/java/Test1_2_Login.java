import Pages.HomePage;
import Pages.LoginPage;
import Pages.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test1_2_Login {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException
    {
        driver= new Setup(driver).setupDeviceInNativeAppium();
    }

    @Test(priority = 0)
    public void invalidLogin(){
        new LoginPage(driver).performInvalidLogin("locked_out_user","secret_sauce");
        Assert.assertTrue(new LoginPage(driver).errorMsg().isDisplayed());
    }

    @Test(priority = 1)
    public void validLogin() {
        new LoginPage(driver).performLogin("standard_user", "secret_sauce");
        Assert.assertTrue(new HomePage(driver).products().isDisplayed());
    }

    @AfterMethod
    public void EndSetup() {
        new Setup(driver).EndSetup();
    }

}
