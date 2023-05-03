package com.Technologies.Flexon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    WebDriver driver;
    @FindBy(tagName="body")
    WebElement body;

    public DashBoardPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public boolean isDisplayed()
    {
        return body.isDisplayed();
    }


}
