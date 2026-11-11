
package base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeClass(alwaysRun = true)
    public void launchBrowser() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        System.out.println("Browser launched successfully");
    }

    @BeforeMethod(alwaysRun = true)
    public void createBrowserContext() {

        context = browser.newContext();

        page = context.newPage();

        System.out.println("New browser context created");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowserContext() {

        if (context != null) {
            context.close();
        }

        System.out.println("Browser context closed");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }

        System.out.println("Browser closed");
    }
}
