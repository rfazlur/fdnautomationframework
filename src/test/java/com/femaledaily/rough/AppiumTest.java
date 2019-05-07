package com.femaledaily.rough;

import com.femaledaily.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest {

    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder().usingDriverExecutable(new File("/home/faiz/.nvm/versions" +
                        "/node/v11.8.0/bin/node"))
                .withAppiumJS(new File("/home/faiz/.nvm/versions/node/v11.8.0/bin/appium"))
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(System.getProperty("user.dir")+"/src/test/resources/appiumlog/Appium.log")));
        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/src/test/resources/app/app-debug.apk");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.fdbr.android.debug:id/buttonLogin").click();
        driver.quit();
        service.stop();
    }

}


