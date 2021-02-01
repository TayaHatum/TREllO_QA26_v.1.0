package com.telran26.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatar extends TestBase{

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getUser().isAvatarPresent()) {
            app.getUser().login(app.setEmail(), app.setPassword());

        }
    }

    @Test
    public void testChangeAvatar() throws InterruptedException {
        app.getUser().clickOnAvatar();
        app.getUser().goToProfile();
        app.getUser().goToAtlassianProfile();
        app.getUser().changeAvatar("/Users/tayahatum/QALearning/TREllO_QA26_v.1.0/src/test/resources/qa-2-min.png");
      Assert.assertTrue(app.getUser().isAvatarAdded());
       app.getUser().pause(2000);
        app.getUser().closeWindow();

    }

}
