package com.femaledaily.testcases;

import com.femaledaily.base.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginUsingUsername(){
        femaleDaily.onBoardingScreen().tapButton("login");
        femaleDaily.loginScreen().doLogin("username");
    }

    @Test
    public void loginUsingEmail(){
        femaleDaily.onBoardingScreen().tapButton("login");
        femaleDaily.loginScreen().doLogin("email");
    }

}
