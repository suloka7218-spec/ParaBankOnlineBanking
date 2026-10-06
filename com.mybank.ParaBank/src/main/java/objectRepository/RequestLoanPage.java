package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanPage {
	WebDriver driver;
	public RequestLoanPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="amount")
	private WebElement loanAmountEdit;
	
	@FindBy(id="downPayment")
	private WebElement downPaymentEdit;
	
	@FindBy(id="fromAccountId")
	private WebElement fromAccDD;
	
	@FindBy(xpath = "//input[@value='Apply Now']")
	private WebElement applyNowBtn;
	
	@FindBy(xpath = "//a[@id='newAccountId']")
	private WebElement accNumLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLoanAmountEdit() {
		return loanAmountEdit;
	}

	public WebElement getDownPaymentEdit() {
		return downPaymentEdit;
	}

	public WebElement getFromAccDD() {
		return fromAccDD;
	}

	public WebElement getApplyNowBtn() {
		return applyNowBtn;
	}
	
	public WebElement getAccNumLink() {
		return accNumLink;
	}
	
	

}
