package stepDefinition;

import com.Technologies.Flexon.ConfigurationW3;
import com.Technologies.Flexon.DriverFactory;
import com.Technologies.Flexon.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected String browser= ConfigurationW3.BROWSER;
    protected WebDriver driver;
    protected HomePage homePage;


    public void createPageObject(WebDriver driver)
    {
        homePage=new HomePage(driver);
    }

    @BeforeClass
    public void setup()
    {
        //launch driver
        System.out.print("Setting up driver ***");
        driver= DriverFactory.getDriver(browser);

        Assert.assertNotNull(driver);

        System.out.println("Opening the browser ***");

        //navigate to homepage
        driver.get(ConfigurationW3.URL);
        homePage=new HomePage(driver);

        //setup timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigurationW3.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigurationW3.PAGE_WAIT));



    }

    @BeforeClass
    public void close()
    {

        System.out.println("Closing the browser ***");
        driver.quit();

    }
}
