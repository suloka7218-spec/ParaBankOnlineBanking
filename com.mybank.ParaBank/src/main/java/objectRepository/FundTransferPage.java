package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FundTransferPage {
	WebDriver driver;
	public FundTransferPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="amount")
	private WebElement amountEdt;
	
	@FindBy(id="fromAccountId")
	private WebElement fromAccountDD;
	
	@FindBy(id="toAccountId")
	private WebElement toAccountDD;
	
	@FindBy(xpath="//input[@value='Transfer']")
	private WebElement transferBtn;
	
	public WebElement getAmountEdt() {
		return amountEdt;
	}

	public WebElement getFromAccountDD() {
		return fromAccountDD;
	}

	public WebElement getToAccountDD() {
		return toAccountDD;
	}

	public WebElement getTransferBtn() {
		return transferBtn;
	}
	
	

}
