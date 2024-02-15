//version4

package Dmitriy.Daniel.config;

import Dmitriy.Daniel.pages.CasesCreatePage;
import Dmitriy.Daniel.pages.CasesViewPage;
import Dmitriy.Daniel.pages.SiteLoginPage;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserInitialization {
    private static BrowserInitialization instance;
    private final Browser browser;
    private final Playwright playwright;
    public final Page page;

    public CasesViewPage casesViewPage;
    public CasesCreatePage casesCreatePage;
    public SiteLoginPage siteLoginPage;

    private BrowserInitialization() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions());
        page = browserContext.newPage();
        page.setViewportSize(1920, 1080);

        casesViewPage = new CasesViewPage(page);
        casesCreatePage = new CasesCreatePage(page);
        siteLoginPage = new SiteLoginPage(page);
    }

    public static BrowserInitialization getInstance() {
        if (instance == null) {
            synchronized (BrowserInitialization.class) {
                if (instance == null) {
                    instance = new BrowserInitialization();
                }
            }
        }
        return instance;
    }

    @BeforeSuite
    public void setup() {
        // Setup code here, but it's already done in the constructor
    }

    @AfterSuite
    public void close() {
        page.context().close();
        browser.close();
        playwright.close();
    }

    // Removed @AfterMethod for closing browser and page, as it's already handled in @AfterSuite
}


//VERSION3
//package Dmitriy.Daniel.config;
//
//import Dmitriy.Daniel.pages.CasesCreatePage;
//import Dmitriy.Daniel.pages.CasesViewPage;
//import Dmitriy.Daniel.pages.SiteLoginPage;
//import com.microsoft.playwright.*;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//
//public class BrowserInitialization {
//    private static BrowserInitialization instance;
//
//    public CasesViewPage casesViewPage;
//    public CasesCreatePage casesCreatePage;
//    public SiteLoginPage siteLoginPage;
//
//    public Page page;
//    protected Playwright playwright;
//    protected Browser browser;
//
//
//    private BrowserInitialization() {
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//    }
//
//    public static BrowserInitialization getInstance() {
//        if (instance == null) {
//            instance = new BrowserInitialization();
//        }
//        return instance;
//    }
//
//    @BeforeSuite
//    public void setup() {
//        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions());
//        page = browserContext.newPage();
//        page.setViewportSize(1920, 1080);
//
//        casesViewPage = new CasesViewPage(page);
//        casesCreatePage = new CasesCreatePage(page);
//        siteLoginPage = new SiteLoginPage(page);
//    }
//
//    @AfterSuite
//    public void close() {
//        page.context().close();
//    }
//
//    @AfterMethod
//    public void closeBrowser() {
//        browser.close();
//        playwright.close();
//    }
//    @AfterMethod
//    public void closePage() {
//        page.close();
//    }
//}










//VARSION 2
//package Dmitriy.Daniel.config;
//
//import Dmitriy.Daniel.pages.CasesCreatePage;
//import Dmitriy.Daniel.pages.CasesViewPage;
//import Dmitriy.Daniel.pages.SiteLoginPage;
//
//import com.microsoft.playwright.*;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//
//public class BrowserInitialization {
//    protected CasesViewPage casesViewPage;
//    protected CasesCreatePage casesCreatePage;
//    protected SiteLoginPage siteLoginPage;
//
//
//    protected Page page;
//    Playwright playwright;
//    Browser browser;
//
//    @BeforeSuite
//    public void setUpBrowser() {
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//    }
//
//    @BeforeMethod
//    public void setup() {
//        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions());
//        page = browserContext.newPage();
//        page.setViewportSize(1920, 1080);
//
//        casesViewPage = new CasesViewPage(page);
//        casesCreatePage = new CasesCreatePage(page);
//        siteLoginPage = new SiteLoginPage(page);
//    }
//
//    @AfterMethod
//    public void close() {
//        page.context().close();
//    }
//
//    @AfterSuite
//    public void closeBrowser() {
//        browser.close();
//        playwright.close();
//    }
//}


////VARSION 1
//package Dmitriy.Daniel.config;
//
//import com.microsoft.playwright.*;
//import groovy.util.logging.Slf4j;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeTest;
//
//@Slf4j
//public class BrowserInitialization {
//    private static BrowserInitialization instance = null;
//    private BrowserContext browser;
//    private Page page;
//    private Playwright playwright;
//
//    private Browser.NewContextOptions browserContext = new Browser.NewContextOptions()
//            .setViewportSize(1920, 1080);
//
//    private
//    BrowserInitialization() {
//        try {
//            playwright = Playwright.create();
//            Browser browserInstance = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//            browser = browserInstance.newContext(browserContext);
//            page = browser.newPage();
//        } catch (Exception e) {
////            log.error("Ошибка при инициализации браузера: ", e);
//        }
//    }
//
//    @BeforeTest
//    public static BrowserInitialization getInstance() {
//        if (instance == null) {
//            instance = new BrowserInitialization();
//        }
//        return instance;
//    }
//
//    public Page getPage() {
//        return page;
//    }
//
//    @AfterMethod
//    public void close() {
//        if (page != null) {
//            page.context().close();
//        }
//    }
//
//    @AfterSuite
//    public void closeBrowser() {
//        if (browser != null) {
//            browser.close();
//            playwright.close();
//        }
//
//    }
//}










