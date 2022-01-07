package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpSuccesPage {
    private final WebDriver driver;

    @FindBy(xpath="//h1[contains(.,'Your Account Has Been Created!')]")
    private WebElement lblSuccess;

    public SignUpSuccesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean lblSuccesIsDisplayed(){
        return lblSuccess.isDisplayed();
    }
}
