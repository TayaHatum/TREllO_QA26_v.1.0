package com.telran26.tests;


import com.telran26.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {



    @Test
    public void testAtlasianUserLogin() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLogInForm(new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$"));
        app.getUser().confirmLogin();

        Assert.assertTrue(app.getUser().isAvatarPresent());

    }

}
