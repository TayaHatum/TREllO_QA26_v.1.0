package com.telran26.fm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerNG implements ITestListener {
    Logger logger = LoggerFactory.getLogger(ListenerNG.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info( "ListenerNg start" +result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("ListenerNg finish" +context.getName());
    }
}
