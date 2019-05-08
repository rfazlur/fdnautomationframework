package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PlusMenuScreen extends ScreenBase {

    public PlusMenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = Constants.ADDPOSTFORM_CAPTION_FIELD)
    private AndroidElement txtCaption;

    private void setCaption(String caption){
        txtCaption.setValue(caption);
    }

    private void checkOnPopUpDialog(){
        if (isElementPresentById(Constants.POP_UP_DIALOG, 10))
            tapViewWithId(Constants.POP_UP_DIALOG_ALLOW);
    }

    public void doAddPost(String type){
        faker = new Faker();
        if (type.equals("imageonly")){
            if (isElementPresentById(Constants.PLUS_MENU_ADDPOST, 10))
                tapViewWithId(Constants.PLUS_MENU_ADDPOST);
            checkOnPopUpDialog();
            checkOnPopUpDialog();
            tapViewWithId(Constants.CAPTURE_BUTTON);
            if (isElementPresentById(Constants.CAPTURE_NEXT_BUTTON, 10))
                tapViewWithId(Constants.CAPTURE_NEXT_BUTTON);
            setCaption(faker.lorem().sentence(10));
            if (isElementPresentById(Constants.ADDPOSTFORM_NEXT_BUTTON, 10))
                tapViewWithId(Constants.ADDPOSTFORM_NEXT_BUTTON);
            isElementPresentByXpath(Constants.TITLE_TOOLBAR_FEED, 10);
        }
    }
}
