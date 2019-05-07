package com.femaledaily.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonUtils {

    private static Properties prop = new Properties();
    public static int IMPLICIT_WAIT_TIME;
    public static String APPIUM_PORT;
    public static String APP;
    public static String UDID;
    public static String AUTOMATION_INSTRUMENTATION;
    public static String PLATFORM_NAME;
    public static String DEVICE_NAME;
    public static String PLATFORM_VERSION;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static URL serverUrl;
    private static AndroidDriver driver;

    public static void loadAndroidConfigProp(String propertyFileName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                +"/src/test/resources/properties/"+propertyFileName);
        prop.load(fis);
        IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
        APPIUM_PORT = prop.getProperty("appium.server.port");
        APP = prop.getProperty("application.app");
        UDID = prop.getProperty("udid");
        AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instrumentation");
        PLATFORM_NAME = prop.getProperty("platform.name");
        DEVICE_NAME = prop.getProperty("device.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");
    }

    public static void setAndroidCapabilities(){
        capabilities.setCapability(MobileCapabilityType.APP, CommonUtils.APP);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CommonUtils.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CommonUtils.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, CommonUtils.AUTOMATION_INSTRUMENTATION);
    }

    public static AndroidDriver getAndroidDriver() throws MalformedURLException {
        serverUrl = new URL("http://127.0.0.1:" + APPIUM_PORT + "/wd/hub");
        driver = new AndroidDriver(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
