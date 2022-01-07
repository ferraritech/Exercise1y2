package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpFormPage {
    private final WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    private WebElement inputLastName;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-telephone")
    private WebElement inputPhone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id="input-confirm")
    private WebElement inputPasswordConfirm;

    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    private WebElement chkPrivacy;

    @FindBy(xpath="//input[@value='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//div[@class='text-danger' and contains(.,'Password confirmation does not match password!')]")
    private WebElement lblErrorMismatchPassword;

    @FindBy(xpath = "//div[@class='text-danger' and contains(.,'E-Mail Address does not appear to be valid!')]")
    private WebElement lblErrorWrongEmail;

    @FindBy(className = "text-danger")
    private WebElement lblErrorGeneral;

    public SignUpFormPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public boolean lblErrorGeneralIsDisplayed(){
        return lblErrorGeneral.isDisplayed();
    }

    public boolean lblErrorWrongEmailIsDisplayed(){
        return lblErrorWrongEmail.isDisplayed();
    }

    public boolean lblErrorMismatchPasswordIsDisplayed(){
        return lblErrorMismatchPassword.isDisplayed();
    }

    public void fillForm(String firstName, String lastName, String email, String phone, String password, String passwordConfirm){
        if(firstName!=null){
            inputFirstName.sendKeys(firstName);
        }

        if(lastName!=null){
            inputLastName.sendKeys(lastName);
        }

        if(email!=null){
            inputEmail.sendKeys(email);
        }

        if(phone!=null){
            inputPhone.sendKeys(phone);
        }

        if(password!=null){
            inputPassword.sendKeys(password);
        }

        if(passwordConfirm!=null){
            inputPasswordConfirm.sendKeys(passwordConfirm);
        }

        chkPrivacy.click();

        btnContinue.click();
    }

}
