package stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import invocation.BrowserInvoke;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TaggedHooks extends BrowserInvoke{

	public static Scenario scenario;
	
	/**
	 * This method is used to invoke the chrome/firefox browser and run before the first
	 * step of each scenario
	 *
	 * @author meghnad
	 */
	@Before
	public void beforeFirst(Scenario scenario) {
		TaggedHooks.scenario=scenario;
		scenario.log("***Initiliaze the browser***");
        finalDriver = BrowserInvoke.browserInitialise();
	}

	/**
	 * This method is used to close the browser and run after the last step of each
	 * scenario
	 *
	 * @author meghnad
	 */
	@After
	public void afterFirst(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.log("***Take the screenshot for failed test cases***");
			TakesScreenshot s = (TakesScreenshot) finalDriver;
			byte[] screenshot = s.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Screenshot attached");
		}
		scenario.log("***Close the browser***");
		finalDriver.quit();
	}
}
