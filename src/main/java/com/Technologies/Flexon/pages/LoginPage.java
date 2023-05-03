package com.Technologies.Flexon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {


    WebDriver driver;
    @FindBy(xpath="//button[@class=\"Button_button__URNp+ Button_primary__d2Jt3 Button_fullwidth__0HLEu\"]")
    WebElement loginButton;



    @FindBy(xpath="//div[@class=\"Alert_wrapper__Aj7U+\"]")
    WebElement alert;

    @FindBy(id="modalusername")
    WebElement emailInput;

    @FindBy(id="current-password")
    WebElement passwordInput;




    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    public void setEmail(String email)
    {
        emailInput.clear();
        emailInput.sendKeys(email);

    }

    public void setPassword(String password)
    {
        passwordInput.clear();
        passwordInput.sendKeys(password);

    }

    public void clickLogin()
    {
        loginButton.click();

    }

    public boolean notValid()
    {
        return alert.isDisplayed();
    }







}
