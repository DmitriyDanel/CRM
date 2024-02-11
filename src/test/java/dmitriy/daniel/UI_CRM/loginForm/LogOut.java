//package dmitriy.daniel.CRM.loginForm;
//
//import Dmitriy.Daniel.config.BrowserInitialization;
//import Dmitriy.Daniel.pages.CasesViewPage;
//import com.microsoft.playwright.Page;
//import dmitriy.daniel.CRM.caseCreate.CreateCaseManually;
//import org.testng.annotations.BeforeMethod;
//
//
//public class LogOut {
//    private BrowserInitialization browserInitialization;
//    private CasesViewPage casesViewPage;
//    private CreateCaseManually createCaseManually;
//    private Page page;
//
//    @BeforeMethod
//    public void setUp() {
//        browserInitialization = BrowserInitialization.getInstance();
//        createCaseManually = new CreateCaseManually();
//        createCaseManually.setUpBrowser();
//        casesViewPage = browserInitialization.casesViewPage;
//    }
//
//    public void logOutUser(){
//        page.locator("body > div.container.body > div > div.top_nav > div > nav > ul > li.nav-item.dropdown.open.show > a").click();
//        page.locator("body > div.container.body > div > div.top_nav > div > nav > ul > li.nav-item.dropdown.open.show > ul > li:nth-child(2) > a").click();
//    }
//
//}
