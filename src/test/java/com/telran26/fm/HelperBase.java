package com.telran26.fm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class HelperBase {

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    WebDriver wd;

    public void type(By locator, String text) {
        if(text!=null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        try {
            wd.findElement(locator).click();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        /*
       * org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <textarea name="about" cols="30" rows="10" placeholder="About (max 500 chars)" class="has-error" style="border: 2px solid red;"></textarea> is not clickable at point (1190, 14). Other element would receive the click: <section class="container header">...</section>
        * */
//        Actions actions =new Actions(wd);
//        Actions actions1 = actions.moveToElement(wd.findElement(locator));
//        actions1.click().perform();

    }
    public void typeByElement(WebElement element, String text) {

        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void typeByCss(String cssSelector, String text) {
        clickByCss(cssSelector);
        wd.findElement(By.cssSelector(cssSelector)).clear();
        wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByxPath(String xPathSelector) {
        wd.findElement(By.xpath(xPathSelector)).click();
    }
    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;
    }
    public void clickYallaButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public void clickHomeButton(By xpath) {
        clickByxPath("//span[@aria-label='HouseIcon']");
    }

    public void takeScreenAshot(){
        Screenshot screen=new AShot().takeScreenshot(wd);
        try {
            ImageIO.write(screen.getImage(), "jpg", new File("src/test/screenshots/screenshot.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
