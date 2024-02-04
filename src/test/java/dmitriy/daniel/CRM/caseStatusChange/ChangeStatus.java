package dmitriy.daniel.CRM.caseStatusChange;

import Dmitriy.Daniel.config.BrowserInitialization;
import Dmitriy.Daniel.pages.CasesViewPage;
import dmitriy.daniel.CRM.caseCreate.CreateCaseManually;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeStatus  {
    private BrowserInitialization browserInitialization;
    private CasesViewPage casesViewPage;
    private CreateCaseManually createCaseManually;

    @BeforeMethod
    public void setUp() {
        browserInitialization = BrowserInitialization.getInstance();
        createCaseManually = new CreateCaseManually();
        createCaseManually.setUpBrowser();
        casesViewPage = browserInitialization.casesViewPage;
    }

    @AfterMethod
    public void tearDownPage() {
        browserInitialization.closePage();
    }
    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-4409  The case status is changed from New to status Open after communication by Email")
    public void changedFromNewToStatusOpenAfterCommunicationByEmail() {
        createCaseManually.createNewCase();
        changeStatusAfterEmailCommunication();
    }
    public void changeStatusAfterEmailCommunication() {
        casesViewPage.setToEmailValue("1")
                .setValueInFormEmailTemplate("add_infant")
                .clickToEmailRadioBtn("dan******@*mail.com")
                .clickToPreviewAndSendEmailBtn()
                .clickToInternalNoteFieldEmail("The agent can send email in Communication Block")
                .clickBtnSendEmail()
                .reload()
                .assertChangedFromNewToStatusOpen();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-4544  The user is able to assign the case to another agent when changing the case status to Pending")
    public void ChangingTheCaseStatusToPending() {
        createCaseManually.createNewCase();
        assignCaseToAnotherAgent();
    }
    public void assignCaseToAnotherAgent() {
        casesViewPage.ckickBtnChangeStatus()
                .setStatusInChangeCaseStatusModal("1")
                .setEmployeeInChangeCaseStatusModal("800")
                .ckickInModalBtnChangeStatus()
                .reload()
                .assertChangedFromOpenToStatusPending();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-4429  The case status is changed to business status Solved")
    public void changedToBusinessStatusSolved() {
        createCaseManually.createNewCase();
        changeStatusAfterEmailCommunication();
        changeStatusToSolved();
    }
    public void changeStatusToSolved() {
        casesViewPage.ckickBtnChangeStatus()
                .setStatusInChangeCaseStatusModal("2")
                .changefieldSentToEmail("danelukdv@gmail.com")
                .setLanguageInChangeCaseStatusModal("en-US")
                .ckickInModalBtnChangeStatus()
                .reload()
                .assertChangedFromNewToStatusSolved();

    }
}
