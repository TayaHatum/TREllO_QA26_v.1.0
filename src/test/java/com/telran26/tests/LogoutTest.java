package com.telran26.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(!app.getUser().isAvatarPresent()) {
            app.getUser().login(app.setEmail(), app.setPassword());

        }
    }

    @Test
    public void logOutTest() throws InterruptedException {


        app.getUser().clickLogOutButton();
        app.getUser().pause(6000);
        Assert.assertFalse(app.getUser().isAvatarPresent());


    }

}
