package dmitriy.daniel.CRM;

import Dmitriy.Daniel.config.BrowserInitialization;

import Dmitriy.Daniel.pages.SiteLoginPage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginForm  {
    BrowserInitialization browserInitialization = BrowserInitialization.getInstance();

    Page page = browserInitialization.getPage();
    @Test
    public void logInUser () {

        SiteLoginPage siteLoginPage = new SiteLoginPage(page);

        page.navigate("https://crm.stage.travel-dev.com");

        siteLoginPage
                .setUserName()
                .setPassword()
                .cliclLoginBtn();
        Assert.assertTrue(page.locator("[class=\"site-index\"]").textContent().contains(" Home Page"));

    }
}