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
    private WebElement txtHeader;
    @AndroidFindBy(id = Constants.LOGINFORM_USERNAME_FIELD)
    private WebElement txtUsername;
    @AndroidFindBy(id = Constants.LOGINFORM_PASSWORD_FIELD)
    private WebElement txtPassword;
    @AndroidFindBy(id = Constants.LOGINFORM_LOGIN_BUTTON)
    private WebElement btnLogin;

    public LoginScreen validateHeaderText(){
        Assert.assertEquals("Welcome to Female Daily", txtHeader.getText());
        return this;
    }

    public LoginScreen doLogin(String type){
        if (type.equals("username")){
            txtUsername.sendKeys(Constants.VALID_USERNAME);
            txtPassword.sendKeys(Constants.VALID_PASSWORD);
            btnLogin.click();
        } else if (type.equals("email")){
            txtUsername.sendKeys(Constants.VALID_EMAIL);
            txtPassword.sendKeys(Constants.VALID_PASSWORD);
            btnLogin.click();
        }
        return this;
    }
}
