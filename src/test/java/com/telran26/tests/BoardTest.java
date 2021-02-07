package com.telran26.tests;

import org.testng.annotations.AfterMethod;
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
    public void createBoard()  {
        if(app.getBoard().getCountBoard()>3){
            app.getBoard().cleanAllBoard();
        }



        app.getBoard().ckickCreateBoard();
        app.getBoard().fillTitleNewBoard("boarNew");
        app.getBoard().clickByBordTypeSelector();
        app.getBoard().clickOnPublicType();
        app.getBoard().clickOnAcceptButton();
        app.getBoard().clickOnCreateBoardButton();

    }

@Test
public void clearBoard()  {
    app.getBoard().cleanAllBoard();
}

@AfterMethod
    public void postCondition(){
        app.getUser().clickLogOutButton();
}
}