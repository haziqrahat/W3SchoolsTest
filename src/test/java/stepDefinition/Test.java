package stepDefinition;

import com.Technologies.Flexon.ConfigurationW3;
import com.Technologies.Flexon.DriverFactory;
import com.Technologies.Flexon.pages.DashBoardPage;
import com.Technologies.Flexon.pages.HomePage;
import com.Technologies.Flexon.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.DataTable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class Test extends BaseTest {

    protected String browser = ConfigurationW3.BROWSER;
    protected WebDriver driver;
    protected HomePage homePage;

    protected DashBoardPage dashBoardPage;

    protected LoginPage loginPage;

    protected DataTable table;

    public void createPageObject(WebDriver driver) {
        homePage = new HomePage(driver);
    }

    @Before
    public void setup() {
        //launch driver
        System.out.print("Setting up driver ***");
        driver = DriverFactory.getDriver(browser);

        Assert.assertNotNull(driver);

        System.out.println("Opening the browser ***");

        //navigate to homepage
        driver.get(ConfigurationW3.URL);
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();
        pause();

    }

    public void pause() {
        //setup timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigurationW3.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigurationW3.PAGE_WAIT));
    }

    public void takeScreenshots(String path) throws IOException {
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File(path));
    }

    @After
    public void before_or_after(Scenario scenario) throws IOException {

        System.out.println("Closing the browser ***");
        takeScreenshots(scenario.getName()+".jpeg");
        driver.quit();

    }

    @After
    public void close() {

        System.out.println("Closing the browser ***");
        driver.quit();

    }

    @When("the user click on the login page")
    public void the_user_click_on_the_login_page() throws InterruptedException {

    }


    @When("the login page is displayed")
    public void the_login_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        loginPage = new LoginPage(driver);
        pause();
    }

    @When("the user enters the valid credentials")
    public void the_user_enters_the_valid_credentials() {
        // Write code here that turns the phrase above into concrete actions

        loginPage.setEmail("haziqbullah@gmail.com");
        loginPage.setPassword("Hsbullah*123");
        loginPage.clickLogin();
        pause();


    }

    @Then("the user is logged in and the learning page is displayed")
    public void the_user_is_logged_in_and_the_learning_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions

        dashBoardPage = new DashBoardPage(driver);
        Assert.assertTrue(dashBoardPage.isDisplayed());
    }

    @And("the user enters the wrong email but correct password")
    public void theUserEntersTheWrongEmailButCorrectPassword() {

        loginPage.setEmail("haziqbul@gmail.com");
        loginPage.setPassword("Hsbullah*123");
        loginPage.clickLogin();
        pause();

    }

    @Then("the user is not logged in and an error message is displayed")
    public void theUserIsNotLoggedInAndAnErrorMessageIsDisplayed() {

        Assert.assertTrue(loginPage.notValid());

    }

    @And("the user enters the correct email but wrong password")
    public void theUserEntersTheCorrectEmailButWrongPassword() {

        loginPage.setEmail("haagasd");
        loginPage.setPassword("hljag");
        loginPage.clickLogin();
        pause();

    }
}


