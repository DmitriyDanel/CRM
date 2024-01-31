package dmitriy.daniel.CRM.generalInfoBlock;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import dmitriy.daniel.CRM.pages.CasesViewPage;
import dmitriy.daniel.CRM.pages.SiteLoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


public class UpdateGeneralInfoBlock{
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    CasesViewPage casesViewPage = new CasesViewPage(page);
    SiteLoginPage siteLoginPage = new SiteLoginPage(page);



    @Test()
    @DisplayName("Update General Info Block")
    @Tags({@Tag("BLOCKER"), @Tag("CASE")})



    public void UpdateGeneralInfoBlock() {


        page.navigate("https://crm.stage.travel-dev.com/cases/view/1c452f40fd53e20145380cc4a1827e9c");
        siteLoginPage.logInUser();


        casesViewPage
                .clickBtnGeneralInfoUpdate()
                .updateDepartmantToUpdateCaseForm("2")
                .updateBookingIDToUpdateCaseForm("654321")
                .updateSubjectToUpdateCaseForm("updateSubjectAutoTest")
                .updateDescriptionToUpdateCaseForm("updateDescriptionAutoTest")
                .setCategoryToUpdateCaseForm("Add child to the existing flight")
                .ClickBtnUpdateGeneralInfoBlock()
                .assertGeneralInfoUpdate();





    }
}
