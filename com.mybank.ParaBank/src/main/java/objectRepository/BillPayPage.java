package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage {
	
	WebDriver driver;
	public BillPayPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "payee.name")
	private WebElement payeeNameEdit;
	
	@FindBy(name = "payee.address.street")
	private WebElement payeeAddressEdit;
	
	@FindBy(name = "payee.address.city")
	private WebElement payeeCityEdit;
	
	@FindBy(name = "payee.address.state")
	private WebElement payeeStateEdit;
	
	@FindBy(name = "payee.address.zipCode")
	private WebElement payeeZipCodeEdit;
	
	@FindBy(name = "payee.phoneNumber")
	private WebElement payeePhoneNumEdit;
	
	@FindBy(name = "payee.accountNumber")
	private WebElement payeeAccountEdit;
	
	@FindBy(name = "verifyAccount")
	private WebElement payeeVrfyAccEdit;
	
	@FindBy(name = "amount")
	private WebElement bpAmountEdit;
	
	@FindBy(name = "fromAccountId")
	private WebElement fromAccountDD;
	
	@FindBy(xpath="//input[@value='Send Payment']")
	private WebElement sendTransferBtn;
	
	public WebElement getPayeeNameEdit() {
		return payeeNameEdit;
	}

	public WebElement getPayeeAddressEdit() {
		return payeeAddressEdit;
	}

	public WebElement getPayeeCityEdit() {
		return payeeCityEdit;
	}

	public WebElement getPayeeStateEdit() {
		return payeeStateEdit;
	}

	public WebElement getPayeeZipCodeEdit() {
		return payeeZipCodeEdit;
	}

	public WebElement getPayeePhoneNumEdit() {
		return payeePhoneNumEdit;
	}

	public WebElement getPayeeAccountEdit() {
		return payeeAccountEdit;
	}

	public WebElement getPayeeVrfyAccEdit() {
		return payeeVrfyAccEdit;
	}

	public WebElement getBpAmountEdit() {
		return bpAmountEdit;
	}

	public WebElement getFromAccountDD() {
		return fromAccountDD;
	}

	public WebElement getSendTransferBtn() {
		return sendTransferBtn;
	}
	
	public void payeeInfo(String name,String address, String city, String state, String zipcode,
			String phoneNum,String account, String vrfyAccount, String amount, String fromAccount)
	{
		payeeNameEdit.sendKeys(name);
		payeeAddressEdit.sendKeys(address);
		payeeCityEdit.sendKeys(city);
		payeeStateEdit.sendKeys(state);
		payeeZipCodeEdit.sendKeys(zipcode);
		payeePhoneNumEdit.sendKeys(phoneNum);
		payeeAccountEdit.sendKeys(account);
		payeeVrfyAccEdit.sendKeys(vrfyAccount);
		bpAmountEdit.sendKeys(amount);
		fromAccountDD.sendKeys(fromAccount);
		sendTransferBtn.click();
		
		
		
		
		
		
		
		
		
	}

}
