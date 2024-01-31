package dmitriy.daniel.CRM.clientInfoBlock;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import dmitriy.daniel.CRM.pages.CasesViewPage;
import dmitriy.daniel.CRM.pages.SiteLoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Locale;

public class ClientInfoBlock {


    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    CasesViewPage casesViewPage = new CasesViewPage(page);
    SiteLoginPage siteLoginPage = new SiteLoginPage(page);

    Faker faker = new Faker(new Locale("en-US"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String middleName = faker.name().name();
    String clientEmail = faker.internet().emailAddress();
    String clientPhone = faker.phoneNumber().phoneNumber();


    @Test
    //("Add Email To Client Info Block")
    public void AddEmailToClientInfoBlock() {

        page.navigate("https://crm.stage.travel-dev.com/cases/view/f243782783e3a8f4955c4188b57c4a91");
        siteLoginPage.logInUser();

        casesViewPage
                .clickBtnAddEmail()
                .addEmailFormEmail("AutoTest@mail.com")
                .btnAddEmailInAddEmailForm();

        Assert.assertTrue(page.locator("#w3").textContent().contains("AutoTest@mail.com"));
    }
    @Test
    //("Add Client Phone in Info Block")

    public void CaseAddPhoneToClientInfoBlock() {
        page.navigate("https://crm.stage.travel-dev.com/cases/view/f243782783e3a8f4955c4188b57c4a91");
        siteLoginPage.logInUser();


        casesViewPage
                .clickBtnAddPhone()
                .addPhoneInForm("+380950950955")
                .clickInModalBtnAddPhone();

        page.reload();//refresh page

        Assert.assertTrue(page.locator("#w3").textContent().contains("+380950950955"));
    }


    @Test()
    //("Update Client Info")
       public void UpdateClientInfo() {

        page.navigate("https://crm.stage.travel-dev.com/cases/view/01105f121721e37b131aea229d829854");
        siteLoginPage.logInUser();

        casesViewPage
                .clickBtnClientUpdate()
                .setClientUpdateFormFirstName("Jack")
                .setClientUpdateFormMiddleName("Capt")
                .setClientUpdateFormLastName("Sparrow")
                .setValueLocale("uk-UA")
                .setValueMarketingCountry("AD")
                .clickModalBtmUpdate();

        Assert.assertTrue(page.locator("#w2 > tbody > tr:nth-child(2) > td").textContent().contains("Jack"));
        Assert.assertTrue(page.locator("#w2 > tbody > tr:nth-child(3) > td").textContent().contains("Capt"));
        Assert.assertTrue(page.locator("#w2 > tbody > tr:nth-child(4) > td").textContent().contains("Sparrow"));
        Assert.assertTrue(page.locator("#w2 > tbody > tr:nth-child(6) > td > span").textContent().contains("uk-UA"));
        Assert.assertTrue(page.locator("[class=js_marketing_country]").textContent().contains("AD"));

    }
}




