package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class OnBoardingScreen extends ScreenBase{

    public OnBoardingScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = Constants.ONBOARDING_HEADER_TEXT)
    public WebElement txtHeader;
    @AndroidFindBy(id = Constants.ONBOARDING_LOGIN_BUTTON)
    public WebElement btnLogin;

    public OnBoardingScreen validateHeaderText(){
        Assert.assertEquals("Your beauty journey starts here", txtHeader.getText());
        return this;
    }

    public OnBoardingScreen tapBtnLogin(){
        btnLogin.click();
        return this;
    }
}
