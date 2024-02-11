//package dmitriy.daniel.CRM.caseFlow;
//
//import Dmitriy.Daniel.config.BrowserInitialization;
//import Dmitriy.Daniel.pages.CasesViewPage;
//import com.microsoft.playwright.Page;
//import dmitriy.daniel.CRM.caseCreate.CreateCaseManually;
//import dmitriy.daniel.CRM.caseStatusChange.ChangeStatus;
//import dmitriy.daniel.CRM.clientInfoBlock.ClientInfoBlock;
//import dmitriy.daniel.CRM.communicationFromCase.CommunicationBlock;
//import dmitriy.daniel.CRM.generalInfoBlock.UpdateGeneralInfoBlock;
//import dmitriy.daniel.CRM.statusHistory.StatusHistory;
//import org.testng.annotations.*;
//
//public class CaseFlow {
//    private BrowserInitialization browserInitialization;
//    private CasesViewPage casesViewPage;
//    private CreateCaseManually createCaseManually;
//    private ChangeStatus changeStatus;
//    private ClientInfoBlock clientInfoBlock;
//    private CommunicationBlock communicationBlock;
//    private UpdateGeneralInfoBlock updateGeneralInfoBlock;
//    private StatusHistory statusHistory;
//
//    @BeforeMethod
//    public void setUp() {
//        browserInitialization = BrowserInitialization.getInstance();
//        statusHistory = new StatusHistory();
//        createCaseManually = new CreateCaseManually();
//        changeStatus = new ChangeStatus();
//        clientInfoBlock = new ClientInfoBlock();
//        communicationBlock = new CommunicationBlock();
//        updateGeneralInfoBlock = new UpdateGeneralInfoBlock();
//        createCaseManually.setUpBrowser();
//        casesViewPage = browserInitialization.casesViewPage;
//        clientInfoBlock = browserInitialization.с
//
//    }
//    @Test
//    public void caseFlow() {
//        createCaseManually.createNewCase();
//
//        statusHistory.statusHistory();
//
//        updateGeneralInfoBlock.updateGeneralInfoBlock();
//        updateGeneralInfoBlock.updateGeneralInfoNegativeScenario();
//
//        communicationBlock.agentCanSendToSMS();
//        communicationBlock.agentCanSentToEmail();
//
//        changeStatus.changeStatusAfterEmailCommunication();
//        changeStatus.assignCaseToAnotherAgent();
//        changeStatus.changeStatusToSolved();
//    }
//
//    @Test
//    public void caseInfoBlockFlow() {
//        createCaseManually.newCaseCreateWithoutEmail();
//
//        clientInfoBlock.updateClientInfoBlock();
//        clientInfoBlock.updateClientWithRequiredAndOptionalFields();
//        clientInfoBlock.updateClientOnlyFirstNameFields();
//
//        clientInfoBlock.addEmailToClientInfoBlockNegativeScenario();
//        clientInfoBlock.addEmailToClientInfoBlock();
//
//        clientInfoBlock.caseAddPhoneToClientInfoBlock();
//        clientInfoBlock.caseAddPhoneToClientInfoBlockNegativeScenario();
//    }
//}
//
