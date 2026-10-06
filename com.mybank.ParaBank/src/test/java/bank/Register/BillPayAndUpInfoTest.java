package bank.Register;

import org.testng.annotations.Test;

import baseTest.BaseClass;
import objectRepository.BillPayPage;
import objectRepository.HomePage;
import objectRepository.UpdateContactInfoPage;

public class BillPayAndUpInfoTest extends BaseClass
{
	@Test
	public void payBillTest() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getBillPaylink().click();
		
		String pName=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 0);
		String pAddress=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 1);
		String pCity=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 2);
		String pState=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 3);
		String pZipCode=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 4);
		String pPhoneNum=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 5);
		String pAccountNum=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 6);
		String pVerifyAcc=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 7);
		String pAmount=eutil.toReadDatafromExcelFile("BillPayeeInfo", 1, 8);
		
		BillPayPage bpp=new BillPayPage(driver);
		bpp.getPayeeNameEdit().sendKeys(pName);
		bpp.getPayeeAddressEdit().sendKeys(pAddress);
		bpp.getPayeeCityEdit().sendKeys(pCity);
		bpp.getPayeeStateEdit().sendKeys(pState);
		bpp.getPayeeZipCodeEdit().sendKeys(pZipCode);
		bpp.getPayeePhoneNumEdit().sendKeys(pPhoneNum);
		bpp.getPayeeAccountEdit().sendKeys(pAccountNum);
		bpp.getPayeeVrfyAccEdit().sendKeys(pVerifyAcc);
		bpp.getBpAmountEdit().sendKeys(pAmount);
		
		bpp.getSendTransferBtn().click();
		
	}
	@Test
	public void updateInfoTest() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getUpdateContactInfolink().click();
		
		String upInCity=eutil.toReadDatafromExcelFile("UpdateContactInfo", 1, 3);
		String upInState=eutil.toReadDatafromExcelFile("UpdateContactInfo", 1, 4);
		UpdateContactInfoPage ucip=new UpdateContactInfoPage(driver);
		ucip.getUpInCityEdit().clear();
		ucip.getUpInCityEdit().sendKeys(upInCity);
		
		ucip.getUpInStateEdit().clear();
		ucip.getUpInStateEdit().sendKeys(upInState);
		ucip.getUpdateProfileBtn().click();
	}
	
	

}
