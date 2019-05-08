package com.femaledaily.base;

import com.femaledaily.screens.LoginScreen;
import com.femaledaily.screens.OnBoardingScreen;
import com.femaledaily.screens.PlusMenuScreen;
import com.femaledaily.screens.SignUpScreen;
import com.femaledaily.utils.TapMenuBar;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FemaleDaily {
    private AndroidDriver<AndroidElement> driver;

    public FemaleDaily(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
    }

    public OnBoardingScreen onBoardingScreen(){
        return new OnBoardingScreen(driver);
    }

    public LoginScreen loginScreen(){
        return new LoginScreen(driver);
    }

    public SignUpScreen signUpScreen(){
        return new SignUpScreen(driver);
    }

    public TapMenuBar tapMenuBar(){
        return new TapMenuBar(driver);
    }

    public PlusMenuScreen plusMenuScreen(){
        return new PlusMenuScreen(driver);
    }
}
