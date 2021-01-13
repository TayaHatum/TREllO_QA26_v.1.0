package com.telran26.tests;


import com.telran26.fm.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {


    //Commit 1
    //Commit 2

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
