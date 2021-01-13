package com.telran26.tests;


import com.telran26.fm.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Set;

public class TestBase {


    protected ApplicationManager app = new ApplicationManager();


  @BeforeClass
    public void setUp(){
        app.start();


    }


    @AfterClass
    public void tearDown(){
        app.stop();


    }



}
