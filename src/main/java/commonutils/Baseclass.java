/**
 * 
 */
package commonutils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * 
 */
public class Baseclass {

	public WebDriver d1;
	public static WebDriver sd1;
	fileutils Pfile=new fileutils();
	Webdriverutil wutil=new Webdriverutil();
	excelutils exfile=new excelutils();
	
	@BeforeSuite
	public void Bsconf()
	{
		Reporter.log("----connect to data base",true);	
	}
	
	//@Parameters("BROWSER")
	//@BeforeTest
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
	       //only to take screenshot
	       sd1=d1;
	}
	
	@BeforeMethod
	public void Bmconf() throws IOException {
		String USERNAME = Pfile.getDataFromPropertyFile("un");
		String PWD = Pfile.getDataFromPropertyFile("password");
		
		 //login to application
	       d1.findElement(By.name("user_name")).sendKeys(USERNAME);
		   d1.findElement(By.name("user_password")).sendKeys(PWD);
		  
		   d1.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void Amconf() throws InterruptedException {
		WebElement mouse = d1.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		 // mouse hovering on admin image 
		 	 Thread.sleep(5000);
		 	wutil.Mousceover(d1,mouse);
		 	//click on sign out 
		 	d1.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 	
		 	
	}
	//@AfterTest
	@AfterClass
	public void Acconf() {
		// d1.findElement(By.id("ubmitButton")).click();
		d1.quit();
	}
	
	@AfterSuite
	public void Asconf()
	{
		Reporter.log("----Disconnect to data base",true);	
	}
}
