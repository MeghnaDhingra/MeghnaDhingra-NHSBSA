package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import invocation.BrowserInvoke;
import stepdefinition.TaggedHooks;
import utility.CommonUtility;

public class NhsJobsPage extends BrowserInvoke {

	public NhsJobsPage() {
		PageFactory.initElements(finalDriver, this);
	}

	/*
	 * Navigate to NHS Jobs Search Page
	 *
	 * @author meghnad
	 */
	public void navigateToUrl() {
		try {
			TaggedHooks.scenario.log("***Navigate to NHS Jobs Search Page***");
			finalDriver.navigate().to(CommonUtility.getPropertyValue("./data/config.properties", "nhsJobsUrl"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Click on Cookies Agreement button
	 *
	 * @author meghnad
	 */
	public void clickAnalyticsCookies() {
		try {
			TaggedHooks.scenario.log("***Click on Analystics Cookies button to Accept***");
			if(acceptCookiesButton.isDisplayed()) {
				acceptCookiesButton.click();}
			CommonUtility.waitForElementToBeVisibleFastAndFluent(finalDriver, 100, searchButton);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Verify the title of NHS Jobs Search Page
	 *
	 * @author meghnad
	 * @return String
	 */
	public String verifyTitleOfJobSearchPage() {
		String actualTitle = null;
		try {
			TaggedHooks.scenario.log("***Verify the title of landing page NHS Jobs Search***::"+titleNHSJobsPage.getText());
			actualTitle = titleNHSJobsPage.getText();
		}	
		catch(Exception e) {
			e.printStackTrace();
		}return actualTitle;

	}

	/*
	 * Enter the value in job title text box
	 *
	 * @author meghnad
	 * @paran String
	 */
	public void enterJobTitle(String jobTitle) {
		try {
			TaggedHooks.scenario.log("***Enter the value in job title text box***");
			jobTitleTextBox.sendKeys(jobTitle);
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Enter the value in job location text box
	 *
	 * @author meghnad
	 * @paran String
	 */
	public void enterJobLocation(String jobLocation) {
		try {
			TaggedHooks.scenario.log("***Enter the value in job location text box***");
			jobLocationTextBox.sendKeys(jobLocation);
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Enter the value in job reference text box
	 *
	 * @author meghnad
	 * @paran String
	 */
	public void enterJobReferenceNumber(String jobReference) {
		try {
			TaggedHooks.scenario.log("***Enter the value in job reference text box***");
			jobReferenceTextBox.sendKeys(jobReference);
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Enter the value in employer name text box
	 *
	 * @author meghnad
	 * @paran String
	 */
	public void enterEmployerName(String employerName) {
		try {
			TaggedHooks.scenario.log("***Enter the value in employer name text box***");
			employerNameTextBox.sendKeys(employerName);
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Select the value from pay range drop down
	 *
	 * @author meghnad
	 * @paran String
	 */
	public void selectPayRangeDropDown(String payrange) { 
		try {
			TaggedHooks.scenario.log("***Select the value from pay range drop down***");
			Select select = new Select(payRangeDropDown);
			select.selectByValue(payrange);
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Click on More Search options button or link to see the job reference and employer text box
	 *
	 * @author meghnad
	 */
	public void clickMoreSearchOptions() {
		try {
			TaggedHooks.scenario.log("***Click on More Search options button or link to see the job reference and employer text box***");
			moreSearchOptionsButton.click();
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Click on Search button
	 *
	 * @author meghnad
	 */
	public void clickSearchButton() {
		try {
			TaggedHooks.scenario.log("***Click on Search button***");
			searchButton.click();
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Verify the list of jobs searched is visible
	 *
	 * @author meghnad
	 * @return int
	 */
	public int verifyJobsResult() {
		int numberOfJobsSearched=0;
		try {
			TaggedHooks.scenario.log("***Verify the list of jobs searched is visible***");
			numberOfJobsSearched = listResultNhsJobs.size();
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		return numberOfJobsSearched;
	}

	/*
	 * Verify the total number of jobs searched and count should be fetched from title
	 *
	 * @author meghnad
	 * @return int
	 */
	public int getTotalNumberOfJobFetched() {
		int jobCount=0;
		try {
			TaggedHooks.scenario.log("***Verify the total number of jobs searched and count should be fetched from title***"+totalSearchJobCount.getText());
			String totalJobsCount = totalSearchJobCount.getText();
			jobCount = Integer.parseInt(totalJobsCount);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jobCount;
	}

	/*
	 * Verify the error message when we insert the special characters in preferences
	 *
	 * @author meghnad
	 * @return String
	 */
	public String getErrorMessageofJobSearch() {
		String actualErrorMessage=null;
		try {
			TaggedHooks.scenario.log("***Verify the error message when we insert the special characters in preferences***"+messageJobSearch.getText());
			actualErrorMessage = messageJobSearch.getText();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return actualErrorMessage;
	}

	/*
	 * Verify the title of jobs searched
	 *
	 * @author meghnad
	 * @return String
	 */
	public String getTitleOfJobSearched() {
		String actualTitleOfJobSearched = null;
		try {
			TaggedHooks.scenario.log("***Verify the title of jobs searched***"+messageJobSearch.getText());
			actualTitleOfJobSearched = messageJobSearch.getText();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return actualTitleOfJobSearched;
	}

	/*
	 * Select the distance of your jobs search with the help of drop down
	 *
	 * @author meghnad
	 * @param String
	 */
	public void enterDistanceJobsSearchArea(String distance) {
		try {
			TaggedHooks.scenario.log("***Select the distance of your jobs search with the help of drop down***");
			Select select = new Select(distanceTextBox);
			select.selectByValue(distance);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Click on Contract Type expander to refine our search
	 *
	 * @author meghnad
	 */
	public void clickContractTypeExpander()
	{
		try {
			TaggedHooks.scenario.log("***Click on Contract Type expander to refine our search***");
			CommonUtility.scrollPageTillElement(finalDriver, contractTypeExpander);
			contractTypeExpander.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Select one of the contract type from the list
	 *
	 * @author meghnad
	 */
	public void selectOneContractType()  {
		try {
			TaggedHooks.scenario.log("***Select one of the contract type from the list***");
			contractTypePermanent.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Click on Working Pattern expander to refine our search
	 *
	 * @author meghnad
	 */
	public void clickWorkingPatternExpander()
	{
		try {
			TaggedHooks.scenario.log("***Click on Working Pattern expander to refine our search***");
			CommonUtility.scrollPageTillElement(finalDriver, workingTypeExpander);
			workingTypeExpander.click();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Select one of the Working pattern from the list
	 *
	 * @author meghnad
	 */
	public void selectOneWorkingPattern() {
		try {
			TaggedHooks.scenario.log("***Select one of the Working pattern from the list***");
			workingTypeFullTime.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Select one of the NHS Pay Band from the list
	 *
	 * @author meghnad
	 */
	public void selectOneNhsPayGrade() {
		try {
			TaggedHooks.scenario.log("***Select one of the NHS Pay Band from the list***");
			nhsPayBand2Value.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Click on Working Pattern expander to refine our search
	 *
	 * @author meghnad
	 */
	public void clickNhsPayBandExpander() {
		try {
			TaggedHooks.scenario.log("***Click on Working Pattern expander to refine our search***");
			nhsPayBandExpander.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Click on apply filter button to refine your search
	 *
	 * @author meghnad
	 */
	public void clickApplyFilterButton() {	
		try {
			TaggedHooks.scenario.log("***Click on apply filter button to refine your search***");
			CommonUtility.scrollPageTillElement(finalDriver, applyFilterButton);
			applyFilterButton.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Verify the Contract type of all jobs searched after applying filter
	 *
	 * @author meghnad
	 * @return List<String>
	 * 
	 */
	public List<String> receiveNhsJobsContractTypeResult() {
		List<String> li = new ArrayList<String>();
		try {
			TaggedHooks.scenario.log("***Verify the Contract type of all jobs searched after applying filter***");
			for (int i = 0; i < listResultPermanentJobsSearch.size(); i++) {
				li.add(listResultPermanentJobsSearch.get(i).getText());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	/*
	 * Verify the Working Pattern of all jobs searched after applying filter
	 *
	 * @author meghnad
	 * @return List<String>
	 * 
	 */
	public List<String> receiveNhsJobsWorkingPatternResult() {
		List<String> li = new ArrayList<String>();
		try {
			TaggedHooks.scenario.log("***Verify the Working Pattern of all jobs searched after applying filter***");
			for (int i = 0; i < listResultFullTimePartTimeJobsSearch.size(); i++) {
				li.add(listResultFullTimePartTimeJobsSearch.get(i).getText());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	/*
	 * Select the Newest date posted option from Drop down
	 *
	 * @author meghnad
	 */
	public void selectDatePostedNewestFromDropDown() throws InterruptedException {
		TaggedHooks.scenario.log("***Select the Newest date posted option from Drop down***");
		Select select = new Select(sortByDropDown);
		select.selectByValue("publicationDateDesc");
		Thread.sleep(5000);
	}

	/*
	 * Verify that jobs searched is in sorted order
	 *
	 * @author meghnad
	 * @return List<String>
	 */
	public List<String> verifySearchResultSortedOrder() throws InterruptedException{
		TaggedHooks.scenario.log("***Verify that jobs searched is in sorted order***");
		List<String> listDate = new ArrayList<String>();
		List<WebElement> li = listSearchJobs ;
		for(int i=0;i<li.size();i++) {
			Select select = new Select(sortByDropDown);
			select.selectByValue("publicationDateDesc");
			CommonUtility.scrollPageTillElement(finalDriver, li.get(i));
			li.get(i).click();
			Thread.sleep(1000);
			CommonUtility.waitForElementToBeVisibleFastAndFluent(finalDriver, 2000, datePosted);
			listDate.add(datePosted.getText());
			finalDriver.navigate().back();
			Thread.sleep(1000);
			CommonUtility.waitForElementToBeVisibleFastAndFluent(finalDriver, 2000, sortByDropDown);
		}
		return CommonUtility.convertListStringToListDate(listDate);
	}

	/*
	 * Verify that NHS Pay band for all Jobs Searched
	 *
	 * @author meghnad
	 * @return List<String>
	 */
	public List<String> verifyNhsPayBandForAllJobsSearched() throws InterruptedException{
		TaggedHooks.scenario.log("***Verify that NHS Pay band for all Jobs Searched***");
		List<String> listPayBand = new ArrayList<String>();
		List<WebElement> li = listSearchJobs ;
		for(int i=0;i<li.size();i++) {
			Select select = new Select(sortByDropDown);
			select.selectByValue("publicationDateDesc");
			CommonUtility.scrollPageTillElement(finalDriver, li.get(i));
			li.get(i).click();
			Thread.sleep(1000);
			CommonUtility.waitForElementToBeVisibleFastAndFluent(finalDriver, 2000, nhsPayBand);
			listPayBand.add(nhsPayBand.getText());
			finalDriver.navigate().back();
			Thread.sleep(1000);
			CommonUtility.waitForElementToBeVisibleFastAndFluent(finalDriver, 2000, sortByDropDown);
		}
		return listPayBand;
	}

	@FindBy(id="accept-cookies")
	WebElement acceptCookiesButton;
	@FindBy(id="search")
	WebElement searchButton;
	@FindBy(xpath = "//*[@id='heading']/h1")
	WebElement titleNHSJobsPage;
	@FindBy(id="keyword")
	WebElement jobTitleTextBox;
	@FindBy(id="location")
	WebElement jobLocationTextBox;
	@FindBy(id="distance")
	WebElement distanceTextBox;
	@FindBy(id="searchOptionsBtn")
	WebElement moreSearchOptionsButton;
	@FindBy(id="employer")
	WebElement employerNameTextBox;
	@FindBy(xpath = "//*[@class='nhsuk-heading-l']")
	WebElement messageJobSearch;
	@FindBy(id="payRange")
	WebElement payRangeDropDown;
	@FindBy(id="jobReference")
	WebElement jobReferenceTextBox;
	@FindAll(@FindBy(xpath = "//ul[@class='nhsuk-list search-results']/li"))
	List<WebElement> listResultNhsJobs;
	@FindBy(xpath = "//*[@class='nhsuk-heading-l']/span")
	WebElement totalSearchJobCount;
	@FindBy(xpath = "//*[@data-test='filter-contract-type']")
	WebElement contractTypeExpander;
	@FindBy(xpath = "//*[@data-test='filter-working-pattern']")
	WebElement workingTypeExpander;
	@FindBy(id="contract-type-permanent")
	WebElement contractTypePermanent;
	@FindBy(id="working-pattern-full-time")
	WebElement workingTypeFullTime;
	@FindBy(id="working-pattern-part-time")
	WebElement workingTypePartTime;
	@FindBy(id="refine-search")
	WebElement applyFilterButton;
	@FindAll(@FindBy(xpath = "//li[@data-test='search-result-jobType']/strong"))
	List<WebElement> listResultPermanentJobsSearch;
	@FindAll(@FindBy(xpath = "//li[@data-test='search-result-workingPattern']/strong"))
	List<WebElement> listResultFullTimePartTimeJobsSearch;
	@FindBy(id="sort")
	WebElement sortByDropDown;
	@FindAll(@FindBy(xpath = "//a[@data-test='search-result-job-title']"))
	List<WebElement> listSearchJobs;
	@FindBy(xpath = "//div[@class='hide-mobile']//p[@id='date_posted']")
	WebElement datePosted;
	@FindBy(xpath = "//*[@data-test='filter-pay-band']")
	WebElement nhsPayBandExpander;
	@FindBy(id="pay-band-2")
	WebElement nhsPayBand2Value;
	@FindBy(xpath = "//div[@class='hide-mobile']//p[@id='payscheme-band']")
	WebElement nhsPayBand;
}
