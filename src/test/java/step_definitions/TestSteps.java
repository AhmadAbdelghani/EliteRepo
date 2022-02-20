package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class TestSteps {
	
	
	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();
	BrowserUtils util = new BrowserUtils();
	

	@Given("user on hempage")
	public void user_on_hempage() {
	    Driver.getDriver().get("http://ec2-3-145-116-184.us-east-2.compute.amazonaws.com:8080/login");
	}
	@When("User enters credrntial")
	public void user_enters_credrntial() {
	   Assert.assertTrue(lp.userNameBox.isDisplayed());
		lp.userNameBox.sendKeys("Ahmad");
		lp.passwordBox.sendKeys("SuperAhmad123!");
		lp.signInBtn.click();
	    
	}
	@Then("User logged in")
	public void user_logged_in() {
		Assert.assertTrue(hp.addTradeBtn.isDisplayed());
	    
	}
}
