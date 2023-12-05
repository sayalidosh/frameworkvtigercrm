package framework1;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import POM1.HomePage;
import POM1.OraganizationPage;
import commonutils.Baseclass1;
import commonutils.Webdriverutil;
import commonutils.excelutils;
import commonutils.javautils;

public class createorgnizationpomtestng extends Baseclass1 {
	
	
	

		@Test 
		public void modulepom2() throws IOException, InterruptedException{
	      
			
			
			Webdriverutil wutil=new Webdriverutil();
			excelutils exfile=new excelutils();
			javautils jutil=new javautils();
			
			 String Orgname = exfile.getDataFromExcelFile("Sheet1", 1, 0);
			String group=exfile.getDataFromExcelFile("Sheet1", 1, 1);

			 
			 HomePage hp=new HomePage();
			 PageFactory.initElements(d1, hp);
			 hp.getOragniaztionlink().click();
			 hp.getImage().click();
			 
			 OraganizationPage org=new OraganizationPage();
			 PageFactory.initElements(d1, org);
			 org.getOragnametf().sendKeys(Orgname+jutil.getRandomnumver());
			 org.getAssignedtobtn().click();
			 wutil.handleDropdown(org.getAssignedropdown(), group);
			 org.getSavebtn().click();
			 Thread.sleep(4000);
		
			
			 
}
}