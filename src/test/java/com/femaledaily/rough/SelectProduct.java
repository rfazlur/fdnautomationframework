package com.femaledaily.rough;

import com.femaledaily.base.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectProduct {

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

        driver.findElementById(Constants.ONBOARDING_LOGIN_BUTTON).click();
        driver.findElementById(Constants.LOGINFORM_USERNAME_FIELD).sendKeys(Constants.VALID_CREDENTIALS[0]);
        driver.findElementById(Constants.LOGINFORM_PASSWORD_FIELD).sendKeys(Constants.VALID_CREDENTIALS[1]);
        driver.findElementById(Constants.LOGINFORM_LOGIN_BUTTON).click();
        driver.findElementById(Constants.TAB_BAR_PLUS).click();
        driver.findElementById(Constants.PLUS_MENU_ADDPOST).click();
        driver.findElementById(Constants.POP_UP_DIALOG_ALLOW).click();
        driver.findElementById(Constants.POP_UP_DIALOG_ALLOW).click();
        driver.findElementById(Constants.CAPTURE_BUTTON).click();
        driver.findElementById(Constants.CAPTURE_NEXT_BUTTON).click();
        driver.findElementById("com.fdbr.android.debug:id/labelTagProducts").click();
        List el = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.fdbr.android.debug:id/layoutParent']"));
        System.out.println("total element : "+el.size());

        service.stop();
    }

}
