package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends ScreenBase {

    public LoginScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = Constants.LOGINFORM_USERNAME_FIELD)
    private AndroidElement txtUsername;
    @AndroidFindBy(id = Constants.LOGINFORM_PASSWORD_FIELD)
    private AndroidElement txtPassword;

    private void setUsername(String username){
        txtUsername.setValue(username);
    }

    private void setPassword(String password){
        txtPassword.setValue(password);
    }

    public void doLogin(String type){
        if (isElementPresentByXpath(Constants.LOGINFORM_HEADER_TEXT, 10))
            if (type.equals("username")){
                setUsername(Constants.VALID_CREDENTIALS[0]);
                setPassword(Constants.VALID_CREDENTIALS[1]);
                tapViewWithId(Constants.LOGINFORM_LOGIN_BUTTON);
                isElementPresentById(Constants.HOME_LABEL_HELLO, 10);
            } else if (type.equals("email")){
                setUsername(Constants.VALID_CREDENTIALS[2]);
                setPassword(Constants.VALID_CREDENTIALS[1]);
                tapViewWithId(Constants.LOGINFORM_LOGIN_BUTTON);
                isElementPresentById(Constants.HOME_LABEL_HELLO, 10);
            }
    }

}
