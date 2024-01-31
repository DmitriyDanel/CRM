package dmitriy.daniel.comm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommAutorizationPage {
    private final Page page;
    private final Locator UserName;
    private final Locator Password;
    private final Locator LoginBtn;

    public CommAutorizationPage(Page page) {
        this.page = page;
        this.UserName = page.locator("#loginform-username");
        this.Password = page.locator("#loginform-password");
        this.LoginBtn = page.locator("#login-form > button");

    }

    public CommAutorizationPage setUserName() {
        UserName.fill("dmitriy.danel");
        return this;
    }
    public CommAutorizationPage setPassword() {
        Password.fill("dmitriy.danel");
        return this ;
    }

    public CommAutorizationPage cliclLoginBtn() {
        LoginBtn.click();
        return this;
    }
    public CommAutorizationPage commLogInUser() {
        CommAutorizationPage commAutorizationPage = new CommAutorizationPage(page);

        commAutorizationPage
                .setUserName()
                .setPassword()
                .cliclLoginBtn();
        return this;
    }
}


