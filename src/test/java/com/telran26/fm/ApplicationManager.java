package com.telran26.fm;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;
    BoardHelper board;



    public BoardHelper getBoard() {
        return board;
    }

    public UserHelper getUser() {
        return user;
    }

    public void start() {
        wd = new ChromeDriver();

        LoggerContext c=  (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(c);

        wd.navigate().to("https://trello.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new UserHelper(wd);
        board = new BoardHelper(wd);


    }

    public void stop() {
        wd.quit();
    }
}
