package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Open New Account']")
	private WebElement openNewAccountlink;
	
	@FindBy(xpath = "//a[text()='Accounts Overview']")
	private WebElement accountOverviewlink;
 
	@FindBy(xpath = "//a[text()='Transfer Funds']")
	private WebElement transferFundslink;
	
	@FindBy(xpath = "//a[text()='Bill Pay']")
	private WebElement billPaylink;
	
	@FindBy(xpath = "//a[text()='Find Transactions']")
	private WebElement findTransactionslink;
	
	@FindBy(xpath = "//a[text()='Update Contact Info']")
	private WebElement updateContactInfolink;

	@FindBy(xpath = "//a[text()='Request Loan']")
	private WebElement requestLoanlink;
	
	public WebElement getOpenNewAccountlink() {
		return openNewAccountlink;
	}

	public WebElement getAccountOverviewlink() {
		return accountOverviewlink;
	}

	public WebElement getTransferFundslink() {
		return transferFundslink;
	}

	public WebElement getBillPaylink() {
		return billPaylink;
	}

	public WebElement getFindTransactionslink() {
		return findTransactionslink;
	}

	public WebElement getUpdateContactInfolink() {
		return updateContactInfolink;
	}

	public WebElement getRequestLoanlink() {
		return requestLoanlink;
	}
}
