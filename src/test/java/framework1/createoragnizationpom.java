/**
 * 
 */
package framework1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import POM1.HomePage;
import POM1.LoginPage;
import POM1.OraganizationPage;
import commonutils.Webdriverutil;
import commonutils.excelutils;
import commonutils.fileutils;
import commonutils.javautils;

/**
 * 
 */
public class createoragnizationpom {

	@Test 
	public void modulepom2() throws IOException, InterruptedException{
      final  WebDriver d1;
		
		fileutils futil=new fileutils();
		Webdriverutil wutil=new Webdriverutil();
		excelutils exfile=new excelutils();
		javautils jutil=new javautils();
		//read data from file
		String BROWSER = futil.getDataFromPropertyFile("browser");
		 String URL = futil.getDataFromPropertyFile("url");
		 String USERNAME= futil.getDataFromPropertyFile("un");
		 String pwd = futil.getDataFromPropertyFile("password");
		 //read data from excelsheet
		//int or = jutil.getRandomnumver();
		  String Orgname = exfile.getDataFromExcelFile("Sheet1", 1, 0);
			String group=exfile.getDataFromExcelFile("Sheet1", 1, 1);

	      if(BROWSER.equals("Chrome"))
	      {
	    	d1=new ChromeDriver();  
	      }
	      else if (BROWSER.equals("firefox"))
	      {
	    	  d1=new FirefoxDriver();
	      }
	      else
	      {
	    	  d1=new EdgeDriver();
	      }
		 //
		 wutil.maximize(d1);
	      wutil.implicitwait(d1);
		 d1.get(URL);
		 LoginPage lp=new LoginPage();
		PageFactory.initElements(d1, lp);
		 lp.getUsernametf().sendKeys(USERNAME);
		 lp.getPasswordtf().sendKeys(pwd);
		 lp.getLoginbtn().click();
		 
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
		 Thread.sleep(5000);
		 wutil.Mousceover(d1,org.getImagebtn());
		 Thread.sleep(5000);
		 org.getSignbtn().click();
		 
		 
		 
		
		 
		 
		 
		 
	}

}
