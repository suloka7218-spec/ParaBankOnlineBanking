package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccountPage {
	WebDriver driver;
	public OpenNewAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="type")
	private WebElement accountType;
	
	@FindBy(id="fromAccountId")
	private WebElement fromAccount;
	
	@FindBy(xpath = "//input[@value='Open New Account']")
	private WebElement openewAccountBtn;
	
	@FindBy(xpath="//a[@id='newAccountId']")
	private WebElement newAccNumCreated;
	
	

	public WebElement getAccountType() {
		return accountType;
	}

	public WebElement getFromAccount() {
		return fromAccount;
	}

	public WebElement getOpenewAccountBtn() {
		return openewAccountBtn;
	}
	
	public WebElement getNewAccNumCreated() {
		return newAccNumCreated;
	}
		

}
