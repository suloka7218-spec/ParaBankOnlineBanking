package bank.Register;

import org.testng.annotations.Test;

import baseTest.BaseClass;
import objectRepository.LoginPage;

public class AARegisterTest extends BaseClass {
	@Test
	public void registerTest() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
		lp.getRegLink().click();
		String fname = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 0);
		String lname = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 1);
		String address = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 2);
		String city = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 3);
		String state = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 4);
		String zipCode = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 5);
		String pnoneNum = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 6);
		String ssn = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 7);
		int rn = jutil.genRandomNumber();
		String regUserName = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 8);
		String regPassword = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 9);
		String cnfrmPass = eutil.toReadDatafromExcelFile("RegisterInfo", 1, 10);

		lp.registerToApp(fname, lname, address, city, state, zipCode, pnoneNum, ssn, regUserName, regPassword,
				cnfrmPass);
	}

}
