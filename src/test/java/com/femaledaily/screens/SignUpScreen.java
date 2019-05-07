package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends ScreenBase {

    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = Constants.SIGNUPFORM_EMAIL_FIELD)
    private WebElement txtEmail;
    @AndroidFindBy(id = Constants.SIGNUPFORM_USERNAME_FIELD)
    private WebElement txtUsername;
    @AndroidFindBy(id = Constants.SIGNUPFORM_PASSWORD_FIELD)
    private WebElement txtPassword;
    @AndroidFindBy(id = Constants.SIGNUPFORM_SIGNUP_BUTTON)
    private WebElement btnSignUp;
    @AndroidFindBy(xpath = Constants.SIGNUPFORM_HEADER_TEXT)
    private WebElement txtHeader;

    public SignUpScreen verifyHeaderText(){
        Assert.assertEquals("Welcome to Female Daily", txtHeader.getText());
        return this;
    }

    public SignUpScreen doRegister(String email, String username, String password){
        txtEmail.sendKeys(email);
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnSignUp.click();
        return this;
    }

}
