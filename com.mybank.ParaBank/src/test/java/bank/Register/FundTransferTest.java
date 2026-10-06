package bank.Register;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import genericUtility.JavaUtility;
import objectRepository.FindTransactionPage;
import objectRepository.FundTransferPage;
import objectRepository.HomePage;
import objectRepository.OpenNewAccountPage;

public class FundTransferTest extends BaseClass {
	@Test
	public void tranferFundTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getOpenNewAccountlink().click();

		OpenNewAccountPage onap = new OpenNewAccountPage(driver);
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		Thread.sleep(3000);
		onap.getOpenewAccountBtn().click();

//		System.out.println(onap.getNewAccNumCreated().isDisplayed());
//		System.out.println(onap.getNewAccNumCreated().isEnabled());

//		WebElement ele1 = driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]"));
//		String a = ele1.getAttribute("Congratulations, your account is now open.");
//		System.out.println(a);
//		WebElement ele2 = driver.findElement(By.xpath("//h1[contains(text(),'Opened')]"));
//		String a1 = ele2.getDomAttribute("Account Opened!");
//		System.out.println(a1);
//        WebElement ele4 = driver.findElement(By.xpath("//a[contains(@id,'newAccountId')]"));

		onap.getNewAccNumCreated().click();

		hp.getTransferFundslink().click();
		FundTransferPage ftp = new FundTransferPage(driver);
		ftp.getAmountEdt().sendKeys("600");
		wutil.selectFromDD(0, ftp.getFromAccountDD());
		wutil.selectFromDD(1, ftp.getToAccountDD());
		String toAccNum = wutil.getFirstSelectedOptionText(ftp.getToAccountDD());
		System.out.println(toAccNum);
		ftp.getTransferBtn().click();
		hp.getFindTransactionslink().click();

		FindTransactionPage ftsp = new FindTransactionPage(driver);
		wutil.selectFromDD(ftsp.getSelAccountDD(), toAccNum);

		JavaUtility ju = new JavaUtility();
		String date = ju.currentDate();
		System.out.println(date);
		ftsp.getFindByDateEdit().sendKeys(date);
		ftsp.getFindTransBtn().click();
	}

	@Test
	public void accOverviewTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.getOpenNewAccountlink().click();

		OpenNewAccountPage onap = new OpenNewAccountPage(driver);
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
		Thread.sleep(2000);
		onap.getOpenewAccountBtn().click();

		onap.getNewAccNumCreated().click();

		hp.getTransferFundslink().click();
		FundTransferPage ftp = new FundTransferPage(driver);
		ftp.getAmountEdt().sendKeys("600");
		wutil.selectFromDD(0, ftp.getFromAccountDD());
		wutil.selectFromDD(1, ftp.getToAccountDD());
		String toAccNum = wutil.getFirstSelectedOptionText(ftp.getToAccountDD());
		System.out.println(toAccNum);
		ftp.getTransferBtn().click();

		hp.getAccountOverviewlink().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='accountTable']//tr[td/a[text()='" + toAccNum + "']]")).click();
		Thread.sleep(2000);
	}

}
