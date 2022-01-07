package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsletterPage {
    private final WebDriver driver;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> rblList;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;

    public NewsletterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void changeNeswletter(){
        if(rblList.get(0).isSelected()){
            rblList.get(1).click();
        }else if(rblList.get(1).isSelected()){
            rblList.get(0).click();
        }
        btnContinue.click();
    }
}
