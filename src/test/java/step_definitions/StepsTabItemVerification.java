package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class StepsTabItemVerification {
	
	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage(); 
	BrowserUtils util = new BrowserUtils();
	
	@Given("that the user on the login page")
	public void that_the_user_on_the_login_page() {
	    Driver.getDriver().get("http://ec2-3-145-116-184.us-east-2.compute.amazonaws.com:8080/login");
	}
	@When("user enters currect username")
	public void user_enters_currect_username() {
	    Assert.assertTrue(lp.userNameBox.isDisplayed());
	    lp.userNameBox.sendKeys("Kian");
	    
	    
	}
	@When("user enters currect password")
	public void user_enters_currect_password() {
	    Assert.assertTrue(lp.passwordBox.isDisplayed());
		lp.passwordBox.sendKeys("SuperKian123!");
		
	}
	@Then("user should click on the login button")
	public void user_should_click_on_the_login_button() {
	    Assert.assertTrue(lp.signInBtn.isDisplayed());
	    lp.signInBtn.click();
	}
	@Then("user should be logged in to home page")
	public void user_should_be_logged_in_to_home_page() {
	    Assert.assertTrue(hp.finomGroup.isDisplayed());
	    
	    
	}
}
