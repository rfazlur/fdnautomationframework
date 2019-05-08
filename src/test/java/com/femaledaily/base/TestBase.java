package com.femaledaily.base;

import com.femaledaily.screens.HomeScreen;
import com.femaledaily.screens.LoginScreen;
import com.femaledaily.screens.OnBoardingScreen;
import com.femaledaily.screens.SignUpScreen;
import com.femaledaily.utils.AppiumServer;
import com.femaledaily.utils.CommonUtils;
import com.femaledaily.utils.TapMenuBar;
import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

    public static AndroidDriver driver;
    public static String loadPropertyFile = "android.properties";
    public OnBoardingScreen onBoardingScreen;
    public LoginScreen loginScreen;
    public HomeScreen homeScreen;
    public SignUpScreen signUpScreen;
    public TapMenuBar tapMenuBar;
    public Faker faker;

    @BeforeSuite
    public void setUp() throws IOException {
        if (driver==null){
            AppiumServer.stop();
            AppiumServer.start();
            CommonUtils.loadAndroidConfigProp(loadPropertyFile);
            CommonUtils.setAndroidCapabilities();
            driver = CommonUtils.getAndroidDriver();
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        AppiumServer.stop();
    }

}
