package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement regLink;
	
	@FindBy(id="customer.firstName")
	private WebElement firstNameedit;	
	
	@FindBy(id="customer.lastName")
	private WebElement lastNameEdit;
	
	@FindBy(id="customer.address.street")
	private WebElement addressEdit;
	
	@FindBy(id="customer.address.city")
	private WebElement cityEdit;
	
	@FindBy(id="customer.address.state")
	private WebElement stateEdit;
	
	@FindBy(id="customer.address.zipCode")
	private WebElement zipCodeEdit;
	
	@FindBy(id="customer.phoneNumber")
	private WebElement phoneNumEdit;
	
	@FindBy(id="customer.ssn")
	private WebElement ssnEdit;
	
	@FindBy(id="customer.username")
	private WebElement usernameEdit;
	
	@FindBy(id="customer.password")
	private WebElement passwordEdit;
	
	@FindBy(id="repeatedPassword")
	private WebElement confmPassEdit;
	
	@FindBy(xpath="//input[@value='Register']")
	private WebElement regBtn;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement logUserNameEdit;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement logPasswordEdit;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='logout.htm']") //  //a[text()='Log Out']
	private WebElement logOutLink;
	
	public WebElement getRegLink() {
		return regLink;
	}

	public WebElement getFirstNameedit() {
		return firstNameedit;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getAddressEdit() {
		return addressEdit;
	}

	public WebElement getCityEdit() {
		return cityEdit;
	}

	public WebElement getStateEdit() {
		return stateEdit;
	}

	public WebElement getZipCodeEdit() {
		return zipCodeEdit;
	}

	public WebElement getPhoneNumEdit() {
		return phoneNumEdit;
	}

	public WebElement getSsnEdit() {
		return ssnEdit;
	}

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getConfmPassEdit() {
		return confmPassEdit;
	}

	public WebElement getRegBtn() {
		return regBtn;
	}

	public WebElement getLogUserNameEdit() {
		return logUserNameEdit;
	}

	public WebElement getLogPasswordEdit() {
		return logPasswordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public WebElement getLogOutLink()
	{
		return logOutLink;
	}
	
	public void registerToApp(String firstName, String lastName, String address,String city, String state,
			String zipCode,String phoneNum,String ssn,String username,String password,String confmPass)
	{
		regLink.click();
		firstNameedit.sendKeys(firstName);
		lastNameEdit.sendKeys(lastName);
		addressEdit.sendKeys(address);
		cityEdit.sendKeys(city);
		stateEdit.sendKeys(state);
		zipCodeEdit.sendKeys(zipCode);
		phoneNumEdit.sendKeys(phoneNum);
		ssnEdit.sendKeys(ssn);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		confmPassEdit.sendKeys(confmPass);
		regBtn.click();
		
	}
	public void loginToApp(String un,String pwd)
	{
		logUserNameEdit.sendKeys(un);
		logPasswordEdit.sendKeys(pwd);
		loginBtn.click();
		
	}
	
	

}
