package com.femaledaily.testcases;

import com.femaledaily.base.TestBase;
import com.femaledaily.screens.HomeScreen;
import com.femaledaily.screens.LoginScreen;
import com.femaledaily.screens.OnBoardingScreen;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginUsingUsername(){
        onBoardingScreen = new OnBoardingScreen(driver);
        loginScreen = new LoginScreen(driver);
        homeScreen = new HomeScreen(driver);
        onBoardingScreen.validateHeaderText();
        onBoardingScreen.tapBtnLogin();
        loginScreen.validateHeaderText();
        loginScreen.doLogin();
        homeScreen.waitForHeaderText();
    }

}
