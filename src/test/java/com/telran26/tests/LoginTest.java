package com.telran26.tests;


import com.telran26.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(app.getUser().isAvatarPresent()) {
            app.getUser().clickLogOutButton();

        }
    }

    @Test
    public void testAtlasianUserLogin() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLogInForm(new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$"));
        app.getUser().confirmLogin();
        app.getUser().pause(2000);

        Assert.assertTrue(app.getUser().isAvatarPresent());
        app.getUser().takeScreenAshot();

    }

}
