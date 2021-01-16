package com.telran26.fm;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;
    BoardHelper board;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
   
    public void start() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd=new FirefoxDriver();
        }else if(browser.equals(BrowserType.EDGE)){
        wd = new EdgeDriver();
    }


        //Display logback status!
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // print logback's internal status
        StatusPrinter.print(lc);

        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new UserHelper(wd);
        board = new BoardHelper(wd);


    }

    public void stop() {
        wd.quit();
    }
    public BoardHelper getBoard() {
        return board;
    }

    public UserHelper getUser() {
        return user;
    }
}
