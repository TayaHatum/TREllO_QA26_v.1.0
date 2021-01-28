package com.telran26.fm;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MyListener extends AbstractWebDriverEventListener {
    HelperBase helperBase;

//    public MyListener(WebDriver driver) {
//        super();
//        this.helperBase = new HelperBase(driver);
//
//    }


    public MyListener() {

    }

    Logger logger = LoggerFactory.getLogger(MyListener.class);


    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver wd) {
        logger.info("Start search ->" +by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver wd) {
        logger.info(by + "<- found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver wd) {
        logger.error(throwable.toString());
        String pathToScreenshot = "src/test/screenshots/screen-"+ System.currentTimeMillis()+ ".png";
        HelperBase helperBase =new HelperBase(wd);
        helperBase.takeScreenshot(pathToScreenshot);
        logger.error(pathToScreenshot);
    }



    public void onException2(Throwable throwable, WebDriver wd) {
        logger.error(throwable.toString());
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new
                File("src/test/screenshots/screenshot-" +(System.currentTimeMillis()/1000%3600)+ ".png");

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.error("Screenshot with error -> "+ screenshot.getAbsolutePath());
    }

}
