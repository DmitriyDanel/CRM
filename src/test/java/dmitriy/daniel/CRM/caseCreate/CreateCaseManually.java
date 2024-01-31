package dmitriy.daniel.CRM.caseCreate;

import com.microsoft.playwright.*;
import dmitriy.daniel.CRM.pages.CasesCreatePage;
import dmitriy.daniel.CRM.pages.CasesViewPage;
import dmitriy.daniel.CRM.pages.SearchSalePage;
import dmitriy.daniel.CRM.pages.SiteLoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Dmitriy.Daniel.constants.CrmConstants.CRM_URL_STAGE;

public class CreateCaseManually {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    BrowserContext context = browser.newContext();
    Page page = context.newPage();


    CasesViewPage casesViewPage = new CasesViewPage(page);
    CasesCreatePage casesCreatePage = new CasesCreatePage(page);
    SiteLoginPage siteLoginPage = new SiteLoginPage(page);
    SearchSalePage searchSalePage = new SearchSalePage(page);

        @Test
    //https://traveldev.atlassian.net/browse/TEST-873
    //("Verify that case is created manually with all required fields and without Phone"

    public void newCaseCreateWithoutPhone() {

        page.navigate(CRM_URL_STAGE + "/cases/create");
        siteLoginPage.logInUser();

        casesCreatePage
                .openFormProjectID()
                .selectProjectID("OVAGO")
                .openWebFormDepID()
                .selectionDepID("Schedule Change")
                .openWebFormSourceTypeID()
                .selectionSourceTypeID("Sms")
                .openAndSetWebFormEmail("danelukdv@gmail.com")
                .bookingID("223456")
                .fillInTheSubjectField("autoTest")
                .fillInTheDescriptionField("Test_Dmitriy.Danel")
                .selectionWebFormCategoryID("Flight Schedule Change")
                .clickBtnCreateCase();
        casesViewPage.assertNewCaseCreate();
    }

    @Test
    //https://traveldev.atlassian.net/browse/TEST-871
    //"Verify that case is created manually with all required fields and without Email"

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
                .openAndSetWebFormClientphone("+380983420000")
                .bookingID("223456")
                .fillInTheSubjectField("autoTest")
                .fillInTheDescriptionField("Test_Dmitriy.Danel")
                .selectionWebFormCategoryID("Refunds")
                .clickBtnCreateCase();
        casesViewPage.assertNewCaseCreate();
    }

    @Test
    public void NewCaseCreation() {
        createNewCase();
        updateGeneralInfo();
        changeStatusAfterEmailCommunication();
        assignCaseToAnotherAgent();
        changeStatusToSolved();
    }

    @Step(" https://traveldev.atlassian.net/browse/TEST-861 [CRM] Create Case - Manually - required fields")
    private void createNewCase() {
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

    @Step("https://traveldev.atlassian.net/browse/TEST-1747  Verify General Info update in the Case")
    private void updateGeneralInfo() {
        casesViewPage.clickBtnGeneralInfoUpdate()
                .updateDepartmantToUpdateCaseForm("2")
                .updateBookingIDToUpdateCaseForm("654321")
                .updateSubjectToUpdateCaseForm("updateSubjectAutoTest")
                .updateDescriptionToUpdateCaseForm("updateDescriptionAutoTest")
                .setCategoryToUpdateCaseForm("Add child to the existing flight")
                .ClickBtnUpdateGeneralInfoBlock()
                .assertGeneralInfoUpdate();
    }

    @Step("https://traveldev.atlassian.net/browse/TEST-4409  The case status is changed from New to status Open after communication by Email")
    private void changeStatusAfterEmailCommunication() {
        casesViewPage.setToEmailValue("1")
                .setValueInFormEmailTemplate("add_infant")
                .clickToEmailRadioBtn("danelukdv@gmail.com")
                .clickToPreviewAndSendEmailBtn()
                .clickToInternalNoteFieldEmail("The agent can send email in Communication Block")
                .clickBtnSendEmail()
                .reload()
                .assertChangedFromNewToStatusOpen();
    }

    @Step("https://traveldev.atlassian.net/browse/TEST-4544  The user is able to assign the case to another agent when changing the case status to Pending")
    private void assignCaseToAnotherAgent() {
        casesViewPage.ckickBtnChangeStatus()
                .setStatusInChangeCaseStatusModal("1")
                .setEmployeeInChangeCaseStatusModal("800")
                .ckickInModalBtnChangeStatus()
                .reload()
                .assertChangedFromOpenToStatusPending();
    }

    @Step("https://traveldev.atlassian.net/browse/TEST-4429  The case status is changed to business status Solved")
    private void changeStatusToSolved() {
        casesViewPage.ckickBtnChangeStatus()
                .setStatusInChangeCaseStatusModal("2")
                .setLanguageInChangeCaseStatusModal("en-US")
                .ckickInModalBtnChangeStatus()
                .reload()
                .assertChangedFromNewToStatusSolved();

    }
}
