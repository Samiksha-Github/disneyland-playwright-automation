
package tests;

import base.BaseTest;
import pages.DisneylandHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisneylandHomePageTest extends BaseTest {

    @Test
    public void verifyDisneylandHomepage() {

        // Create Page Object
        DisneylandHomePage homePage =
                new DisneylandHomePage(page);

        // Navigate to homepage
        homePage.navigateToHomePage();

        // Get page details
        String title = homePage.getPageTitle();
        String url = homePage.getCurrentUrl();

        System.out.println("Page Title: " + title);
        System.out.println("Current URL: " + url);

        // Assertions
        Assert.assertTrue(
                title.toLowerCase().contains("disneyland"),
                "Homepage title validation failed"
        );

        Assert.assertTrue(
                url.contains("disneyland.disney.go.com"),
                "Incorrect homepage URL"
        );
    }

    @Test
    public void verifyHomepageURL() {

        DisneylandHomePage homePage =
                new DisneylandHomePage(page);

        homePage.navigateToHomePage();

        Assert.assertTrue(
                homePage.getCurrentUrl()
                        .startsWith("https://disneyland.disney.go.com"),
                "Homepage URL is incorrect"
        );
    }
}
