package com.telran26.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(!app.getUser().isAvatarPresent()) {
            app.getUser().login();
        }
    }

    @Test
    public void createBoard(){
        app.getBoard().ckickCreateBoard();
        app.getBoard().fillTitleNewBoard("boarNew");
        app.getBoard().clickByBordTypeSelector();
        app.getBoard().clickOnPublicType();
        app.getBoard().clickOnAcceptButton();
        app.getBoard().clickOnCreateBoardButton();

    }
}
