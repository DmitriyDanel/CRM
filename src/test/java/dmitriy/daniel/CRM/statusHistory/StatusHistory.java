package dmitriy.daniel.CRM.statusHistory;

import Dmitriy.Daniel.config.BrowserInitialization;
import Dmitriy.Daniel.pages.CasesViewPage;
import dmitriy.daniel.CRM.caseCreate.CreateCaseManually;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatusHistory {
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
    @Story("https://traveldev.atlassian.net/browse/TEST-1710  [Case] Verify status History")
    public void verifyStatusHistory(){
        createCaseManually.createNewCase();
        statusHistory();
    }

    public void statusHistory(){
        casesViewPage.ckickBtnLogs()
                .ckickBtnStatusHistory()
                .assertStatusHistory();
    }
}


//package dmitriy.daniel.CRM.statusHistory;
//
//import Dmitriy.Daniel.config.BrowserInitialization;
//import Dmitriy.Daniel.pages.CasesCreatePage;
//import Dmitriy.Daniel.pages.CasesViewPage;
//import Dmitriy.Daniel.pages.SiteLoginPage;
//import com.microsoft.playwright.Page;
//import dmitriy.daniel.CRM.caseCreate.CreateCaseManually;
//import io.qameta.allure.Story;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class StatusHistory {
//    private BrowserInitialization browserInitialization;
//    private Page page;
//    private CasesViewPage casesViewPage;
//
//
//    @BeforeMethod
//    public void setUpBrowser() {
//        browserInitialization = BrowserInitialization.getInstance();
//        browserInitialization.setup();
//        page = browserInitialization.page;
//        casesViewPage = browserInitialization.casesViewPage;
//    }
//
//    CreateCaseManually createCaseManually = new CreateCaseManually();
//
//    @Test
//    @Story("https://traveldev.atlassian.net/browse/TEST-1710  [Case] Verify status History")
//    public void verifyStatusHistory(){
//        createCaseManually.createNewCase();
//        statusHistory();
//
//    }
//    public void statusHistory(){
//        casesViewPage.ckickBtnLogs()
//                .ckickBtnStatusHistory()
//                .assertStatusHistory();
//    }
//}
//    BrowserInitialization browserInitialization = BrowserInitialization.getInstance();
//    Page page = browserInitialization.getPage();
//    CasesViewPage casesViewPage = new CasesViewPage(page);