package Dmitriy.Daniel.config;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BrowserInitial {
    private static Browser browser;
    private static BrowserContext browserContext;
    protected static Page page;

    public static void initializeBrowser() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch();
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
    }

    public static void closeBrowserContext() {
        if (browserContext != null) {
            browserContext.close();
        }
    }

    public static void closePage() {
        if (page != null) {
            page.close();
        }
    }

    public static void closeBrowsersAndContext() {
        closePage();
        closeBrowserContext();
        closeBrowser();
    }
}



    //==============================================================
//    Playwright playwright = Playwright.create();
//    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//    BrowserContext context = browser.newContext();
//    protected Page page = context.newPage();

//==============================================================
//    private static Browser browser;
//    private static BrowserContext browserContext;
//    protected static Page page;
//
//    public static void initializeBrowser() {
//        Playwright playwright = Playwright.create();
//        browser = playwright.chromium().launch();
//        browserContext = browser.newContext();
//        page = browserContext.newPage();
//    }
//
//    public static void closeBrowser() {
//        if (browser != null) {
//            browser.close();
//        }
//    }
//
//    public static void closeBrowserContext() {
//        if (browserContext != null) {
//            browserContext.close();
//        }
//    }
//
//    public static void closePage() {
//        if (page != null) {
//            page.close();
//        }
//    }
//
//    public static void closeBrowsersAndContext() {
//        closePage();
//        closeBrowserContext();
//        closeBrowser();
//    }




