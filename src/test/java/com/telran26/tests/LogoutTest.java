package com.telran26.tests;

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
    public void logOutTest()  {


        app.getUser().clickLogOutButton();
        Assert.assertFalse(app.getUser().isAvatarPresent());


    }

}
