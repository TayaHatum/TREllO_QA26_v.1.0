package com.telran26.fm;

import com.telran26.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }


    public void initLogin() {
        click(By.cssSelector("[href='/login']"));


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
        pause(2000);
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void login(String email, String password) throws InterruptedException {
        initLogin();
        fillLogInForm(new User().withEmail(email).withPassword(password));
        confirmLogin();
    }

    public void clickLogOutButton() {
        click(By.cssSelector("._1FekJJAz6Hu32v"));
        click(By.xpath("//span[contains(.,'Log Out')]"));


    }

    public void clickOnAvatar() {
        click(By.cssSelector("._1FekJJAz6Hu32v"));

    }

    public void goToProfile() {
        clickByxPath("//span[.='Profile and Visibility']");
    }

    public void goToAtlassianProfile() {
        click(By.cssSelector("[href$=manage-profile]"));
        List<String> tabs= new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
    }

    public void changeAvatar(String path) throws InterruptedException {
        pause(100);

        Actions actions= new Actions(wd);
        actions.moveToElement(wd.findElement(By.xpath("//div[@data-test-selector='profile-avatar']"))).perform();
        pause(100);
        WebElement el=wd.findElement(By.xpath("//button[@aria-controls='uid17']"));
       el.click();
        pause(100);
        el.findElement(By.xpath("//span[text()='Change profile photo']")).click();
        attachPhoto(By.id("image-input"),new File(path));
        click(By.xpath("//span[text()='Upload']"));


    }
}
