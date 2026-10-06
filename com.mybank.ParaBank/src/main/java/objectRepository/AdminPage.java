package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	WebDriver driver;
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[text()='Admin Page']")
	private WebElement adminPageLink;
	
	@FindBy(id="initialBalance")
	private WebElement initialBalEdit;
	
	@FindBy(id="minimumBalance")
	private WebElement minimumBalEdit;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitBtn;
	
	public WebElement getAdminPageLink() {
		return adminPageLink;
	}

	public WebElement getInitialBalEdit() {
		return initialBalEdit;
	}

	public WebElement getMinimumBalEdit() {
		return minimumBalEdit;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

}
