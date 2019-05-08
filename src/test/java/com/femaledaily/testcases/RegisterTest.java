package com.femaledaily.testcases;

import com.femaledaily.base.TestBase;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {

    @Test
    public void registerUser(){
        femaleDaily.onBoardingScreen().tapButton("signup");
        femaleDaily.signUpScreen().doRegister();
    }

}
