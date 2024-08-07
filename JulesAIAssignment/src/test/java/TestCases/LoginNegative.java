package TestCases;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginNegative {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		PlaywrightAssertions.setDefaultAssertionTimeout(10_000);
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
				.setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		BrowserContext bowsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1536, 730));
		Page page = bowsercontext.newPage();
		page.navigate("https://demo.haroldwaste.com/");
		assertThat(page).hasURL("https://demo.haroldwaste.com/authentication");
		assertThat(page.locator("#root > div > div:nth-child(2) > div > div > p:nth-child(1)")).hasText("Log in");
		page.locator("[type=email]").type("qa@julesai.com");
		page.locator("[type=password]").type("WrongPassword");
		page.click("button:has-text('Log in')");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page.onDialog(dialog -> {
			
			System.out.println(dialog.message());
			
		});
		page.close();
		playwright.close();
	}

}
