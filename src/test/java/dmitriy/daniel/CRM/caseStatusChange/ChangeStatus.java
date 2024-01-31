package dmitriy.daniel.CRM.caseStatusChange;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import dmitriy.daniel.CRM.caseCreate.CreateCaseManually;
import dmitriy.daniel.CRM.communicationFromCase.FlowCommunicationBlock;
import dmitriy.daniel.CRM.pages.CasesViewPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NewToStatusAfterSendingCommunicationByEmail {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();

    CasesViewPage casesViewPage = new CasesViewPage(page);



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
    //        casesViewPage.clickBtnClose();
//        page.pause();
//
//        assertThat(page.locator("#w0 > tbody > tr:nth-child(1) > td > span.badge.badge-danger")).hasText("Closed");
}
