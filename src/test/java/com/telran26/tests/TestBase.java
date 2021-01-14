package com.telran26.tests;


import com.telran26.fm.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {


    protected ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m){
        logger.info("Start test - >" +m.getName());
    }
    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m){
        logger.info("End of test -> "+m.getName());
    }








  @BeforeClass
    public void setUp(){
        app.start();


    }

    @AfterClass
    public void tearDown(){
        app.stop();


    }

}


    /*
    Revert back on one commit
    git revert HEAD --no-edit
    * */

    /*
    Revert to commit
    where hash is commit after revert
    git revert <hash> --no-edit
    * */
