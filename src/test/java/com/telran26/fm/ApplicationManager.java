package com.telran26.fm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    EventFiringWebDriver wd;
    UserHelper user;
    BoardHelper board;
    String browser;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties=new Properties();
    }

    public void start() throws IOException {
        String target=System.getProperty("target","data");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));




        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
        }else if(browser.equals(BrowserType.EDGE)){
        wd = new EventFiringWebDriver(new EdgeDriver());
    }


        //Display logback status!
       // LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // print logback's internal status
        //StatusPrinter.print(lc);

        user = new UserHelper(wd);
        board = new BoardHelper(wd);

        wd.register(new MyListener());

        wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        wd.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    public WebDriver getWd() {
        return wd;
    }

    public String setEmail(){
        return properties.getProperty("web.email");

    }
    public String setPassword(){
        return properties.getProperty("web.password");
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
