package com.femaledaily.testcases;

import com.femaledaily.base.TestBase;
import com.femaledaily.screens.OnBoardingScreen;
import com.femaledaily.screens.SignUpScreen;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {

    @Test
    public void registerNewUser(){
        onBoardingScreen = new OnBoardingScreen(driver);
        signUpScreen = new SignUpScreen(driver);
        faker = new Faker();
        onBoardingScreen.validateHeaderText();
        onBoardingScreen.tapBtnSignUp();
        signUpScreen.verifyHeaderText();
        signUpScreen.doRegister(
                faker.internet().safeEmailAddress(),
                faker.internet().slug(),
                faker.internet().password(6, 10));
    }

}
