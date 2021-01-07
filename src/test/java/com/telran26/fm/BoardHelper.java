package com.telran26.fm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void ckickCreateBoard() {
        click(By.cssSelector(".boards-page-board-section-list-item:last-child"));
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
        clickByxPath("//span[@name='public']");
    }

    public void clickOnAcceptButton() {
        clickByxPath("//button[.='Yes, Make Board Public']");
    }

    public void clickOnCreateBoardButton() {
        clickByxPath("//button[.='Create Board']");
    }
}
