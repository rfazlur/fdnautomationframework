package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OnBoardingScreen extends ScreenBase{

    public OnBoardingScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void tapButton(String menu){
        if (isElementPresentByXpath(Constants.ONBOARDING_HEADER_TEXT, 10))
            if (menu.equals("login")){
                tapViewWithId(Constants.ONBOARDING_LOGIN_BUTTON);
            } else if (menu.equals("signup")){
                tapViewWithId(Constants.ONBOARDING_SIGNUP_BUTTON);
            }
    }
}
