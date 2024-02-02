package dmitriy.daniel.CRM.loginForm;

import Dmitriy.Daniel.config.BrowserInitialization;
import Dmitriy.Daniel.pages.SiteLoginPage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginForm  {
    private BrowserInitialization browserInitialization;
    private Page page; // Добавляем переменную page в класс

    @BeforeMethod
    public void setUp() {
        browserInitialization = BrowserInitialization.getInstance();
        browserInitialization.setup();
        page = browserInitialization.page;
    }
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