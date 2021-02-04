package com.telran26.tests;


import com.telran26.fm.DataProviders;
import com.telran26.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @AfterMethod
    public void ensurePrecondition() {
        if(app.getUser().isAvatarPresent()) {
            app.getUser().clickLogOutButton();
        }
    }


    @Test(dataProvider = "validLogin", dataProviderClass = DataProviders.class)
    public void testDataProviderLogin(String email, String password) throws InterruptedException {
        logger.info("\n********************************"+"\n Email ->"+email +"\nPassword -> "+password+"\n*******************************");
        app.getUser().initLogin();
        app.getUser().fillLogInForm(new User().withEmail(email).withPassword(password));
        app.getUser().confirmLogin();
        app.getUser().pause(2000);

        Assert.assertTrue(app.getUser().isAvatarPresent());
        String screenshot = "src/test/screenshots/screenshot-" +(System.currentTimeMillis()/1000%3600)+ ".png";
        app.getUser().takeScreenshot(screenshot);
        logger.info("Test passed ");

    }

    @Test(dataProvider = "validLoinFromFile", dataProviderClass = DataProviders.class)
    public void testDataProviderCSVLogin(User user) throws InterruptedException {

        logger.info("\n********************************"+"\n Email ->"+user.getEmail() +"\nPassword -> "+user.getPassword()+"\n*******************************");
        app.getUser().initLogin();
        app.getUser().fillLogInForm(user);
        app.getUser().confirmLogin();
       app.getUser().pause(2000);

        Assert.assertTrue(app.getUser().isAvatarPresent());
        String screenshot = "src/test/screenshots/screenshot-" +(System.currentTimeMillis()/1000%3600)+ ".png";
        app.getUser().takeScreenshot(screenshot);
        logger.info("Test passed ");

    }


    @Test
    public void testAtlassianUserLogin() throws InterruptedException {
        logger.info("\n********************************"+"\n Email ->hatum.testing@gmail.com " +"\nPassword -> Hatum21$"+"\n*******************************");
        app.getUser().initLogin();
        app.getUser().fillLogInForm(new User().withEmail(app.setEmail()).withPassword(app.setPassword()));
        app.getUser().confirmLogin();


        Assert.assertTrue(app.getUser().isAvatarPresent());
        String screenshot = "src/test/screenshots/screenshot-" +(System.currentTimeMillis()/1000%3600)+ ".png";
        app.getUser().takeScreenshot(screenshot);
        logger.info("Test passed ");
    }
}
