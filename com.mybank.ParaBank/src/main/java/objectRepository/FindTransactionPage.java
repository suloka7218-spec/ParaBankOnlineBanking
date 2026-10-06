package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FindTransactionPage 
{
	WebDriver driver;
	public FindTransactionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//select[@id='accountId']")
	private WebElement selAccountDD;
	
	@FindBy(id="transactionDate")
	private WebElement findByDateEdit;
	
	@FindBy(id="findByDate")
	private WebElement findTransBtn;

	public WebElement getSelAccountDD() {
		return selAccountDD;
	}

	public WebElement getFindByDateEdit() {
		return findByDateEdit;
	}

	public WebElement getFindTransBtn() {
		return findTransBtn;
	}

}
