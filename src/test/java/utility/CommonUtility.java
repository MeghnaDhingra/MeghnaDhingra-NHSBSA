package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CommonUtility {
	 
	/**
     * This method is used to get the values from configuration file.
     *
     * @author meghnad
     * @param String, String
     * @return String
     */
    public static String getPropertyValue(String fileName, String propertyName) {
        Properties properties = new Properties();
        try {
            String current = new java.io.File(".").getCanonicalPath();
            fileName = fileName.replace("./", "/");
            InputStream inputStream = new FileInputStream(current + fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
        return properties.getProperty(propertyName);
    }

    /**
     * This method is used to wait for the element.
     *
     * @author meghnad
     * @param WebDriver, int, WebElement
     */
    public static void waitForElementToBeVisibleFastAndFluent(WebDriver driver, int timeout, WebElement element) {
        FluentWait<WebDriver> wait =
                new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(timeout)).pollingEvery(Duration.ofMillis(10)).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method is used to scroll the page till the element found.
     *
     * @author meghnad
     * @param WebDriver, WebElement
     */
    public static void scrollPageTillElement(WebDriver driver, WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
    }
    
    /**
     * This method is used to convert the string ArrayList into date.
     *
     * @author meghnad
     * @param List<String>
     * @return List<String>
     */
    public static List<String> convertListStringToListDate(List<String> actualListFromUIInString) {
    	List<String> actualListFromUIInDateFormat = new ArrayList<String>();
		for(int i=0;i<actualListFromUIInString.size();i++) {
			DateTimeFormatter form = DateTimeFormatter.ofPattern("dd MMMM yyyy",Locale.ENGLISH);
			LocalDate date=LocalDate.parse(actualListFromUIInString.get(i), form);
			actualListFromUIInDateFormat.add(date.toString());
			}
		return actualListFromUIInDateFormat;		
    }
}

