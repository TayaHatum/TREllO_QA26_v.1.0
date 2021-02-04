package com.telran26.fm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void ckickCreateBoard() {
        click(By.xpath("//span[.='Create new board']"));
    }

    public void fillTitleNewBoard(String text) {
        if(text!=null) {
            type(By.cssSelector("[placeholder='Add board title']"), text);
        }
    }

    public void clickByBordTypeSelector() {
        click(By.cssSelector("[aria-label='DownIcon']"));
    }

    public void clickOnPublicType() {
        clickByxPath("//span[contains(.,'Public')]");
    }

    public void clickOnAcceptButton() {
        clickByxPath("//button[.='Yes, Make Board Public']");
    }

    public void clickOnCreateBoardButton() {
        clickByxPath("//button[.='Create Board']");
    }

    public int getCountBoard() {
        int size =wd.findElements(By.xpath("//ul[@class='boards-page-board-section-list']/li/a")).size();
        System.out.println(size);
        return size;

    }

    public void cleanAllBoard() throws InterruptedException {

       while(wd.findElements(By.xpath("//ul[@class='boards-page-board-section-list']/li/a")).size() > 0){


           wd.findElements(By.xpath("//ul[@class='boards-page-board-section-list']/li/a")).get(0).click();
          //pause(4000);
          click(By.xpath("//a[@title='Go back.']"));
          click(By.xpath("//li[contains(.,'More')]"));
          clickByxPath("//li[contains(.,'Close Board…')]");
          clickByxPath("//input[@type='submit' and @value='Close']");
          //pause(4000);
          clickByxPath("//a[.='Permanently Delete Board…']");
          click(By.xpath("//input[@value='Delete']"));
          //pause(4000);
          clickHomeButton(By.xpath("//span[@aria-label='HouseIcon']"));
          //pause(4000);

       }

    }

public void clearall(){
        List<WebElement> boards= wd.findElements(By.xpath(""));
    System.out.println(boards.size());

    for(int i=0; i<boards.size();i++){
        WebElement el =boards.get(0);
        el.click();
        click(By.xpath("//a[@title='Go back.']"));
        click(By.xpath("//li[contains(.,'More')]"));
        clickByxPath("//li[contains(.,'Close Board…')]");
        clickByxPath("//input[@type='submit' and @value='Close']");
        //pause(4000);
        clickByxPath("//a[.='Permanently Delete Board…']");
        click(By.xpath("//input[@value='Delete']"));
        //pause(4000);
        clickHomeButton(By.xpath("//span[@aria-label='HouseIcon']"));
    }
}
}
