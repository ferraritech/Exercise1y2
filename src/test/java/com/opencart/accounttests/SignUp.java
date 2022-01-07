package com.opencart.accounttests;

import com.dataprovider.SignUpDataProvider;
import com.opencart.Base;
import com.pageobjects.MainPage;
import com.pageobjects.SignUpFormPage;
import com.pageobjects.SignUpSuccesPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Base {
    private MainPage mainPage;
    private SignUpFormPage signUpPageFormPage;
    private SignUpSuccesPage signUpSuccesPage;

  @BeforeTest
  public void initialize(){
      driver=initializeDriver();
      mainPage= new MainPage(driver);
      signUpPageFormPage = new SignUpFormPage(driver);
  }

  @BeforeMethod
    public void beforeMethod(){
      driver.get(mainPage.getUrl());
      mainPage.clickOnRegister();
  }

  @Test(dataProvider = "valid data",dataProviderClass = SignUpDataProvider.class)
    public void testUserRegistrationValidData(String firstName, String lastName, String email, String phone, String password, String passwordConfirm){
      signUpSuccesPage = new SignUpSuccesPage(driver);
      signUpPageFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirm);
      Assert.assertTrue(signUpSuccesPage.lblSuccesIsDisplayed());
  }

  @Test(dataProvider = "missing fields",dataProviderClass = SignUpDataProvider.class)
  public void testUserRegistrationMissingField(String firstName, String lastName, String email, String phone, String password, String passwordConfirm){
      signUpPageFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirm);
      Assert.assertTrue(signUpPageFormPage.lblErrorGeneralIsDisplayed());
  }

  @Test(dataProvider = "email missing at",dataProviderClass = SignUpDataProvider.class)
  public void testUserRegistrationInvalidEmailMissingAt(String firstName, String lastName, String email, String phone, String password, String passwordConfirm){
      signUpPageFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirm);
      //Message displayed : Missing @
  }

  @Test(dataProvider = "email missing dot com",dataProviderClass = SignUpDataProvider.class)
  public void testUserRegistrationInvalidEmailMissingDotCom(String firstName, String lastName, String email, String phone, String password, String passwordConfirm){
      signUpPageFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirm);
      Assert.assertTrue(signUpPageFormPage.lblErrorWrongEmailIsDisplayed());
  }

  @Test(dataProvider = "different passwords",dataProviderClass = SignUpDataProvider.class)
  public void testUserRegistrationDifferentPasswords(String firstName, String lastName, String email, String phone, String password, String passwordConfirm){
      signUpPageFormPage.fillForm(firstName,lastName,email,phone,password,passwordConfirm);
      Assert.assertTrue(signUpPageFormPage.lblErrorMismatchPasswordIsDisplayed());
  }

  @AfterTest
    public void closeDriver(){
      driver.quit();
  }




}
