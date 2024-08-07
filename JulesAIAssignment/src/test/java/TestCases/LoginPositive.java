package TestCases;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

//import java.awt.Dimension;
//import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserContext;
//import com.microsoft.playwright.Page.TypeOptions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPositive {

	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		PlaywrightAssertions.setDefaultAssertionTimeout(10_000);
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		BrowserContext bowsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1536,730));
		Page page = bowsercontext.newPage();
		page.navigate("https://demo.haroldwaste.com/");
		assertThat(page).hasURL("https://demo.haroldwaste.com/authentication");
		assertThat(page.locator("#root > div > div:nth-child(2) > div > div > p:nth-child(1)")).hasText("Log in");
		page.locator("[type=email]").type("qa@julesai.com");
		page.locator("[type=password]").type("QaJULES2023!");
		page.click("button:has-text('Log in')");
		assertThat(page.locator("#root > div > div.headroom-wrapper > div > div > div:nth-child(2)")).hasText("Purchase & Opportunity list");
		page.click("#root > div > div.headroom-wrapper > div > div > div:nth-child(8) > div > div > div > div > div > div > div");
		page.click("#simple-popover > div.MuiPaper-root.MuiPopover-paper.MuiPaper-elevation8.MuiPaper-rounded > div > ul > li:nth-child(2) > div:nth-child(2)");
		assertThat(page.locator("#root > div > div:nth-child(2) > div > div > p:nth-child(1)")).hasText("Log in");
		page.close();
		playwright.close();
		
	}

}
