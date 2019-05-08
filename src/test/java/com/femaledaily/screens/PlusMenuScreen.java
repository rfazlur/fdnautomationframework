package com.femaledaily.screens;

import com.femaledaily.base.Constants;
import com.femaledaily.base.ScreenBase;
import com.sun.org.apache.xpath.internal.operations.Plus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PlusMenuScreen extends ScreenBase {

    public PlusMenuScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = Constants.PLUS_MENU_ADDREVIEW)
    private WebElement btnAddReview;
    @AndroidFindBy(id = Constants.PLUS_MENU_ADDPOST)
    private WebElement btnAddPost;
    @AndroidFindBy(id = Constants.PLUS_MENU_ADDPRODUCT)
    private WebElement btnAddProduct;
    @AndroidFindBy(id = Constants.PLUS_MENU_CANCEL)
    private WebElement btnCancel;

    public PlusMenuScreen tapMenu(String menu){
        switch (menu){
            case "addreview":
                btnAddReview.click();
                break;
            case "addpost":
                btnAddPost.click();
                break;
            case "addproduct":
                btnAddProduct.click();
                break;
            case "cancel":
                btnCancel.click();
                break;
        }
        return this;
    }

    /*public PlusMenuScreen doAddPost(){
        btnAddPost.click();
    }*/
}
