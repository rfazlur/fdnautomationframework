package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginScreen extends ScreenBase {

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = Constants.LOGINFORM_HEADER_TEXT)
    public WebElement txtHeader;
    @AndroidFindBy(id = Constants.LOGINFORM_USERNAME_FIELD)
    public WebElement txtUsername;
    @AndroidFindBy(id = Constants.LOGINFORM_PASSWORD_FIELD)
    public WebElement txtPassword;
    @AndroidFindBy(id = Constants.LOGINFORM_LOGIN_BUTTON)
    public WebElement btnLogin;

    public LoginScreen validateHeaderText(){
        Assert.assertEquals("Welcome to Female Daily", txtHeader.getText());
        return this;
    }

    public LoginScreen doLogin(){
        txtUsername.sendKeys(Constants.VALID_USERNAME);
        txtPassword.sendKeys(Constants.VALID_PASSWORD);
        btnLogin.click();
        return this;
    }
}
