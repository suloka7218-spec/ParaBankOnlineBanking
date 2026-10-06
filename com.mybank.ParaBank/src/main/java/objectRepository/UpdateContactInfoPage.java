package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInfoPage {
	
	WebDriver driver;
	public UpdateContactInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="customer.firstName")
	private WebElement upInFirstNameEdit;
	
	@FindBy(id="customer.lastName")
	private WebElement upInLastNameEdit;
	
	@FindBy(id="customer.address.street")
	private WebElement upInAddressEdit;
	
	@FindBy(id="customer.address.city")
	private WebElement upInCityEdit;
	
	@FindBy(id="customer.address.state")
	private WebElement upInStateEdit;
	
	@FindBy(id="customer.address.zipCode")
	private WebElement upInZipCodeEdit;
	
	@FindBy(id="customer.phoneNumber")
	private WebElement upInPhoneNumEdit;
	
	@FindBy(xpath="//input[@value='Update Profile']")
	private WebElement updateProfileBtn;
	
	public WebElement getUpInFirstNameEdit() {
		return upInFirstNameEdit;
	}

	public WebElement getUpInLastNameEdit() {
		return upInLastNameEdit;
	}

	public WebElement getUpInAddressEdit() {
		return upInAddressEdit;
	}

	public WebElement getUpInCityEdit() {
		return upInCityEdit;
	}

	public WebElement getUpInStateEdit() {
		return upInStateEdit;
	}

	public WebElement getUpInZipCodeEdit() {
		return upInZipCodeEdit;
	}

	public WebElement getUpInPhoneNumEdit() {
		return upInPhoneNumEdit;
	}

	public WebElement getUpdateProfileBtn() {
		return updateProfileBtn;
	}
	
	

}
