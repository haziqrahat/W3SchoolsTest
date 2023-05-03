package com.Technologies.Flexon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;

    @FindBy(id="w3loginbtn")
    WebElement loginMenu;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void navigateToLoginPage() {

        loginMenu.click();

    }
}
