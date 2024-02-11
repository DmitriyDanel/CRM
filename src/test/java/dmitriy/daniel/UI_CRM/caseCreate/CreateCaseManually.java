package dmitriy.daniel.UI_CRM.caseCreate;

import Dmitriy.Daniel.config.BrowserInitialization;
import Dmitriy.Daniel.pages.CasesCreatePage;
import Dmitriy.Daniel.pages.CasesViewPage;
import Dmitriy.Daniel.pages.SiteLoginPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Dmitriy.Daniel.constants.CrmConstants.CRM_URL_STAGE;

public class CreateCaseManually {
    private BrowserInitialization browserInitialization;
    private Page page;
    private CasesCreatePage casesCreatePage;
    private CasesViewPage casesViewPage;
    private SiteLoginPage siteLoginPage;

    @BeforeMethod
    public void setUpBrowser() {
        browserInitialization = BrowserInitialization.getInstance();
        browserInitialization.setup();
        page = browserInitialization.page;

        casesCreatePage = browserInitialization.casesCreatePage;
        casesViewPage = browserInitialization.casesViewPage;
        siteLoginPage = browserInitialization.siteLoginPage;
    }
    @AfterMethod
    public void tearDownPage() {
        browserInitialization.closePage();
    }
    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-861 [CRM] Create Case - Manually - required fields")
    public void createNewCase() {

        page.navigate(CRM_URL_STAGE + "/cases/create");
        siteLoginPage.logInUser();

        casesCreatePage.openFormProjectID()
                .selectProjectID("OVAGO")
                .openWebFormDepID()
                .selectionDepID("Exchange")
                .openWebFormSourceTypeID()
                .selectionSourceTypeID("Call")
                .openAndSetWebFormClientphone("+380983400001")
                .openAndSetWebFormEmail("danelukdv@gmail.com")
                .bookingID("223456")
                .fillInTheSubjectField("autoTest")
                .fillInTheDescriptionField("Test_Dmitriy.Danel")
                .selectionWebFormCategoryID("New flight reservation")
                .clickBtnCreateCase();
        casesViewPage.assertNewCaseCreate();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-873 Verify that case is created manually with all required fields and without Phone")

    public void newCaseCreateWithoutPhone() {

        page.navigate(CRM_URL_STAGE + "/cases/create");
        siteLoginPage.logInUser();

        casesCreatePage
                .openFormProjectID()
                .selectProjectID("OVAGO")
                .openWebFormDepID()
                .selectionDepID("Exchange")
                .selectionWebFormCategoryID("New flight reservation")
                .openWebFormSourceTypeID()
                .selectionSourceTypeID("Sms")
                .openAndSetWebFormEmail("danelukdv@gmail.com")
                .bookingID("223456")
                .fillInTheSubjectField("autoTest")
                .fillInTheDescriptionField("Test_Dmitriy.Danel")

                .clickBtnCreateCase();
        casesViewPage.assertNewCaseCreate();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-871 Verify that case is created manually with all required fields and without Email")

    public void newCaseCreateWithoutEmail() {

        page.navigate(CRM_URL_STAGE + "/cases/create");
        siteLoginPage.logInUser();

        casesCreatePage
                .openFormProjectID()
                .selectProjectID("OVAGO")
                .openWebFormDepID()
                .selectionDepID("Exchange")
                .openWebFormSourceTypeID()
                .selectionSourceTypeID("Mail")
                .openAndSetWebFormClientphone("+380983429271")
                .bookingID("223456")
                .fillInTheSubjectField("autoTest")
                .fillInTheDescriptionField("Test_Dmitriy.Danel")
                .selectionWebFormCategoryID("Refunds")
                .clickBtnCreateCase();
        casesViewPage.assertNewCaseCreate();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-881 Verify that Validation error message is displayed when Email and Phone fields are empty")

    public void ValidationErrorMessageWhenEmailAndPhoneFieldsAreEmpty() {

        page.navigate(CRM_URL_STAGE + "/cases/create");
        siteLoginPage.logInUser();

        casesCreatePage
                .openFormProjectID()
                .selectProjectID("OVAGO")
                .openWebFormDepID()
                .selectionDepID("Exchange")
                .openWebFormSourceTypeID()
                .selectionSourceTypeID("Mail")
                .openAndSetWebFormClientphone("")
                .bookingID("223456")
                .fillInTheSubjectField("autoTest")
                .fillInTheDescriptionField("")
                .selectionWebFormCategoryID("Refunds")
                .clickBtnCreateCase()
                .assertValidationErrorMessageWhenEmailAndPhoneFieldsAreEmpty();

    }
}
