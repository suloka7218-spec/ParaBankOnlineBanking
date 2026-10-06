package bank.Register;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import objectRepository.HomePage;
import objectRepository.OpenNewAccountPage;
import objectRepository.RequestLoanPage;

public class LoanRequestTest extends BaseClass {
	@Test
	public void requestforLoanTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getOpenNewAccountlink().click();

		OpenNewAccountPage onap = new OpenNewAccountPage(driver);
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		Thread.sleep(3000);
		onap.getOpenewAccountBtn().click();
		onap.getNewAccNumCreated().click();

		hp.getRequestLoanlink().click();
		RequestLoanPage rlp = new RequestLoanPage(driver);
		rlp.getLoanAmountEdit().sendKeys("200");
		rlp.getDownPaymentEdit().sendKeys("25");
		wutil.selectFromDD(1, rlp.getFromAccDD());
		rlp.getApplyNowBtn().click();
	}

	@Test
	public void accDetailsTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getOpenNewAccountlink().click();

		OpenNewAccountPage onap = new OpenNewAccountPage(driver);
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		Thread.sleep(3000);
		onap.getOpenewAccountBtn().click();
		onap.getNewAccNumCreated().click();

		hp.getRequestLoanlink().click();
		RequestLoanPage rlp = new RequestLoanPage(driver);
		rlp.getLoanAmountEdit().sendKeys("200");
		rlp.getDownPaymentEdit().sendKeys("25");
		wutil.selectFromDD(1, rlp.getFromAccDD());
		rlp.getApplyNowBtn().click();

		rlp.getAccNumLink().click();
	}

}
