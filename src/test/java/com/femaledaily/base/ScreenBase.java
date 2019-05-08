package com.femaledaily.base;

import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScreenBase {

    public AndroidDriver<AndroidElement> driver;
    private int maxSwipeCount = 10;
    private PointOption pointOption = new PointOption();
    private WaitOptions waitOptions = new WaitOptions();
    public Faker faker;

    public ScreenBase(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isElementPresentById(String id, int timeOut) {
        By by = By.id(id);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresentByXpath(String id, int timeOut) {
        By by = By.xpath(id);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void tapViewWithId(String id) {
        findElementWithId(id).click();
    }

    private AndroidElement findElementWithId(String id) {

        AndroidElement element = null;
        for (int i = 0; i < maxSwipeCount; i++) {
            try {
                element = driver.findElementById(id);
                if (isElementPresent(element)) break;
            } catch (NoSuchElementException e) {
                swipeUp();
            }
        }
        return element;
    }

    public boolean isElementPresent(AndroidElement androidElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOf(androidElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void swipeUp() {

        Dimension size = driver.manage().window().getSize();
        TouchAction touchAction = new TouchAction(driver);

        int y0 = (int) (size.height * 0.7);
        int y1 = (int) (size.height * 0.3);
        int x = (size.width / 2);

        touchAction
                .press(pointOption.withCoordinates(x, y0))
                .waitAction(waitOptions.withDuration(Duration.ofMillis(1250)))
                .moveTo(pointOption.withCoordinates(x, y1))
                .release()
                .perform();
    }

}
