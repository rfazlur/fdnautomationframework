package com.femaledaily.base;

import com.femaledaily.utils.AppiumServer;
import com.femaledaily.utils.CommonUtils;
import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

    public static AndroidDriver driver;
    public static String loadPropertyFile = "android.properties";
    protected static FemaleDaily femaleDaily;

    @BeforeSuite
    public void setUp() throws IOException {
        if (driver==null){
            AppiumServer.stop();
            AppiumServer.start();
            CommonUtils.loadAndroidConfigProp(loadPropertyFile);
            CommonUtils.setAndroidCapabilities();
            driver = CommonUtils.getAndroidDriver();
            femaleDaily = new FemaleDaily(driver);
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        AppiumServer.stop();
    }

}
