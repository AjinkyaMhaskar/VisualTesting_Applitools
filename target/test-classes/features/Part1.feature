#Author: mhaskar@adobe.com
#Keywords Summary :
#Feature: List of scenarios.

@tag
Feature: Automate the tests against the V1 version of this application.
 
  @tag1
    Scenario: Main Page test
    Given I navigate to the main page of the application
    Then Use Applitools Eyes, take a screenshot of the entire page and save using following information for Main Page. 
    | App Name     |Test name    |Step name   |
    | AppliFashion |Test 1		   |main page   |
   
  @tag2
    Scenario: Filtered Product Grid test
    When I Check Black under the colors filter and click the Filter button.
    Then I verify two black shoes, take a screenshot of the product grid with id "product_grid" and save using following information for Filtered Product Grid.
    | App Name     |Test name    |Step name       |
    | AppliFashion |Test 2		   |filter by color |

  @tag3
    Scenario: Product Details test
    When I click on click on the Appli Air x Night shoe.
    Then I get navigated to product detail page, take a screenshot of the PDP and save using following information for Product Details.
    | App Name     |Test name    |Step name       |
    | AppliFashion |Test 3		   |product details |