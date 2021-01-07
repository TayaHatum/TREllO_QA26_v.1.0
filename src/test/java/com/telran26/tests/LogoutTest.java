package com.telran26.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(!app.getUser().isAvatarPresent()) {
            app.getUser().login();

        }
    }

    @Test
    public void logOutTest() throws InterruptedException {


        app.getUser().clickLogOutButton();
        app.getUser().pause(3000);
        Assert.assertFalse(app.getUser().isElementPresent(By.cssSelector("[href='/login']")));


    }

}
