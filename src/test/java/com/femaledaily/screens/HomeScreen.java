package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends ScreenBase {

    private WebDriverWait wait;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public HomeScreen waitForHeaderText(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.HOME_HEADER_TEXT)));
        return this;
    }
}
