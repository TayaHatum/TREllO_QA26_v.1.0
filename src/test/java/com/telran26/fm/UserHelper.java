package com.telran26.fm;

import com.telran26.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

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
        //pause(1000);
        WebDriverWait wait =new WebDriverWait(wd,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form-login")));
        type(By.id("password"), user.getPassword());
    }

    public void confirmLogin() {
        click(By.id("login-submit"));
    }

    public boolean isAvatarPresent() {

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
        clickByxPath("//button[@id='logout-submit']");



    }

    public void clickOnAvatar() {
        click(By.cssSelector("._1FekJJAz6Hu32v"));

    }

    public void goToProfile() {
        clickByxPath("//span[.='Profile and Visibility']");
    }

    public void goToAtlassianProfile() {
        click(By.cssSelector("[href$=manage-profile]"));
        switchToWindowHandel(1);
    }

    public void changeAvatar(String path)  {


        Actions actions= new Actions(wd);
        actions.moveToElement(wd.findElement(By.xpath("//div[@data-test-selector='profile-avatar']"))).perform();

        WebElement el=wd.findElement(By.xpath("//button[@aria-controls='uid17']"));
       el.click();

        el.findElement(By.xpath("//span[text()='Change profile photo']")).click();
        attachPhoto(By.id("image-input"),new File(path));

        click(By.xpath("//span[text()='Upload']"));


    }
    public void closeWindow(){
        wd.close();
        switchToWindowHandel(0);
    }


    public boolean isAvatarAdded() {

        WebDriverWait wait = new WebDriverWait(wd,10);
       return wait.until(ExpectedConditions.
               textToBePresentInElement(wd.findElement(By.xpath("//span[text()='Avatar added']")),"Avatar added"));
    }
}
