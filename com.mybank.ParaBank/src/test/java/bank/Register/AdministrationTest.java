package bank.Register;

import org.testng.annotations.Test;

import baseTest.BaseClass;
import objectRepository.AdminPage;

public class AdministrationTest extends BaseClass {
	
	@Test
	public void administration() throws Throwable
	{
		
		AdminPage ap=new AdminPage(driver);
		Thread.sleep(3000);
		ap.getAdminPageLink().click();
		ap.getInitialBalEdit().sendKeys("550");
		ap.getMinimumBalEdit().sendKeys("110");
		ap.getSubmitBtn().click();
	}

}
