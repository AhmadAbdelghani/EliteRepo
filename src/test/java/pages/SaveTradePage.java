package pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import utilities.Driver;

public class SaveTradePage extends BasePage{

	
	@FindBy (xpath = "//p[@class='h4 mb-4']")
	public WebElement pageHeading;
	
	@FindBy (xpath = "//select[@class='form-control mb-4 col-4']")
	public WebElement dropDownOptions;
	
	@FindBy (xpath = "//div/input[@name='symbol']")
	public WebElement symbolField;
	
	@FindBy (xpath = "//input[@name='openDate']")
	public WebElement openDate;
	
	@FindBy (css  = "input[name='entry']")
	public WebElement entryPriceField;
	
	@FindBy (css = "input[name='closeDate']")
	public WebElement closeDate;
	
	@FindBy (css  = "input[name='exit']")
	public WebElement exitPriceField;
	
	@FindBy (xpath  = "(//button[@type='submit'])[3]")
	public WebElement saveBtn;
	
	@FindBy (linkText = "Back to Transactions")
	public WebElement backToTransactionsBtn;
	
	@FindBy(xpath = "//form[@action='/records/save']")
	public WebElement tradeValues;
}
