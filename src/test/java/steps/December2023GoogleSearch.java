package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.GoogleBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PageObjects;

public class December2023GoogleSearch extends GoogleBase{
	
	PageObjects po;
	
	
	
	@Given("I am on Google homepage")
	public void i_am_on_google_homepage() {
		
		//call the lauchBrowser
		lauchBrowser();
	}

	@When("I enter the search {string}")
	public void i_enter_the_search(String string) {
		
		//step 1:identify or locate the element
		//8 locators: id, name, class name, html tag,link text, partial link text, xpath, css selector
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		
		
		//step 2:perform the action
		searchBox.sendKeys(string);
		po = new PageObjects(driver);
		po.enterSearch(string);
	    
	}

	@When("I click Search button")
	public void i_click_search_button() {
		
		WebElement searchButton = driver.findElement(By.name("btnK"));
		
		po.clicksearch();
	    
	}

	@Then("I receive the result")
	public void i_receive_the_result() {
		
		WebElement result = driver.findElement(By.id("result-stats"));
		String myResult = result.getText();
		
		System.out.println("***************************");
		System.out.println(myResult);
		System.out.println("***************************");
		
		closeBrowser();
		
		
	    
	}


}
