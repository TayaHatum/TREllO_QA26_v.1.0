package com.telran26.fm;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    static EventFiringWebDriver wd;
    UserHelper user;
    BoardHelper board;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
        }else if(browser.equals(BrowserType.EDGE)){
        wd = new EventFiringWebDriver(new EdgeDriver());
    }


        //Display logback status!
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // print logback's internal status
        StatusPrinter.print(lc);
        wd.register(new MyListener());

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

    public static class MyListener extends AbstractWebDriverEventListener {
        HelperBase helperBase= new HelperBase(wd);

        public MyListener(){
            super();
        }
        Logger logger =LoggerFactory.getLogger(ApplicationManager.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver wd) {
            System.out.println("Start search -> " +by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver wd) {
            System.out.println(by + "-> found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver wd) {
            logger.error(throwable.toString());
            String pathToScreenshot = "src/test/screenshots/screen-"+ System.currentTimeMillis()+ ".png";
            
            helperBase.takeScreenshot(pathToScreenshot);
            logger.error(pathToScreenshot);
        }
    }

}
