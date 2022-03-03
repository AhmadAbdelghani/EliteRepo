package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class loginFeatureSteps {
	
	
	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();
	BrowserUtils util = new BrowserUtils();
	
    // test login valid credentials #Starts
	@Given("User is on Trade Joiurnal app login page")
	public void user_is_on_trade_joiurnal_app_login_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("appURL"));
	    Assert.assertTrue(lp.pageHeader.isDisplayed());
	}
	
	@When("User inters valid username {string} and valid password {string}")
	public void user_inters_valid_username_and_valid_password(String username, String password) {
	   lp.userNameBox.sendKeys(username);
	   lp.passwordBox.sendKeys(password);
	   
	}
	@When("User clicks the sign in button")
	public void user_clicks_the_sign_in_button() {
		lp.signInBtn.click();
	}
	@Then("User should be directed to the homepage of Trade Journal app")
	public void user_should_be_directed_to_the_homepage_of_trade_journal_app() {
	    Assert.assertTrue(hp.pageTitle.isDisplayed());
	    
	}
	// test login valid credentials #Ends
	
	
	
	
	
	
	
	
	
	// test invalid login (invalid username-valid password) #Starts
	@When("User enters invalid username {string} and valid password")
	public void user_enters_invalid_username_and_valid_password(String username) {
	    lp.userNameBox.sendKeys(username);
	    lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
	    lp.signInBtn.click();
	}
	
	@Then("User sould not be directed to home page")
	public void user_sould_not_be_directed_to_home_page() {
	    Assert.assertTrue(lp.pageHeader.isDisplayed());
	   
	}
	
	@Then("User should see message {string}")
	public void user_should_see_message(String expectedErrorMess) {
	    Assert.assertEquals(lp.badCredentialText.getText().trim(), expectedErrorMess);
	}
	// test invalid login (invalid username-valid password) #Ends
	
	
	
	
	// test invalid log in (valid username-invalid password) #Starts
	@When("User enters valid username and invalid password {string}")
	public void user_enters_valid_username_and_invalid_password(String password) {
	    lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
	    lp.passwordBox.sendKeys(password);
	}
	// test invalid log in (valid username-invalid password) #Ends

	
	
	
	
	//test invalid log in (ib=nvalid username and invalif=d password) #Starts
	@When("User enters invalid username {string} and invalid password {string} into the fields")
	public void user_enters_invalid_username_and_invalid_password_into_the_fields(String username, String password) {
	   lp.userNameBox.sendKeys(username);
	   lp.passwordBox.sendKeys(password);
	}
	//test invalid log in (ib=nvalid username and invalif=d password) #Ends

	
	
	
	
	// test logout #Starts
	@Given("User is logged in to Journal app and on the home page")
	public void user_is_logged_in_to_journal_app_and_on_the_home_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("appURL"));
	    Assert.assertTrue(lp.pageHeader.isDisplayed());
	    lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
	    lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
	    lp.signInBtn.click();
	}
	
	@When("User clicks oon the logout button")
	public void user_clicks_oon_the_logout_button() {
	    Assert.assertTrue(hp.logOutBtn.isDisplayed());
	    hp.logOutBtn.click();
	}
	
	@Then("User should be directed to a page with message {string}")
	public void user_should_be_directed_to_a_page_with_message(String expectdLogoutMessage) {
	    Assert.assertEquals(lp.areYouSur.getText().trim(), expectdLogoutMessage);
	}
	
	@Then("User should see button {string}")
	public void user_should_see_button(String logoutButtonText) {
	    Assert.assertTrue(lp.logoutBtn.isDisplayed());
	    Assert.assertEquals(lp.logoutBtn.getText().trim(), logoutButtonText);
	}
	
	@When("User clicks on the lougout button")
	public void user_clicks_on_the_lougout_button() {
	    lp.logoutBtn.click();
	}
	@Then("User should be directed to the log in page")
	public void user_should_be_directed_to_the_log_in_page() {
	    Assert.assertTrue(lp.pageHeader.isDisplayed());
	    Assert.assertTrue(lp.signInBtn.isDisplayed());
	}
	
	@Then("user should see a message {string}")
	public void user_should_see_a_message(String confirmedLodoutMessage) {
	    Assert.assertEquals(lp.signedOutText.getText().trim(), confirmedLodoutMessage);
		
	}
	// test logout #Ends
	
	
	
	
	
	
	
	
	
	
}
