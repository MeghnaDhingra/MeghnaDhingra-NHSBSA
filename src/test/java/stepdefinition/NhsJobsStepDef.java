package stepdefinition;

import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NhsJobsPage;

public class NhsJobsStepDef  {

	NhsJobsPage nhsJobPage = new NhsJobsPage();
	
	@Given("Open the NHS Jobs URL")
	public void open_the_nhs_jobs_url() {
		nhsJobPage.navigateToUrl(); 
	}

	@And("Accept the analytics cookies")
	public void accept_the_analytics_cookies() {
		nhsJobPage.clickAnalyticsCookies();
	}

	@Given("I am landing on NHS Jobs page")
	public void i_am_landing_on_nhs_jobs_page() {
		String actualTitle = nhsJobPage.verifyTitleOfJobSearchPage();
		Assert.assertEquals(actualTitle.trim(),"Search for jobs in the NHS");
	}

	@When("I put my preferences into text boxes for search functionality as (.*), (.*),(.*), (.*), (.*), (.*)$")
	public void i_put_my_preferences_into_text_boxes_for_search_functionality_as(String jobTitle, String location, String distance, String jobReference, String employer, String payRange) {
	    	  nhsJobPage.enterJobTitle(jobTitle);
	    	  nhsJobPage.enterJobLocation(location);
	    	  if(location.isBlank()==false) {
	    		  nhsJobPage.enterDistanceJobsSearchArea(distance.trim());
	    	  }
		      nhsJobPage.clickMoreSearchOptions();
		      nhsJobPage.enterJobReferenceNumber(jobReference);
		      nhsJobPage.enterEmployerName(employer);
	 	      nhsJobPage.selectPayRangeDropDown(payRange);
	   }
	
	@When("I click on Search button")
	public void i_click_on_search_button() {
		nhsJobPage.clickSearchButton();	}


	@Then("I should get a list of jobs which matches my preferences and number of jobs searched should be equal to {int} or more than {int}")
	public void i_should_get_a_list_of_jobs_which_matches_my_preferences_and_number_of_jobs_searched_should_be_equal_to_or_more_than(Integer int1, Integer int2) {
	Assert.assertTrue(nhsJobPage.verifyJobsResult()>=1);
    Assert.assertTrue(nhsJobPage.getTotalNumberOfJobFetched()>=1);
	}

	@Then("I should get a output as (.*)$")
	public void i_should_get_a_output_as_(String output) {
		Assert.assertTrue(nhsJobPage.getErrorMessageofJobSearch().contains(output));
	}

	@Then("Verify the title of jobs searched as (.*)$")
	public void verify_the_title_of_jobs_searched_as(String output) {
		Assert.assertTrue(nhsJobPage.getTitleOfJobSearched().contains(output));
	}
	
	@Then("select the filter as per our requirement as (.*), (.*), (.*)$")
	public void select_the_filter_as_per_our_requirement_as(String workingPattern, String contractType, String nhsPayGrade)  {
		if(contractType.isBlank()==false) {
		nhsJobPage.clickContractTypeExpander();
		nhsJobPage.selectOneContractType();
		}
		else if(workingPattern.isBlank()==false) {
			nhsJobPage.clickWorkingPatternExpander();
			nhsJobPage.selectOneWorkingPattern();
		}	
		else if(nhsPayGrade.isBlank()==false) {
			nhsJobPage.clickNhsPayBandExpander();
			nhsJobPage.selectOneNhsPayGrade();
		}	
	}
	
	@Then("Click on apply filter button")
	public void click_on_apply_filter_button() {
		nhsJobPage.clickApplyFilterButton();
	}
	    

	@Then("Verify the working pattern and contract type for all searched jobs (.*), (.*), (.*)$")
	public void verify_the_working_pattern_and_contract_type_for_all_searched_jobs(String workingPattern, String contractType, String nhsPayGrade) throws InterruptedException {
		if(contractType.isBlank()==false) {
		List<String> li=nhsJobPage.receiveNhsJobsContractTypeResult();
		for (int i = 0; i < li.size(); i++) {
			Assert.assertEquals(li.get(i).trim(),contractType.trim());	
		   }
		}
		else if(workingPattern.isBlank()==false) {
			List<String> li=nhsJobPage.receiveNhsJobsWorkingPatternResult();
			for (int i = 0; i < li.size(); i++) {
				Assert.assertTrue(li.get(i).contains(workingPattern));
			   }
			}
		else if(nhsPayGrade.isBlank()==false) {
			List<String> li=nhsJobPage.verifyNhsPayBandForAllJobsSearched();
			for (int i = 0; i < li.size(); i++) {
				Assert.assertTrue(li.get(i).trim().equals(nhsPayGrade.trim()));
			   }
			}
		
	}
	
	@Then("Sort my search results with the newest date posted with the help of Sort By Dropdown")
	public void sort_my_search_results_with_the_newest_date_posted_with_the_help_of_sort_by_dropdown() throws InterruptedException {
		nhsJobPage.selectDatePostedNewestFromDropDown();
	}

	@Then("Verify the search results should be in sorted order")
	public void verify_the_search_results_should_be_in_sorted_order() throws InterruptedException {
		List<String> actualListFromUIInDateFormat=nhsJobPage.verifySearchResultSortedOrder();
		Collections.sort(actualListFromUIInDateFormat, Collections.reverseOrder());
		Assert.assertEquals(actualListFromUIInDateFormat,actualListFromUIInDateFormat);
	 }


}
