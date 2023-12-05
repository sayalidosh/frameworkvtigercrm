/**
 * 
 */
package commonutils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import POM1.LoginPage;
import POM1.OraganizationPage;


/**
 * 
 */
public class Baseclass1 {

	public WebDriver d1;
	fileutils Pfile=new fileutils();
	Webdriverutil wutil=new Webdriverutil();
	excelutils exfile=new excelutils();
	
	@BeforeSuite
	public void Bsconf()
	{
		Reporter.log("----connect to data base",true);	
	}
	
	@BeforeClass
	public void Bcconf() throws IOException {
		String BROWSER = Pfile.getDataFromPropertyFile("browser");
		String URL = Pfile.getDataFromPropertyFile("url");
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
	    //maximize window
	      wutil.maximize(d1);
	    //to apply implicit wait
	     
	      wutil.implicitwait(d1);
	      //to luanch the url
	       d1.get(URL);
	}
	
	@BeforeMethod
	public void Bmconf() throws IOException {
		String USERNAME = Pfile.getDataFromPropertyFile("un");
		String PWD = Pfile.getDataFromPropertyFile("password");
		 LoginPage lp=new LoginPage();
			PageFactory.initElements(d1, lp);
			 lp.getUsernametf().sendKeys(USERNAME);
			 lp.getPasswordtf().sendKeys(PWD);
			 lp.getLoginbtn().click();
	}
	
	@AfterMethod
	public void Amconf() throws InterruptedException {
		OraganizationPage org=new OraganizationPage();
		 PageFactory.initElements(d1, org);
		 wutil.Mousceover(d1,org.getImagebtn());
		 Thread.sleep(5000);
		 org.getSignbtn().click();
	}
	
	@AfterClass
	public void Acconf() {
		d1.close();
	}
	
	@AfterSuite
	public void Asconf()
	{
		Reporter.log("----Disconnect to data base",true);	
	}
}


