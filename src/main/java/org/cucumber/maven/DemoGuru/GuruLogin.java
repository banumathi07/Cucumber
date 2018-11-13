package org.cucumber.maven.DemoGuru;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GuruLogin {
	
	static WebDriver driver;
	
	@Given("^The user is in guru login page$")
	public void the_user_is_in_guru_login_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bsekar6\\eclipse-workspace\\sample_cucumber_file\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/index.php");
	}

	@When("^The user enter valid username and password$")
	public void the_user_enter_valid_username_and_password() {

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr162508");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("aqehatY");
	}

	@When("^The user clicks the submit button$")
	public void the_user_clicks_the_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^The user should be manager home$")
	public void the_user_should_be_manager_home() {

		Assert.assertTrue(driver.getCurrentUrl().contains("Managerhomepage"));
	}

}
