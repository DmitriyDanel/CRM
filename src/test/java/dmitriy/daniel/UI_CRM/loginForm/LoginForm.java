package dmitriy.daniel.UI_CRM.loginForm;

import Dmitriy.Daniel.config.BrowserInitialization;
import Dmitriy.Daniel.pages.SiteLoginPage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Dmitriy.Daniel.constants.CrmConstants.CRM_URL_STAGE;

public class LoginForm  {
    private BrowserInitialization browserInitialization;
    private Page page;

    @BeforeMethod
    public void setUp() {
        browserInitialization = BrowserInitialization.getInstance();
        browserInitialization.setup();
        page = browserInitialization.page;
    }
    @Test
    public void logInUser () {

        SiteLoginPage siteLoginPage = new SiteLoginPage(page);

        page.navigate(CRM_URL_STAGE);

        siteLoginPage
                .setUserName()
                .setPassword()
                .cliclLoginBtn();
        Assert.assertTrue(page.locator("[class=\"site-index\"]").textContent().contains(" Home Page"));

    }


}