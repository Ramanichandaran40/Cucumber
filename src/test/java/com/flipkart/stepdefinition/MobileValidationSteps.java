package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class MobileValidationSteps {
	static long startTime;
	static String name1;
	static String mn;
	@Given("user login by entering valid credentials")
	public void user_login_by_entering_valid_credentials() {
		WebElement btn = Hooks.driver.findElement(By.xpath("//button[text() ='✕']"));
		btn.click();
	}

	@When("user search mobile")
	public void user_search_mobile() {
		mn = "Redmi Mobile";
		WebElement search = Hooks.driver.findElement(By.name("q"));
		search.sendKeys(mn,Keys.ENTER);
	    	}

	@When("user click mobile name")
	public void user_click_mobile_name() {
		WebElement mobileName1 = Hooks.driver.findElement(By.xpath("(//div[@class ='_4rR01T'])[1]"));
		name1 = mobileName1.getText();
		System.out.println(name1);
		mobileName1.click();
	}

	@Then("user validates the mobile")
	public void user_validates_the_mobile() {
		String pWin = Hooks.driver.getWindowHandle();
		Set <String> cWin = Hooks.driver.getWindowHandles();
		for(String x:cWin) {
			if(!pWin.equals(x)) {
				Hooks.driver.switchTo().window(x);
			}
		}
		WebElement mobileName2 = Hooks.driver.findElement(By.xpath("//span[@class ='B_NuCI']"));
		String name2 = mobileName2.getText();
				System.out.println(name2);
				//Assert.assertEquals(name1, name2);
				Hooks.driver.quit();
	}
	@When("user search mobile by one dimensilnal list")
	public void user_search_mobile_by_one_dimensilnal_list(DataTable dataTable) {
	   List<String> datas = dataTable.asList();
	   mn= datas.get(0);
	   WebElement search = Hooks.driver.findElement(By.name("q"));
		search.sendKeys(mn,Keys.ENTER);
	   
	}
	@When("user search mobile by one dimensilnal map")
	public void user_search_mobile_by_one_dimensilnal_map(DataTable dataTable) {
		Map <String, String> datas = dataTable.asMap(String.class, String.class);
		mn = datas.get("2");
		WebElement search = Hooks.driver.findElement(By.name("q"));
		search.sendKeys(mn,Keys.ENTER);
	}
	@When("user search mobile {string}")
	public void user_search_mobile(String phone) {
		mn = phone;
		WebElement search = Hooks.driver.findElement(By.name("q"));
		search.sendKeys(mn,Keys.ENTER);
	}
}
