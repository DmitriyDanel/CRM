package Dmitriy.Daniel.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SiteLoginPage {

    private final Page page;
    private final Locator UserName ;
    private final Locator Password;
    private final Locator LoginBtn;


    public SiteLoginPage(Page page) {
        this.page = page;
        this.UserName = page.locator("#loginform-username");
        this.Password = page.locator("#loginform-password");
        this.LoginBtn = page.locator("[name=login-button]");

    }

    public SiteLoginPage setUserName() {
        UserName.fill("dmitriy.daniel.admin");
        return this;
    }
    public SiteLoginPage setPassword() {
        Password.fill("0910BIGti/*-+");
        return this ;
    }

    public SiteLoginPage cliclLoginBtn() {
        LoginBtn.click();
        return this;
    }
    public SiteLoginPage logInUser () {
        SiteLoginPage siteLoginPage = new SiteLoginPage(page);

        siteLoginPage
                .setUserName()
                .setPassword()
                .cliclLoginBtn();
        return this;
    }
    public void logOutUser(){
        page.locator("body > div.container.body > div > div.top_nav > div > nav > ul > li.nav-item.dropdown.open.show").dblclick();
        page.locator("body > div.container.body > div > div.top_nav > div > nav > ul > li.nav-item.dropdown.open.show > ul > li:nth-child(2) > a").click();
    }
}



