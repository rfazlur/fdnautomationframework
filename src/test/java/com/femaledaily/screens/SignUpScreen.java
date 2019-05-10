package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpScreen extends ScreenBase {

    private Faker faker;

    public SignUpScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = Constants.SIGNUPFORM_EMAIL_FIELD)
    private AndroidElement txtEmail;
    @AndroidFindBy(id = Constants.SIGNUPFORM_USERNAME_FIELD)
    private AndroidElement txtUsername;
    @AndroidFindBy(id = Constants.SIGNUPFORM_PASSWORD_FIELD)
    private AndroidElement txtPassword;

    private void setEmail(String email){
        txtEmail.setValue(email);
    }

    private void setUsername(String username){
        txtUsername.setValue(username);
    }

    private void setPassword(String password){
        txtPassword.setValue(password);
    }

    public void doRegister(){
        faker = new Faker();
        if (isElementPresentByXpath(Constants.SIGNUPFORM_HEADER_TEXT, 10)){
            setEmail(faker.internet().safeEmailAddress());
            setUsername(faker.internet().slug());
            setPassword(faker.internet().password(6,10));
            tapViewWithId(Constants.SIGNUPFORM_SIGNUP_BUTTON);
        }

    }

}
