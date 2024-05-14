Feature: I want to search a jobs on NHS Jobs website with my preferences

  Background: Navigate to NHS Jobs Website
    Given Open the NHS Jobs URL
    And Accept the analytics cookies

  Scenario Outline: Search the jobs on NHS jobs website with different preferences and sort the result with newest date posted
    Given I am landing on NHS Jobs page
    When I put my preferences into text boxes for search functionality as <jobTitle>, <location>, <distance>, <jobReference>, <employer>, <payRange>
    And I click on Search button
    Then I should get a list of jobs which matches my preferences and number of jobs searched should be equal to 1 or more than 1
    And Verify the title of jobs searched as <output>
    And Sort my search results with the newest date posted with the help of Sort By Dropdown
    And Verify the search results should be in sorted order

    Examples: 
      | jobTitle      | location            | distance | jobReference  | employer                       | payRange | output                                                         |
      |               |                     |          |               |                                |          | jobs found                                                     |
      | Nursing       |                     |          |               |                                |          | jobs found for Nursing                                         |
      |               | Newcastle Upon Tyne |        5 |               |                                |          | jobs found within 5 miles of Newcastle Upon Tyne               |
      |               |                     |          | B0150-24-0001 |                                |          | job found for B0150-24-0001                                    |
      |               |                     |          |               | NHS Business Service Authority |          | jobs found for NHS Business Service Authority                  |
      |               |                     |          |               |                                | 20-30    | jobs found                                                     |
      | Teaching      | Newcastle Upon Tyne |       10 |               |                                |          | jobs found for Teaching within 10 miles of Newcastle Upon Tyne |
      | Testing       | Newcastle Upon Tyne |       30 |        003839 |                                |          | job found for 003839                                           |
      | Customer Care | Newcastle Upon Tyne |       20 |        003839 | NHS                            | 50-60    | job found for 003839                                           |

  # Refine your Search
  Scenario Outline: Search the jobs on NHS jobs website and apply the filters or refine on your search
    Given I am landing on NHS Jobs page
    When I click on Search button
    Then I should get a list of jobs which matches my preferences and number of jobs searched should be equal to 1 or more than 1
    And select the filter as per our requirement as <workingPattern>, <contractType>, <nhsPayGrade>
    And Click on apply filter button
    And Sort my search results with the newest date posted with the help of Sort By Dropdown
    And Verify the search results should be in sorted order
    And Verify the working pattern and contract type for all searched jobs <workingPattern>, <contractType>, <nhsPayGrade>

    Examples: 
      | workingPattern | contractType | nhsPayGrade |
      |                | Permanent    |             |
      | Full time      |              |             |
      |                |              | Band 2      |

  #Negative Scenarios
  Scenario Outline: Search the jobs on NHS jobs website with special character
    Given I am landing on NHS Jobs page
    When I put my preferences into text boxes for search functionality as <jobTitle>, <location>,<distance>, <jobReference>, <employer>, <payRange>
    And I click on Search button
    Then I should get a output as <Output>

    Examples: 
      | jobTitle | location | distance | jobReference | employer | payRange | Output             |
      | wer$%#$  |          |          |              |          |          | No result found    |
      |          | erw@$    |        5 |              |          |          | Location not found |
      |          |          |          |              | ertt%#   |          | No result found    |
      |          |          |          | ertt%#       |          |          | No result found    |
