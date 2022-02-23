package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath  = "//a[text()='Home ']")
	public WebElement pageTitle;
	
	@FindBy (xpath = "//a[contains(text(), 'Finom')]")
	public WebElement finomGroup;
	
	@FindBy (linkText  = "Slack Channel")
	public WebElement slackChannel;
	
	@FindBy (xpath = "//span[text()='PrimeTech_SDET_Batch1']")
	public WebElement batch1SlackChannel;
	
	@FindBy (css = "#navbarDropdown")
	public  WebElement toolDropDown;
	
	@FindBy (xpath = "//a[@class='dropdown-item']")
	public List <WebElement> dropDownOptions;
	
	@FindBy (xpath = "//input[@name='symbol']")
	public  WebElement symbolBox;
	
	@FindBy (xpath = "(//button[@type='submit'])[1]")
	public  WebElement searchBtn;
	
	@FindBy (xpath = "//input[@type='date']")
	public  WebElement dateBox;
	
	@FindBy (xpath = "(//button[@type='submit'])[2]")
	public  WebElement logOutBtn;
	
	@FindBy (linkText  = "Add trade")
	public  WebElement addTradeBtn;
	
	@FindBy(xpath = "//table/tbody/tr/td[text()='AhmadDontDelete']/following-sibling::td[6]/a[2]")
    public WebElement ahmadTradeDelete;
	
	@FindBy(xpath = "//tbody/tr/td")
	public List<WebElement> UItableRecord;
	
	@FindBy(xpath = "//table/tbody/tr/td[text()='AhmadDontDelete']/following-sibling::td[6]/a[1]")
    public WebElement ahmadTradeUpdate;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement searchField;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]")
	public List<WebElement> stockSymbol;
	
	
	@FindBy(xpath = "//a[contains(text(), 'Update')]")
	public WebElement updateButton;
}
