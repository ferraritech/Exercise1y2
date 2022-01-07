package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private final WebDriver driver;

    @FindBy(linkText = "Your Store")
    private WebElement lblYourStore;

    @FindBy(linkText = "Edit your account information")
    private WebElement linkEditAccount;

    @FindBy(linkText = "Change your password")
    private WebElement linkChangePassword;

    @FindBy(linkText = "Modify your address book entries")
    private WebElement linkModifyAddressBook;

    @FindBy(linkText = "Modify your wish list")
    private WebElement linkModifyWishList;

    @FindBy(linkText = "View your order history")
    private WebElement linkOrderHistory;

    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    private WebElement linkNewsletter;

    @FindBy(xpath = "//div[contains(@class,'alert-success') and contains(.,' Success: Your account has been successfully updated.')]")
    private WebElement lblSuccesEdit;

    @FindBy(xpath = "//div[contains(@class,'alert-success') and contains(.,' Success: Your newsletter subscription has been successfully updated!')]")
    private WebElement lblSuccesNewsLetter;


    public MyAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnWishList(){
        linkModifyWishList.click();
    }

    public void clickOnOrderHistory(){
        linkOrderHistory.click();
    }

    public void clickOnNesletter(){
        linkNewsletter.click();
    }

    public void clickOnEditInformation(){
        linkEditAccount.click();
    }

    public boolean lblYourStoreIsDisplayed(){
        return lblYourStore.isDisplayed();
    }
    public boolean linkEditAccountIsDisplayed(){
        return linkEditAccount.isDisplayed();
    }
    public boolean linkChangePasswordIsDisplayed(){
        return linkChangePassword.isDisplayed();
    }
    public boolean linkModifyAdressBookIsDisplayed(){
        return linkModifyAddressBook.isDisplayed();
    }
    public boolean linkModifyWishlistIsDisplayed(){
        return linkModifyWishList.isDisplayed();
    }

    public boolean lblSuccesEditIsDisplayed(){
        return lblSuccesEdit.isDisplayed();
    }

    public boolean lblSuccessNewsLetterIsDisplayed(){
        return lblSuccesNewsLetter.isDisplayed();
    }
}
