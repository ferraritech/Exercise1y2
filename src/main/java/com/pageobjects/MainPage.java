package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement btnMyAccount;

    @FindBy(xpath = "//a[contains(.,'Login')]")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[contains(.,'Register')]")
    private WebElement btnRegister;

    @FindBy(xpath = "//ul[contains(@class,'dropdown')]//a[contains(.,'My Account')]")
    private WebElement btnMyAccountSub;

    @FindBy(xpath = "//a[contains(.,'Logout')]")
    private WebElement btnLogout;

    public final String url= "https://demo.opencart.com";

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrl(){
        return url;
    }

    public void clickOnRegister(){
        btnMyAccount.click();
        btnRegister.click();
    }

    public void clicOnLogin(){
        btnMyAccount.click();
        btnLogin.click();
    }

    public void goToMyAccount(){
    btnMyAccount.click();
    btnMyAccountSub.click();
    }

    public void logout(){
        btnMyAccount.click();
        btnLogout.click();
    }
}
