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

import POM1.ContactPage;
import POM1.HomePage;
import POM1.LoginPage;
import commonutils.Webdriverutil;
import commonutils.excelutils;
import commonutils.fileutils;

/**
 * 
 */
public class cratecontactpom {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@Test
	public void modulepom1() throws IOException, InterruptedException {
		
		 WebDriver d1=new ChromeDriver();
			
			fileutils futil=new fileutils();
			Webdriverutil wutil=new Webdriverutil();
			excelutils exfile=new excelutils();
			//read data from file
			String BROWSER = futil.getDataFromPropertyFile("browser");
			 String URL = futil.getDataFromPropertyFile("url");
			 String USERNAME= futil.getDataFromPropertyFile("un");
			 String pwd = futil.getDataFromPropertyFile("password");
			 //read data from excel sheet
			 String FIRSTNAME=exfile.getDataFromExcelFile("Sheet1", 1,2);
				String LASTNAME=exfile.getDataFromExcelFile("Sheet1", 1,3);
				String Orgname = exfile.getDataFromExcelFile("Sheet1", 1, 0);
				String group=exfile.getDataFromExcelFile("Sheet1", 2, 1);
				String PARENTURL=exfile.getDataFromExcelFile("Sheet1", 1, 4);
				String CHILDURL=exfile.getDataFromExcelFile("Sheet1", 3, 4);
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
			// to apply implicit wait
		      wutil.implicitwait(d1);
		    //launch the url  
			 d1.get(URL);
			 //create object of login pager
			 LoginPage lp=new LoginPage(); 
			PageFactory.initElements(d1, lp);
			//login to application
			 lp.getUsernametf().sendKeys(USERNAME);
			 lp.getPasswordtf().sendKeys(pwd);
			 lp.getLoginbtn().click();
			//create object of home page  
			 HomePage hp=new HomePage();
			 PageFactory.initElements(d1, hp);
			 //click on contact
			 hp.getContactlink().click();
			//click on plus image
			 hp.getImage().click();
			//crate object of contactpage
			 ContactPage ct=new ContactPage();
			 PageFactory.initElements(d1, ct);
			 //enter firstname
			 ct.getFirstnametf().sendKeys(FIRSTNAME);
			 //enter lastname
			 ct.getLastnametf().sendKeys(LASTNAME);
			//to click plus image in organiaztion image
			 ct.getGetContactplusbtn().click();
			 //transfer control parent to child
			 wutil.switchtowindow(d1,CHILDURL);
			 
			 ct.getContactSearchtf().sendKeys(Orgname);
			 ct.getSearchbtn().click();
			 ct.getContacttext().click();
			 
           //transfer control child to parent 
			 wutil.switchtowindow(d1,PARENTURL);
			//to click on group radio button
			 ct.getAssignedtobtn().click();
			 //dropdown webelement
			 wutil.handleDropdown(ct.getAssignedropdown(), group);
			 //take screen shot of webpage
			 wutil.TakeScreenshot(d1);
		      // for scrolling      
		     Thread.sleep(2000);
		     wutil.scrolling(d1);
		   //to click on save button
			 ct.getSavebtn().click();
			//admin image and mousehover on it 
			 wutil.Mousceover(d1,ct.getImagebtn());
			 //click on signout
			 ct.getSignbtn().click();
			 
			
			 
			 
			
	}

}
