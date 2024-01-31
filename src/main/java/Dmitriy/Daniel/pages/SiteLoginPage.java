package dmitriy.daniel.CRM.pages;

import com.microsoft.playwright.*;

public class SiteLoginPage {

    private final Page page;
    private final Locator UserName;
    private final Locator Password;
    private final Locator LoginBtn;

    public SiteLoginPage(Page page) {
        this.page = page;
        this.UserName = page.locator("#loginform-username");
        this.Password = page.locator("#loginform-password");
        this.LoginBtn = page.locator("[name=login-button]");

    }

    public SiteLoginPage setUserName() {
        UserName.fill("dmitriy.daniel.admin");//
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
}



