package step_definitions;

import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

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

public class UpdateFeatureSteps {

	HomePage hp = new HomePage();
	LoginPage lp = new LoginPage();
	SaveTradePage sp = new SaveTradePage();
	BrowserUtils util = new BrowserUtils();
	DButils databaseUtil = new DButils();
	List<String> updatesValue;
	List<String> updateFeatreTable;
	List<String> featueTable;
	String UIfixedOpendate;
	String symbol;
	String UIfixedClosedate;



	// update test updating all the fields #Starts
	@Given("User looged in to trade Journal app and on the homepage")
	public void user_looged_in_to_trade_journal_app_and_on_the_homepage() {
		Driver.getDriver().get(PropertiesReader.getProperty("appURL"));
		Assert.assertTrue(lp.pageHeader.isDisplayed());
		lp.userNameBox.sendKeys(PropertiesReader.getProperty("username"));
		lp.passwordBox.sendKeys(PropertiesReader.getProperty("password"));
		lp.signInBtn.click();
		Assert.assertTrue(hp.pageTitle.isDisplayed());
	}

	@When("User creat new record with the following data and")
	public void user_creat_new_record_with_the_following_data_and(DataTable dataTable) throws InterruptedException {
		featueTable = dataTable.transpose().asList();
		symbol = featueTable.get(1);

		hp.addTradeBtn.click();
		Assert.assertTrue(sp.pageHeading.isDisplayed());
		util.selectByVisibleText(sp.dropDownOptions, featueTable.get(0));
		sp.symbolField.sendKeys(featueTable.get(1));

		sp.openDate.sendKeys(featueTable.get(2));
		sp.entryPriceField.sendKeys(featueTable.get(3));
		sp.closeDate.sendKeys(featueTable.get(4));

		sp.exitPriceField.sendKeys(featueTable.get(5));

	}

	@When("User save the record")
	public void user_save_the_record() throws InterruptedException {
		Assert.assertTrue(sp.saveBtn.isDisplayed());
		sp.saveBtn.click();

	}

	@Then("Record should be saved")
	public void record_should_be_saved() throws InterruptedException {
		hp.searchField.sendKeys(symbol);

		hp.searchBtn.click();

		Assert.assertEquals(hp.UItableRecord.get(1).getText(), symbol);
	}

	@When("User update this new created record with the following data")
	public void user_update_this_new_created_record_with_the_following_data(DataTable dataTable)
			throws InterruptedException {
		updateFeatreTable = dataTable.transpose().asList();
		symbol = updateFeatreTable.get(1);

		util.waitUntilElementClickable(hp.updateButton);
		hp.updateButton.click();

		util.selectByVisibleText(sp.dropDownOptions, updateFeatreTable.get(0));
		sp.symbolField.clear();
		sp.symbolField.sendKeys(updateFeatreTable.get(1));

		sp.openDate.clear();
		sp.openDate.sendKeys(updateFeatreTable.get(2));
		sp.entryPriceField.clear();
		sp.entryPriceField.sendKeys(updateFeatreTable.get(3));

		sp.closeDate.clear();
		sp.closeDate.sendKeys(updateFeatreTable.get(4));
		sp.exitPriceField.clear();
		sp.exitPriceField.sendKeys(updateFeatreTable.get(5));
		sp.saveBtn.click();

	}

	@Then("Record should be updated on the UI table")
	public void record_should_be_updated_on_the_ui_table() {
		hp.searchField.sendKeys(symbol);
		hp.searchBtn.click();
		Assert.assertEquals(hp.UItableRecord.get(0).getText().trim(), updateFeatreTable.get(0));
		Assert.assertEquals(hp.UItableRecord.get(1).getText().trim(), updateFeatreTable.get(1));
		String[] openDate = updateFeatreTable.get(2).split("-");
		UIfixedOpendate = openDate[2] + "-" + openDate[0] + "-" + openDate[1];
		Assert.assertEquals(hp.UItableRecord.get(2).getText(), UIfixedOpendate);
		Assert.assertEquals(hp.UItableRecord.get(3).getText().replace('$', ' ').trim(), updateFeatreTable.get(3));
		String[] closeDate = updateFeatreTable.get(4).split("-");
		 UIfixedClosedate = closeDate[2] + "-" + closeDate[0] + "-" + closeDate[1];
		Assert.assertEquals(hp.UItableRecord.get(4).getText(), UIfixedClosedate);
		Assert.assertEquals(hp.UItableRecord.get(5).getText().replace('$', ' ').trim(), updateFeatreTable.get(5));

	}

	@Then("Record is updated on the database")
	public void record_is_updated_on_the_database() {
		String quiry = "select * from records where symbol=" + "'"+symbol+"'";
		List<String> databaseRecoed = databaseUtil.selectARecord(quiry);
		System.out.println(databaseRecoed);
		Assert.assertEquals(databaseRecoed.get(2), "1");
		Assert.assertEquals(databaseRecoed.get(3), symbol);
		Assert.assertEquals(databaseRecoed.get(4), UIfixedOpendate);
		Assert.assertEquals(databaseRecoed.get(5), updateFeatreTable.get(3));
		Assert.assertEquals(databaseRecoed.get(6), UIfixedClosedate);
		Assert.assertEquals(databaseRecoed.get(7), updateFeatreTable.get(5));
		

	}
	
	@Then("record should be deleted")
	public void record_should_be_deleted() {
	    String quiry = "delete from records where symbol="+"'"+symbol+"'";
	    databaseUtil.deleteRecord(quiry);
	    List<String> list = databaseUtil.selectARecord("select * from records where symbol="+"'"+symbol+"'");
	    Assert.assertTrue(list.size()==0);
	    System.out.println("The list is empty: "+list);
	}

}
