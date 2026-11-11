
package pages;

import com.microsoft.playwright.Page;

public class DisneylandHomePage {

    private final Page page;

    // Constructor
    public DisneylandHomePage(Page page) {
        this.page = page;
    }

    // Navigate to Disneyland homepage
    public void navigateToHomePage() {
        page.navigate("https://disneyland.disney.go.com/");
    }

    // Get page title
    public String getPageTitle() {
        return page.title();
    }

    // Get current URL
    public String getCurrentUrl() {
        return page.url();
    }
}
