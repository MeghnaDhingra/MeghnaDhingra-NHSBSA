package invocation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.CommonUtility;


public class BrowserInvoke extends CommonUtility
{
	public static WebDriver finalDriver = null;

	 /**
     * This method is used to initiate the browser with the help of configuration file.
     *
     * @author meghnad
     */
    public static WebDriver browserInitialise() {
        String browserIntialize = CommonUtility.getPropertyValue("./data/config.properties", "browser");
        WebDriver driver = null;
        if (browserIntialize.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}


