package com.telran26.tests;

import com.telran26.fm.ListenerNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerNG.class)
public class ListenerNGTest {

    @Test(enabled = false)
   public void testOpenWIKI() {

        WebDriver wd = new ChromeDriver();
        wd.get("https://ru.wikipedia.org/");
        wd.quit();
    }
}
