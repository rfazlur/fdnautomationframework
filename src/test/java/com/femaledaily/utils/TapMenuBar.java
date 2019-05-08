package com.femaledaily.utils;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TapMenuBar extends ScreenBase {

    public TapMenuBar(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void tapMenu(String menu){
        switch (menu){
            case "home":
                tapViewWithId(Constants.TAB_BAR_HOME);
                break;
            case "feed":
                tapViewWithId(Constants.TAB_BAR_FEED);
                break;
            case "plus":
                tapViewWithId(Constants.TAB_BAR_PLUS);
                break;
            case "discover":
                tapViewWithId(Constants.TAB_BAR_DISCOVER);
                break;
            case "profile":
                tapViewWithId(Constants.TAB_BAR_PROFILE);
                break;
        }
    }
}
