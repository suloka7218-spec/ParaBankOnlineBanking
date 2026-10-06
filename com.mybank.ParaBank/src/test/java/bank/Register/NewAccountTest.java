package bank.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import objectRepository.FundTransferPage;
import objectRepository.HomePage;
import objectRepository.OpenNewAccountPage;

public class NewAccountTest extends BaseClass {
	
	
	@Test(priority=1)
	public void openNewAccountTest() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getOpenNewAccountlink().click();
		
		OpenNewAccountPage onap=new OpenNewAccountPage(driver);
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		Thread.sleep(2000);
		onap.getOpenewAccountBtn().click();
	}
	
	@Test(priority=2)
	public void fundTransferTest()
	{
		HomePage hp=new HomePage(driver);
		hp.getTransferFundslink().click();
		FundTransferPage ftp=new FundTransferPage(driver);
		ftp.getAmountEdt().sendKeys("200");
		Select sel=new Select(ftp.getFromAccountDD());
		sel.selectByIndex(0);
		
		Select sel1=new Select(ftp.getToAccountDD());
		sel.selectByIndex(1);
		ftp.getTransferBtn().click();
//		wutil.selectFromDD(1, ftp.getFromAccountDD());
//		wutil.selectFromDD(2, ftp.getToAccountDD());
	}

}
