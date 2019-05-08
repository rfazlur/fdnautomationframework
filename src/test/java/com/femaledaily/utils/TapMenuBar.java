package com.femaledaily.utils;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TapMenuBar extends ScreenBase {

    public TapMenuBar(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = Constants.TAB_BAR_HOME)
    private WebElement btnHome;
    @AndroidFindBy(id = Constants.TAB_BAR_FEED)
    private WebElement btnFeed;
    @AndroidFindBy(id = Constants.TAB_BAR_PLUS)
    private WebElement btnPlus;
    @AndroidFindBy(id = Constants.TAB_BAR_DISCOVER)
    private WebElement btnDiscover;
    @AndroidFindBy(id = Constants.TAB_BAR_PROFILE)
    private WebElement btnProfile;

    public TapMenuBar tapMainMenu(String type){
        switch (type){
            case "home":
                btnHome.click();
                break;
            case "feed":
                btnFeed.click();
                break;
            case "plus":
                btnPlus.click();
                break;
            case "discover":
                btnDiscover.click();
                break;
            case "profile":
                btnProfile.click();
                break;
        }
        return this;
    }
}
