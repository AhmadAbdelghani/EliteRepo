package step_definitions;

import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.SaveTradePage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;
import utilities.PropertiesReader;

public class AddTradSteps {
	
	
	HomePage hp = new HomePage();
	LoginPage lp = new LoginPage();
	SaveTradePage st = new SaveTradePage();
	DButils dbUtil = new DButils();
	BrowserUtils bUtil = new BrowserUtils();
	List<String> featureList;
	String symbol;
	String entryPrice;

	@Given("User is logged in to Trade Journal app and User is on homepage")
	public void user_is_logged_in_to_trade_journal_app_and_user_is_on_homepage() {
	    Driver.getDriver().get(PropertiesReader.getProperty("appURL"));
	    Assert.assertTrue(lp.pageHeader.isDisplayed());
	    lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
	    lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
	    lp.signInBtn.click();
	}
	@When("User clicks on add trade button")
	public void user_clicks_on_add_trade_button() {
	    Assert.assertTrue(hp.addTradeBtn.isDisplayed());
	    hp.addTradeBtn.click();
	    
	}
	@When("Users enters the following data")
	public void users_enters_the_following_data(DataTable dataTable) {
	 featureList = dataTable.transpose().asList();
	 symbol=featureList.get(1);
	 entryPrice=featureList.get(3);
	 bUtil.selectByVisibleText(st.dropDownOptions, featureList.get(0));
	 st.symbolField.sendKeys(symbol);
	 st.openDate.sendKeys(featureList.get(2));
	 st.entryPriceField.sendKeys(featureList.get(3));
	 st.closeDate.sendKeys(featureList.get(4));
	 st.exitPriceField.sendKeys(featureList.get(5));
			   
	}
	@When("User clicks on save button")
	public void user_clicks_on_save_button() {
	    Assert.assertTrue(st.saveBtn.isDisplayed());
	    st.saveBtn.click();
	}
	@Then("Trade is added on the UI table")
	public void trade_is_added_on_the_ui_table() {
	    Assert.assertEquals(hp.symbol.getText(), symbol);
	    Assert.assertEquals(hp.entryPrice.getText(), "$"+entryPrice);
	    
	    
	}
	@Then("Trade is added on the database table")
	public void trade_is_added_on_the_database_table() {
	    String quiry = "select long_short, symbol, open_date, entry_price, close_date, exit_price from records where symbol="+"'"+symbol+"'";
	    	List<String> databaseRecord = dbUtil.selectARecord(quiry);
	    	System.out.println(databaseRecord);
	    	String[] openDate = featureList.get(2).split("-");
	    	String fixedOpDa = openDate[2]+"-"+openDate[0]+"-"+openDate[1];
	    	String[] closeDate = featureList.get(4).split("-");
	    	String fixedClDa = closeDate[2]+"-"+closeDate[0]+"-"+closeDate[1];
	    	Assert.assertEquals(databaseRecord.get(2), fixedOpDa);
	    	Assert.assertEquals(databaseRecord.get(0), "0");
	    	Assert.assertEquals(databaseRecord.get(1), symbol);
	    	Assert.assertEquals(databaseRecord.get(3), featureList.get(3));
	    	Assert.assertEquals(databaseRecord.get(4), fixedClDa);
	    	Assert.assertEquals(databaseRecord.get(5), featureList.get(5));
	}
	
	@Then("Record should be deleted")
	public void record_should_be_deleted() {
	   
		String query = "delete from records where symbol ="+"'"+symbol+"'";
		dbUtil.deleteRecord(query);
		List <String> list = dbUtil.selectARecord("select * from records where symbol ="+"'"+symbol+"'");
		Assert.assertTrue(list.size()==0);
	}

}
