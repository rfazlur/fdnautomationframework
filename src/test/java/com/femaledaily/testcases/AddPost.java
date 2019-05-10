package com.femaledaily.testcases;

import com.femaledaily.base.TestBase;
import org.testng.annotations.Test;

public class AddPost extends TestBase {

    @Test
    public void addPostImageOnly(){
        femaleDaily.onBoardingScreen().tapButton("login");
        femaleDaily.loginScreen().doLogin("username");
        femaleDaily.tapMenuBar().tapMenu("plus");
        femaleDaily.plusMenuScreen().doAddPost("imageonly");
    }

    @Test
    public void addPostTagProduct(){
        femaleDaily.onBoardingScreen().tapButton("login");
        femaleDaily.loginScreen().doLogin("username");
        femaleDaily.tapMenuBar().tapMenu("plus");
        femaleDaily.plusMenuScreen().doAddPost("tagproduct");
    }

    @Test
    public void addPostWithReview(){
        femaleDaily.onBoardingScreen().tapButton("login");
        femaleDaily.loginScreen().doLogin("username");
        femaleDaily.tapMenuBar().tapMenu("plus");
        femaleDaily.plusMenuScreen().doAddPost("withreview");
    }

}
