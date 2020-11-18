package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainpage extends runner.TestRunner {

	// Function to return Black color filter WebElement
	public static WebElement filter_color_black() {
		return driver.findElement(By.xpath("//span[@id='SPAN__checkmark__107']"));
	}

	// Function to return filter button WebElement
	public static WebElement filter_button() {
		return driver.findElement(By.xpath("//button[@id='filterBtn']"));
	}

	// Function to return product image WebElement
	public static WebElement product_Appli_Air_x_Night_shoe() {
		return driver.findElement(By.xpath("//img[@id='IMG__imgfluid__215']"));
	}
}
