package com.telran26.fm;

import com.telran26.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }


    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
        click(By.cssSelector(""));

    }

    public void fillLogInForm(User user) throws InterruptedException {
        type(By.id("user"), user.getEmail());
        click(By.id("login"));
        pause(2000);
        type(By.id("password"), user.getPassword());


    }
    public void confirmLogin() {
        click(By.id("login-submit"));
    }

    public boolean isAvatarPresent() throws InterruptedException {
        pause(20000);
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void login() throws InterruptedException {
        initLogin();
        fillLogInForm(new User().withEmail("hatum.testing@gmail.com").withPassword("Hatum21$"));
        confirmLogin();
    }

    public void clickLogOutButton() {
        click(By.cssSelector("._1FekJJAz6Hu32v"));
        click(By.xpath("//span[contains(.,'Log Out')]"));


    }
}
