package dmitriy.daniel.CRM.communicationFromCase;

import Dmitriy.Daniel.config.BrowserInitialization;
import Dmitriy.Daniel.pages.CasesViewPage;
import dmitriy.daniel.CRM.caseCreate.CreateCaseManually;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CommunicationBlock {
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
    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1359 Verify that agent can send SMS from Case")
    public void AgentCanSendSmsFromCase(){
        createCaseManually.createNewCase();
        agentCanSendToSMS();
    }
    public void agentCanSendToSMS() {
        casesViewPage
                .setToSMSValue("2")
                .setValueInFormSMSTemplate("sms_ex_agent_blank")
                .setValueInFormPhonNumber("+3809*****001")
                .clickToSendSMSBtn()
                .clickToSMSInternalNoteField("Add SMS To Communication Block")
                .clickToModalSendSMSBtn()
                .reload()
                .assertAgentCanSendToSMS();
    }

    @Test
    @Story("https://traveldev.atlassian.net/browse/TEST-1358   Verify that agent can send email from Case")
    public void AgentCanSendEmailFromCase(){
        createCaseManually.createNewCase();
        agentCanSentToEmail();
    }

    public void agentCanSentToEmail() {
        casesViewPage.setToEmailValue("1")
                .setValueInFormEmailTemplate("add_infant")
                .clickToEmailRadioBtn("dan******@*mail.com")
                .clickToPreviewAndSendEmailBtn()
                .clickToInternalNoteFieldEmail("The agent can send email in Communication Block")
                .clickBtnSendEmail()
                .reload()
                .assertChangedFromNewToStatusOpen();
    }
}

//    BrowserInitialization browserInitialization = BrowserInitialization.getInstance();
//    Page page = browserInitialization.getPage();
//
//    CasesViewPage casesViewPage = new CasesViewPage(page);
//    CreateCaseManually createCaseManually = new CreateCaseManually();
