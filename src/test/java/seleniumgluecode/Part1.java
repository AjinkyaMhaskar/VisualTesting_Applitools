package seleniumgluecode;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import commonFunctions.CommonUIFunctions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import pages.mainpage;
import runner.TestRunner;

public class Part1 {
	@Given("^I navigate to the main page of the application$")
	public void i_navigate_to_the_main_page_of_the_application() throws Throwable {
		// do nothing, Framework automatically navigates to the base URL
		String windowTitle = TestRunner.driver.getTitle();
		Assert.assertEquals(ConfigFileReader.getMainPageTitle(), windowTitle);
	}

	@Then("^Use Applitools Eyes, take a screenshot of the entire page and save using following information for Main Page\\.$")
	public void use_Applitools_Eyes_take_a_screenshot_of_the_entire_page_and_save_using_following_information_for_Main_Page(
			DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		TestRunner.validateWindow(data);
	}

	@When("^I Check Black under the colors filter and click the Filter button\\.$")
	public void i_Check_Black_under_the_colors_filter_and_click_the_Filter_button() throws Throwable {
		mainpage.filter_color_black().click();
		mainpage.filter_button().click();
	}

	@Then("^I verify two black shoes, take a screenshot of the product grid with id \"([^\"]*)\" and save using following information for Filtered Product Grid\\.$")
	public void i_verify_two_black_shoes_take_a_screenshot_of_the_product_grid_with_id_and_save_using_following_information_for_Filtered_Product_Grid(
			String locator, DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		TestRunner.validateRegion(data, By.id(locator));
		Assert.assertEquals(2, CommonUIFunctions.getShoeCount());
	}

	@When("^I click on click on the Appli Air x Night shoe\\.$")
	public void i_click_on_click_on_the_Appli_Air_x_Night_shoe() throws Throwable {
		mainpage.product_Appli_Air_x_Night_shoe().click();
	}

	@Then("^I get navigated to product detail page, take a screenshot of the PDP and save using following information for Product Details\\.$")
	public void i_get_navigated_to_product_detail_page_take_a_screenshot_of_the_PDP_and_save_using_following_information_for_Product_Details(
			DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		TestRunner.validateWindow(data);
	}
}
