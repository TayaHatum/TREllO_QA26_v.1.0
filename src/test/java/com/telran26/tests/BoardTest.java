package com.telran26.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() throws InterruptedException {
        if(!app.getUser().isAvatarPresent()) {
            app.getUser().login(app.setEmail(), app.setPassword());
        }
    }

    @Test
    public void createBoard() throws InterruptedException {
        if(app.getBoard().getCountBoard()>3){
            app.getBoard().cleanAllBoard();
        }


        app.getBoard().pause(2000);
        app.getBoard().ckickCreateBoard();
        app.getBoard().fillTitleNewBoard("boarNew");
        app.getBoard().clickByBordTypeSelector();

        app.getBoard().clickOnPublicType();
        app.getBoard().clickOnAcceptButton();
        app.getBoard().pause(2000);
        app.getBoard().clickOnCreateBoardButton();

    }

@Test
public void clearBoard() throws InterruptedException {
    app.getBoard().cleanAllBoard();
}
}